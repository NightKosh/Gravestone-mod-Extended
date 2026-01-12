package nightkosh.gravestone_extended.block.bone_block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.fml.ModList;
import nightkosh.gravestone_extended.core.GSEConfigs;

import javax.annotation.Nonnull;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class ABoneBlockCrawler extends Block {

    private static final String WL_MOD_ID = "withered_lands";
    protected static final String SKELETON = "skeleton_skull_crawler";
    protected static final String STRAY = "stray_skull_crawler";
    protected static final String BOGGED = "bogged_skull_crawler";
    protected static final String PARCHED = "parched_skull_crawler";
    protected static final String WITHER = "wither_skull_crawler";
    protected static final String ZOMBIE = "zombie_skull_crawler";
    protected static final String HUSK = "husk_skull_crawler";
    protected static final String DROWNED = "drowned_skull_crawler";
    protected static final String PIGLIN = "piglin_skull_crawler";

    public ABoneBlockCrawler(Properties properties) {
        super(properties);
    }

    @Override
    public boolean onDestroyedByPlayer(
            @Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos,
            @Nonnull Player player, @Nonnull ItemStack toolStack, boolean willHarvest,
            @Nonnull FluidState fluid) {
        if (!level.isClientSide() && GSEConfigs.SPAWN_CRAWLERS_AT_BLOCK_DESTRUCTION.get() &&
                ModList.get().isLoaded(WL_MOD_ID)) {
            var id = fromNamespaceAndPath(WL_MOD_ID, getCrawler());
            var type = BuiltInRegistries.ENTITY_TYPE.get(id);
            if (type.isPresent() && type.get().value() != null) {
                var crawler = type.get().value().create(level, EntitySpawnReason.EVENT);
                crawler.snapTo(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0, 0);
                level.addFreshEntity(crawler);
            }
        }

        return super.onDestroyedByPlayer(state, level, pos, player, toolStack, willHarvest, fluid);
    }

    public String getCrawler() {
        return SKELETON;
    }

}
