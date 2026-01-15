package nightkosh.gravestone_extended.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSETabs {

    public static final DeferredRegister<CreativeModeTab> GSE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModInfo.ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GRAVESTONE_EXTENDED =
            GSE_TAB.register("gravestone_extended", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(GSEBlocks.SKULL_CANDLE_WITHER.get()))
                    .title(Component.translatable("itemGroup." + ModInfo.ID))
                    .displayItems((parameters, output) -> {

                        // tools and armor
                        output.accept(GSEItems.BONE_SHIELD.get());

                        output.accept(GSEItems.SLIME_CHUNK.get());
                        output.accept(GSEItems.IMP_SKULL.get());
                        output.accept(GSEItems.ENDER_SKULL.get());
                        output.accept(GSEItems.FROZEN_MIRROR.get());

                        // skull candles
                        output.accept(GSEBlocks.SKULL_CANDLE_SKELETON.get());
                        output.accept(GSEBlocks.SKULL_CANDLE_ZOMBIE.get());
                        output.accept(GSEBlocks.SKULL_CANDLE_WITHER.get());

                        // pile of bones
                        output.accept(GSEBlocks.PILE_OF_BONES.get());
                        output.accept(GSEBlocks.PILE_OF_BONES_SKULL.get());
                        output.accept(GSEBlocks.PILE_OF_BONES_SKULL_SKELETON.get());
                        output.accept(GSEBlocks.PILE_OF_BONES_SKULL_STRAY.get());
                        output.accept(GSEBlocks.PILE_OF_BONES_SKULL_BOGGED.get());
                        output.accept(GSEBlocks.PILE_OF_BONES_SKULL_PARCHED.get());
                        output.accept(GSEBlocks.PILE_OF_BONES_SKULL_WITHER.get());
                        output.accept(GSEBlocks.PILE_OF_BONES_SKULL_ZOMBIE.get());
                        output.accept(GSEBlocks.PILE_OF_BONES_SKULL_HUSK.get());
                        output.accept(GSEBlocks.PILE_OF_BONES_SKULL_DROWNED.get());
                        output.accept(GSEBlocks.PILE_OF_BONES_SKULL_PIGLIN.get());

                        // bone blocks
                        output.accept(GSEBlocks.BONE_BLOCK.get());
                        output.accept(GSEBlocks.BONE_BLOCK_SKULL.get());
                        output.accept(GSEBlocks.BONE_SLAB.get());
                        output.accept(GSEBlocks.BONE_STAIRS.get());

                        output.accept(GSEBlocks.BONE_BLOCK_SKELETON_CRAWLER.get());
                        output.accept(GSEBlocks.BONE_BLOCK_SKULL_SKELETON_CRAWLER.get());
                        output.accept(GSEBlocks.BONE_BLOCK_STRAY_CRAWLER.get());
                        output.accept(GSEBlocks.BONE_BLOCK_SKULL_STRAY_CRAWLER.get());
                        output.accept(GSEBlocks.BONE_BLOCK_BOGGED_CRAWLER.get());
                        output.accept(GSEBlocks.BONE_BLOCK_SKULL_BOGGED_CRAWLER.get());
                        output.accept(GSEBlocks.BONE_BLOCK_PARCHED_CRAWLER.get());
                        output.accept(GSEBlocks.BONE_BLOCK_SKULL_PARCHED_CRAWLER.get());
                        output.accept(GSEBlocks.BONE_BLOCK_WITHER_CRAWLER.get());
                        output.accept(GSEBlocks.BONE_BLOCK_SKULL_WITHER_CRAWLER.get());
                        output.accept(GSEBlocks.BONE_BLOCK_ZOMBIE_CRAWLER.get());
                        output.accept(GSEBlocks.BONE_BLOCK_SKULL_ZOMBIE_CRAWLER.get());
                        output.accept(GSEBlocks.BONE_BLOCK_HUSK_CRAWLER.get());
                        output.accept(GSEBlocks.BONE_BLOCK_SKULL_HUSK_CRAWLER.get());
                        output.accept(GSEBlocks.BONE_BLOCK_DROWNED_CRAWLER.get());
                        output.accept(GSEBlocks.BONE_BLOCK_SKULL_DROWNED_CRAWLER.get());
                        output.accept(GSEBlocks.BONE_BLOCK_PIGLIN_CRAWLER.get());
                        output.accept(GSEBlocks.BONE_BLOCK_SKULL_PIGLIN_CRAWLER.get());

                        // glass
                        output.accept(GSEBlocks.WITHERED_GLASS.get());
                        output.accept(GSEBlocks.WITHERED_BRICKS.get());

                    })
                    .build()
            );

//
//    public static CreativeTabs memorialsTab;
//    public static CreativeTabs corpseTab;
//    public static CreativeTabs otherItemsTab;
//
//    public static void registration() {
//        memorialsTab = new CreativeTabs("tabGSMemorials") {
//            @Override
//            public ItemStack getIconItemStack() {
//                return new ItemStack(GSBlock.MEMORIAL, 1, EnumMemorials.STONE_CELTIC_CROSS.ordinal());
//            }
//
//            @Override
//            @SideOnly(Side.CLIENT)
//            public ItemStack getTabIconItem() {
//                return new ItemStack(GSBlock.MEMORIAL, 1, EnumMemorials.STONE_CELTIC_CROSS.ordinal());
//            }
//        };
//
//        corpseTab = new CreativeTabs("tabGSCorpse") {
//            @Override
//            public ItemStack getIconItemStack() {
//                return ZombieCorpseHelper.getDefaultCorpse();
//            }
//
//            @Override
//            @SideOnly(Side.CLIENT)
//            public ItemStack getTabIconItem() {
//                return ZombieCorpseHelper.getDefaultCorpse();
//            }
//        };
//
//        otherItemsTab = new CreativeTabs("tabGSOther") {
//            @Override
//            public ItemStack getIconItemStack() {
//                return new ItemStack(GSItem.ENCHANTED_SKULL, 1, 1);
//            }
//
//            @Override
//            @SideOnly(Side.CLIENT)
//            public ItemStack getTabIconItem() {
//                return new ItemStack(GSItem.ENCHANTED_SKULL, 1, 1);
//            }
//        };
//    }

    public static void register(IEventBus modEventBus) {
        GSE_TAB.register(modEventBus);
    }

}
