package nightkosh.gravestone_extended.entity.projectile;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import nightkosh.advanced_fishing.entity.projectile.LavaFishHook;
import nightkosh.gravestone_extended.core.GSEEntities;
import nightkosh.gravestone_extended.core.GSEFluids;

import java.util.List;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class WitheredFishHook extends LavaFishHook {

    private static final List<TagKey<Fluid>> SUPPORTED_LIQUID_TYPE = List.of(FluidTags.WATER, FluidTags.LAVA, GSEFluids.BLIGHTWATER_TAG);

    public WitheredFishHook(EntityType<? extends WitheredFishHook> entityType, Level level) {
        super(entityType, level);
    }

    public WitheredFishHook(Player player, ServerLevel level, int additionalLuck, int additionalLureSpeed, ItemStack fishingPole) {
        super(GSEEntities.WITHERED_FISH_HOOK.get(), player, level, additionalLuck, additionalLureSpeed, fishingPole);
    }

    @Override
    protected List<TagKey<Fluid>> getSupportedLiquidType() {
        return SUPPORTED_LIQUID_TYPE;
    }

}
