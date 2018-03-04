package nightkosh.gravestone_extended.potion;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.teleporter.TeleporterRecall;

import javax.annotation.Nullable;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class PotionRecall extends PotionInstant {

    public PotionRecall() {
        super(false, 0xc7fb);
        this.setRegistryName(ModInfo.ID, "gs_recall_potion");
        this.setPotionName("potion.recall.title");
    }

    @Override
    public void affectEntity(@Nullable Entity source, @Nullable Entity indirectSource, EntityLivingBase entity, int amplifier, double health) {
        if (!entity.world.isRemote && entity instanceof EntityPlayerMP) {
            EntityPlayerMP player = (EntityPlayerMP) entity;
            MinecraftServer minecraftServer = player.getServer();
            if (player.world.provider.getDimension() != 0) {
                player.invulnerableDimensionChange = true;
                minecraftServer.getPlayerList().transferPlayerToDimension(player, 0, new TeleporterRecall(minecraftServer.getWorld(0)));
                TeleporterRecall.changePosition(player);
            } else {
                player.invulnerableDimensionChange = true;
                TeleporterRecall.changePosition(player);
            }
        }
    }
}
