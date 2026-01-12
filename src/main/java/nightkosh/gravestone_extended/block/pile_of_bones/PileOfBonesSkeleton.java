package nightkosh.gravestone_extended.block.pile_of_bones;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import nightkosh.gravestone_extended.core.GSEBlocks;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class PileOfBonesSkeleton extends APileOfBonesCrawler {

    public PileOfBonesSkeleton(Properties properties) {
        super(properties);
    }

    public PileOfBonesSkeleton() {
        this(Properties.of()
                .instrument(NoteBlockInstrument.XYLOPHONE)
                .setId(GSEBlocks.PILE_OF_BONES_SKULL_SKELETON_RK)
                .sound(SoundType.BONE_BLOCK)
                .noCollision()
                .strength(0.1F, 0));
    }

}
