package nightkosh.gravestone_extended.entity.monster.bat;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.core.GSLootTables;
import nightkosh.gravestone_extended.core.GSPotion;
import nightkosh.gravestone_extended.helper.MobsHelper;

import javax.annotation.Nullable;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntityVampireBat extends EntityHostileBat {

    public EntityVampireBat(World world) {
        super(world);
    }

    @Override
    protected void applyEffect(EntityLivingBase entity) {
        entity.addPotionEffect(new PotionEffect(GSPotion.BLEEDING, 600));
    }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return GSLootTables.VAMPIRE_BAT;
    }

    @Override
    public boolean getCanSpawnHere() {
        return super.getCanSpawnHere() && MobsHelper.isDimensionAllowedForSpawn(this.world);
    }
}
