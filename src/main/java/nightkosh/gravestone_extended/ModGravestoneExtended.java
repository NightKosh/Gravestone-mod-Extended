package nightkosh.gravestone_extended;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import nightkosh.gravestone_extended.core.GSEBlocks;
import nightkosh.gravestone_extended.core.GSEItems;
import nightkosh.gravestone_extended.core.ModInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
//@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION,
//        dependencies = "required-after:" + nightkosh.gravestone.api.ModInfo.ID + "@[1.3.1,);after:" + nightkosh.advanced_fishing.api.ModInfo.ID + "@[1.3.2,);")
@Mod(ModInfo.ID)
public class ModGravestoneExtended {

    public static ModGravestoneExtended INSTANCE;

    public static final Logger LOGGER = LogManager.getLogger(ModInfo.ID);

//    static {
//        FluidRegistry.enableUniversalBucket();
//    }

    public ModGravestoneExtended(IEventBus eventBus, ModContainer container) {
        INSTANCE = this;

//        container.registerConfig(ModConfig.Type.COMMON, GSEConfigs.SPEC, ModInfo.ID + ".toml");

//        GSEEntities.register(eventBus);
//        GSESounds.register(eventBus);
        GSEBlocks.register(eventBus);
        GSEItems.register(eventBus);
//        GSETabs.register(eventBus);
//        GSEMobEffects.register(eventBus);
    }

//    @Mod.EventHandler
//    public void preInit(FMLPreInitializationEvent event) {
//        ExtendedConfig.getInstance(event.getModConfigurationDirectory().getAbsolutePath() + "/GraveStoneMod/", "GraveStone.cfg");
//
//        GSStructures.preInit();
//
////        MessageHandler.init();
//
//        GSTileEntity.registration();
//
////        CapabilityManager.INSTANCE.register(ICemetery.class, new CemeteryStorage(), Cemetery.class);
//
////        GSLootTables.registration();
////
////        GSDimensions.registration();
////
////        GSEntity.registration();
////
////        GSMaterials.registration();
//    }

    //TODO
//    @Mod.EventHandler
//    public void load(FMLInitializationEvent event) {
//        // register death event
//        MinecraftForge.EVENT_BUS.register(new GSEventsHandler());
//        MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
//        FMLCommonHandler.instance().bus().register(new TickEventHandler());
//        proxy.registerHandlers();
//
//        // reciepes registration
//        GSRecipes.registration();
//        GSRecipes.smeltingRecipesRegistration();
//
//        // register structures
//        GSStructures.registration();
//
//        GSParticles.registration();
//
//        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
//
//        proxy.registerMobsRenderers();
//
//        VillagersHandler.registerVillagers();
//
//        proxy.registerEggs();
//    }
//
//    @Mod.EventHandler
//    public void postInit(FMLPostInitializationEvent event) {
//        Compatibility.INSTANCE.checkMods();
//
//        CemeteryHelper.addGravePositionHandlers();
//
//        GraveGenerationHelper.addMobsItemsHandlers();
//
//        GraveSpawnerHelper.setGraveSpawnerHelper();
//
//        TileEntityGraveStone.fogHandler = new FogHandler();
//    }
//
//    @Mod.EventHandler
//    public void serverStarting(FMLServerStartingEvent event) {
//        ExtendedCommands.getInstance(event);
//    }
}