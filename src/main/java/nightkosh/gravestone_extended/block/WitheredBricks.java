package nightkosh.gravestone_extended.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import nightkosh.gravestone_extended.core.GSEBlocks;

import javax.annotation.Nonnull;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class WitheredBricks extends Block {

    public WitheredBricks() {
        super(Properties.of()
                .setId(GSEBlocks.WITHERED_BRICKS_RK)
                .mapColor(MapColor.NETHER)
                .sound(SoundType.NETHER_BRICKS)
                .instrument(NoteBlockInstrument.BASEDRUM)
                .strength(4, Integer.MAX_VALUE));
    }

    @Override
    public boolean canEntityDestroy(
            @Nonnull BlockState state, @Nonnull BlockGetter level,
            @Nonnull BlockPos pos, @Nonnull Entity entity) {
        return false;
    }

}
