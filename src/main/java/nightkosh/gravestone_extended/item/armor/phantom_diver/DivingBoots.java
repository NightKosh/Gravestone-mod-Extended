package nightkosh.gravestone_extended.item.armor.phantom_diver;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.helper.TimeHelper;
import org.jspecify.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class DivingBoots extends Item {

    private static final ResourceKey<Item> RK = ResourceKey.create(
            Registries.ITEM, fromNamespaceAndPath(ModInfo.ID, "diving_boots"));

    public DivingBoots() {
        super(new Item.Properties()
                .setId(RK)
                .rarity(Rarity.EPIC)
                .humanoidArmor(ArmorMaterials.IRON, ArmorType.BOOTS));
    }

    @Override
    public void inventoryTick(@Nonnull ItemStack stack, @Nonnull ServerLevel level,
                              @Nonnull Entity entity, @Nullable EquipmentSlot slot) {
        super.inventoryTick(stack, level, entity, slot);
        if (entity instanceof Player player &&
                player.getItemBySlot(EquipmentSlot.FEET).equals(stack)) {
            if (!level.isClientSide() && player.isUnderWater() && player.tickCount % 20 == 0) {
                player.addEffect(new MobEffectInstance(MobEffects.SPEED, TimeHelper.SECONDS_5,
                        0, true, false, true));
            }
        }
    }

    @Override
    public void appendHoverText(
            @Nonnull ItemStack stack, @Nonnull Item.TooltipContext context,
            @Nonnull TooltipDisplay tooltipDisplay, @Nonnull Consumer<Component> consumer,
            @Nonnull TooltipFlag flag) {
        consumer.accept(Component.translatable("item.gravestone_extended.diving_boots.tooltip"));

        super.appendHoverText(stack, context, tooltipDisplay, consumer, flag);
    }

}
