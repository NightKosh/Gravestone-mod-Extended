package nightkosh.gravestone_extended.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nightkosh.gravestone_extended.gui.container.DisenchantmentContainerMenu;
import nightkosh.gravestone_extended.gui.container.EnchantmentContainerMenu;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSEMenus {

    public static final DeferredRegister<MenuType<?>> MENUS_REGISTER =
            DeferredRegister.create(Registries.MENU, ModInfo.ID);

    public static final DeferredHolder<MenuType<?>, MenuType<DisenchantmentContainerMenu>> ALTAR_DISENCHANTMENT =
            registerMenuType(DisenchantmentContainerMenu::new, "altar_disenchantment");

    public static final DeferredHolder<MenuType<?>, MenuType<EnchantmentContainerMenu>> ALTAR_ENCHANTMENT =
            registerMenuType(EnchantmentContainerMenu::new, "altar_enchantment");

    private static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(
            IContainerFactory<T> factory, String name) {
        return MENUS_REGISTER.register(name, () -> IMenuTypeExtension.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS_REGISTER.register(eventBus);
    }

}
