package nightkosh.gravestone_extended.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import nightkosh.gravestone_extended.core.GSEParticles;

import javax.annotation.Nonnull;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class SkullCandle extends Block {

    private static final int ROTATIONS = RotationSegment.getMaxSegmentIndex() + 1;
    public static final IntegerProperty ROTATION = BlockStateProperties.ROTATION_16;

    private static final VoxelShape SHAPE = Block.box(3, 0, 3, 13, 7, 13);

    private static final MapCodec<SkullCandle> CODEC = simpleCodec(SkullCandle::new);

    public SkullCandle(ResourceKey id) {
        this(BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.SKELETON)
                .setId(id)
                .sound(SoundType.BONE_BLOCK)
                .lightLevel(state -> 8)
                .noCollision()
                .pushReaction(PushReaction.DESTROY)
                .strength(0.1F, 0));
    }

    public SkullCandle(Properties properties) {
        super(properties);

        this.registerDefaultState(this.defaultBlockState().setValue(ROTATION, 0));
    }

    @Nonnull
    @Override
    protected MapCodec<? extends SkullCandle> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(@Nonnull StateDefinition.Builder<Block, BlockState> stateBuilder) {
        super.createBlockStateDefinition(stateBuilder);
        stateBuilder.add(ROTATION);
    }

    @Override
    public BlockState getStateForPlacement(@Nonnull BlockPlaceContext context) {
        return super.getStateForPlacement(context)
                .setValue(ROTATION, RotationSegment.convertToSegment(context.getRotation()));
    }

    @Nonnull
    @Override
    public VoxelShape getShape(
            @Nonnull BlockState blockState, @Nonnull BlockGetter blockGetter,
            @Nonnull BlockPos blockPos, @Nonnull CollisionContext collisionContext) {
        return SHAPE;
    }

    @Override
    public void animateTick(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos, @Nonnull RandomSource random) {
        //TODO
        double angle = state.getValue(BlockStateProperties.ROTATION_16) * (Math.PI * 2 / 16);

        double dx = -Math.sin(angle) * 0.05;
        double dz = -Math.cos(angle) * 0.05;

        double xPos = pos.getX() + 0.5 + dx;
        double yPos = pos.getY() + 0.85;
        double zPos = pos.getZ() + 0.5 + dz;

        level.addParticle(ParticleTypes.SMOKE, xPos, yPos, zPos, 0, 0, 0);
        level.addParticle(GSEParticles.GREEN_FLAME.get(), xPos, yPos, zPos, 0, 0, 0);
    }

    @Nonnull
    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(ROTATION, rotation.rotate(state.getValue(ROTATION), ROTATIONS));
    }

    @Nonnull
    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.setValue(ROTATION, mirror.mirror(state.getValue(ROTATION), ROTATIONS));
    }

}
