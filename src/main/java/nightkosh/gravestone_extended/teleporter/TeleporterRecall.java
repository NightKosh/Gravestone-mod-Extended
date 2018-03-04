package nightkosh.gravestone_extended.teleporter;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TeleporterRecall extends Teleporter {

    public TeleporterRecall(WorldServer world) {
        super(world);
    }

    @Override
    public void placeInPortal(Entity entity, float rotationYaw) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            BlockPos pos = getSpawnPosition(player, this.world);

            if (player instanceof EntityPlayerMP) {
                ((EntityPlayerMP) player).connection.setPlayerLocation(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, player.rotationYaw, player.rotationPitch);
            } else {
                player.setPositionAndUpdate(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
            }
        }
    }

    @Override
    public boolean placeInExistingPortal(Entity entity, float rotationYaw) {
        return false;
    }

    @Override
    public boolean makePortal(Entity entity) {
        return false;
    }

    @Override
    public void removeStalePortalLocations(long worldTime) {
    }

    public static BlockPos getSpawnPosition(EntityPlayer player, World world) {
        return (player.getBedLocation() != null) ? player.getBedLocation() : world.getTopSolidOrLiquidBlock(world.getSpawnPoint());
    }

    public static void changePosition(EntityPlayerMP player) {
        if (player.getServer() != null) {
            BlockPos pos = getSpawnPosition(player, player.world);
            player.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
        }
    }
}
