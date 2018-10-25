package nightkosh.gravestone_extended.helper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import nightkosh.gravestone_extended.core.MessageHandler;
import nightkosh.gravestone_extended.packets.NetherFortressMessageToServer;
import nightkosh.gravestone_extended.packets.StrongholdMessageToServer;

import java.util.HashMap;
import java.util.Map;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class VanillaStructuresPosition {
    private static BlockPos DEFAULT_POS = new BlockPos(0, 0, 0);

    private static BlockPos NETHER_FORTRESS = null;
    private static BlockPos STRONGHOLD = null;

    private static BlockPos lastPos = null;

    public static final Map<String, Long> SEEDS = new HashMap<>();

    public static BlockPos getNetherFortress(EntityPlayer player) {
        if (isPositionChanged(player.getPosition())) {
            MessageHandler.networkWrapper.sendToServer(new NetherFortressMessageToServer(player));
        }
        if (NETHER_FORTRESS == null) {
            return DEFAULT_POS;
        } else {
            return NETHER_FORTRESS;
        }
    }

    public static BlockPos getStrongHold(EntityPlayer player) {
        if (isPositionChanged(player.getPosition())) {
            MessageHandler.networkWrapper.sendToServer(new StrongholdMessageToServer(player));
        }
        if (STRONGHOLD == null) {
            return DEFAULT_POS;
        } else {
            return STRONGHOLD;
        }
    }

    public static void setNetherFortress(BlockPos pos) {
        NETHER_FORTRESS = pos;
    }

    public static void setStronghold(BlockPos pos) {
        STRONGHOLD = pos;
    }

    private static boolean isPositionChanged(BlockPos pos) {
        if (lastPos == null || pos.getX() < lastPos.getX() - 10 || pos.getX() > lastPos.getX() + 10 ||
                pos.getZ() < lastPos.getZ() - 10 || pos.getZ() > lastPos.getZ() + 10) {
            lastPos = pos;
            return true;
        } else {
            return false;
        }
    }
}
