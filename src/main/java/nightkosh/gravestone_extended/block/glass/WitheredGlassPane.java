package nightkosh.gravestone_extended.block.glass;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import nightkosh.gravestone_extended.core.GSEBlocks;

import javax.annotation.Nonnull;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class WitheredGlassPane extends IronBarsBlock {

    public WitheredGlassPane() {
        super(BlockBehaviour.Properties.of()
                .setId(GSEBlocks.WITHERED_GLASS_PANE_RK)
                .instrument(NoteBlockInstrument.HAT)
                .strength(4, Integer.MAX_VALUE)
                .sound(SoundType.GLASS)
                .noOcclusion());
    }

    @Override
    public boolean canEntityDestroy(
            @Nonnull BlockState state, @Nonnull BlockGetter level,
            @Nonnull BlockPos pos, @Nonnull Entity entity) {
        return false;
    }

    @Override
    protected boolean propagatesSkylightDown(@Nonnull BlockState state) {
        return false;
    }

    @Override
    protected int getLightBlock(@Nonnull BlockState state) {
        return 15;
    }

}
