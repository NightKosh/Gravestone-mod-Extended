package nightkosh.gravestone_extended.item;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemEnchantedSkull {//TODO extends ItemEnchantedBook {
//
//    public ItemEnchantedSkull() {
//        this.setUnlocalizedName("gravestone.enchanted_skull");
//        this.setRegistryName(ModInfo.ID, "gs_enchanted_skull");
//        this.setCreativeTab(GSTabs.otherItemsTab);
//    }
//
//    @Override
//    public String getUnlocalizedName(ItemStack stack) {
//        return super.getUnlocalizedName(stack) + (stack.getMetadata() == 0 ? "" : "_withered");
//    }
//
//    public static ItemStack getEnchantedItemStack(EnchantmentData data, int meta) {
//        ItemStack itemstack = new ItemStack(GSItem.ENCHANTED_SKULL, 1, meta);
//        addEnchantment(itemstack, data);
//        return itemstack;
//    }
//
//    @Override
//    public boolean getHasSubtypes() {
//        return true;
//    }
//
//    @Override
//    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
//        if (this.isInCreativeTab(tab)) {
//            for (Enchantment enchantment : Enchantment.REGISTRY) {
//                if (enchantment.type != null) {
//                    items.add(getEnchantedItemStack(new EnchantmentData(enchantment, enchantment.getMaxLevel()), 0));
//                }
//            }
//            for (Enchantment enchantment : Enchantment.REGISTRY) {
//                if (enchantment.type != null) {
//                    items.add(getEnchantedItemStack(new EnchantmentData(enchantment, enchantment.getMaxLevel()), 1));
//                }
//            }
//        }
//    }
//
//    @Override
//    public int getItemEnchantability() {
//        return 1;
//    }
//
//    @Override
//    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
//        return true;
//    }
}
