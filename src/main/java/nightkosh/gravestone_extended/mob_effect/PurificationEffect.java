package nightkosh.gravestone_extended.mob_effect;

import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import nightkosh.gravestone_extended.core.GSEConfigs;

import javax.annotation.Nonnull;
import java.util.ArrayList;

import static nightkosh.gravestone_extended.ModGravestoneExtended.LOGGER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class PurificationEffect extends InstantenousMobEffect {

    public PurificationEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xffffff);
    }

    @Override
    public boolean applyEffectTick(@Nonnull ServerLevel level, @Nonnull LivingEntity entity, int amplifier) {
        if (!level.isClientSide()) {
            if (GSEConfigs.DEBUG_MODE.get()) {
                LOGGER.info("Going to remove all negative effects on {} by PurificationEffect", entity.getScoreboardName());
            }

            var effectsToRemove = new ArrayList<Holder<MobEffect>>();
            for (var effectInstance : entity.getActiveEffects()) {
                var effect = effectInstance.getEffect();
                if (effect.value().getCategory() == MobEffectCategory.HARMFUL) {
                    effectsToRemove.add(effect);
                }
            }
            for (var effect : effectsToRemove) {
                entity.removeEffect(effect);
            }
            entity.extinguishFire();
            entity.clearFreeze();
        }

        return true;
    }

//TODO ???
//    public static void applyPotionOnBlocks(EntityPotion entityPotion) {
//        int range = 5;
//        Map<BlockPos, TileEntity> teMap = entityPotion.world.getChunkFromBlockCoords(entityPotion.getPosition()).getTileEntityMap();
//        teMap.putAll(entityPotion.world.getChunkFromBlockCoords(new BlockPos(entityPotion.posX + range, entityPotion.posY, entityPotion.posZ)).getTileEntityMap());
//        teMap.putAll(entityPotion.world.getChunkFromBlockCoords(new BlockPos(entityPotion.posX - range, entityPotion.posY, entityPotion.posZ)).getTileEntityMap());
//        teMap.putAll(entityPotion.world.getChunkFromBlockCoords(new BlockPos(entityPotion.posX, entityPotion.posY, entityPotion.posZ + range)).getTileEntityMap());
//        teMap.putAll(entityPotion.world.getChunkFromBlockCoords(new BlockPos(entityPotion.posX, entityPotion.posY, entityPotion.posZ - range)).getTileEntityMap());
//        teMap.putAll(entityPotion.world.getChunkFromBlockCoords(new BlockPos(entityPotion.posX + range, entityPotion.posY, entityPotion.posZ + range)).getTileEntityMap());
//        teMap.putAll(entityPotion.world.getChunkFromBlockCoords(new BlockPos(entityPotion.posX + range, entityPotion.posY, entityPotion.posZ - range)).getTileEntityMap());
//        teMap.putAll(entityPotion.world.getChunkFromBlockCoords(new BlockPos(entityPotion.posX - range, entityPotion.posY, entityPotion.posZ + range)).getTileEntityMap());
//        teMap.putAll(entityPotion.world.getChunkFromBlockCoords(new BlockPos(entityPotion.posX - range, entityPotion.posY, entityPotion.posZ - range)).getTileEntityMap());
//
//        for (Map.Entry<BlockPos, TileEntity> teEntry : teMap.entrySet()) {
//            if (teEntry != null && teEntry.getValue() instanceof TileEntityGraveStone &&
//                    (teEntry.getKey().getX() >= entityPotion.posX - range && teEntry.getKey().getX() <= entityPotion.posX + range &&
//                            teEntry.getKey().getZ() >= entityPotion.posZ - range && teEntry.getKey().getZ() <= entityPotion.posZ + range &&
//                            teEntry.getKey().getY() >= entityPotion.posY - range && teEntry.getKey().getY() <= entityPotion.posY + range)) {
//                ((TileEntityGraveStone) teEntry.getValue()).setPurified(true);
//            }
//        }
//    }

}
