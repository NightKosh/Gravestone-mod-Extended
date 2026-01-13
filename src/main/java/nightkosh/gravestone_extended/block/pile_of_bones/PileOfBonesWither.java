package nightkosh.gravestone_extended.block.pile_of_bones;

import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.PushReaction;
import nightkosh.gravestone_extended.core.GSEBlocks;

import static nightkosh.gravestone_extended.core.compatibility.WitheredLandsCompatibility.WITHER_CRAWLER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class PileOfBonesWither extends APileOfBonesCrawler {

    public PileOfBonesWither(Properties properties) {
        super(properties);
    }

    public PileOfBonesWither() {
        this(Properties.of()
                .instrument(NoteBlockInstrument.XYLOPHONE)
                .setId(GSEBlocks.PILE_OF_BONES_SKULL_WITHER_RK)
                .sound(SoundType.BONE_BLOCK)
                .noCollision()
                .pushReaction(PushReaction.DESTROY)
                .strength(0.1F, 0));
    }

    @Override
    public Identifier getCrawler() {
        return WITHER_CRAWLER;
    }

}
