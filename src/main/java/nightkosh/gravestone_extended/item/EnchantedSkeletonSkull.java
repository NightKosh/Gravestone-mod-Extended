package nightkosh.gravestone_extended.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
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
public class EnchantedSkeletonSkull extends Item {

    private static final ResourceKey<Item> RK = ResourceKey.create(
            Registries.ITEM, fromNamespaceAndPath(ModInfo.ID, "enchanted_skeleton_skull"));

    public EnchantedSkeletonSkull() {
        super(new Item.Properties()
                .stacksTo(1)
                .rarity(Rarity.RARE)
                .enchantable(1)
                .setId(RK));
    }

}
