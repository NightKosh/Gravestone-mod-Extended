package nightkosh.gravestone_extended.core;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import nightkosh.gravestone_extended.capability.cemetery.CemeteryProvider;
import nightkosh.gravestone_extended.capability.choke.ChokeProvider;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CapabilityHandler {
    public static final ResourceLocation AIR_CAP = new ResourceLocation(ModInfo.ID, "choke");
    public static final ResourceLocation CEMETERY_CAP = new ResourceLocation(ModInfo.ID, "cemetery");

    @SubscribeEvent
    public void attachPlayerCapability(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof EntityPlayer) {
            event.addCapability(AIR_CAP, new ChokeProvider());
            event.addCapability(CEMETERY_CAP, new CemeteryProvider());
        }
    }

    @SubscribeEvent
    public void attachWorldCapability(AttachCapabilitiesEvent<World> event) {
        if (event.getObject() != null) {
            event.addCapability(CEMETERY_CAP, new CemeteryProvider());
        }
    }
}
