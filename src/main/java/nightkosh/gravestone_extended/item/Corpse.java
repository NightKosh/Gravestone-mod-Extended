package nightkosh.gravestone_extended.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import nightkosh.gravestone_extended.core.GSEItems;
import nightkosh.gravestone_extended.helper.CorpseHelper;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Corpse extends Item {

    public Corpse(ResourceKey<Item> id) {
        super(new Properties()
                .stacksTo(64)
                .setId(id));
    }

    @Override
    public void appendHoverText(
            @Nonnull ItemStack stack, @Nonnull Item.TooltipContext context,
            @Nonnull TooltipDisplay tooltipDisplay, @Nonnull Consumer<Component> consumer,
            @Nonnull TooltipFlag flag) {
        var data = stack.get(DataComponents.CUSTOM_DATA);
        if (data != null) {
            var tag = data.copyTag();
            if (tag.contains(CorpseHelper.CUSTOM_NAME)) {
                // custom name
                var name = tag.getStringOr(CorpseHelper.CUSTOM_NAME, "");
                consumer.accept(Component.literal(name)
                        .withStyle(ChatFormatting.GOLD));
            }
            if (tag.contains(CorpseHelper.MOB_DATA)) {
                var mobData = tag.getCompound(CorpseHelper.MOB_DATA).get();

                // cats
                if (stack.is(GSEItems.CORPSE_CAT)) {
                    consumer.accept(Component.translatable(
                            "item.gravestone_extended.corpse_cat." + mobData.getStringOr(CorpseHelper.CAT_TYPE, ":tabby")
                                    .split(":", 2)[1])
                            .withStyle(ChatFormatting.YELLOW));
                }

                // wolves
                if (stack.is(GSEItems.CORPSE_DOG)) {
                    consumer.accept(Component.translatable(
                            "item.gravestone_extended.corpse_dog." + mobData.getStringOr(CorpseHelper.WOLF_TYPE, ":pale")
                                    .split(":", 2)[1])
                            .withStyle(ChatFormatting.YELLOW));
                }

                // villagers
                if (mobData.contains(CorpseHelper.VILLAGER_DATA)) {
                    var villagerData = mobData.getCompound(CorpseHelper.VILLAGER_DATA).get();
                    if (villagerData.contains(CorpseHelper.VILLAGER_PROFESSION)) {
                        consumer.accept(Component.translatable(
                                        "merchant.title",
                                        Component.translatable("entity.minecraft.villager." + villagerData.getStringOr(CorpseHelper.VILLAGER_PROFESSION, ":none")
                                                .split(":", 2)[1]),
                                        Component.translatable("merchant.level." + villagerData.getIntOr(CorpseHelper.VILLAGER_LEVEL, 0)))
                                .withStyle(ChatFormatting.YELLOW));
                    }
                }

                if (mobData.contains(CorpseHelper.VILLAGER_OFFERS)) {
                    var offers = mobData.getCompound(CorpseHelper.VILLAGER_OFFERS).get();
                    if (offers.contains(CorpseHelper.VILLAGER_OFFERS_RECIPES)) {
                        var recipes = offers.getList(CorpseHelper.VILLAGER_OFFERS_RECIPES).get();
                        consumer.accept(Component.translatable("merchant.trades")
                                .append(Component.literal(":"))
                                .withStyle(ChatFormatting.AQUA));
                        for (var recipe : recipes) {
                            if (recipe instanceof CompoundTag compTag && compTag.contains(CorpseHelper.VILLAGER_OFFERS_SELL)) {
                                var sell = compTag.getCompound(CorpseHelper.VILLAGER_OFFERS_SELL).get();
                                var itemId = sell.getStringOr(CorpseHelper.VILLAGER_OFFERS_ITEM_ID, "");

                                var itemHolder = BuiltInRegistries.ITEM.get(Identifier.parse(itemId));
                                if (itemHolder.isPresent()) {
                                    var components = sell.getCompound(CorpseHelper.VILLAGER_OFFERS_ITEM_COMPONENTS).orElse(null);
                                    var item = itemHolder.get().value();
                                    if (!Items.EMERALD.equals(item)) {
                                        var result = Component.empty()
                                                .append(item.getName());

                                        if (components != null && Items.ENCHANTED_BOOK.equals(item)) {
                                            var enchantment = components.getCompound(CorpseHelper.VILLAGER_OFFERS_ITEM_ENCHANTMENTS)
                                                    .orElse(null);
                                            if (enchantment != null) {
                                                enchantment.keySet()
                                                        .stream()
                                                        .findFirst()
                                                        .ifPresent(
                                                                s -> result.append(Component.literal(" - "))
                                                                        .append(Component.translatable(
                                                                                "enchantment." + s.replace(":", "."))));
                                            }
                                        }
                                        consumer.accept(result);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
