package nightkosh.gravestone_extended.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone_extended.core.GSTabs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.potion.PotionRecall;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemFrozenMirror extends Item {

    public ItemFrozenMirror() {
        this.setUnlocalizedName("gravestone.frozen_mirror");
        this.setRegistryName(ModInfo.ID, "gs_frozen_mirror");
        this.setCreativeTab(GSTabs.otherItemsTab);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entity, EnumHand hand) {
        PotionRecall.teleport(entity);
        return new ActionResult(EnumActionResult.PASS, entity.getHeldItem(hand));
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
