package nightkosh.gravestone_extended.enchantment;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EnchantmentBloodyReplication {//TODO extends EnchantmentTreasure {
//
//    public EnchantmentBloodyReplication() {
//        super(Rarity.VERY_RARE, EnumEnchantmentType.DIGGER, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
//        this.setName("bloody_replication");
//        this.setRegistryName(ModInfo.ID, "gs_bloody_replication");
//    }
//
//    @Override
//    public int getMinEnchantability(int enchantmentLevel) {
//        return 5 + (enchantmentLevel - 1) * 8;
//    }
//
//    @Override
//    public int getMaxEnchantability(int enchantmentLevel) {
//        return super.getMinEnchantability(enchantmentLevel) + 60;
//    }
//
//    @Override
//    public int getMaxLevel() {
//        return 4;
//    }
//
//    @Override
//    public boolean canApply(ItemStack stack) {
//        return super.canApply(stack) && stack.getItem() instanceof IBoneAxe;
//    }
//
//    public static boolean applyEffect(LivingEntity entity, IBlockState state, BlockPos pos) {
//        if (!entity.isSneaking()) {
//            ItemStack axe = entity.getHeldItemMainhand();
//            if (axe.getItem() instanceof IBoneAxe) {
//                if (!axe.isEmpty()) {
//                    int level = GSEnchantmentHelper.getEnchantmentLevel(axe, GSEnchantment.BLOODY_REPLICATION);
//                    if (level > 0) {
//                        var block = state.getBlock();
//                        if (!(level == 4 && entity.getHealth() < 0.3) && block instanceof BlockLog) {
//                            block.dropBlockAsItem(entity.level(), entity.blockPosition(), state, 0);
//                            float damage;
//                            switch (level) {
//                                case 1:
//                                    damage = 1.5F;
//                                    break;
//                                case 2:
//                                    damage = 1;
//                                    break;
//                                case 3:
//                                    damage = 0.6F;
//                                    break;
//                                default:
//                                    damage = 0.25F;
//                                    break;
//                            }
//                            entity.attackEntityFrom(DamageSource.MAGIC, damage);
//                            axe.damageItem(1, entity);
//                            return true;
//                        } else {
//                            return false;
//                        }
//                    }
//                }
//            }
//        }
//        return false;
//    }

}
