package nightkosh.gravestone_extended.block.bone_block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import nightkosh.gravestone_extended.core.GSEBlocks;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BoneBlockSkullCrawler extends Block {

    public BoneBlockSkullCrawler() {
        super(Properties.of()
                .setId(GSEBlocks.BONE_BLOCK_SKULL_CRAWLER_RK)
                .sound(SoundType.BONE_BLOCK)
                .strength(0.5F));
    }
//
//    /**
//     * Called right before the block is destroyed by a player. Args: world, x, y, z, metaData
//     */
//    @Override
//    public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state) {
//        if (!world.isRemote && isSkullCrawlerBlock(state) && ExtendedConfig.spawnSkullCrawlersAtBoneBlockDestruction) {
//            EntitySkullCrawler skullCrawler = new EntitySkullCrawler(world);
//            skullCrawler.setLocationAndAngles(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, 0, 0);
//            world.spawnEntity(skullCrawler);
//            skullCrawler.spawnExplosionParticle();
//        }
//
//        super.onBlockDestroyedByPlayer(world, pos, state);
//    }
}
