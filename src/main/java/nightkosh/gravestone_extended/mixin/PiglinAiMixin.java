package nightkosh.gravestone_extended.mixin;

import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import nightkosh.gravestone_extended.core.GSEEnchantments;
import nightkosh.gravestone_extended.helper.GSEEnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@Mixin(PiglinAi.class)
public class PiglinAiMixin {

    @Inject(method = "isWearingSafeArmor", at = @At("HEAD"), cancellable = true)
    private static void gravestone_extended$isWearingSafeArmor(
            LivingEntity wearer, CallbackInfoReturnable<Boolean> ci) {
        for (var equipmentslot : EquipmentSlotGroup.ARMOR) {
            if (GSEEnchantmentHelper.enchanted(wearer.level(), GSEEnchantments.GILDED_SHEEN, wearer.getItemBySlot(equipmentslot))) {
                ci.setReturnValue(true);
                break;
            }
        }
    }

}
