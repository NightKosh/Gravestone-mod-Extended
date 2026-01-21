package nightkosh.gravestone_extended.block.bone_block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gamerules.GameRules;
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
public abstract class ABoneBlockCrawler extends Block {

    public ABoneBlockCrawler(Properties properties) {
        super(properties);
    }

    @Override
    protected void spawnAfterBreak(
            @Nonnull BlockState state, @Nonnull ServerLevel level, @Nonnull BlockPos pos,
            @Nonnull ItemStack stack, boolean dropExperience) {
        super.spawnAfterBreak(state, level, pos, stack, dropExperience);
        if (level.getGameRules().get(GameRules.BLOCK_DROPS) &&
                !EnchantmentHelper.hasTag(stack, EnchantmentTags.PREVENTS_INFESTED_SPAWNS)) {
            this.spawnCrawler(level, pos);
        }
    }

    protected void spawnCrawler(@Nonnull ServerLevel level, @Nonnull BlockPos pos) {
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
    }

    public Identifier getCrawler() {
        return SKELETON_CRAWLER;
    }

}
