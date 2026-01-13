package nightkosh.gravestone_extended.block.bone_block;

import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import nightkosh.gravestone_extended.core.GSEBlocks;

import static nightkosh.gravestone_extended.core.compatibility.WitheredLandsCompatibility.PIGLIN_CRAWLER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BoneBlockPiglinCrawler extends ABoneBlockCrawler {

    public BoneBlockPiglinCrawler() {
        super(Properties.of()
                .instrument(NoteBlockInstrument.XYLOPHONE)
                .setId(GSEBlocks.BONE_BLOCK_PIGLIN_CRAWLER_RK)
                .sound(SoundType.BONE_BLOCK)
                .strength(0.5F));
    }

    @Override
    public Identifier getCrawler() {
        return PIGLIN_CRAWLER;
    }

}
