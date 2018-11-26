package nightkosh.gravestone_extended.item.tools.hoe;

import net.minecraft.block.BlockGrass;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.core.GSEnchantment;
import nightkosh.gravestone_extended.core.ModInfo;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemBoneHoe extends ItemHoe implements IBoneHoe {

    public ItemBoneHoe() {
        this(ToolMaterial.STONE);
        this.setUnlocalizedName("gravestone.bone_hoe");
        this.setRegistryName(ModInfo.ID, "gs_bone_hoe");
        this.setCreativeTab(null);
    }

    public ItemBoneHoe(ToolMaterial material) {
        super(material);
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return super.getIsRepairable(toRepair, repair) || repair.getItem() == Item.getItemFromBlock(GSBlock.BONE_BLOCK);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getHeldItem(hand);
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() instanceof IGrowable) {
            NBTTagList nbtList = stack.getEnchantmentTagList();
            for (NBTBase nbt : nbtList) {
                if (((NBTTagCompound) nbt).getInteger("id") == Enchantment.getEnchantmentID(GSEnchantment.BONE_RAIN)) {
                    if (applyBonemeal(stack, world, pos, state, player, hand)) {
                        if (!world.isRemote) {
                            world.playEvent(2005, pos, 0);
                        }
                        return EnumActionResult.SUCCESS;
                    }
                    break;
                }
            }
        }

        return super.onItemUse(player, world, pos, hand, side, hitX, hitY, hitZ);
    }

    public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, @javax.annotation.Nullable EnumHand hand) {
        if (!(state.getBlock() instanceof BlockGrass) || player.isSneaking()) {

            int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, worldIn, pos, state, stack, hand);
            if (hook != 0) return hook > 0;

            IGrowable igrowable = (IGrowable) state.getBlock();
            if (igrowable.canGrow(worldIn, pos, state, worldIn.isRemote)) {
                if (!worldIn.isRemote) {
                    if (igrowable.canUseBonemeal(worldIn, worldIn.rand, pos, state)) {
                        igrowable.grow(worldIn, worldIn.rand, pos, state);
                    }
                    stack.damageItem(1, player);
                }
                return true;
            }
        }
        return false;
    }
}
