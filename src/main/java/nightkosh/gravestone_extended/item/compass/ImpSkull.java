package nightkosh.gravestone_extended.item.compass;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import nightkosh.gravestone_extended.core.ModInfo;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ImpSkull extends Item {

    private static final ResourceKey<Item> RK = ResourceKey.create(
            Registries.ITEM, fromNamespaceAndPath(ModInfo.ID, "imp_skull"));

    public ImpSkull() {
        super(new Item.Properties()
                .stacksTo(1)
                .rarity(Rarity.UNCOMMON)
                .equippable(EquipmentSlot.HEAD)
                .setId(RK));
    }

    protected String getPropertyName() {
        return "angle";
    }

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
