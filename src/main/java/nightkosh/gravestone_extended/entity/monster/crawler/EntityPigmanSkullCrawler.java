package nightkosh.gravestone_extended.entity.monster.crawler;

import net.minecraft.init.SoundEvents;
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
public class EntityPigmanSkullCrawler extends EntityZombieSkullCrawler {
    public EntityPigmanSkullCrawler(World world) {
        super(world);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ZOMBIE_PIG_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.ENTITY_ZOMBIE_PIG_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ZOMBIE_PIG_DEATH;
    }

    @Nullable
    protected ResourceLocation getLootTable() {
        return GSLootTables.PIGMAN_SKULL_CRAWLER;
    }
}
