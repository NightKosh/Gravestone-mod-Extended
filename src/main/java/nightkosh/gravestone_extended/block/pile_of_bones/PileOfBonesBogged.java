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
public class PileOfBonesBogged extends APileOfBonesCrawler {

    public PileOfBonesBogged(Properties properties) {
        super(properties);
    }

    public PileOfBonesBogged() {
        this(Properties.of()
                .instrument(NoteBlockInstrument.XYLOPHONE)
                .setId(GSEBlocks.PILE_OF_BONES_SKULL_BOGGED_RK)
                .sound(SoundType.BONE_BLOCK)
                .noCollision()
                .strength(0.1F, 0));
    }

    public String getCrawler() {
        return BOGGED;
    }

}
