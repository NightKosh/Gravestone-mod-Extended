package nightkosh.gravestone_extended.entity.projectile;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import nightkosh.advanced_fishing.entity.projectile.AFishHook;
import nightkosh.advanced_fishing.entity.projectile.AdvancedFishHook;
import nightkosh.gravestone_extended.core.GSEEntities;
import nightkosh.gravestone_extended.core.GSEFluids;

import java.util.List;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BoneFishHook extends AdvancedFishHook {

    private static final List<TagKey<Fluid>> SUPPORTED_LIQUID_TYPE = List.of(FluidTags.WATER, GSEFluids.BLIGHTWATER_TAG);

    public BoneFishHook(EntityType<? extends BoneFishHook> entityType, Level level) {
        super(entityType, level);
    }

    public BoneFishHook(Player player, ServerLevel level, int additionalLuck, int additionalLureSpeed, ItemStack fishingPole) {
        this(GSEEntities.BONE_FISH_HOOK.get(), player, level, additionalLuck, additionalLureSpeed, fishingPole);
    }

    public BoneFishHook(EntityType<? extends AFishHook> entityType, Player player, ServerLevel level,
                        int additionalLuck, int additionalLureSpeed, ItemStack fishingPole) {
        super(entityType, player, level, additionalLuck, additionalLureSpeed, fishingPole);
    }

    @Override
    protected List<TagKey<Fluid>> getSupportedLiquidType() {
        return SUPPORTED_LIQUID_TYPE;
    }

}
