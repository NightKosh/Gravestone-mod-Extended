package nightkosh.gravestone_extended.enchantment.curse;

import nightkosh.gravestone_extended.core.GSEnchantment;
import nightkosh.gravestone_extended.core.ModInfo;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EnchantmentAwkwardCurse extends EnchantmentCurse {
//TODO
//    public EnchantmentAwkwardCurse() {
//        super(EnumEnchantmentType.WEAPON, HAND_SLOTS);
//        this.setName("awkward_curse");
//        this.setRegistryName(ModInfo.ID, "gs_awkward_curse");
//    }
//
//    public static boolean applyCurseEffect(DamageSource damageSource, EntityLivingBase mob, float damage) {
//        if (damageSource.getTrueSource() instanceof EntityLivingBase) {
//            EntityLivingBase attacker = (EntityLivingBase) damageSource.getTrueSource();
//            ItemStack stack = attacker.getHeldItemMainhand();
//
//            if (!stack.isEmpty()) {
//                NBTTagList nbtList = stack.getEnchantmentTagList();
//                for (NBTBase nbt : nbtList) {
//                    if (((NBTTagCompound) nbt).getInteger("id") == Enchantment.getEnchantmentID(GSEnchantment.CURSE_AWKWARD)) {
//                        if (attacker.world.rand.nextInt(10) == 0) {
////                            attacker.attackEntityFrom(DamageSource.causeIndirectDamage(mob, attacker).setDamageBypassesArmor().setDamageIsAbsolute(), damage);
//                            attacker.attackEntityFrom(DamageSource.MAGIC.setDamageIsAbsolute(), damage);
//                            return true;
//                        }
//                    }
//                }
//            }
//        }
//        return false;
//    }
}
