package nightkosh.gravestone_extended.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone_extended.core.GSItem;
import nightkosh.gravestone_extended.core.MessageHandler;
import nightkosh.gravestone_extended.helper.VanillaStructuresPosition;
import nightkosh.gravestone_extended.packets.SeedMessageToServer;

import javax.annotation.Nullable;
import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemSlimeChunk extends ItemImpSkull {

    public ItemSlimeChunk() {
        this.setUnlocalizedName("gravestone.slime_chunk");
    }

    @Override
    protected String getItemRegistryName() {
        return "gs_slime_chunk";
    }

    @Override
    protected String getPropertyName() {
        return "size";
    }

    protected IItemPropertyGetter getPropertyGetter() {
        return new IItemPropertyGetter() {
            long lastUpdateTick;
            byte tick = 0;
            byte size = 0;

            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World world, @Nullable EntityLivingBase entity) {
                if (entity == null || stack.isOnItemFrame()) {
                    return 0;
                } else {
                    if (world == null) {
                        world = entity.world;
                    }

                    if (!world.getWorldInfo().getTerrainType().handleSlimeSpawnReduction(world.rand, world)) {
                        if (VanillaStructuresPosition.SEEDS.containsKey(world.getWorldInfo().getWorldName())) {
                            long seed = VanillaStructuresPosition.SEEDS.get(world.getWorldInfo().getWorldName());
                            int x = MathHelper.floor(entity.posX / 16D);
                            int z = MathHelper.floor(entity.posZ / 16D);
                            Random r = new Random(seed + x * x * 4987142 + x * 5947611 + z * z * 4392871L + z * 389711 ^ 987234911L);
                            if (world.provider.isSurfaceWorld() && r.nextInt(10) == 0) {
                                if (world.getTotalWorldTime() != this.lastUpdateTick) {
                                    this.lastUpdateTick = world.getTotalWorldTime();
                                    tick++;
                                    if (tick == 2) {
                                        tick = 0;
                                        size++;
                                        if (size == 8) {
                                            size = 0;
                                            if (entity.getHeldItemMainhand().getItem() == GSItem.SLIME_CHUNK || entity.getHeldItemOffhand().getItem() == GSItem.SLIME_CHUNK) {
                                                entity.playSound(SoundEvents.ENTITY_SLIME_JUMP, 0.2F, (entity.getRNG().nextFloat() - entity.getRNG().nextFloat()) * 0.2F + 1);
                                            }
                                        }
                                    }
                                }
                            } else {
                                tick = 0;
                                size = 0;
                            }
                        } else {
                            MessageHandler.networkWrapper.sendToServer(new SeedMessageToServer());
                        }
                    }

                    return size;
                }
            }
        };
    }
}
