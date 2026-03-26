package nightkosh.gravestone_extended.block.bone_block;

import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import nightkosh.gravestone_extended.core.GSEBlocks;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BoneSlab extends SlabBlock {

    public BoneSlab() {
        super(BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.XYLOPHONE)
                .setId(GSEBlocks.BONE_SLAB_RK)
                .sound(SoundType.BONE_BLOCK)
                .strength(0.5F));
    }

}
