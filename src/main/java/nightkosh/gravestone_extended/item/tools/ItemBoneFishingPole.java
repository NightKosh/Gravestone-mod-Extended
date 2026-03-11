package nightkosh.gravestone_extended.item.tools;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import nightkosh.advanced_fishing.core.AFEnchantments;
import nightkosh.advanced_fishing.entity.projectile.AFishHook;
import nightkosh.advanced_fishing.item.AbstractFishingRod;
import nightkosh.gravestone_extended.core.GSETags;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.entity.projectile.BoneFishHook;
import nightkosh.gravestone_extended.entity.projectile.WitheredFishHook;
import nightkosh.gravestone_extended.helper.GSEEnchantmentHelper;

import javax.annotation.Nonnull;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemBoneFishingPole extends AbstractFishingRod implements IBoneFishingPole {

    private static final ResourceKey RK = ResourceKey.create(
            Registries.ITEM,
            fromNamespaceAndPath(ModInfo.ID, "fishing_pole_bone"));

    public ItemBoneFishingPole() {
        super(new Item.Properties()
                .fireResistant()
                .rarity(Rarity.UNCOMMON)
                .durability(250)
                .repairable(GSETags.MATERIAL_BONE)
                .enchantable(25)
                .setId(RK));
    }

    @Nonnull
    @Override
    protected AFishHook getHook(Player player, ServerLevel level, ItemStack fishingPole) {
        if (GSEEnchantmentHelper.enchanted(level, AFEnchantments.INFERNAL_LINE, fishingPole)) {
            return new WitheredFishHook(player, level, 0, 0, fishingPole);
        } else {
            return new BoneFishHook(player, level, 0, 0, fishingPole);
        }
    }

}
