package nightkosh.gravestone_extended.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WebBlock;
import net.minecraft.world.level.block.state.BlockState;
import nightkosh.gravestone_extended.core.GSEEnchantments;
import nightkosh.gravestone_extended.helper.GSEEnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@Mixin(WebBlock.class)
public class CobwebBlockMixin {

    @Inject(method = "entityInside", at = @At("HEAD"), cancellable = true)
    private void gravestone_extended$noCobwebSlowdown(
            BlockState state, Level level, BlockPos pos, Entity entity,
            InsideBlockEffectApplier effectApplier, boolean intersects,
            CallbackInfo ci) {
        if (entity instanceof Player player) {
            var leggings = player.getItemBySlot(EquipmentSlot.LEGS);
            if (!leggings.isEmpty()) {
                if (GSEEnchantmentHelper.enchanted(level, GSEEnchantments.WEB_CRAWLER, leggings)) {
                    ci.cancel();
                }
            }
        }
    }

}
