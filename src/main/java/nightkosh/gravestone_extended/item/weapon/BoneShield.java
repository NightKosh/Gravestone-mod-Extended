package nightkosh.gravestone_extended.item.weapon;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.component.BlocksAttacks;
import nightkosh.gravestone_extended.core.GSETags;
import nightkosh.gravestone_extended.core.ModInfo;

import java.util.List;
import java.util.Optional;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BoneShield extends ShieldItem implements IBoneShiled {

    private static final ResourceKey<Item> BONE_SHIELD_RK = ResourceKey.create(
            Registries.ITEM, fromNamespaceAndPath(ModInfo.ID, "bone_shield"));

    public BoneShield() {
        super(new Item.Properties()
                .stacksTo(1)
                .durability(750)
                .enchantable(1)
                .repairable(GSETags.MATERIAL_BONE)
                .equippableUnswappable(EquipmentSlot.OFFHAND)
                .component(
                        DataComponents.BLOCKS_ATTACKS,
                        new BlocksAttacks(
                                0.25F,
                                1,
                                List.of(new BlocksAttacks.DamageReduction(90, Optional.empty(), 0, 1)),
                                new BlocksAttacks.ItemDamageFunction(3, 1, 1),
                                Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                                Optional.of(SoundEvents.SHIELD_BLOCK),
                                Optional.of(SoundEvents.SHIELD_BREAK)
                        )
                )
                .component(DataComponents.BREAK_SOUND, SoundEvents.SHIELD_BREAK)
                .rarity(Rarity.UNCOMMON)
                .setId(BONE_SHIELD_RK));
    }

}
