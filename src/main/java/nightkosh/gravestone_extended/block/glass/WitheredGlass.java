package nightkosh.gravestone_extended.block.glass;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TintedGlassBlock;
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
public class WitheredGlass extends TintedGlassBlock {

    public WitheredGlass() {
        super(BlockBehaviour.Properties.of()
                .setId(GSEBlocks.WITHERED_GLASS_RK)
                .sound(SoundType.GLASS)
                .instrument(NoteBlockInstrument.HAT)
                .requiresCorrectToolForDrops()
                .noOcclusion()
                .isValidSpawn(Blocks::never)
                .isRedstoneConductor((state, level, pos) -> false)
                .isSuffocating((state, level, pos) -> false)
                .isViewBlocking((state, level, pos) -> false)
                .strength(30, Integer.MAX_VALUE));
    }

    @Override
    public boolean canEntityDestroy(
            @Nonnull BlockState state, @Nonnull BlockGetter level,
            @Nonnull BlockPos pos, @Nonnull Entity entity) {
        return false;
    }

}
