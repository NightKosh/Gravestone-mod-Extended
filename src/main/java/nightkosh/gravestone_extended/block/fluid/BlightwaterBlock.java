package nightkosh.gravestone_extended.block.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.redstone.Orientation;
import nightkosh.gravestone_extended.core.GSEFluids;
import nightkosh.gravestone_extended.core.ModInfo;
import org.jspecify.annotations.Nullable;

import javax.annotation.Nonnull;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlightwaterBlock extends LiquidBlock {

    public static final ResourceKey RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "blightwater"));

    public BlightwaterBlock() {
        super(GSEFluids.BLIGHTWATER.get(), BlockBehaviour.Properties
                .ofFullCopy(Blocks.WATER)
                .noLootTable()
                .replaceable()
                .strength(100)
                .noCollision()
                .setId(RK));
    }

    @Override
    protected void onPlace(
            @Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos,
            @Nonnull BlockState oldState, boolean movedByPiston) {
        super.onPlace(state, level, pos, oldState, movedByPiston);

        if (!level.isClientSide()) {
            BlightwaterFluid.meltAllAround(level, pos);
        }
    }

    @Override
    protected void neighborChanged(
            @Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos,
            @Nonnull Block block, @Nullable Orientation orientation, boolean isMoving) {
        super.neighborChanged(state, level, pos, block, orientation, isMoving);

        if (!level.isClientSide()) {
            BlightwaterFluid.meltAllAround(level, pos);
        }
    }

}
