package nightkosh.gravestone_extended.potion;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import nightkosh.gravestone_extended.capability.choke.ChokeProvider;
import nightkosh.gravestone_extended.capability.choke.IChoke;
import nightkosh.gravestone_extended.core.MessageHandler;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.packets.ChokeMessageToClient;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class PotionChoke extends PotionBase {

    public PotionChoke() {
        super(true, 0x50999d);
        this.setIconIndex(7, 0);
        this.setRegistryName(ModInfo.ID, "gs_choke_potion");
        this.setPotionName("potion.choke.title");
    }

    @Override
    public void removeAttributesModifiersFromEntity(EntityLivingBase entity, AbstractAttributeMap attributeMap, int amplifier) {
        IChoke choke = entity.getCapability(ChokeProvider.AIR_CAP, null);
        choke.setActive(false);
        updateChoke(entity, choke);
        super.removeAttributesModifiersFromEntity(entity, attributeMap, amplifier);
    }

    @Override
    public void applyAttributesModifiersToEntity(EntityLivingBase entity, AbstractAttributeMap attributeMap, int amplifier) {
        IChoke choke = entity.getCapability(ChokeProvider.AIR_CAP, null);
        choke.setAir(entity.getAir());
        choke.setActive(true);
        updateChoke(entity, choke);

        super.applyAttributesModifiersToEntity(entity, attributeMap, amplifier);
    }

    @Override
    public void performEffect(EntityLivingBase entity, int amplifier) {
        if (entity != null && entity instanceof EntityPlayer && !((EntityPlayer) entity).world.isRemote) {
            IChoke choke = entity.getCapability(ChokeProvider.AIR_CAP, null);
            int air = choke.getAir();

            air = Math.min(air, entity.getAir());

            if (!((EntityPlayer) entity).capabilities.disableDamage) {
                air--;
                if (air < -19) {
                    air = 0;
                    entity.attackEntityFrom(DamageSource.DROWN, 2);
                }

                entity.setAir(air);
                choke.setAir(air);
                updateChoke(entity, choke);
            }
        }
    }

    private void updateChoke(EntityLivingBase entity, IChoke choke) {
        MessageHandler.networkWrapper.sendTo(new ChokeMessageToClient(choke.getAir(), choke.isActive()), (EntityPlayerMP) entity);
    }
}
