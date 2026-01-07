package nightkosh.gravestone_extended.item;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemImpSkull {//TODO extends Item {
//
//    public ItemImpSkull() {
//        this.setUnlocalizedName("gravestone.imp_skull");
//        this.setRegistryName(ModInfo.ID, getItemRegistryName());
//        this.setCreativeTab(GSTabs.otherItemsTab);
//
//        this.addPropertyOverride(new ResourceLocation(getPropertyName()), getPropertyGetter());
//    }
//
//    @Nullable
//    @Override
//    public EntityEquipmentSlot getEquipmentSlot(ItemStack stack) {
//        return EntityEquipmentSlot.HEAD;
//    }
//
//    protected String getItemRegistryName() {
//        return "gs_imp_skull";
//    }
//
//    protected String getPropertyName() {
//        return "angle";
//    }
//
//    protected IItemPropertyGetter getPropertyGetter() {
//        return new IItemPropertyGetter() {
//            double rotation;
//            double rota;
//            long lastUpdateTick;
//
//            @SideOnly(Side.CLIENT)
//            public float apply(ItemStack stack, @Nullable World world, @Nullable EntityLivingBase entity) {
//                if (entity == null || !(entity instanceof EntityPlayer) || stack.isOnItemFrame()) {
//                    return 0;
//                } else {
//                    if (world == null) {
//                        world = entity.world;
//                    }
//
//                    double d0;
//
//                    if (isCorrectDimension(world)) {
//                        double rotationYaw = MathHelper.positiveModulo(entity.rotationYaw / 360D, 1);
//                        double d2 = this.getPosToAngle((EntityPlayer) entity) / (Math.PI * 2);
//                        d0 = 0.5 - (rotationYaw - 0.25 - d2);
//                    } else {
//                        d0 = Math.random();
//                    }
//
//                    return MathHelper.positiveModulo((float) this.wobble(world, d0), 1);
//                }
//            }
//
//            @SideOnly(Side.CLIENT)
//            private double wobble(World world, double d0) {
//                if (world.getTotalWorldTime() != this.lastUpdateTick) {
//                    this.lastUpdateTick = world.getTotalWorldTime();
//                    d0 = MathHelper.positiveModulo(d0 - this.rotation + 0.5, 1) - 0.5;
//                    this.rota += d0 * 0.1;
//                    this.rota *= 0.8;
//                    this.rotation = MathHelper.positiveModulo(this.rotation + this.rota, 1);
//                }
//
//                return this.rotation;
//            }
//
//            @SideOnly(Side.CLIENT)
//            private double getPosToAngle(EntityPlayer player) {
//                BlockPos pos = getPos(player);
//                return Math.atan2(pos.getZ() - player.posZ, pos.getX() - player.posX);
//            }
//        };
//    }
//
//    protected boolean isCorrectDimension(World world) {
//        return world.provider.isNether();
//    }
//
//    protected BlockPos getPos(EntityPlayer player) {
//        return VanillaStructuresPosition.getNetherFortress(player);
//    }
}
