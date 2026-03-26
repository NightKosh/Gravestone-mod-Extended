package nightkosh.gravestone_extended.core.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.block.FluidModel;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.ClientHooks;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterFluidModelsEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.client.event.ViewportEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import nightkosh.gravestone_extended.core.*;
import nightkosh.gravestone_extended.helper.FogHandler;
import nightkosh.gravestone_extended.models.armor.phantom_diver_costume.DivingHelmetModel;
import nightkosh.gravestone_extended.particle.*;
import nightkosh.gravestone_extended.renderer.entity.projectile.BoneFishHookRenderer;
import nightkosh.gravestone_extended.renderer.entity.projectile.WitheredFishHookRenderer;
import org.jspecify.annotations.Nullable;

import javax.annotation.Nonnull;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;
import static nightkosh.gravestone_extended.ModGravestoneExtended.LOGGER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@EventBusSubscriber(modid = ModInfo.ID, value = Dist.CLIENT)
public class GSEEventsClient {


    @SubscribeEvent
    public static void onRenderFog(ViewportEvent.RenderFog event) {
        if (GSEConfigs.GRAVES_FOG_ENABLED.get() && FogHandler.currentFog > 0) {
            float far = Mth.lerp(FogHandler.currentFog, FogHandler.MAX_FOG_DISTANCE, FogHandler.MIN_FOG_DISTANCE);

            event.setNearPlaneDistance(Math.max(0, far * 0.25F));
            event.setFarPlaneDistance(Math.min(far, event.getFarPlaneDistance()));
        }
    }

    @SubscribeEvent
    public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(GSEEntities.BONE_FISH_HOOK.get(), BoneFishHookRenderer::new);
        event.registerEntityRenderer(GSEEntities.WITHERED_FISH_HOOK.get(), WitheredFishHookRenderer::new);
    }

    @SubscribeEvent
    public static void onRegisterFluidModelsEvent(RegisterFluidModelsEvent event) {
        var blightwaterModel = new FluidModel.Unbaked(
                new Material(fromNamespaceAndPath(ModInfo.ID, "block/fluid/blightwater/still"), true),
                new Material(fromNamespaceAndPath(ModInfo.ID, "block/fluid/blightwater/flow"), true),
                null, null);
        event.register(blightwaterModel, GSEFluids.BLIGHTWATER);
        event.register(blightwaterModel, GSEFluids.BLIGHTWATER_FLOWING);
    }

    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(GSEParticles.BLIGHTWATER_BUBBLE.get(), BlightwaterBubbleParticle.Provider::new);
        event.registerSpriteSet(GSEParticles.BLIGHTWATER_DRIP.get(), BlightwaterDripParticle.HangProvider::new);
        event.registerSpriteSet(GSEParticles.BLIGHTWATER_FALL.get(), BlightwaterDripParticle.FallProvider::new);
        event.registerSpriteSet(GSEParticles.BLIGHTWATER_WAKE.get(), BlightwaterWakeParticle.Provider::new);
        event.registerSpriteSet(GSEParticles.BLIGHTWATER_SPLASH.get(), BlightwaterSplashParticle.Provider::new);
        event.registerSpriteSet(GSEParticles.GREEN_FLAME.get(), GreenFlameParticle.Provider::new);
        event.registerSpriteSet(GSEParticles.CATACOMBS_PORTAL.get(), CatacombsPortalParticle.Provider::new);
    }

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        if (GSEConfigs.DEBUG_MODE.get()) {
            LOGGER.info("EntityRenderersEvent.RegisterLayerDefinitions event triggered");
        }
        event.registerLayerDefinition(DivingHelmetModel.LAYER, DivingHelmetModel::createLayerDefinition);
    }

    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerItem(new IClientItemExtensions() {

            private DivingHelmetModel<?> cached;

            @Override
            public Identifier getArmorTexture(
                    @Nonnull ItemStack stack, @Nonnull EquipmentClientInfo.LayerType type,
                    @Nonnull EquipmentClientInfo.Layer layer, @Nonnull Identifier identifier) {
                return GSETextures.DIVING_HELMET;
            }

            @Nonnull
            @Override
            public Model getHumanoidArmorModel(
                    @Nonnull ItemStack itemStack, @Nonnull EquipmentClientInfo.LayerType layerType,
                    @Nonnull Model original) {
                if (original instanceof HumanoidModel<?> humanoidModel) {
                    if (cached == null) {
                        cached = new DivingHelmetModel<>(
                                Minecraft.getInstance()
                                        .getEntityModels()
                                        .bakeLayer(DivingHelmetModel.LAYER));
                    }
                    ClientHooks.copyModelProperties(humanoidModel, cached);
                    return cached;
                } else {
                    return original;
                }
            }
        }, GSEItems.DIVING_HELMET.get());

        event.registerItem(new IClientItemExtensions() {

            @Override
            public @Nullable Identifier getArmorTexture(
                    @Nonnull ItemStack stack, @Nonnull EquipmentClientInfo.LayerType type,
                    @Nonnull EquipmentClientInfo.Layer layer, @Nonnull Identifier identifier) {
                return GSETextures.DIVING_CHESTPLATE;
            }

        }, GSEItems.DIVING_CHESTPLATE.get());

        event.registerItem(new IClientItemExtensions() {

            @Override
            public @Nullable Identifier getArmorTexture(
                    @Nonnull ItemStack stack, @Nonnull EquipmentClientInfo.LayerType type,
                    @Nonnull EquipmentClientInfo.Layer layer, @Nonnull Identifier identifier) {
                return GSETextures.DIVING_LEGGINGS;
            }

        }, GSEItems.DIVING_LEGGINGS.get());

        event.registerItem(new IClientItemExtensions() {

            @Override
            public @Nullable Identifier getArmorTexture(
                    @Nonnull ItemStack stack, @Nonnull EquipmentClientInfo.LayerType type,
                    @Nonnull EquipmentClientInfo.Layer layer, @Nonnull Identifier identifier) {
                return GSETextures.DIVING_BOOTS;
            }

        }, GSEItems.DIVING_BOOTS.get());
    }

}
