package nightkosh.gravestone_extended.core.compatibility;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootParams;
import nightkosh.advanced_fishing.api.AdvancedFishingAPI;
import nightkosh.advanced_fishing.core.CatchManager;
import nightkosh.advanced_fishing.core.LootTables;
import nightkosh.gravestone_extended.core.GSEBlocks;
import nightkosh.gravestone_extended.core.GSEConfigs;
import nightkosh.gravestone_extended.core.GSEParticles;
import nightkosh.gravestone_extended.core.GSLootTables;

import java.util.List;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;
import static nightkosh.advanced_fishing.ModAdvancedFishing.LOGGER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AdvancedFishingCompatibility extends ACompatibility {

    public static final String ADVANCED_FISHING_ID = "advanced_fishing";

    public static final String NETHER_FISHING_TREASURE_LOOT_TABLE = "advanced_fishing:gameplay/fishing/nether/treasure";
    public static final String NETHER_FISHING_TREASURE_POOL_NAME = "fishing_nether_treasure";

    public static final String FISHING_DEAD_TREASURE_LOOT_TABLE = "advanced_fishing:gameplay/fishing/dead/treasure";
    public static final String FISHING_DEAD_TREASURE_POOL_NAME = "fishing_dead_treasure";

    public static final Item BLUE_JELLYFISH = getFish("blue_jellyfish");
    public static final Item MAGMA_JELLYFISH = getFish("magma_jellyfish");
    public static final Item GREEN_JELLYFISH = getFish("green_jellyfish");
    public static final Item PIRANHA = getFish("piranha");
    public static final Item ANGLER_FISH = getFish("angler_fish");
    public static final Item CAVE_TROUT = getFish("cave_trout");
    public static final Item GOLDEN_KOI = getFish("golden_koi");
    public static final Item FLAREFIN_KOI = getFish("flarefin_koi");
    public static final Item CHORUS_KOI = getFish("chorus_koi");
    public static final Item WITHERED_CRUCIAN = getFish("withered_crucian");
    public static final Item BONE_FISH = getFish("bone_fish");
    public static final Item SPOOKYFIN = getFish("spookyfin");
    public static final Item SPECULAR_SNAPPER = getFish("specular_snapper");
    public static final Item SNOWY_WALLEYE = getFish("snowy_walleye");
    public static final Item GLACIER_ANCHOVY = getFish("glacier_anchovy");

    private static Item getFish(String id) {
        var holder = BuiltInRegistries.ITEM.get(fromNamespaceAndPath(ADVANCED_FISHING_ID, id));
        return holder.isPresent() ?
                holder.get().value() :
                Items.NETHER_STAR;
    }

    public static boolean loaded() {
        return loaded(ADVANCED_FISHING_ID);
    }

//TODO
//    public static Item getBoneFishingPole() {
//        return new ItemBoneFishingPole();
//    }
//    public static boolean isBoneHook(Entity entity) {
//        return entity instanceof EntityBoneFishHook;
//    }


    protected static List<ItemStack> getBlightwaterCatch(LootParams.Builder lootBuilder, Level level, BlockPos pos, float luck) {
        var biomeHolder = level.getBiome(pos);

        if (GSEConfigs.DEBUG_MODE.get()) {
            LOGGER.info("Get fishing catch from Blightwater, fishing in " + CatchManager.getBiomeRes(biomeHolder));
        }

        int chance = CatchManager.getChance(level.random, luck);
        if (chance < 10) {
            if (GSEConfigs.DEBUG_MODE.get()) {
                LOGGER.info("Going to catch junk");
            }
            return CatchManager.getCatch(lootBuilder, level, LootTables.FISHING_JUNK);
        } else if (chance < 95) {
            if (GSEConfigs.DEBUG_MODE.get()) {
                LOGGER.info("Fishing in " + CatchManager.getBiomeRes(biomeHolder));
            }

            var list = CatchManager.getCatch(lootBuilder, level, LootTables.FISHING_DEAD);
            if (list.isEmpty()) {
                if (GSEConfigs.DEBUG_MODE.get()) {
                    LOGGER.info("No specific catch! Trying to get default catch.");
                }
                list = CatchManager.getCatch(lootBuilder, level, LootTables.FISHING_JUNK);
            }
            return list;
        } else {
            return CatchManager.getCatch(lootBuilder, level, LootTables.FISHING_DEAD_TREASURE);
        }
    }

    static {
        AdvancedFishingAPI.PARTICLES_MANAGER.addSplashParticles(GSEBlocks.BLIGHTWATER.get(), AdvancedFishingCompatibility::spawnBlightwaterSplashParticles);
        AdvancedFishingAPI.PARTICLES_MANAGER.addBubbleParticles(GSEBlocks.BLIGHTWATER.get(), AdvancedFishingCompatibility::spawnBlightwaterBubbleParticles);
        AdvancedFishingAPI.PARTICLES_MANAGER.addWakeParticles(GSEBlocks.BLIGHTWATER.get(), AdvancedFishingCompatibility::spawnBlightwaterWakeParticles);

        AdvancedFishingAPI.CATCH_MANAGER.addCatch(GSEBlocks.BLIGHTWATER.get(), AdvancedFishingCompatibility::getBlightwaterCatch);
    }

    protected static void spawnBlightwaterSplashParticles(
            ServerLevel level,
            double x, double y, double z,
            int num,
            double xOffset, double yOffset, double zOffset,
            double speed) {
        level.sendParticles(ParticleTypes.SMOKE, x, y, z, num, 0.1, 0, 0.1, 0);
        level.sendParticles(GSEParticles.BLIGHTWATER_SPLASH.get(), x, y, z, num, 0.1, 0, 0.1, 0);
    }

    protected static void spawnBlightwaterBubbleParticles(
            ServerLevel level,
            double x, double y, double z,
            int num,
            double xOffset, double yOffset, double zOffset,
            double speed) {
        level.sendParticles(GSEParticles.BLIGHTWATER_BUBBLE.get(), x, y, z, num, xOffset, yOffset, zOffset, speed);
    }

    protected static void spawnBlightwaterWakeParticles(
            ServerLevel level,
            double x, double y, double z,
            int num,
            double xOffset, double yOffset, double zOffset,
            double speed) {
        level.sendParticles(ParticleTypes.SMOKE, x, y, z, num, xOffset, yOffset, zOffset, speed);
        level.sendParticles(GSEParticles.BLIGHTWATER_WAKE.get(), x, y, z, num, xOffset, yOffset, zOffset, speed);
    }

}
