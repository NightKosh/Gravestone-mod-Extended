package nightkosh.gravestone_extended.block.pile_of_bones;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import nightkosh.gravestone_extended.core.GSEBlocks;

import javax.annotation.Nonnull;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class PileOfBones extends Block {

    public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public static final MapCodec<PileOfBones> CODEC = simpleCodec(PileOfBones::new);

    private static final VoxelShape SHAPE = Block.box(1, 0, 1, 15, 2, 15);

    public PileOfBones(Properties properties) {
        super(properties);

        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false));
    }

    public PileOfBones() {
        this(BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.XYLOPHONE)
                .setId(GSEBlocks.PILE_OF_BONES_RK)
                .sound(SoundType.BONE_BLOCK)
                .noCollision()
                .pushReaction(PushReaction.DESTROY)
                .strength(0.1F, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(FACING, WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(WATERLOGGED, context.getLevel().getFluidState(context.getClickedPos())
                        .getType() == Fluids.WATER);
    }

    @Nonnull
    @Override
    public VoxelShape getShape(
            @Nonnull BlockState blockState, @Nonnull BlockGetter blockGetter,
            @Nonnull BlockPos blockPos, @Nonnull CollisionContext collisionContext) {
        return SHAPE;
    }

    @Nonnull
    @Override
    protected MapCodec<? extends PileOfBones> codec() {
        return CODEC;
    }

    @Nonnull
    @Override
    public RenderShape getRenderShape(@Nonnull BlockState state) {
        return RenderShape.MODEL;
    }

//    @Override
//    public boolean canSurvive(@Nonnull BlockState state, @Nonnull LevelReader level, @Nonnull BlockPos pos) {
//        return canSupportCenter(level, pos, Direction.UP);
//    }

//    @Override
//    protected boolean canSilkHarvest() {
//        return true;
//    }
//
//    @Override
//    public Item getItemDropped(IBlockState state, Random random, int fortune) {
//        return Items.BONE;
//    }
//
//    @Override
//    public int quantityDropped(Random random) {
//        return 4;
//    }
//
//    @Override
//    public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state) {
//        if (!world.isRemote && isSkullCrawlerBlock(state) && ExtendedConfig.spawnSkullCrawlersAtPileBonesDestruction) {
//            EntitySkullCrawler skullCrawler = new EntitySkullCrawler(world);
//            skullCrawler.setLocationAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0, 0);
//            world.spawnEntity(skullCrawler);
//            skullCrawler.spawnExplosionParticle();
//        }
//
//        super.onBlockDestroyedByPlayer(world, pos, state);
//    }
//
//    @Override
//    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack stack) {
//        EnumFacing enumfacing = EnumFacing.getHorizontal(MathHelper.floor(entity.rotationYaw * 4 / 360F + 0.5) & 3).getOpposite();
//        world.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
//    }
//
//    @Override
//    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block,  BlockPos fromPos) {
//        if (!canPlaceBlockAt(world, pos)) {
//            this.dropBlockAsItem(world, pos, state, 0);
//            world.setBlockToAir(pos);
//        }
//    }

}
