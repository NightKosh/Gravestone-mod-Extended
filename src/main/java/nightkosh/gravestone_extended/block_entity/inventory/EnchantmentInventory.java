package nightkosh.gravestone_extended.block_entity.inventory;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import nightkosh.gravestone_extended.block_entity.AltarBlockEntity;
import nightkosh.gravestone_extended.core.GSEItems;

import javax.annotation.Nonnull;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EnchantmentInventory extends DisenchantmentInventory {

    private static final int INVENTORY_SIZE = 2;

    public EnchantmentInventory(AltarBlockEntity altar) {
        super(altar);
    }

    @Nonnull
    public ItemStack getSkull() {
        return this.getItem(1);
    }

    public void setSkull(ItemStack skull) {
        if (skull.is(GSEItems.ENCHANTED_SKELETON_SKULL)) {
            this.setItem(1, new ItemStack(Items.SKELETON_SKULL));
        } else {
            this.setItem(1, new ItemStack(Items.WITHER_SKELETON_SKULL));
        }
    }

    @Override
    public int getContainerSize() {
        return INVENTORY_SIZE;
    }

    @Override
    protected String getKeyName() {
        return "Enchantment";
    }

}
