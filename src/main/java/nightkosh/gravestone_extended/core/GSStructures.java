package nightkosh.gravestone_extended.core;

import nightkosh.gravestone_extended.core.logger.GSLogger;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSStructures {
//TODO
//    public static final Block[] VALUABLE_BLOCKS = {
//            Blocks.GOLD_BLOCK, Blocks.LAPIS_BLOCK, Blocks.REDSTONE_BLOCK,
//            Blocks.GOLD_BLOCK, Blocks.LAPIS_BLOCK, Blocks.REDSTONE_BLOCK,
//            Blocks.DIAMOND_BLOCK, Blocks.EMERALD_BLOCK
//    };

    private GSStructures() {
    }

    public static void preInit() {
        // register memorials
        if (GSEConfigs.generateVillageMemorials) {
            try {
//                MapGenStructureIO.registerStructureComponent(ComponentVillageMemorial.class, "GSVillageMemorial");
            } catch (Throwable e) {
                GSLogger.logError("Can not register ComponentGSVillageMemorial");
                e.printStackTrace();
            }
        }

        // register Undertaker
        if (GSEConfigs.generateUndertaker) {
            try {
//                MapGenStructureIO.registerStructureComponent(ComponentVillageUndertaker.class, "GSUndertakerHouse");
            } catch (Throwable e) {
                GSLogger.logError("Can not register ComponentGSVillageUndertaker");
                e.printStackTrace();
            }
        }
    }

    public static void registration() {
        // register memorials
        if (GSEConfigs.generateVillageMemorials) {
//            VillagerRegistry.instance().registerVillageCreationHandler(villageMemorialHandler);
        }

        // register Undertaker
        if (GSEConfigs.generateUndertaker) {
//            VillagerRegistry.instance().registerVillageCreationHandler(villageUndertakerHandler);
        }

        // structure generator
//        GameRegistry.registerWorldGenerator(new GraveStoneWorldGenerator(), 50);
    }
}
