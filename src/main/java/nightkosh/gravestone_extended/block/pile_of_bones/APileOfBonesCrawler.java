package nightkosh.gravestone_extended.block.pile_of_bones;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import nightkosh.gravestone_extended.core.GSEConfigs;
import nightkosh.gravestone_extended.core.compatibility.WitheredLandsCompatibility;

import javax.annotation.Nonnull;

import static nightkosh.gravestone_extended.core.compatibility.WitheredLandsCompatibility.SKELETON_CRAWLER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class APileOfBonesCrawler extends PileOfBones {

    public APileOfBonesCrawler(Properties properties) {
        super(properties);
    }

    @Override
    public boolean onDestroyedByPlayer(
            @Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos,
            @Nonnull Player player, @Nonnull ItemStack toolStack, boolean willHarvest,
            @Nonnull FluidState fluid) {
        if (!level.isClientSide() && GSEConfigs.SPAWN_CRAWLERS_AT_BLOCK_DESTRUCTION.get() &&
                WitheredLandsCompatibility.loaded()) {
            var id = getCrawler();
            var type = BuiltInRegistries.ENTITY_TYPE.get(id);
            if (type.isPresent() && type.get().value() != null) {
                var crawler = type.get().value().create(level, EntitySpawnReason.EVENT);
                crawler.snapTo(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0, 0);
                level.addFreshEntity(crawler);
            }
        }

        return super.onDestroyedByPlayer(state, level, pos, player, toolStack, willHarvest, fluid);
    }

    public Identifier getCrawler() {
        return SKELETON_CRAWLER;
    }

}
