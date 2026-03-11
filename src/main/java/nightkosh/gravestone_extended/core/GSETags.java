package nightkosh.gravestone_extended.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.Fluid;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSETags {

    public static final TagKey<Fluid> BLIGHTWATER = TagKey.create(
            Registries.FLUID,
            fromNamespaceAndPath(ModInfo.ID, "blightwater"));

    public static final TagKey<Item> MATERIAL_BONE = TagKey.create(
            Registries.ITEM,
            fromNamespaceAndPath(ModInfo.ID, "material_bone"));

}
