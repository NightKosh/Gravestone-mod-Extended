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
public class EnderSkull extends Item {

    private static final ResourceKey<Item> RK = ResourceKey.create(
            Registries.ITEM, fromNamespaceAndPath(ModInfo.ID, "ender_skull"));

    public EnderSkull() {
        super(new Item.Properties()
                .stacksTo(1)
                .rarity(Rarity.UNCOMMON)
                .equippable(EquipmentSlot.HEAD)
                .setId(RK));
    }
//
//    @Override
//    protected boolean isCorrectDimension(World world) {
//        return world.provider.isSurfaceWorld();
//    }
//
//    @Override
//    protected BlockPos getPos(EntityPlayer player) {
//        return VanillaStructuresPosition.getStrongHold(player);
//    }
}
