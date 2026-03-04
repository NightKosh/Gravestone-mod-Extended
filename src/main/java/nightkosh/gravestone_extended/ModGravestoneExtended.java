package nightkosh.gravestone_extended;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import nightkosh.gravestone_extended.core.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@Mod(ModInfo.ID)
public class ModGravestoneExtended {

    public static ModGravestoneExtended INSTANCE;

    public static final Logger LOGGER = LogManager.getLogger(ModInfo.ID);

//    static {
//        FluidRegistry.enableUniversalBucket();
//    }

    public ModGravestoneExtended(IEventBus eventBus, ModContainer container) {
        INSTANCE = this;

        container.registerConfig(ModConfig.Type.COMMON, GSEConfigs.SPEC, ModInfo.ID + ".toml");

//        GSEEntities.register(eventBus);
//        GSESounds.register(eventBus);
        GSEBlocks.register(eventBus);
        GSEItems.register(eventBus);
        GSEBlockEntities.register(eventBus);
        GSETabs.register(eventBus);
        GSEMobEffects.register(eventBus);
        GSEPotions.register(eventBus);
        GSEMenus.register(eventBus);
        GSEVillagers.register(eventBus);
    }

//    @Mod.EventHandler
//    public void preInit(FMLPreInitializationEvent event) {
////        MessageHandler.init();
//
////        CapabilityManager.INSTANCE.register(ICemetery.class, new CemeteryStorage(), Cemetery.class);
//
////        GSLootTables.registration();
////
////        GSDimensions.registration();
////
////        GSMaterials.registration();
//    }

    //TODO
//    @Mod.EventHandler
//    public void load(FMLInitializationEvent event) {
//        // register structures
//        GSStructures.registration();
//
//        GSParticles.registration();
//    }

}