package nightkosh.gravestone_extended.item.compass;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.helper.VanillaStructuresPositionHelper;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EnderSkull extends ImpSkull {

    private static final ResourceKey<Item> RK = ResourceKey.create(
            Registries.ITEM, fromNamespaceAndPath(ModInfo.ID, "ender_skull"));

    public EnderSkull() {
        super(new Item.Properties()
                .stacksTo(1)
                .rarity(Rarity.UNCOMMON)
                .equippable(EquipmentSlot.HEAD)
                .setId(RK));
    }

    @Override
    protected boolean isCorrectDimension(Level level) {
        return level.dimension() == Level.OVERWORLD;
    }

    @Override
    protected ResourceKey<Level> getLevelKey() {
        return Level.OVERWORLD;
    }

    protected BlockPos getPos(Player player) {
        return VanillaStructuresPositionHelper.getStrongHold(player);
    }

}
