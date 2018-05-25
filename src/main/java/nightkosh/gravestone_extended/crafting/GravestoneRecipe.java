package nightkosh.gravestone_extended.crafting;

import net.minecraft.block.Block;
import net.minecraft.block.BlockVine;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import nightkosh.gravestone.api.grave.EnumGraveMaterial;
import nightkosh.gravestone.api.grave.IEnumGraveType;

import java.util.ArrayList;
import java.util.List;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GravestoneRecipe {
    private ItemStack resultItem;
    private List<ItemStack> requiredItems;
    private boolean isGravestone;
    private IEnumGraveType graveType;
    private EnumGraveMaterial material;
    private boolean canBeMossy;

    private static final ItemStack ENCHANTED_BOOK = new ItemStack(Items.ENCHANTED_BOOK, 1);
    private static final ItemStack VINE = new ItemStack(Blocks.VINE, 1);

    public GravestoneRecipe(boolean isGravestone, IEnumGraveType graveType, EnumGraveMaterial material, List<ItemStack> requiredItems, ItemStack resultItem) {
        this(isGravestone, graveType, material, true, requiredItems, resultItem);
    }

    public GravestoneRecipe(boolean isGravestone, IEnumGraveType graveType, EnumGraveMaterial material, boolean canBeMossy, List<ItemStack> requiredItems, ItemStack resultItem) {
        this.isGravestone = isGravestone;
        this.graveType = graveType;
        this.material = material;
        this.requiredItems = requiredItems;
        this.resultItem = resultItem;
        this.canBeMossy = canBeMossy;
    }

    public ItemStack getResultItem() {
        return resultItem.copy();
    }

    public ItemStack getResultItem(List<ItemStack> requiredItems, boolean isEnchanted, boolean isMossy) {
        isEnchanted = isEnchanted && requiredItems.stream().anyMatch((item) -> item != null && item.getItem() instanceof ItemEnchantedBook);
        isMossy = isMossy && requiredItems.stream().anyMatch((item) -> item != null && Block.getBlockFromItem(item.getItem()) instanceof BlockVine);
        return this.getResultItem(isEnchanted, isMossy);
    }

    public ItemStack getResultItem(boolean isEnchanted, boolean isMossy) {
        ItemStack item = this.getResultItem();
        if (item != null) {
            NBTTagCompound nbt = item.getTagCompound();
            if (nbt == null) {
                nbt = new NBTTagCompound();
            }
            if (isEnchanted) {
                nbt.setBoolean("Enchanted", isEnchanted);
            }
            if (isMossy) {
                nbt.setBoolean("Mossy", isMossy);
            }

            item.setTagCompound(nbt);
        }
        return item;
    }

    public List<ItemStack> getRequiredItems() {
        return new ArrayList<>(requiredItems);
    }

    public List<ItemStack> getRequiredItems(boolean isEnchanted, boolean isMossy) {
        List<ItemStack> items = this.getRequiredItems();
        if (isEnchanted) {
            items.add(ENCHANTED_BOOK);
        }
        if (isMossy) {
            items.add(VINE);
        }
        return items;
    }

    public boolean isGravestone() {
        return isGravestone;
    }

    public IEnumGraveType getGraveType() {
        return graveType;
    }

    public EnumGraveMaterial getMaterial() {
        return material;
    }

    public boolean match(IEnumGraveType graveType, EnumGraveMaterial material, boolean isMossy) {
        return this.getGraveType() == graveType && this.getMaterial() == material && (this.canBeMossy || !isMossy);
    }

    public boolean matchCrafting(IEnumGraveType graveType, EnumGraveMaterial material, boolean isEnchanted, boolean isMossy, List<ItemStack> items) {
        return this.match(graveType, material, isMossy) && this.containItems(items, isEnchanted, isMossy);
    }

    protected boolean containItems(List<ItemStack> items, boolean isEnchanted, boolean isMossy) {
        if (items != null && this.requiredItems.size() <= items.size()) {
            int count =  0;

            for (ItemStack recipeItem : this.requiredItems) {
                if (compareItems(items, recipeItem)) {
                    count++;
                }
            }
            if (count == this.requiredItems.size()) {
                boolean match = true;
                if (isEnchanted) {
                    match = match && compareItems(items, ENCHANTED_BOOK);
                }
                if (isMossy) {
                    match = match && compareItems(items, VINE);
                }
                return match;
            }
        }
        return false;
    }

    protected boolean compareItems(List<ItemStack> items, ItemStack recipeItem) {
        return items.stream().anyMatch((item) -> item != null && recipeItem.getItem().equals(item.getItem()) &&
                recipeItem.getMetadata() == item.getMetadata() && recipeItem.getCount() <= item.getCount());
    }
}
