package nightkosh.gravestone_extended.core;

import net.minecraft.resources.Identifier;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSETextures {

    private static final String GUI_LOCATION = "textures/gui/";

    public static Identifier DIVING_HELMET = fromNamespaceAndPath(ModInfo.ID, "textures/equipment/phantom_diver/helmet.png");
    public static Identifier DIVING_CHESTPLATE = fromNamespaceAndPath(ModInfo.ID, "textures/equipment/phantom_diver/chestplate.png");
    public static Identifier DIVING_LEGGINGS = fromNamespaceAndPath(ModInfo.ID, "textures/equipment/phantom_diver/leggings.png");
    public static Identifier DIVING_BOOTS = fromNamespaceAndPath(ModInfo.ID, "textures/equipment/phantom_diver/boots.png");

    // gui
    public static final Identifier ALTAR_RESURRECTION_GUI = fromNamespaceAndPath(ModInfo.ID, GUI_LOCATION + "altar/resurrection.png");
    public static final Identifier ALTAR_ENCHANTMENT_GUI = fromNamespaceAndPath(ModInfo.ID, GUI_LOCATION + "altar/enchanting.png");
    public static final Identifier ALTAR_DISENCHANTMENT_GUI = fromNamespaceAndPath(ModInfo.ID, GUI_LOCATION + "altar/disenchanting.png");

}
