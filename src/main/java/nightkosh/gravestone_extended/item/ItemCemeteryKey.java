package nightkosh.gravestone_extended.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone_extended.block.BlockMemorial;
import nightkosh.gravestone_extended.block.enums.EnumMemorials;
import nightkosh.gravestone_extended.capability.cemetery.CemeteryInfo;
import nightkosh.gravestone_extended.capability.cemetery.ICemetery;
import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.core.GSTabs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.helper.CemeteryHelper;
import nightkosh.gravestone_extended.tileentity.TileEntityMemorial;

import javax.annotation.Nullable;
import java.util.List;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemCemeteryKey extends Item {

    private static final String OWNER = "Owner";

    private static final String PLAYER_KEY = "item.gravestone.cemetery_key.player";
    private static final String SERVER_KEY = "item.gravestone.cemetery_key.server";


    public ItemCemeteryKey() {
        this.setRegistryName(ModInfo.ID, "cemetery_key");
        this.setCreativeTab(GSTabs.otherItemsTab);
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    public int getMetadata(int damageValue) {
        return damageValue;
    }

    @Override
    public boolean getHasSubtypes() {
        return true;
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (this.isInCreativeTab(tab)) {
            items.add(new ItemStack(this, 1, 0));
            items.add(new ItemStack(this, 1, 1));
        }
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return I18n.translateToLocal((stack.getMetadata() == 0) ? PLAYER_KEY : SERVER_KEY).trim();
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag) {
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }

        if (stack.getMetadata() == 0) {
            NBTTagCompound nbt = stack.getTagCompound();
            if (nbt.hasKey(OWNER)) {
                tooltip.add(I18n.translateToLocal("message.cemetery_key.activated") + " " + nbt.getString(OWNER));
            }
        }
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            ItemStack stack = player.getHeldItem(hand);
            if (!stack.hasTagCompound()) {
                stack.setTagCompound(new NBTTagCompound());
            }

            boolean isPlayerKey = stack.getMetadata() == 0;
            NBTTagCompound nbt = stack.getTagCompound();
            if (!nbt.hasKey(OWNER) || nbt.getString(OWNER).equals(player.getName())) {
                IBlockState state = world.getBlockState(pos);
                if (state.getBlock().equals(GSBlock.MEMORIAL)) {
                    TileEntityMemorial te = (TileEntityMemorial) world.getTileEntity(pos);
                    if (te != null) {
                        ICemetery cemetery = CemeteryHelper.getCemeteryCapability(isPlayerKey ? player : world);

                        EnumFacing facing = state.getValue(BlockMemorial.FACING);
                        EnumMemorials.EnumMemorialType type = te.getMemorialType().getMemorialType();

                        CemeteryInfo cemeteryInfo = new CemeteryInfo();
                        cemeteryInfo.setDimension(world.provider.getDimension());
                        cemeteryInfo.setPosition(pos);
                        cemeteryInfo.setFacing(facing);

                        if (type == EnumMemorials.EnumMemorialType.DOG_STATUE || type == EnumMemorials.EnumMemorialType.CAT_STATUE) {
                            cemetery.setPetCemetery(cemeteryInfo);
                        } else {
                            cemetery.setPlayerCemetery(cemeteryInfo);
                        }

                        if (isPlayerKey) {
                            if (type == EnumMemorials.EnumMemorialType.DOG_STATUE || type == EnumMemorials.EnumMemorialType.CAT_STATUE) {
                                player.sendMessage(new TextComponentTranslation("message.cemetery_key.bounded.pet"));
                            } else {
                                player.sendMessage(new TextComponentTranslation("message.cemetery_key.bounded"));
                            }
                            nbt.setString(OWNER, player.getName());
                        } else {
                            if (type == EnumMemorials.EnumMemorialType.DOG_STATUE || type == EnumMemorials.EnumMemorialType.CAT_STATUE) {
                                player.sendMessage(new TextComponentTranslation("message.cemetery_key.bounded_server.pet"));
                            } else {
                                player.sendMessage(new TextComponentTranslation("message.cemetery_key.bounded_server"));
                            }
                        }
                        return EnumActionResult.SUCCESS;
                    }
                }
            } else {
                player.sendMessage(new TextComponentTranslation("message.cemetery_key.cant_use").setStyle(new Style().setColor(TextFormatting.RED)));
            }
        }

        return EnumActionResult.FAIL;
    }

}
