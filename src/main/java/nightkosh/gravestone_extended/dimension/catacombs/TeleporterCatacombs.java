package nightkosh.gravestone_extended.dimension.catacombs;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;
import nightkosh.gravestone_extended.core.GSBlock;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TeleporterCatacombs extends Teleporter {

    private final WorldServer worldServerInstance;
    private final Long2ObjectMap<Teleporter.PortalPosition> destinationCoordinateCache = new Long2ObjectOpenHashMap<>(4096);

    public TeleporterCatacombs(WorldServer world) {
        super(world);
        this.worldServerInstance = world;
    }

    @Override
    public void placeInPortal(Entity entity, float rotationYaw) {
        this.placeInExistingPortal(entity, rotationYaw);
    }

    @Override
    public boolean placeInExistingPortal(Entity entity, float rotationYaw) {
        double d0 = -1;
        boolean flag = true;
        BlockPos pos = entity.getPosition();
        long chunkPos = ChunkPos.asLong(MathHelper.floor(entity.posX), MathHelper.floor(entity.posZ));

        if (this.destinationCoordinateCache.containsKey(chunkPos)) {
            Teleporter.PortalPosition portalPosition = this.destinationCoordinateCache.get(chunkPos);
            d0 = 0;
            pos = portalPosition;
            portalPosition.lastUpdateTime = this.worldServerInstance.getTotalWorldTime();
            flag = false;
        } else {
            BlockPos pos4 = new BlockPos(entity);

            for (int x = -128; x <= 128; ++x) {
                BlockPos pos1;

                for (int z = -128; z <= 128; ++z) {
                    for (BlockPos blockpos = pos4.add(x, this.worldServerInstance.getActualHeight() - 1 - pos4.getY(), z);
                         blockpos.getY() >= 0; blockpos = pos1) {
                        pos1 = blockpos.down();

                        if (this.worldServerInstance.getBlockState(blockpos).getBlock() == GSBlock.CATACOMBS_PORTAL) {
                            while (this.worldServerInstance.getBlockState(pos1 = blockpos.down()).getBlock() == GSBlock.CATACOMBS_PORTAL) {
                                blockpos = pos1;
                            }
                            double d1 = blockpos.distanceSq(pos4);

                            if (d0 < 0 || d1 < d0) {
                                d0 = d1;
                                pos = blockpos;
                            }
                        }
                    }
                }
            }
        }

        if (d0 >= 0) {
            if (flag) {
                this.destinationCoordinateCache.put(chunkPos, new Teleporter.PortalPosition(pos, this.worldServerInstance.getTotalWorldTime()));
            }

            entity.motionX = 0;
            entity.motionZ = 0;

            entity.setLocationAndAngles(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, entity.rotationYaw, entity.rotationPitch);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean makePortal(Entity entity) {
        return true;
    }

    @Override
    public void removeStalePortalLocations(long worldTime) {
    }
}
