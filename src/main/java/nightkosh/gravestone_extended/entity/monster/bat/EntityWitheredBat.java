package nightkosh.gravestone_extended.entity.monster.bat;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.core.GSLootTables;

import javax.annotation.Nullable;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntityWitheredBat extends EntityHostileBat {

    public EntityWitheredBat(World world) {
        super(world);
        this.isImmuneToFire = true;
    }

    @Override
    public void onLivingUpdate() {
        if (this.world.isRemote) {
            for (int i = 0; i < 5; i++) {
                this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL,
                        this.posX + 0.25 - this.rand.nextDouble() * 0.5,
                        this.posY + 0.25 + this.rand.nextDouble() * 0.5,
                        this.posZ + 0.25 - this.rand.nextDouble() * 0.5,
                        0, 0, 0);
            }
        }

        super.onLivingUpdate();
    }

    @Override
    protected void applyEffect(EntityLivingBase entity) {
        entity.addPotionEffect(new PotionEffect(MobEffects.WITHER, 200));
    }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return GSLootTables.WITHERED_BAT;
    }
}
