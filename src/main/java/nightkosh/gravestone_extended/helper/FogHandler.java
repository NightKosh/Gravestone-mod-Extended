package nightkosh.gravestone_extended.helper;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nightkosh.gravestone.helper.IFog;
import nightkosh.gravestone_extended.config.ExtendedConfig;
import nightkosh.gravestone_extended.core.GSDimensions;
import nightkosh.gravestone_extended.core.event.RenderEventHandler;
import nightkosh.gravestone_extended.core.event.TickEventHandler;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class FogHandler implements IFog {

    public static final int FOG_RANGE = 30;

    public void addFog(World world, BlockPos pos) {
        if (world.isRemote && ExtendedConfig.isFogEnabled && TickEventHandler.getFogTicCount() == 0) {
            if (world.provider.getDimension() != GSDimensions.CATACOMBS.getId() && TimeHelper.isFogTime(world)) {
                EntityPlayer player = world.getClosestPlayer(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, FOG_RANGE, false);
                if (player != null && player.getCommandSenderEntity().equals(Minecraft.getMinecraft().player)) {
                    RenderEventHandler.addFog();
                }
            }
        }
    }
}
