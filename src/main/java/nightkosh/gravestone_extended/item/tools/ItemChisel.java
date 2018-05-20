package nightkosh.gravestone_extended.item.tools;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nightkosh.gravestone.tileentity.TileEntityGrave;
import nightkosh.gravestone_extended.ModGravestoneExtended;
import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.core.GSTabs;
import nightkosh.gravestone_extended.core.GuiHandler;
import nightkosh.gravestone_extended.core.ModInfo;

import java.util.HashSet;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemChisel extends ItemTool {

    public ItemChisel() {
        super(1, 5, ToolMaterial.IRON, new HashSet<>());
        this.setMaxStackSize(1);
        this.setCreativeTab(GSTabs.otherItemsTab);
        this.setUnlocalizedName("gravestone.chisel");
        this.setMaxDamage(50);
        this.setRegistryName(ModInfo.ID, "gschisel");
    }

    /**
     * Called whenever this item is equipped and the right mouse button is
     * pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack itemStack = player.getHeldItem(hand);
        player.setActiveHand(EnumHand.MAIN_HAND);
        return new ActionResult(EnumActionResult.PASS, itemStack);
    }

    /**
     * Callback for item usage. If the item does something special on right
     * clicking, he will have one of those. Return True if something happen and
     * false if it don't. This is for ITEMS, not BLOCKS
     */
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getHeldItem(hand);
        if (world.getBlockState(pos).getBlock().equals(GSBlock.GRAVE_STONE)) {
            return setGraveText(stack, player, world, pos, false);
        } else if (world.getBlockState(pos).getBlock().equals(GSBlock.MEMORIAL)) {
            return setGraveText(stack, player, world, pos, true);
        } else {
            player.openGui(ModGravestoneExtended.instance, GuiHandler.CHISEL_CRAFTING_GUI_ID, world, pos.getX(), pos.getY(), pos.getZ());
        }

        return EnumActionResult.SUCCESS;
    }

    private EnumActionResult setGraveText(ItemStack stack, EntityPlayer player, World world, BlockPos pos, boolean isMemorial) {
        if (world.isRemote) {
            TileEntityGrave tileEntity = (TileEntityGrave) world.getTileEntity(pos);

            if (tileEntity != null && tileEntity.isEditable() && tileEntity.getDeathTextComponent().getDeathText().length() == 0) {
                ModGravestoneExtended.proxy.openGraveTextGui(tileEntity);
                if (isMemorial) {
                    stack.damageItem(5, player);
                } else {
                    stack.damageItem(2, player);
                }

                return EnumActionResult.SUCCESS;
            }
        }

        return EnumActionResult.FAIL;
    }
}
