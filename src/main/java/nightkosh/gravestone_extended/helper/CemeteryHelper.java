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
import nightkosh.gravestone_extended.capability.cemetery.CemeteryProvider;
import nightkosh.gravestone_extended.capability.cemetery.ICemetery;
import nightkosh.gravestone_extended.core.GSBlock;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CemeteryHelper {

    public static void cloneCemetery(EntityPlayer playerOln, EntityPlayer playerNew) {
        ICemetery cemeteryOld = playerOln.getCapability(CemeteryProvider.CEMETERY_CAP, null);
        ICemetery cemeteryNew = playerNew.getCapability(CemeteryProvider.CEMETERY_CAP, null);

        if (cemeteryOld.hasPlayerCemetery()) {
            cemeteryNew.setPlayerCemetery(true);
            cemeteryNew.setPlayerPosition(cemeteryOld.getPlayerPosition());
            cemeteryNew.setPlayerFacing(cemeteryOld.getPlayerFacing());
        }

        if (cemeteryOld.hasPetCemetery()) {
            cemeteryNew.setPetCemetery(true);
            cemeteryNew.setPetPosition(cemeteryOld.getPetPosition());
            cemeteryNew.setPetFacing(cemeteryOld.getPetFacing());
        }
    }

    public static void addGravePositionHandlers() {
        //player player cemetery
        GraveStoneAPI.graveGenerationAtDeath.addGravePositionHandler(new IGravePositionHandler() {

            @Override
            public boolean condition(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
                if (entity instanceof EntityPlayer) {
                    ICemetery cemetery = entity.getCapability(CemeteryProvider.CEMETERY_CAP, null);
                    if (cemetery.hasPlayerCemetery()) {
                        if (world.getBlockState(cemetery.getPlayerPosition()).getBlock() == GSBlock.MEMORIAL) {
                            return true;
                        } else {
                            cemetery.setPlayerCemetery(false);
                        }
                    }
                }
                return false;
            }

            @Override
            public BlockPos gravePosition(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
                ICemetery cemetery = entity.getCapability(CemeteryProvider.CEMETERY_CAP, null);
                BlockPos gravePos = cemetery.getPlayerPosition();
                //TODO
                return pos.west(2);
            }

            @Override
            public EnumFacing graveFacing(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
                return entity.getCapability(CemeteryProvider.CEMETERY_CAP, null).getPlayerFacing();
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
                            if (cemetery.hasPetCemetery()) {
                                if (world.getBlockState(cemetery.getPetPosition()).getBlock() == GSBlock.MEMORIAL) {
                                    return true;
                                } else {
                                    cemetery.setPetCemetery(false);
                                }
                            }
                        }
                    }
                }
                return false;
            }

            @Override
            public BlockPos gravePosition(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
                ICemetery cemetery = entity.getCapability(CemeteryProvider.CEMETERY_CAP, null);
                BlockPos gravePos = cemetery.getPetPosition();
                //TODO
                return pos.west(2);
            }

            @Override
            public EnumFacing graveFacing(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
                return entity.getCapability(CemeteryProvider.CEMETERY_CAP, null).getPetFacing();
            }
        });

        //server player cemetery
        GraveStoneAPI.graveGenerationAtDeath.addGravePositionHandler(new IGravePositionHandler() {

            @Override
            public boolean condition(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
                if (entity instanceof EntityPlayer) {
                    ICemetery cemetery = world.getCapability(CemeteryProvider.CEMETERY_CAP, null);
                    if (cemetery.hasPlayerCemetery()) {
                        if (world.getBlockState(cemetery.getPlayerPosition()).getBlock() == GSBlock.MEMORIAL) {
                            return true;
                        } else {
                            cemetery.setPlayerCemetery(false);
                        }
                    }
                }
                return false;
            }

            @Override
            public BlockPos gravePosition(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
                ICemetery cemetery = world.getCapability(CemeteryProvider.CEMETERY_CAP, null);
                BlockPos gravePos = cemetery.getPlayerPosition();
                //TODO
                return pos.west(2);
            }

            @Override
            public EnumFacing graveFacing(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
                return world.getCapability(CemeteryProvider.CEMETERY_CAP, null).getPlayerFacing();
            }
        });

        //server pet cemetery
        GraveStoneAPI.graveGenerationAtDeath.addGravePositionHandler(new IGravePositionHandler() {

            @Override
            public boolean condition(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
                if (entity instanceof EntityWolf || entity instanceof EntityOcelot && ((EntityTameable) entity).isTamed()) {
                    ICemetery cemetery = world.getCapability(CemeteryProvider.CEMETERY_CAP, null);
                    if (cemetery.hasPetCemetery()) {
                        if (world.getBlockState(cemetery.getPetPosition()).getBlock() == GSBlock.MEMORIAL) {
                            return true;
                        } else {
                            cemetery.setPetCemetery(false);
                        }
                    }
                }
                return false;
            }

            @Override
            public BlockPos gravePosition(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
                ICemetery cemetery = world.getCapability(CemeteryProvider.CEMETERY_CAP, null);
                BlockPos gravePos = cemetery.getPetPosition();
                //TODO
                return pos.west(2);
            }

            @Override
            public EnumFacing graveFacing(World world, Entity entity, BlockPos pos, DamageSource damageSource) {
                return world.getCapability(CemeteryProvider.CEMETERY_CAP, null).getPetFacing();
            }
        });
    }
}
