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
public class SlimeChunk extends Item {

    private static final ResourceKey<Item> RK = ResourceKey.create(
            Registries.ITEM, fromNamespaceAndPath(ModInfo.ID, "slime_chunk"));

    public SlimeChunk() {
        super(new Item.Properties()
                .stacksTo(1)
                .rarity(Rarity.UNCOMMON)
                .equippable(EquipmentSlot.HEAD)
                .setId(RK));
    }
//
//    @Override
//    protected String getPropertyName() {
//        return "size";
//    }
//
//    protected IItemPropertyGetter getPropertyGetter() {
//        return new IItemPropertyGetter() {
//            long lastUpdateTick;
//            byte tick = 0;
//            byte size = 0;
//
//            @SideOnly(Side.CLIENT)
//            public float apply(ItemStack stack, @Nullable World world, @Nullable EntityLivingBase entity) {
//                if (entity == null || stack.isOnItemFrame()) {
//                    return 0;
//                } else {
//                    if (world == null) {
//                        world = entity.world;
//                    }
//
//                    if (!world.getWorldInfo().getTerrainType().handleSlimeSpawnReduction(world.rand, world)) {
//                        if (VanillaStructuresPosition.SEEDS.containsKey(world.getWorldInfo().getWorldName())) {
//                            long seed = VanillaStructuresPosition.SEEDS.get(world.getWorldInfo().getWorldName());
//                            int x = MathHelper.floor(entity.posX / 16D);
//                            int z = MathHelper.floor(entity.posZ / 16D);
//                            Random r = new Random(seed + x * x * 4987142 + x * 5947611 + z * z * 4392871L + z * 389711 ^ 987234911L);
//                            if (world.provider.isSurfaceWorld() && r.nextInt(10) == 0) {
//                                if (world.getTotalWorldTime() != this.lastUpdateTick) {
//                                    this.lastUpdateTick = world.getTotalWorldTime();
//                                    tick++;
//                                    if (tick == 2) {
//                                        tick = 0;
//                                        size++;
//                                        if (size == 8) {
//                                            size = 0;
//                                            if (entity.getHeldItemMainhand().getItem() == GSItem.SLIME_CHUNK || entity.getHeldItemOffhand().getItem() == GSItem.SLIME_CHUNK) {
//                                                entity.playSound(SoundEvents.ENTITY_SLIME_JUMP, 0.2F, (entity.getRNG().nextFloat() - entity.getRNG().nextFloat()) * 0.2F + 1);
//                                            }
//                                        }
//                                    }
//                                }
//                            } else {
//                                tick = 0;
//                                size = 0;
//                            }
//                        } else {
//                            MessageHandler.networkWrapper.sendToServer(new SeedMessageToServer());
//                        }
//                    }
//
//                    return size;
//                }
//            }
//        };
//    }
}
