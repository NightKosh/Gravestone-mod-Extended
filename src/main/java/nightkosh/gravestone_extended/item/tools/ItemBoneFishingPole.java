package nightkosh.gravestone_extended.item.tools;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemBoneFishingPole {//TODO extends AbstractFishingPole implements IBoneFishingPole {
//
//    public ItemBoneFishingPole() {
//        this.setMaxDamage(250);
//        this.setCreativeTab(GSTabs.otherItemsTab);
//        this.setUnlocalizedName("gravestone.bone_fishing_pole");
//        this.setRegistryName(ModInfo.ID, "gs_bone_fishing_pole");
//    }
//
//    @Override
//    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
//        return super.getIsRepairable(toRepair, repair) || repair.getItem() == Item.getItemFromBlock(GSBlock.BONE_BLOCK);
//    }
//
//    @Override
//    protected EntityBoneFishHook getHook(World world, EntityPlayer player, ItemStack stack) {
//        boolean hellishAngling = false;
//        NBTTagList nbtList = stack.getEnchantmentTagList();
//        for (NBTBase nbt : nbtList) {
//            if (((NBTTagCompound) nbt).getInteger("id") == Enchantment.getEnchantmentID(GSEnchantment.HELLISH_ANGLING)) {
//                hellishAngling = true;
//                break;
//            }
//        }
//        if (hellishAngling) {
//            return new EntityObsidianFishHook(world, player);
//        } else {
//            return new EntityBoneFishHook(world, player);
//        }
//    }
}
