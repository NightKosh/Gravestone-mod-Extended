package nightkosh.gravestone_extended.block.spawner;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SpawnerBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import nightkosh.gravestone_extended.block_entity.spawner.ASpawnerBlockEntity;
import nightkosh.gravestone_extended.block_entity.spawner.SkeletonSpawnerBlockEntity;
import nightkosh.gravestone_extended.core.GSEBlockEntities;
import nightkosh.gravestone_extended.core.GSEBlocks;
import org.jspecify.annotations.Nullable;

import javax.annotation.Nonnull;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class ASpawner extends SpawnerBlock {

    private static final VoxelShape SHAPE = Block.box(-8, 0, -8, 24, 6, 24);

    public ASpawner(Properties properties) {
        super(properties);
    }

    public ASpawner(ResourceKey id) {
        this(BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.SKELETON)
                .sound(SoundType.SPAWNER)
                .lightLevel(state -> 4)
                .strength(2)
                .noOcclusion()
                .noCollision()
                .setId(id));
    }

    protected abstract BlockEntityType<ASpawnerBlockEntity> getBlockEntityType();

    @Nonnull
    @Override
    public abstract BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state);

    @Override
    public <T extends BlockEntity> @Nullable BlockEntityTicker<T> getTicker(
            Level level, @Nonnull BlockState state, @Nonnull BlockEntityType<T> entityType) {
        return createTickerHelper(
                entityType,
                getBlockEntityType(),
                level.isClientSide() ?
                        ASpawnerBlockEntity::clientTick :
                        ASpawnerBlockEntity::serverTick
        );
    }

    @Override
    public void animateTick(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos, @Nonnull RandomSource random) {
        double xPos = pos.getX() + 0.5F;
        double yPos = pos.getY() + 0.85;
        double zPos = pos.getZ() + 0.5F;
        double dRotation = Math.toRadians(72);
        double rotation = Math.toRadians(-36);
        double d = 0.9;
        double dx;
        double dz;

        for (int i = 0; i < 5; i++) {
            dx = -Math.sin(rotation) * d;
            dz = Math.cos(rotation) * d;
            level.addParticle(ParticleTypes.SMOKE, xPos + dx, yPos, zPos + dz, 0, 0, 0);
            level.addParticle(ParticleTypes.SOUL_FIRE_FLAME, xPos + dx, yPos, zPos + dz, 0, 0, 0);
            rotation += dRotation;
        }

    }

    @Nonnull
    @Override
    public VoxelShape getShape(
            @Nonnull BlockState blockState, @Nonnull BlockGetter blockGetter,
            @Nonnull BlockPos blockPos, @Nonnull CollisionContext collisionContext) {
        return SHAPE;
    }

}
