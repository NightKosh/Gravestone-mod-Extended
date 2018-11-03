package nightkosh.gravestone_extended.helper;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
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

    public static void cloneCemetery(EntityPlayer playerOln, EntityPlayer playerNew) {
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
        public boolean condition(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
            if (isPlayerCemetery) {
                if (entity instanceof EntityPlayer) {
                    return checkCondition(world, entity, isServerCemetery ? world : entity);
                }
            } else {
                if (entity instanceof EntityWolf || entity instanceof EntityOcelot && ((EntityTameable) entity).isTamed()) {
                    if (isServerCemetery) {
                        return checkCondition(world, entity, world);
                    } else {
                        EntityLivingBase owner = ((EntityTameable) entity).getOwner();
                        if (owner != null && owner instanceof EntityPlayer) {
                            return checkCondition(world, entity, owner);
                        }
                    }
                }
            }
            return false;
        }

        @Override
        public BlockPos gravePosition(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
            World newWorld = getCemeteryWorld(world, entity, getProvider(world, entity));
            return getGravePos(newWorld, getCemeteryInfo(getCemeteryCapability(getProvider(newWorld, entity))).getPosition());
        }

        @Override
        public EnumFacing graveFacing(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
            World newWorld = getCemeteryWorld(world, entity, getProvider(world, entity));
            return getCemeteryFacing(getProvider(newWorld, entity));
        }

        @Nonnull
        @Override
        public World getWorld(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
            return getCemeteryWorld(world, entity, getProvider(world, entity));
        }

        protected boolean checkCondition(World world, Entity entity, ICapabilityProvider provider) {
            ICemetery cemetery = getCemeteryCapability(provider);

            CemeteryInfo cemeteryInfo;
            if (isPlayerCemetery) {
                cemeteryInfo = cemetery.getPlayerCemetery();
            } else {
                cemeteryInfo = cemetery.getPetCemetery();
            }

            if (cemeteryInfo != null) {
                World newWorld = getCemeteryWorld(world, entity, getProvider(world, entity));
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

        protected World getCemeteryWorld(World world, Entity entity, ICapabilityProvider provider) {
            int dimensionId = getCemeteryInfo(getCemeteryCapability(provider)).getDimensionId();
            if (world.provider.getDimension() == dimensionId) {
                return world;
            } else {
                return DimensionManager.getWorld(dimensionId);
            }
        }

        protected CemeteryInfo getCemeteryInfo(ICemetery cemetery) {
            return isPlayerCemetery ? cemetery.getPlayerCemetery() : cemetery.getPetCemetery();
        }

        protected ICapabilityProvider getProvider(World world, Entity entity) {
            if (isServerCemetery) {
                return world;
            } else {
                return isPlayerCemetery ? entity : ((EntityTameable) entity).getOwner();
            }
        }


        private static final int CEMETERY_SIZE_PLAYER = 4;
        private static final int CEMETERY_SIZE_PET = 3;
        private static final int CEMETERY_SIZE_PLAYER_SERVER = 10;
        private static final int CEMETERY_SIZE_PET_SERVER = 5;

        protected BlockPos getGravePos(World world, BlockPos pos) {
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

                    addPosition(list, world, pos, xPos, zPos);
                    addPosition(list, world, pos, -xPos, zPos);
                    addPosition(list, world, pos, xPos, -zPos);
                    addPosition(list, world, pos, -xPos, -zPos);
                }
            }

            if (list.isEmpty()) {
                return null;
            } else {
                return list.get(rnd.nextInt(list.size()));
            }
        }

        private static void addPosition(List<BlockPos> list, World world, BlockPos cemeteryPos, int x, int z) {
            x = cemeteryPos.getX() + x;
            z = cemeteryPos.getZ() + z;

            int y = GraveGenerationHelper.getGround(world, x, cemeteryPos.getY() + 10, z);
            BlockPos pos = new BlockPos(x, y, z);
            if (GraveGenerationHelper.canGenerateGraveAtCoordinates(world, pos)) {
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
