package nightkosh.gravestone_extended.entity.monster.crawler;

import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
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
public class EntityStraySkullCrawler extends EntitySkullCrawler  {
    public EntityStraySkullCrawler(World world) {
        super(world);
    }

    @Override
    protected PotionEffect getPotionEffect() {
        return new PotionEffect(MobEffects.SLOWNESS, 200);
    }

    @Override
    public boolean canHideInBones() {
        return false;
    }

    @Nullable
    protected ResourceLocation getLootTable() {
        return GSLootTables.STRAY_SKULL_CRAWLER;
    }
}
