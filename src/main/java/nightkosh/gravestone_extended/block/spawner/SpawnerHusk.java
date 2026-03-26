package nightkosh.gravestone_extended.block.spawner;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import nightkosh.gravestone_extended.block_entity.spawner.ASpawnerBlockEntity;
import nightkosh.gravestone_extended.block_entity.spawner.HuskSpawnerBlockEntity;
import nightkosh.gravestone_extended.core.GSEBlockEntities;
import nightkosh.gravestone_extended.core.GSEBlocks;

import javax.annotation.Nonnull;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class SpawnerHusk extends ASpawner {

    public SpawnerHusk() {
        super(GSEBlocks.SPAWNER_HUSK_RK);
    }

    @Nonnull
    @Override
    public BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state) {
        return new HuskSpawnerBlockEntity(pos, state);
    }

    @Override
    protected BlockEntityType<ASpawnerBlockEntity> getBlockEntityType() {
        return GSEBlockEntities.SPAWNER_HUSK.get();
    }

}
