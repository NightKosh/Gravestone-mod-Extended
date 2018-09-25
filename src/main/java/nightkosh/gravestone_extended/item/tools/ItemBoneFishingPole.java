package nightkosh.gravestone_extended.item.tools;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import nightkosh.advanced_fishing.item.AbstractFishingPole;
import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.core.GSEnchantment;
import nightkosh.gravestone_extended.core.GSTabs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.entity.projectile.EntityBoneFishHook;
import nightkosh.gravestone_extended.entity.projectile.EntityObsidianFishHook;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemBoneFishingPole extends AbstractFishingPole implements IBoneFishingPole {

    public ItemBoneFishingPole() {
        this.setMaxDamage(250);
        this.setCreativeTab(GSTabs.otherItemsTab);
        this.setUnlocalizedName("gravestone.bone_fishing_pole");
        this.setRegistryName(ModInfo.ID, "gs_bone_fishing_pole");
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return super.getIsRepairable(toRepair, repair) || repair.getItem() == Item.getItemFromBlock(GSBlock.BONE_BLOCK);
    }

    @Override
    protected EntityBoneFishHook getHook(World world, EntityPlayer player, ItemStack stack) {
        boolean hellishAngling = false;
        NBTTagList nbtList = stack.getEnchantmentTagList();
        for (NBTBase nbt : nbtList) {
            if (((NBTTagCompound) nbt).getInteger("id") == Enchantment.getEnchantmentID(GSEnchantment.HELLISH_ANGLING)) {
                hellishAngling = true;
                break;
            }
        }
        if (hellishAngling) {
            return new EntityObsidianFishHook(world, player);
        } else {
            return new EntityBoneFishHook(world, player);
        }
    }
}
