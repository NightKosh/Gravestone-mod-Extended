package nightkosh.gravestone_extended.block_entity;

import com.mojang.datafixers.util.Either;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.SpawnData;
import net.minecraft.world.level.Spawner;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import nightkosh.gravestone_extended.core.GSEBlockEntities;
import org.jspecify.annotations.Nullable;

import javax.annotation.Nonnull;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSESpawnerBlockEntity extends BlockEntity implements Spawner {

    public GSESpawnerBlockEntity(BlockPos pos, BlockState blockState) {
        super(GSEBlockEntities.SPAWNER.get(), pos, blockState);
    }

    @Override
    protected void loadAdditional(@Nonnull ValueInput input) {
        super.loadAdditional(input);
        this.spawner.load(this.level, this.worldPosition, input);
    }

    @Override
    protected void saveAdditional(@Nonnull ValueOutput output) {
        super.saveAdditional(output);
        this.spawner.save(output);
    }

    public static void clientTick(Level level, BlockPos pos, BlockState state, GSESpawnerBlockEntity blockEntity) {
        blockEntity.spawner.clientTick(level, pos);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, GSESpawnerBlockEntity blockEntity) {
        blockEntity.spawner.serverTick((ServerLevel)level, pos);
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Nonnull
    @Override
    public CompoundTag getUpdateTag(@Nonnull HolderLookup.Provider provider) {
        var compoundtag = this.saveCustomOnly(provider);
        compoundtag.remove("SpawnPotentials");
        return compoundtag;
    }

    @Override
    public boolean triggerEvent(int id, int type) {
        return this.spawner.onEventTriggered(this.level, id) ? true : super.triggerEvent(id, type);
    }

    @Override
    public void setEntityId(@Nonnull EntityType<?> type, @Nonnull RandomSource random) {
        this.spawner.setEntityId(type, this.level, random, this.worldPosition);
        this.setChanged();
    }

    public BaseSpawner getSpawner() {
        return this.spawner;
    }

    private final BaseSpawner spawner = new BaseSpawner() {

        @Override
        public void broadcastEvent(Level level, @Nonnull BlockPos pos, int eventId) {
            level.blockEvent(pos, Blocks.SPAWNER, eventId, 0);
        }

        @Override
        public void setNextSpawnData(@Nullable Level level, @Nonnull BlockPos pos, @Nonnull SpawnData spawnData) {
            super.setNextSpawnData(level, pos, spawnData);
            if (level != null) {
                var state = level.getBlockState(pos);
                level.sendBlockUpdated(pos, state, state, 260);
            }
        }

        @Override
        public Either<BlockEntity, Entity> getOwner() {
            return Either.left(GSESpawnerBlockEntity.this);
        }
    };
//
//    protected ISpawnerEntity spawnerEntity;
//    protected int delay;
//    protected Entity spawnedMob;
//    protected AxisAlignedBB bb;
//
//    public Spawner(ISpawnerEntity tileEntity, int delay) {
//        this.spawnerEntity = tileEntity;
//        this.delay = delay;
//        this.bb = new AxisAlignedBB(spawnerEntity.getIPos().getX(), spawnerEntity.getIPos().getY(), spawnerEntity.getIPos().getZ(),
//                spawnerEntity.getIPos().getX() + 1, spawnerEntity.getIPos().getY() + 1, spawnerEntity.getIPos().getZ() + 1).expand(1, 4, getSpawnRange() * 2);
//    }
//
//    /**
//     * Update entity state.
//     */
//    public void update() {
//        if (!spawnerEntity.getIWorld().getDifficulty().equals(EnumDifficulty.PEACEFUL)) {
//            if (spawnerEntity.getIWorld().isRemote) {
////                clientUpdateLogic(); TODO
//            } else {
//                serverUpdateLogic();
//            }
//        }
//    }
//
//    /**
//     * Sets the delay before a new spawn.
//     */
//    public void updateDelay() {
//        delay = getMinDelay() + spawnerEntity.getIWorld().rand.nextInt(getMaxDelay() - getMinDelay());
//    }
//
//    public void setMinDelay() {
//        delay = getMinDelay();
//    }
//
//    protected int getNearbyMobsCount() {
//        return spawnerEntity.getIWorld().getEntitiesWithinAABB(this.spawnedMob.getClass(), bb).size();
//    }
//
//    protected boolean anyPlayerInRange() {
//        return spawnerEntity.getIWorld().getClosestPlayer(spawnerEntity.getIPos().getX() + 0.5D, spawnerEntity.getIPos().getY() + 0.5D, spawnerEntity.getIPos().getZ() + 0.5D, getPlayerRange(), false) != null;
//    }
//
//    abstract protected boolean canSpawnMobs(World world);
//
//    abstract protected int getPlayerRange();
//
//    abstract protected int getSpawnRange();
//
//    abstract protected int getMinDelay();
//
//    abstract protected int getMaxDelay();
//
//    abstract protected Entity getMob();
//
//    abstract protected void clientUpdateLogic();
//
//    abstract protected void serverUpdateLogic();
}
