package nightkosh.gravestone_extended.potion;

import nightkosh.gravestone_extended.core.GSPotion;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.item.IBoneItem;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class PotionRust extends PotionBase {

//    public PotionRust() {
//        super(true, 0x839f30);
//        this.setIconIndex(1, 0);
//        this.setRegistryName(ModInfo.ID, "gs_rust_potion");
//        this.setPotionName("potion.rust.title");
//    }
//
//    @Override
//    public void performEffect(EntityLivingBase entity, int amplifier) {
//        if (entity != null) {
//            for (PotionEffect potion : entity.getActivePotionEffects()) {
//                if (Potion.getIdFromPotion(potion.getPotion()) == Potion.getIdFromPotion(GSPotion.BONE_SKIN)) {
//                    return;
//                }
//            }
//
//            Iterable<ItemStack> equipment = entity.getEquipmentAndArmor();
//            if (equipment != null) {
//                for (ItemStack stack : equipment) {
//                    if (stack != null && stack != ItemStack.EMPTY && stack.isItemStackDamageable() && !(stack.getItem() instanceof IBoneItem)) {
//                        stack.damageItem(1, entity);
//                    }
//                }
//            }
//        }
//    }
//
//    @Override
//    public boolean isReady(int duration, int amplifier) {
//        int j = 25 >> amplifier;
//        return j <= 0 || duration % j == 0;
//    }
}
