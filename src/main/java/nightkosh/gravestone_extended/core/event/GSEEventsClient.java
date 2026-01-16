package nightkosh.gravestone_extended.core.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.ClientHooks;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import nightkosh.gravestone_extended.core.GSEConfigs;
import nightkosh.gravestone_extended.core.GSETextures;
import nightkosh.gravestone_extended.core.GSEItems;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.models.armor.phantom_diver_costume.DivingHelmetModel;
import org.jspecify.annotations.Nullable;

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
            public @Nullable Identifier getArmorTexture(
                    ItemStack stack, EquipmentClientInfo.LayerType type,
                    EquipmentClientInfo.Layer layer, Identifier _default) {
                return GSETextures.DIVING_HELMET;
            }

            @Override
            public Model getHumanoidArmorModel(ItemStack itemStack, EquipmentClientInfo.LayerType layerType, Model original) {
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
                    ItemStack stack, EquipmentClientInfo.LayerType type,
                    EquipmentClientInfo.Layer layer, Identifier _default) {
                return GSETextures.DIVING_CHESTPLATE;
            }

        }, GSEItems.DIVING_CHESTPLATE.get());

        event.registerItem(new IClientItemExtensions() {

            @Override
            public @Nullable Identifier getArmorTexture(
                    ItemStack stack, EquipmentClientInfo.LayerType type,
                    EquipmentClientInfo.Layer layer, Identifier _default) {
                return GSETextures.DIVING_LEGGINGS;
            }

        }, GSEItems.DIVING_LEGGINGS.get());

        event.registerItem(new IClientItemExtensions() {

            @Override
            public @Nullable Identifier getArmorTexture(
                    ItemStack stack, EquipmentClientInfo.LayerType type,
                    EquipmentClientInfo.Layer layer, Identifier _default) {
                return GSETextures.DIVING_BOOTS;
            }

        }, GSEItems.DIVING_BOOTS.get());
    }

}
