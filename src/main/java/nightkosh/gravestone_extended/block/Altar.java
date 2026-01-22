package nightkosh.gravestone_extended.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import nightkosh.gravestone_extended.block_entity.AltarBlockEntity;
import nightkosh.gravestone_extended.core.GSEBlocks;

import javax.annotation.Nonnull;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Altar extends BaseEntityBlock {

    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 12, 16);

    public static final MapCodec<Altar> CODEC = simpleCodec(Altar::new);

    public Altar(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public Altar() {
        this(BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.BASEDRUM)
                .mapColor(MapColor.COLOR_RED)
                .setId(GSEBlocks.ALTAR_RK)
                .strength(5, Integer.MAX_VALUE));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Nonnull
    @Override
    public BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state) {
        return new AltarBlockEntity(pos, state);
    }

    @Override
    public void animateTick(
            @Nonnull BlockState state, @Nonnull Level level,
            @Nonnull BlockPos pos, @Nonnull RandomSource random) {
        super.animateTick(state, level, pos, random);

        level.addParticle(
                ParticleTypes.SOUL,
                pos.getX() + random.nextFloat(),
                pos.getY() + 1,
                pos.getZ() + random.nextFloat(),
                0,
                0.01F,
                0);
    }

    @Nonnull
    @Override
    protected InteractionResult useWithoutItem(
            @Nonnull BlockState state, Level level, @Nonnull BlockPos pos,
            @Nonnull Player player, @Nonnull BlockHitResult blockHitResult) {
        if (!level.isClientSide() && !player.isShiftKeyDown() &&
                level.getBlockEntity(pos) instanceof AltarBlockEntity altar) {
            player.openMenu(altar, pos);
        }

        return InteractionResult.SUCCESS;
    }

    @Nonnull
    @Override
    protected VoxelShape getShape(
            @Nonnull BlockState state, @Nonnull BlockGetter getter,
            @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected boolean isPathfindable(@Nonnull BlockState state, @Nonnull PathComputationType pathComputationType) {
        return false;
    }

}
