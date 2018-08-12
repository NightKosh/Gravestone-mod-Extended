package nightkosh.gravestone_extended.tileentity;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ITickable;
import net.minecraft.world.World;
import nightkosh.gravestone.tileentity.ISpawnerEntity;
import nightkosh.gravestone.tileentity.TileEntityBase;
import nightkosh.gravestone_extended.block.enums.EnumSpawner;
import nightkosh.gravestone_extended.entity.helper.EntityGroupOfGravesMobSpawnerHelper;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileEntitySpawner extends TileEntityBase implements ITickable, ISpawnerEntity {

    protected MobSpawner spawner;

    public TileEntitySpawner() {
        spawner = new MobSpawner(this);
    }

    @Override
    public void update() {
        spawner.update();
    }

    @Override
    public World getIWorld() {
        return getWorld();
    }

    @Override
    public BlockPos getIPos() {
        return getPos();
    }

    @Override
    public boolean haveSpawnerHelper() {
        return false;
    }

    @Override
    public EntityGroupOfGravesMobSpawnerHelper getSpawnerHelper() {
        return null;
    }

    @Override
    public int getBlockMetadata() {
        if (this.hasWorld()) {
            return super.getBlockMetadata();
        } else {
            return EnumSpawner.WITHER_SPAWNER.ordinal();
        }
    }
}
