package nightkosh.gravestone_extended.enchantment.curse;

import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.event.entity.player.ItemFishedEvent;
import nightkosh.gravestone_extended.core.GSEnchantment;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.helper.GSEnchantmentHelper;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EnchantmentBrokenHookCurse extends EnchantmentCurse {
    private static final Random RANDOM = new Random();

    public EnchantmentBrokenHookCurse() {
        super(EnumEnchantmentType.FISHING_ROD, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
        this.setName("broken_hook_curse");
        this.setRegistryName(ModInfo.ID, "gs_broken_hook_curse");
    }

    public static void applyEffect(ItemFishedEvent event) {
        int level = GSEnchantmentHelper.getEnchantmentLevel(event.getEntityPlayer().getHeldItemMainhand(), GSEnchantment.CURSE_BROKEN_HOOK);
        if (level > 0 && RANDOM.nextInt(10) < 3) {
            event.setCanceled(true);
        }
    }
}
