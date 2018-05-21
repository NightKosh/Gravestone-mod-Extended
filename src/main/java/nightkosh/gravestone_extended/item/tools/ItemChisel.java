package nightkosh.gravestone_extended.item.tools;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
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

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack itemStack = player.getHeldItem(hand);
        player.setActiveHand(EnumHand.MAIN_HAND);

        RayTraceResult raytraceresult = this.rayTrace(world, player, false);

        if (raytraceresult != null && raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK &&
                (world.getBlockState(raytraceresult.getBlockPos()).getBlock() == GSBlock.GRAVE_STONE ||
                world.getBlockState(raytraceresult.getBlockPos()).getBlock() == GSBlock.MEMORIAL)) {
            return new ActionResult<>(EnumActionResult.PASS, itemStack);
        } else {
            player.openGui(ModGravestoneExtended.instance, GuiHandler.CHISEL_CRAFTING_GUI_ID, world,
                    player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
            return new ActionResult<>(EnumActionResult.SUCCESS, itemStack);
        }
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing
            side, float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getHeldItem(hand);
        if (world.getBlockState(pos).getBlock().equals(GSBlock.GRAVE_STONE)) {
            return setGraveText(stack, player, world, pos, false);
        } else if (world.getBlockState(pos).getBlock().equals(GSBlock.MEMORIAL)) {
            return setGraveText(stack, player, world, pos, true);
        }

        return EnumActionResult.FAIL;
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
