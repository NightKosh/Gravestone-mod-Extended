package nightkosh.gravestone_extended.core.compatibility;

import net.minecraftforge.fml.common.Loader;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Compatibility {

    public static final Compatibility INSTANCE = new Compatibility();

    public static final String FORESTRY_ID = "forestry";
    public static final String ADVANCED_FISHING_ID = "advanced-fishing";

    //This fields should be out of their compatibility modules to prevent "ClassNotFoundException" or some other similar bugs in case of API lack
    public static boolean advancedFishingInstalled;
    public static boolean sophisticatedWolvesInstalled;
    public static boolean forestryInstalled;

    public void checkMods() {
        if (isModLoaded("mocreatures")) {
            CompatibilityMoCreatures.isInstalled = true;
            CompatibilityMoCreatures.addMobs();
        }

        if (isModLoaded("thaumcraft")) {
            CompatibilityThaumcraft.addReciepes();
            CompatibilityThaumcraft.addAspects();
            CompatibilityThaumcraft.addSwords();
        }

        if (isModLoaded(FORESTRY_ID)) {
            forestryInstalled = true;
        }

        if (isModLoaded("sophisticatedwolves")) {
            sophisticatedWolvesInstalled = true;
        }

        if (isModLoaded(ADVANCED_FISHING_ID)) {
            advancedFishingInstalled = true;
        }

        if (isModLoaded(CompatibilityInfernalMobs.ID)) {
            CompatibilityInfernalMobs.isInstalled = true;
            CompatibilityInfernalMobs.disableInfernalMobs();
        }


        if (isModLoaded("antiqueatlas")) {
            CompatibilityAntiqueAtlas.isInstalled = true;
        }
    }

    public static boolean isModLoaded(String modId) {
        return Loader.isModLoaded(modId);
    }
}
