package nightkosh.gravestone_extended.block.spawner;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import nightkosh.gravestone_extended.block_entity.spawner.ASpawnerBlockEntity;
import nightkosh.gravestone_extended.block_entity.spawner.SpiderSpawnerBlockEntity;
import nightkosh.gravestone_extended.core.GSEBlockEntities;
import nightkosh.gravestone_extended.core.GSEBlocks;

import javax.annotation.Nonnull;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class SpawnerSpider extends ASpawner {

    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 16, 16);

    public SpawnerSpider() {
        super(BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.SKELETON)
                .sound(SoundType.COBWEB)
                .strength(2)
                .noOcclusion()
                .setId(GSEBlocks.SPAWNER_SPIDER_RK));
    }

    @Nonnull
    @Override
    public BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state) {
        return new SpiderSpawnerBlockEntity(pos, state);
    }

    @Override
    protected BlockEntityType<ASpawnerBlockEntity> getBlockEntityType() {
        return GSEBlockEntities.SPAWNER_SPIDER.get();
    }

    @Override
    public void animateTick(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos, @Nonnull RandomSource random) {

    }

    @Nonnull
    @Override
    public VoxelShape getShape(
            @Nonnull BlockState blockState, @Nonnull BlockGetter blockGetter,
            @Nonnull BlockPos blockPos, @Nonnull CollisionContext collisionContext) {
        return SHAPE;
    }

}
