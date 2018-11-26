package nightkosh.gravestone_extended.enchantment;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.block.BlockFrozenLava;
import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.core.GSEnchantment;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.helper.GSEnchantmentHelper;
import nightkosh.gravestone_extended.item.armor.bone.ItemBoneBoots;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EnchantmentFrozenNether extends EnchantmentTreasure {

    public EnchantmentFrozenNether() {
        super(Rarity.VERY_RARE, EnumEnchantmentType.ARMOR_FEET, new EntityEquipmentSlot[]{EntityEquipmentSlot.FEET});
        this.setName("frozen_nether");
        this.setRegistryName(ModInfo.ID, "frozen_nether");
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return enchantmentLevel * 10;
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return super.getMinEnchantability(enchantmentLevel) + 15;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public boolean canApply(ItemStack stack) {
        return super.canApply(stack) && stack.getItem() instanceof ItemBoneBoots;
    }

    public static void applyEffect(EntityLivingBase entity) {
        World world = entity.getEntityWorld();
        if (!world.isRemote) {
            int level = GSEnchantmentHelper.getEnchantmentLevel(entity.getItemStackFromSlot(EntityEquipmentSlot.FEET), GSEnchantment.FROZEN_NETHER);

            if (level > 0) {
                BlockPos blockPos = entity.getPosition();
                double f = Math.ceil(Math.min(16, 1.5 + level));
                BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos(0, 0, 0);

                for (BlockPos.MutableBlockPos pos : BlockPos.getAllInBoxMutable(blockPos.add(-f, -1, -f), blockPos.add(f, -1, f))) {
                    if (pos.distanceSqToCenter(entity.posX, entity.posY, entity.posZ) <= (f * f)) {
                        mutableBlockPos.setPos(pos.getX(), pos.getY() + 1, pos.getZ());
                        IBlockState state = world.getBlockState(mutableBlockPos);

                        if (state.getMaterial() == Material.AIR) {
                            IBlockState blockState = world.getBlockState(pos);

                            if (blockState.getMaterial() == Material.LAVA && (blockState.getBlock() == Blocks.LAVA || blockState.getBlock() == Blocks.FLOWING_LAVA) &&
                                    blockState.getValue(BlockLiquid.LEVEL) == 0 && world.mayPlace(GSBlock.FROZEN_LAVA, pos, false, EnumFacing.DOWN, null) ||
                                    (blockState.getBlock() == GSBlock.FROZEN_LAVA && blockState.getValue(BlockFrozenLava.AGE) != 0)) {
                                world.setBlockState(pos, GSBlock.FROZEN_LAVA.getDefaultState());
                                world.scheduleUpdate(pos.toImmutable(), GSBlock.FROZEN_LAVA, MathHelper.getInt(entity.getRNG(), 60, 120));
                            }
                        }
                    }
                }
            }
        }
    }
}
