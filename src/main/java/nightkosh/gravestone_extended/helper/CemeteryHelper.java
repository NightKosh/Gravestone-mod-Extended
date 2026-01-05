package nightkosh.gravestone_extended.helper;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.feline.Cat;
import net.minecraft.world.entity.animal.wolf.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import nightkosh.gravestone.api.GraveStoneAPI;
import nightkosh.gravestone.api.grave_position.IGravePositionHandler;
import nightkosh.gravestone.helper.GraveGenerationHelper;
import nightkosh.gravestone_extended.capability.cemetery.CemeteryInfo;
import nightkosh.gravestone_extended.capability.cemetery.CemeteryProvider;
import nightkosh.gravestone_extended.capability.cemetery.ICemetery;
import nightkosh.gravestone_extended.core.GSBlock;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CemeteryHelper {

    private static final Random rnd = new Random();

    public static void cloneCemetery(Player playerOln, Player playerNew) {
        ICemetery cemeteryOld = getCemeteryCapability(playerOln);
        ICemetery cemeteryNew = getCemeteryCapability(playerNew);

        cemeteryNew.setPlayerCemetery(cemeteryOld.getPlayerCemetery());
        cemeteryNew.setPetCemetery(cemeteryOld.getPetCemetery());
    }

    public static void addGravePositionHandlers() {
        //player player cemetery
        GraveStoneAPI.graveGenerationAtDeath.addGravePositionHandler(new GravePositionHandler(true, false));

        //player pet cemetery
        GraveStoneAPI.graveGenerationAtDeath.addGravePositionHandler(new GravePositionHandler(false, false));

        //server player cemetery
        GraveStoneAPI.graveGenerationAtDeath.addGravePositionHandler(new GravePositionHandler(true, true));

        //server pet cemetery
        GraveStoneAPI.graveGenerationAtDeath.addGravePositionHandler(new GravePositionHandler(false, true));
    }

    private static class GravePositionHandler implements IGravePositionHandler {

        private boolean isPlayerCemetery;
        private boolean isServerCemetery;

        public GravePositionHandler(boolean isPlayerCemetery, boolean isServerCemetery) {
            this.isPlayerCemetery = isPlayerCemetery;
            this.isServerCemetery = isServerCemetery;
        }

        @Override
        public boolean condition(Level level, Entity entity, BlockPos pos, DamageSource damageSource) {
            if (isPlayerCemetery) {
                if (entity instanceof Player) {
                    return checkCondition(level, entity, isServerCemetery ? level : entity);
                }
            } else {
                if (entity instanceof Wolf || entity instanceof Cat && ((TamableAnimal) entity).isTame()) {
                    if (isServerCemetery) {
                        return checkCondition(level, entity, level);
                    } else {
                        var owner = ((TamableAnimal) entity).getOwner();
                        if (owner instanceof Player) {
                            return checkCondition(level, entity, owner);
                        }
                    }
                }
            }
            return false;
        }

        @Override
        public BlockPos gravePosition(Level level, Entity entity, BlockPos pos, DamageSource damageSource) {
            var newWorld = getCemeteryWorld(level, entity, getProvider(level, entity));
            return getGravePos(newWorld, getCemeteryInfo(getCemeteryCapability(getProvider(newWorld, entity))).getPosition());
        }

        @Override
        public EnumFacing graveFacing(Level level, Entity entity, BlockPos pos, DamageSource damageSource) {
            var newWorld = getCemeteryWorld(level, entity, getProvider(level, entity));
            return getCemeteryFacing(getProvider(newWorld, entity));
        }

        @Nonnull
        @Override
        public Level getWorld(Level level, Entity entity, BlockPos pos, DamageSource damageSource) {
            return getCemeteryWorld(level, entity, getProvider(level, entity));
        }

        protected boolean checkCondition(Level level, Entity entity, ICapabilityProvider provider) {
            ICemetery cemetery = getCemeteryCapability(provider);

            CemeteryInfo cemeteryInfo;
            if (isPlayerCemetery) {
                cemeteryInfo = cemetery.getPlayerCemetery();
            } else {
                cemeteryInfo = cemetery.getPetCemetery();
            }

            if (cemeteryInfo != null) {
                var newWorld = getCemeteryWorld(level, entity, getProvider(level, entity));
                if (newWorld.getBlockState(cemeteryInfo.getPosition()).getBlock() == GSBlock.MEMORIAL) {
                    return true;
                } else {
                    cemetery.setPlayerCemetery(null);
                }
            }
            return false;
        }

        protected EnumFacing getCemeteryFacing(ICapabilityProvider provider) {
            return getCemeteryInfo(getCemeteryCapability(provider)).getFacing();
        }

        protected Level getCemeteryWorld(Level level, Entity entity, ICapabilityProvider provider) {
            int dimensionId = getCemeteryInfo(getCemeteryCapability(provider)).getDimensionId();
            if (level.provider.getDimension() == dimensionId) {
                return level;
            } else {
                return DimensionManager.getWorld(dimensionId);
            }
        }

        protected CemeteryInfo getCemeteryInfo(ICemetery cemetery) {
            return isPlayerCemetery ? cemetery.getPlayerCemetery() : cemetery.getPetCemetery();
        }

        protected ICapabilityProvider getProvider(Level level, Entity entity) {
            if (isServerCemetery) {
                return level;
            } else {
                return isPlayerCemetery ? entity : ((EntityTameable) entity).getOwner();
            }
        }


        private static final int CEMETERY_SIZE_PLAYER = 4;
        private static final int CEMETERY_SIZE_PET = 3;
        private static final int CEMETERY_SIZE_PLAYER_SERVER = 10;
        private static final int CEMETERY_SIZE_PET_SERVER = 5;

        protected BlockPos getGravePos(Level level, BlockPos pos) {
            List<BlockPos> list = new ArrayList<>();

            int xPos;
            int zPos;

            int size;
            if (isServerCemetery) {
                size = isPlayerCemetery ? CEMETERY_SIZE_PLAYER_SERVER : CEMETERY_SIZE_PET_SERVER;
            } else {
                size = isPlayerCemetery ? CEMETERY_SIZE_PLAYER : CEMETERY_SIZE_PET;
            }

            for (int x = 1; x <= size; x++) {
                for (int z = 1; z <= size; z++) {
                    if (x == 1 && z == 1) {
                        continue;
                    }
                    xPos = x * 2 - 1;
                    zPos = z * 2 - 1;

                    addPosition(list, level, pos, xPos, zPos);
                    addPosition(list, level, pos, -xPos, zPos);
                    addPosition(list, level, pos, xPos, -zPos);
                    addPosition(list, level, pos, -xPos, -zPos);
                }
            }

            if (list.isEmpty()) {
                return null;
            } else {
                return list.get(rnd.nextInt(list.size()));
            }
        }

        private static void addPosition(List<BlockPos> list, Level level, BlockPos cemeteryPos, int x, int z) {
            x = cemeteryPos.getX() + x;
            z = cemeteryPos.getZ() + z;

            int y = GraveGenerationHelper.getGround(level, x, cemeteryPos.getY() + 10, z);
            BlockPos pos = new BlockPos(x, y, z);
            if (GraveGenerationHelper.canGenerateGraveAtCoordinates(level, pos)) {
                list.add(pos);
            }
        }
    }

    public static ICemetery getCemeteryCapability(ICapabilityProvider provider) {
        if (provider instanceof World) {
            return DimensionManager.getWorld(DimensionType.OVERWORLD.getId()).getCapability(CemeteryProvider.CEMETERY_CAP, null);
        } else {
            return provider.getCapability(CemeteryProvider.CEMETERY_CAP, null);
        }
    }
}
