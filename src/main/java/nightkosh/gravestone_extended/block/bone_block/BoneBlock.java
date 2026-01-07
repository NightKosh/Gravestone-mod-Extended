package nightkosh.gravestone_extended.block.bone_block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import nightkosh.gravestone_extended.core.GSEBlocks;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BoneBlock extends Block {

    public BoneBlock() {
        super(BlockBehaviour.Properties.of()
                .setId(GSEBlocks.BONE_BLOCK_RK)
                .sound(SoundType.BONE_BLOCK)
                .strength(0.5F));
    }

}
