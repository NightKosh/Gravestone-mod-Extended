package nightkosh.gravestone_extended.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.redstone.Orientation;
import nightkosh.gravestone_extended.core.GSEBlocks;
import nightkosh.gravestone_extended.core.GSEEnchantments;
import nightkosh.gravestone_extended.helper.GSEEnchantmentHelper;
import org.jspecify.annotations.Nullable;

import javax.annotation.Nonnull;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class FrozenLava extends Block {

    public static final MapCodec<FrozenLava> CODEC = simpleCodec(FrozenLava::new);

    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    public static final int MAX_AGE = 3;
    private static final int NEIGHBORS_TO_AGE = 4;
    private static final int NEIGHBORS_TO_MELT = 2;

    public FrozenLava(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }
    public FrozenLava() {
        this(Properties.of()
                .setId(GSEBlocks.FROZEN_LAVA_RK)
                .mapColor(MapColor.NETHER)
                .instrument(NoteBlockInstrument.BASEDRUM)
                .lightLevel(p_152684_ -> 3)
                .strength(0.5F)
                .emissiveRendering((state, level, pos) -> true));
    }

    @Override
    public void stepOn(@Nonnull Level level, @Nonnull BlockPos pos, @Nonnull BlockState state, Entity entity) {
        if (!entity.isSteppingCarefully() && entity instanceof LivingEntity livingE &&
                !GSEEnchantmentHelper.enchanted(level, GSEEnchantments.FROZEN_NETHER, livingE.getItemBySlot(EquipmentSlot.LEGS))) {
            entity.hurt(level.damageSources().hotFloor(), 1);
        }

        super.stepOn(level, pos, state, entity);
    }

    @Nonnull
    @Override
    public MapCodec<FrozenLava> codec() {
        return CODEC;
    }


    @Override
    public void onPlace(@Nonnull BlockState state, Level level, @Nonnull BlockPos blockPos,
                        @Nonnull BlockState oldState, boolean movedByPiston) {
        level.scheduleTick(blockPos, this, Mth.nextInt(level.getRandom(), 60, 120));
    }

    @Override
    protected void tick(@Nonnull BlockState state, @Nonnull ServerLevel level,
                        @Nonnull BlockPos blockPos, RandomSource random) {
        if (random.nextInt(3) == 0 || this.fewerNeighboursThan(level, blockPos, NEIGHBORS_TO_AGE)) {
            int i = level.dimension() == Level.END ?
                    level.getBrightness(LightLayer.BLOCK, blockPos) :
                    level.getMaxLocalRawBrightness(blockPos);
            if (i > 11 - state.getValue(AGE) - state.getLightDampening() && this.slightlyMelt(state, level, blockPos)) {
                var pos = new BlockPos.MutableBlockPos();

                for (var direction : Direction.values()) {
                    pos.setWithOffset(blockPos, direction);
                    var blockstate = level.getBlockState(pos);
                    if (blockstate.is(this) && !this.slightlyMelt(blockstate, level, pos)) {
                        level.scheduleTick(pos, this, Mth.nextInt(random, 20, 40));
                    }
                }

                return;
            }
        }

        level.scheduleTick(blockPos, this, Mth.nextInt(random, 20, 40));
    }

    private boolean slightlyMelt(BlockState state, Level level, BlockPos pos) {
        int i = state.getValue(AGE);
        if (i < MAX_AGE) {
            level.setBlock(pos, state.setValue(AGE, i + 1), 2);
            return false;
        } else {
            this.melt(state, level, pos);
            return true;
        }
    }

    @Override
    protected void neighborChanged(@Nonnull BlockState blockState, @Nonnull Level level,
                                   @Nonnull BlockPos pos, Block block,
                                   @Nullable Orientation orientation, boolean movedByPiston) {
        if (block.defaultBlockState().is(this) && this.fewerNeighboursThan(level, pos, NEIGHBORS_TO_MELT)) {
            this.melt(blockState, level, pos);
        }

        super.neighborChanged(blockState, level, pos, block, orientation, movedByPiston);
    }

    private boolean fewerNeighboursThan(BlockGetter level, BlockPos pos, int neighborsRequired) {
        int i = 0;
        var blockPos = new BlockPos.MutableBlockPos();

        for (var direction : Direction.values()) {
            blockPos.setWithOffset(pos, direction);
            if (level.getBlockState(blockPos).is(this)) {
                if (++i >= neighborsRequired) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Nonnull
    @Override
    protected ItemStack getCloneItemStack(@Nonnull LevelReader level, @Nonnull BlockPos pos,
                                          @Nonnull BlockState state, boolean includeData) {
        return ItemStack.EMPTY;
    }

    protected void melt(BlockState state, Level level, BlockPos pos) {
        level.setBlockAndUpdate(pos, meltsInto());
        level.neighborChanged(pos, meltsInto().getBlock(), null);
    }

    public static BlockState meltsInto() {
        return Blocks.LAVA.defaultBlockState();
    }

}
