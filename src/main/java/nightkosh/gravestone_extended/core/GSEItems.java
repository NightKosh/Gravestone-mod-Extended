package nightkosh.gravestone_extended.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nightkosh.gravestone_extended.item.EnchantedSkeletonSkull;
import nightkosh.gravestone_extended.item.EnchantedWitherSkull;
import nightkosh.gravestone_extended.item.FrozenMirror;
import nightkosh.gravestone_extended.item.armor.phantom_diver.DivingHelmet;
import nightkosh.gravestone_extended.item.armor.phantom_diver.DivingBoots;
import nightkosh.gravestone_extended.item.armor.phantom_diver.DivingChestplate;
import nightkosh.gravestone_extended.item.armor.phantom_diver.DivingLeggings;
import nightkosh.gravestone_extended.item.compass.EnderSkull;
import nightkosh.gravestone_extended.item.compass.ImpSkull;
import nightkosh.gravestone_extended.item.compass.SlimeChunk;
import nightkosh.gravestone_extended.item.weapon.BoneShield;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSEItems {

    public static final DeferredRegister<Item> ITEMS_REGISTER =
            DeferredRegister.create(Registries.ITEM, ModInfo.ID);

    public static final DeferredHolder<Item, Item> BONE_SHIELD = ITEMS_REGISTER.register("bone_shield", BoneShield::new);

    public static final DeferredHolder<Item, Item> DIVING_HELMET = ITEMS_REGISTER.register("diving_helmet", DivingHelmet::new);
    public static final DeferredHolder<Item, Item> DIVING_CHESTPLATE = ITEMS_REGISTER.register("diving_chestplate", DivingChestplate::new);
    public static final DeferredHolder<Item, Item> DIVING_LEGGINGS = ITEMS_REGISTER.register("diving_leggings", DivingLeggings::new);
    public static final DeferredHolder<Item, Item> DIVING_BOOTS = ITEMS_REGISTER.register("diving_boots", DivingBoots::new);

    public static final DeferredHolder<Item, Item> SLIME_CHUNK = ITEMS_REGISTER.register("slime_chunk", SlimeChunk::new);
    public static final DeferredHolder<Item, Item> IMP_SKULL = ITEMS_REGISTER.register("imp_skull", () -> new ImpSkull());
    public static final DeferredHolder<Item, Item> ENDER_SKULL = ITEMS_REGISTER.register("ender_skull", EnderSkull::new);
    public static final DeferredHolder<Item, Item> FROZEN_MIRROR = ITEMS_REGISTER.register("frozen_mirror", FrozenMirror::new);

    public static final DeferredHolder<Item, Item> ENCHANTED_SKELETON_SKULL = ITEMS_REGISTER.register("enchanted_skeleton_skull", EnchantedSkeletonSkull::new);
    public static final DeferredHolder<Item, Item> ENCHANTED_WITHER_SKULL = ITEMS_REGISTER.register("enchanted_wither_skull", EnchantedWitherSkull::new);

//    public static final Item BONE_SWORD = new ItemBoneSword();
//    public static final Item BONE_SWORD_IRON = new ItemIronBoneSword();
//    public static final Item BONE_SWORD_GOLDEN = new ItemGoldenBoneSword();
//    public static final Item BONE_SWORD_DIAMOND = new ItemDiamondBoneSword();
//
//    public static Item BONE_FISHING_POLE;
//    public static final Item BONE_HOE = new ItemBoneHoe();
//    public static final Item BONE_HOE_IRON = new ItemIronBoneHoe();
//    public static final Item BONE_HOE_GOLDEN = new ItemGoldenBoneHoe();
//    public static final Item BONE_HOE_DIAMOND = new ItemDiamondBoneHoe();
//
//    public static final Item BONE_SHOVEL = new ItemBoneShovel();
//    public static final Item BONE_SHOVEL_IRON = new ItemIronBoneShovel();
//    public static final Item BONE_SHOVEL_GOLDEN = new ItemGoldenBoneShovel();
//    public static final Item BONE_SHOVEL_DIAMOND = new ItemDiamondBoneShovel();
//
//    public static final Item BONE_AXE = new ItemBoneAxe();
//    public static final Item BONE_AXE_IRON = new ItemIronBoneAxe();
//    public static final Item BONE_AXE_GOLDEN = new ItemGoldenBoneAxe();
//    public static final Item BONE_AXE_DIAMOND = new ItemDiamondBoneAxe();
//
//    public static final Item BONE_PICKAXE = new ItemBonePickaxe();
//    public static final Item BONE_PICKAXE_IRON = new ItemIronBonePickaxe();
//    public static final Item BONE_PICKAXE_GOLDEN = new ItemGoldenBonePickaxe();
//    public static final Item BONE_PICKAXE_DIAMOND = new ItemDiamondBonePickaxe();
//
//    public static final Item BONE_HELMET = new ItemBoneHelmet();
//    public static final Item BONE_CHESTPLATE = new ItemBoneChestplate();
//    public static final Item BONE_LEGGINGS = new ItemBoneLeggings();
//    public static final Item BONE_BOOTS = new ItemBoneBoots();
//
//
//    public static final Item SWAMP_THING_HELMET = new ItemSwampThingHelmet();
//    public static final Item SWAMP_THING_CHESTPLATE = new ItemSwampThingChestplate();
//    public static final Item SWAMP_THING_LEGGINGS = new ItemSwampThingLeggings();
//    public static final Item SWAMP_THING_BOOTS = new ItemSwampThingBoots();
//
//    public static final Item MUMMY_HELMET = new ItemMummyHelmet();
//    public static final Item MUMMY_CHESTPLATE = new ItemMummyChestplate();
//    public static final Item MUMMY_LEGGINGS = new ItemMummyLeggings();
//    public static final Item MUMMY_BOOTS = new ItemMummyBoots();
//
//    public static final Item CEMETERY_KEY = new ItemCemeteryKey();
//
//    public static final Item TOXIC_SLIME = new ItemToxicSlime();
//    public static final Item OOZE = new ItemOoze();
//    public static final Item PIECE_OF_MUMMY_CLOTH = new ItemPieceOfMummyCloth();
//    public static final Item RAVEN_FEATHER = new ItemRavenFeather();
//    public static final Item RAVEN_CLAWS = new ItemRavenClaws();

    public static void register(IEventBus eventBus) {
        ITEMS_REGISTER.register(eventBus);
    }

}
