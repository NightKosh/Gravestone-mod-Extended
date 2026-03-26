package nightkosh.gravestone_extended.block_entity.inventory;

import net.minecraft.world.item.ItemStack;
import nightkosh.gravestone_extended.block_entity.AltarBlockEntity;

import javax.annotation.Nonnull;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CorpseInventory extends DisenchantmentInventory {

    private static final int INVENTORY_SIZE = 1;

    public CorpseInventory(AltarBlockEntity altar) {
        super(altar);
    }

    @Nonnull
    public ItemStack getCorpse() {
        return this.getItem(0);
    }

    public void setCorpse(ItemStack corpse) {
        this.setItem(0, corpse);
    }

    @Override
    public int getContainerSize() {
        return INVENTORY_SIZE;
    }

    @Override
    protected String getKeyName() {
        return "Corpse";
    }

}
