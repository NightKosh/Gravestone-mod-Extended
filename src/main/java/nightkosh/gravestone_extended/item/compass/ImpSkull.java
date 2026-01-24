package nightkosh.gravestone_extended.item.compass;

import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.LodestoneTracker;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import nightkosh.gravestone_extended.core.GSEConfigs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.helper.VanillaStructuresPositionHelper;
import org.jspecify.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.function.Consumer;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;
import static net.minecraft.resources.Identifier.withDefaultNamespace;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ImpSkull extends Item {

    protected static final ResourceKey<Level> UNEXISTED_DIMENSION =
            ResourceKey.create(Registries.DIMENSION, withDefaultNamespace("unexisted_dimension"));
    protected static final BlockPos UNEXISTED_POS = new BlockPos(0, 300, 0);

    private static final ResourceKey<Item> RK = ResourceKey.create(
            Registries.ITEM, fromNamespaceAndPath(ModInfo.ID, "imp_skull"));

    public ImpSkull(Item.Properties properties) {
        super(properties);
    }

    public ImpSkull() {
        super(new Item.Properties()
                .stacksTo(1)
                .rarity(Rarity.UNCOMMON)
                .equippable(EquipmentSlot.HEAD)
                .setId(RK));
    }

    @Override
    public void inventoryTick(
            @Nonnull ItemStack compass, ServerLevel level,
            @Nonnull Entity entity, @Nullable EquipmentSlot slot) {
        if (!level.isClientSide()) {
            if (entity instanceof Player player &&
                    ((slot == EquipmentSlot.MAINHAND || slot == EquipmentSlot.OFFHAND))) {
                if (isCorrectDimension(level)) {
                    if (player.tickCount % 20 == 0) {
                        var pos = getPos(player);
                        if (pos != null) {
                            boolean shouldUpdate = true;
                            var oldTracker = compass.get(DataComponents.LODESTONE_TRACKER);
                            if (oldTracker != null) {
                                var oldTarget = oldTracker.target();
                                if (oldTarget.isPresent() && oldTarget.get().pos().equals(pos)) {
                                    shouldUpdate = false;
                                }
                            }
                            if (shouldUpdate) {
                                var target = GlobalPos.of(getLevelKey(), pos);
                                compass.set(
                                        DataComponents.LODESTONE_TRACKER,
                                        new LodestoneTracker(Optional.of(target), false));
                            }
                        } else {
                            setUnexistedLocation(compass);
                        }
                    }
                } else {
                    setUnexistedLocation(compass);
                }
            }
        }
    }

    @Override
    public void appendHoverText(
            @Nonnull ItemStack stack, @Nonnull Item.TooltipContext context,
            @Nonnull TooltipDisplay tooltipDisplay, @Nonnull Consumer<Component> consumer,
            @Nonnull TooltipFlag flag) {
        super.appendHoverText(stack, context, tooltipDisplay, consumer, flag);

        var tracker = stack.get(DataComponents.LODESTONE_TRACKER);
        if (tracker != null) {
            var targetOpt = tracker.target();
            if (targetOpt.isPresent()) {
                if (!targetOpt.get().dimension().equals(UNEXISTED_DIMENSION)) {
                    consumer.accept(Component.translatable("item.gravestone_extended.compass_tooltip.direction"));
                    if (GSEConfigs.DEBUG_MODE.get()) {
                        consumer.accept(Component.literal(targetOpt.get().pos().toShortString()));
                    }
                    return;
                }
            }
        }
        consumer.accept(Component.translatable("item.gravestone_extended.compass_tooltip.not_found"));
    }

    protected void setUnexistedLocation(ItemStack compass) {
        var tracker = compass.get(DataComponents.LODESTONE_TRACKER);
        if (tracker != null) {
            var targetOpt = tracker.target();
            if (targetOpt.isPresent()) {
                if (targetOpt.get().dimension().equals(UNEXISTED_DIMENSION)) {
                    return;
                }
            }
        }

        var target = GlobalPos.of(UNEXISTED_DIMENSION, UNEXISTED_POS);
        compass.set(
                DataComponents.LODESTONE_TRACKER,
                new LodestoneTracker(Optional.of(target), true));
    }

    protected boolean isCorrectDimension(Level level) {
        return level.dimension() == Level.NETHER;
    }

    protected ResourceKey<Level> getLevelKey() {
        return Level.NETHER;
    }

    protected BlockPos getPos(Player player) {
        return VanillaStructuresPositionHelper.getNetherFortress(player);
    }

}
