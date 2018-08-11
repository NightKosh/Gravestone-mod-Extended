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

    //This fields should be out of their compatibility modules to prevent "ClassNotFoundException" or some other similar bugs in case of API lack
    public static boolean sophisticatedWolvesInstalled;
    public static boolean forestryInstalled;

    public void checkMods() {
        if (Loader.isModLoaded("mocreatures")) {
            CompatibilityMoCreatures.isInstalled = true;
            CompatibilityMoCreatures.addMobs();
        }

        if (Loader.isModLoaded("thaumcraft")) {
            CompatibilityThaumcraft.addReciepes();
            CompatibilityThaumcraft.addAspects();
            CompatibilityThaumcraft.addSwords();
        }

        if (Loader.isModLoaded(FORESTRY_ID)) {
            forestryInstalled = true;
        }

        if (Loader.isModLoaded("sophisticatedwolves")) {
            sophisticatedWolvesInstalled = true;
        }

        if (Loader.isModLoaded(CompatibilityInfernalMobs.ID)) {
            CompatibilityInfernalMobs.isInstalled = true;
            CompatibilityInfernalMobs.disableInfernalMobs();
        }


        if (Loader.isModLoaded("antiqueatlas")) {
            CompatibilityAntiqueAtlas.isInstalled = true;
        }
    }
}
