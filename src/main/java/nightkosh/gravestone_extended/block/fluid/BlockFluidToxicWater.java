package nightkosh.gravestone_extended.block.fluid;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone_extended.config.ExtendedConfig;
import nightkosh.gravestone_extended.core.*;
import nightkosh.gravestone_extended.core.compatibility.Compatibility;
import nightkosh.gravestone_extended.core.compatibility.CompatibilityAdvancedFishing;
import nightkosh.gravestone_extended.entity.monster.EntityToxicSludge;
import nightkosh.gravestone_extended.helper.StateHelper;
import nightkosh.gravestone_extended.item.armor.bone.IBoneArmor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockFluidToxicWater extends BlockFluidClassic {

    public BlockFluidToxicWater() {
        super(GSFluids.TOXIC_WATER, Material.WATER);
        this.setUnlocalizedName("gs_toxic_water");
        this.setCreativeTab(GSTabs.otherItemsTab);
        this.setRegistryName(ModInfo.ID, GSFluids.TOXIC_WATER.getName());
        this.setTickRandomly(true);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
        super.onEntityCollidedWithBlock(world, pos, state, entity);
        boolean dealDamage = false;
        if (entity instanceof EntityLivingBase) {
            if (!(entity instanceof EntitySlime)) {
                EntityLivingBase baseEntity = (EntityLivingBase) entity;
                if (baseEntity.getCreatureAttribute() != EnumCreatureAttribute.UNDEAD) {
                    if (entity instanceof EntityPlayer || entity instanceof EntityTameable) {
                        for (PotionEffect potion : baseEntity.getActivePotionEffects()) {
                            if (Potion.getIdFromPotion(potion.getPotion()) == Potion.getIdFromPotion(GSPotion.BONE_SKIN)) {
                                return;
                            }
                        }
                        if (entity instanceof EntityPlayer) {
                            baseEntity.addPotionEffect(new PotionEffect(GSPotion.RUST, 100));
                            Iterable<ItemStack> equipment = entity.getArmorInventoryList();
                            int armorParts = 0;
                            if (equipment != null) {
                                for (ItemStack stack : equipment) {
                                    if (!stack.isEmpty() && stack.isItemStackDamageable() && stack.getItem() instanceof IBoneArmor) {
                                        armorParts++;
                                    }
                                }
                            }
                            dealDamage = armorParts != 4;
                        } else {
                            dealDamage = true;
                        }
                    } else {
                        dealDamage = true;
                    }
                }
            }
        } else if (!(entity instanceof EntityItem) &&
                !(Compatibility.isModLoaded(Compatibility.ADVANCED_FISHING_ID) && CompatibilityAdvancedFishing.isBoneHook(entity))) {
            dealDamage = true;
            if (entity instanceof EntityFishHook) {
                meltEffect(world, entity.posX, entity.posY, entity.posZ);
                if (entity.ticksExisted > 20) {
                    entity.setDead();
                }
                return;
            }
        }
        if (dealDamage && world.rand.nextInt(20) == 0) {
            entity.attackEntityFrom(DamageSource.MAGIC, 1);
            meltEffect(world, entity.posX, entity.posY, entity.posZ);
        }
    }

    public static void meltEffect(World world, double x, double y, double z) {
        if (!world.isRemote) {
            ((WorldServer) world).spawnParticle(EnumParticleTypes.SMOKE_LARGE, x, y + 1, z, 2, 0.1, 0, 0.1, 0);
            world.playSound(null, x, y + 1, z, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 0.2F + world.rand.nextFloat() * 0.2F, 0.9F + world.rand.nextFloat() * 0.15F);
        }
    }

    public void melt(World world, BlockPos liquidPos, BlockPos replacedPos) {
        if (EntityToxicSludge.replaceBlock(world, replacedPos)) {
            meltEffect(world, replacedPos.getX() + 0.5, replacedPos.getY() + 0.5, replacedPos.getZ() + 0.5);
        }
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        super.onBlockAdded(world, pos, state);

        if (ExtendedConfig.toxicSludgeAndWaterChangeBlocks) {
            melt(world, pos, pos.down());
            melt(world, pos, pos.east());
            melt(world, pos, pos.west());
            melt(world, pos, pos.south());
            melt(world, pos, pos.north());
        }
    }

    @Override
    public boolean displaceIfPossible(World world, BlockPos pos) {
        return !isWaterBlock(world, pos) && super.displaceIfPossible(world, pos);
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        super.updateTick(world, pos, state, rand);
        if (!world.isRemote) {
            if (ExtendedConfig.removeToxicWater) {
                world.setBlockState(pos, StateHelper.FLOWING_WATER);
            } else if (ExtendedConfig.spreadToxicWater && rand.nextInt(10) == 0 && state.getValue(LEVEL) == 0) {
                List<BlockPos> replacePos = new ArrayList<>();
                if (isWaterBlock(world, pos.up())) {
                    replacePos.add(pos.up());
                }
                if (isWaterBlock(world, pos.down())) {
                    replacePos.add(pos.down());
                }
                if (isWaterBlock(world, pos.west())) {
                    replacePos.add(pos.west());
                }
                if (isWaterBlock(world, pos.east())) {
                    replacePos.add(pos.east());
                }
                if (isWaterBlock(world, pos.north())) {
                    replacePos.add(pos.north());
                }
                if (isWaterBlock(world, pos.south())) {
                    replacePos.add(pos.south());
                }

                if (!replacePos.isEmpty()) {
                    world.setBlockState(replacePos.get(rand.nextInt(replacePos.size())), StateHelper.TOXIC_WATER);
                }
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
        super.randomDisplayTick(state, world, pos, rand);
        if (world.getBlockState(pos.up()).getMaterial() == Material.AIR && !world.getBlockState(pos.up()).isOpaqueCube()) {

            if (rand.nextInt(300) == 0) {
                double x = pos.getX() + rand.nextFloat();
                double y = pos.getY() + state.getBoundingBox(world, pos).maxY;
                double z = pos.getZ() + rand.nextFloat();
                world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, x, y, z, 0, 0, 0);
                world.playSound(x, y, z, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 0.2F + rand.nextFloat() * 0.2F, 0.9F + rand.nextFloat() * 0.15F, false);
            }

            if (rand.nextInt(100) == 0) {
                world.playSound(pos.getX(), pos.getY(), pos.getZ(), GSSound.BUBBLING, SoundCategory.BLOCKS, 0.2F + rand.nextFloat() * 0.2F, 0.9F + rand.nextFloat() * 0.15F, false);
            }
        }

        if (rand.nextInt(50) == 0 && world.getBlockState(pos.down()).isTopSolid()) {
            Material material = world.getBlockState(pos.down(2)).getMaterial();

            if (!material.blocksMovement() && !material.isLiquid()) {
                double x = pos.getX() + rand.nextFloat();
                double y = pos.getY() - 1.05;
                double z = pos.getZ() + rand.nextFloat();

                world.spawnParticle(GSParticles.TOXIC_WATER_DRIP, x, y, z, 0, 0, 0);
                world.playSound(x, y, z, GSSound.DROP_OF_ACID, SoundCategory.BLOCKS, 0.2F + rand.nextFloat() * 0.2F, 0.9F + rand.nextFloat() * 0.15F, false);
            }
        }
    }

    private static boolean isWaterBlock(World world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        Block block = state.getBlock();
        return (block == Blocks.WATER || block == Blocks.FLOWING_WATER) && state.getValue(LEVEL) == 0;
    }
}
