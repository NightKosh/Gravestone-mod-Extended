package nightkosh.gravestone_extended.entity.monster.crawler;

import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.core.GSLootTables;

import javax.annotation.Nullable;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntityHuskSkullCrawler extends EntityZombieSkullCrawler {
    public EntityHuskSkullCrawler(World world) {
        super(world);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_HUSK_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.ENTITY_HUSK_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_HUSK_DEATH;
    }

    @Override
    protected PotionEffect getPotionEffect() {
        return new PotionEffect(MobEffects.HUNGER, 200);
    }

    @Nullable
    protected ResourceLocation getLootTable() {
        return GSLootTables.HUSK_SKULL_CRAWLER;
    }
}
