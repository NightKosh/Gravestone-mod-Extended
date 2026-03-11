package nightkosh.gravestone_extended.item.tools;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import nightkosh.advanced_fishing.entity.projectile.AFishHook;
import nightkosh.advanced_fishing.item.AbstractFishingRod;
import nightkosh.gravestone_extended.core.GSETags;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.entity.projectile.WitheredFishHook;

import javax.annotation.Nonnull;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemWitheredFishingPole extends AbstractFishingRod implements IBoneFishingPole {

    private static final ResourceKey RK = ResourceKey.create(
            Registries.ITEM,
            fromNamespaceAndPath(ModInfo.ID, "fishing_pole_withered"));

    public ItemWitheredFishingPole() {
        super(new Properties()
                .fireResistant()
                .rarity(Rarity.EPIC)
                .durability(500)
                .repairable(GSETags.MATERIAL_BONE)
                .enchantable(30)
                .setId(RK));
    }

    @Nonnull
    @Override
    protected AFishHook getHook(Player player, ServerLevel level, ItemStack fishingPole) {
        return new WitheredFishHook(player, level, 2, 1, fishingPole);
    }

}
