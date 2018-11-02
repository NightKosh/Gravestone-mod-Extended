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
import net.minecraft.world.World;
import nightkosh.gravestone.api.GraveStoneAPI;
import nightkosh.gravestone.api.grave_position.IGravePositionHandler;
import nightkosh.gravestone.helper.GraveGenerationHelper;
import nightkosh.gravestone_extended.capability.cemetery.CemeteryInfo;
import nightkosh.gravestone_extended.capability.cemetery.CemeteryProvider;
import nightkosh.gravestone_extended.capability.cemetery.ICemetery;
import nightkosh.gravestone_extended.core.GSBlock;

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
        ICemetery cemeteryOld = playerOln.getCapability(CemeteryProvider.CEMETERY_CAP, null);
        ICemetery cemeteryNew = playerNew.getCapability(CemeteryProvider.CEMETERY_CAP, null);

        cemeteryNew.setPlayerCemetery(cemeteryOld.getPlayerCemetery());
        cemeteryNew.setPetCemetery(cemeteryOld.getPetCemetery());
    }

    public static void addGravePositionHandlers() {
        //player player cemetery
        GraveStoneAPI.graveGenerationAtDeath.addGravePositionHandler(new IGravePositionHandler() {

            @Override
            public boolean condition(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
                if (entity instanceof EntityPlayer) {
                    ICemetery cemetery = entity.getCapability(CemeteryProvider.CEMETERY_CAP, null);
                    return checkCondition(world, cemetery, cemetery.getPlayerCemetery());
                }
                return false;
            }

            @Override
            public BlockPos gravePosition(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
                return getGravePos(world, entity.getCapability(CemeteryProvider.CEMETERY_CAP, null).getPlayerCemetery().getPosition(), false, true);
            }

            @Override
            public EnumFacing graveFacing(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
                return entity.getCapability(CemeteryProvider.CEMETERY_CAP, null).getPlayerCemetery().getFacing();
            }
        });

        //player pet cemetery
        GraveStoneAPI.graveGenerationAtDeath.addGravePositionHandler(new IGravePositionHandler() {

            @Override
            public boolean condition(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
                if (entity instanceof EntityWolf || entity instanceof EntityOcelot) {
                    EntityTameable pet = (EntityTameable) entity;
                    if (pet.isTamed()) {
                        EntityLivingBase owner = pet.getOwner();
                        if (owner != null && owner instanceof EntityPlayer) {
                            ICemetery cemetery = owner.getCapability(CemeteryProvider.CEMETERY_CAP, null);
                            return checkCondition(world, cemetery, cemetery.getPetCemetery());
                        }
                    }
                }
                return false;
            }

            @Override
            public BlockPos gravePosition(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
                return getGravePos(world, ((EntityTameable) entity).getOwner().getCapability(CemeteryProvider.CEMETERY_CAP, null).getPetCemetery().getPosition(), false, false);
            }

            @Override
            public EnumFacing graveFacing(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
                return ((EntityTameable) entity).getOwner().getCapability(CemeteryProvider.CEMETERY_CAP, null).getPetCemetery().getFacing();
            }
        });

        //server player cemetery
        GraveStoneAPI.graveGenerationAtDeath.addGravePositionHandler(new IGravePositionHandler() {

            @Override
            public boolean condition(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
                if (entity instanceof EntityPlayer) {
                    ICemetery cemetery = world.getCapability(CemeteryProvider.CEMETERY_CAP, null);
                    return checkCondition(world, cemetery, cemetery.getPlayerCemetery());
                }
                return false;
            }

            @Override
            public BlockPos gravePosition(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
                return getGravePos(world, world.getCapability(CemeteryProvider.CEMETERY_CAP, null).getPlayerCemetery().getPosition(), true, true);
            }

            @Override
            public EnumFacing graveFacing(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
                return world.getCapability(CemeteryProvider.CEMETERY_CAP, null).getPlayerCemetery().getFacing();
            }
        });

        //server pet cemetery
        GraveStoneAPI.graveGenerationAtDeath.addGravePositionHandler(new IGravePositionHandler() {

            @Override
            public boolean condition(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
                if (entity instanceof EntityWolf || entity instanceof EntityOcelot && ((EntityTameable) entity).isTamed()) {
                    ICemetery cemetery = world.getCapability(CemeteryProvider.CEMETERY_CAP, null);
                    return checkCondition(world, cemetery, cemetery.getPetCemetery());
                }
                return false;
            }

            @Override
            public BlockPos gravePosition(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
                return getGravePos(world, world.getCapability(CemeteryProvider.CEMETERY_CAP, null).getPetCemetery().getPosition(), true, false);
            }

            @Override
            public EnumFacing graveFacing(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
                return world.getCapability(CemeteryProvider.CEMETERY_CAP, null).getPetCemetery().getFacing();
            }
        });
    }

    private static boolean checkCondition(World world, ICemetery cemetery, CemeteryInfo cemeteryInfo) {
        if (cemeteryInfo != null) {
            if (world.getBlockState(cemeteryInfo.getPosition()).getBlock() == GSBlock.MEMORIAL) {
                return true;
            } else {
                cemetery.setPlayerCemetery(null);
            }
        }
        return false;
    }

    private static final int CEMETERY_SIZE_PLAYER = 4;
    private static final int CEMETERY_SIZE_PET = 3;
    private static final int CEMETERY_SIZE_PLAYER_SERVER = 10;
    private static final int CEMETERY_SIZE_PET_SERVER = 5;

    private static BlockPos getGravePos(World world, BlockPos pos, boolean isServer, boolean playerCemetery) {
        List<BlockPos> list = new ArrayList<>();

        int xPos;
        int zPos;

        int size;
        if (isServer) {
            size = playerCemetery ? CEMETERY_SIZE_PLAYER_SERVER : CEMETERY_SIZE_PET_SERVER;
        } else {
            size = playerCemetery ? CEMETERY_SIZE_PLAYER : CEMETERY_SIZE_PET;
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
