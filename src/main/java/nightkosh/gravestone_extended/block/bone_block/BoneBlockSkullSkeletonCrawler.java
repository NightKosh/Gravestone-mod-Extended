package nightkosh.gravestone_extended.block.bone_block;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import nightkosh.gravestone_extended.core.GSEBlocks;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BoneBlockSkullSkeletonCrawler extends ABoneBlockCrawler {

    public BoneBlockSkullSkeletonCrawler() {
        super(Properties.of()
                .instrument(NoteBlockInstrument.XYLOPHONE)
                .setId(GSEBlocks.BONE_BLOCK_SKULL_SKELETON_CRAWLER_RK)
                .sound(SoundType.BONE_BLOCK)
                .strength(0.5F));
    }

}
