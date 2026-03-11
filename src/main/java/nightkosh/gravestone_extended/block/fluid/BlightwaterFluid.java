package nightkosh.gravestone_extended.block.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import nightkosh.gravestone_extended.core.*;
import nightkosh.gravestone_extended.core.compatibility.WitheredLandsCompatibility;
import nightkosh.gravestone_extended.helper.TimeHelper;
import nightkosh.gravestone_extended.item.armor.bone.IBoneArmor;
import org.jspecify.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.ArrayList;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class BlightwaterFluid extends BaseFlowingFluid {

    protected BlightwaterFluid() {
        super(new BaseFlowingFluid.Properties(GSEFluidTypes.BLIGHTWATER, GSEFluids.BLIGHTWATER, GSEFluids.BLIGHTWATER_FLOWING)
                .bucket(GSEItems.BLIGHTWATER_BUCKET)
                .block(GSEBlocks.BLIGHTWATER)
                .tickRate(20)
                .slopeFindDistance(4)
                .levelDecreasePerBlock(1));
    }

    @Override
    protected boolean isRandomlyTicking() {
        return true;
    }

    @Override
    public void randomTick(@Nonnull ServerLevel level, @Nonnull BlockPos pos,
                           @Nonnull FluidState state, @Nonnull RandomSource random) {
        super.randomTick(level, pos, state, random);

        if (!level.isClientSide()) {
            meltAllAround(level, pos);

            if (state.isSource()) {
                if (GSEConfigs.BLIGHTWATER_AUTO_REMOVE.get()) {
                    level.setBlockAndUpdate(pos, Blocks.WATER.defaultBlockState());
                } else if (GSEConfigs.BLIGHTWATER_SPREAD.get() && pos.getY() <= 20) {
                    var replacePos = new ArrayList<BlockPos>();
                    if (isWaterBlock(level, pos.above())) {
                        replacePos.add(pos.above());
                    }
                    if (isWaterBlock(level, pos.below())) {
                        replacePos.add(pos.below());
                    }
                    if (isWaterBlock(level, pos.west())) {
                        replacePos.add(pos.west());
                    }
                    if (isWaterBlock(level, pos.east())) {
                        replacePos.add(pos.east());
                    }
                    if (isWaterBlock(level, pos.north())) {
                        replacePos.add(pos.north());
                    }
                    if (isWaterBlock(level, pos.south())) {
                        replacePos.add(pos.south());
                    }

                    if (!replacePos.isEmpty()) {
                        level.setBlockAndUpdate(
                                replacePos.get(random.nextInt(replacePos.size())),
                                GSEBlocks.BLIGHTWATER.get().defaultBlockState());
                    }
                }
            }
        }
    }

    private static boolean isWaterBlock(Level level, BlockPos pos) {
        var fluid = level.getFluidState(pos);
        return fluid.is(Tags.Fluids.WATER) && fluid.isSource();
    }

    @Override
    protected void entityInside(@Nonnull Level level, @Nonnull BlockPos pos,
                                @Nonnull Entity entity, @Nonnull InsideBlockEffectApplier effectApplier) {
        super.entityInside(level, pos, entity, effectApplier);

        if (!level.isClientSide() && entity instanceof LivingEntity living) {
            if (living.getType().is(EntityTypeTags.UNDEAD)) {
                living.addEffect(new MobEffectInstance(MobEffects.POISON, TimeHelper.SECONDS_5, 0));
                return;
            } else if (entity instanceof Player || entity instanceof TamableAnimal) {
                for (var mobEffectInstance : living.getActiveEffects()) {
                    if (mobEffectInstance.is(GSEMobEffects.BONE_SKIN)) {
                        return;
                    }
                }
                if (entity instanceof Player player) {
                    if (isBoneArmor(player, EquipmentSlot.HEAD) &&
                            isBoneArmor(player, EquipmentSlot.CHEST) &&
                            isBoneArmor(player, EquipmentSlot.LEGS) &&
                            isBoneArmor(player, EquipmentSlot.FEET)) {
                        return;
                    }
                }
            } else if (living instanceof Slime) {
                living.addEffect(new MobEffectInstance(MobEffects.STRENGTH, TimeHelper.SECONDS_5, 0));
                return;
            }

            if (level instanceof ServerLevel serverlevel && level.random.nextInt(20) == 0) {
                entity.hurtServer(serverlevel, level.damageSources().magic(), 1);
                meltEffect(level, entity.getX(), entity.getY(), entity.getZ());
                if (WitheredLandsCompatibility.loaded()) {
                    var rustEffect = WitheredLandsCompatibility.getRustEffect();
                    if (rustEffect != null) {
                        living.addEffect(new MobEffectInstance(rustEffect, TimeHelper.SECONDS_5, 0));
                    }
                }
            }
        }
    }

    private boolean isBoneArmor(LivingEntity entity, EquipmentSlot slot) {
        var stack = entity.getItemBySlot(slot);
        return !stack.isEmpty() && stack.isDamageableItem() && stack.getItem() instanceof IBoneArmor;
    }

    public static void meltAllAround(Level level, BlockPos pos) {
        if (GSEConfigs.BLIGHTWATER_CONVERT_BLOCKS.get()) {
            melt(level, pos.above());
            melt(level, pos.below());
            melt(level, pos.east());
            melt(level, pos.west());
            melt(level, pos.south());
            melt(level, pos.north());
        }
    }

    public static void melt(Level level, BlockPos pos) {
        if (tryToReplaceBlock(level, pos, level.getBlockState(pos))) {
            meltEffect(level, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
        }
    }

    public static boolean tryToReplaceBlock(Level level, BlockPos pos, BlockState state) {
        if (state.is(Blocks.STONE) || state.is(Blocks.MOSSY_COBBLESTONE)) {
            level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
            return true;
        } else if (state.is(Blocks.GRAVEL)) {
            level.setBlock(pos, Blocks.SAND.defaultBlockState(), 3);
            return true;
        }
        if (state.is(Blocks.DEEPSLATE)) {
            level.setBlock(pos, Blocks.COBBLED_DEEPSLATE.defaultBlockState(), 3);
            return true;
        }
        if (state.is(Blocks.STONE_BRICKS) || state.is(Blocks.MOSSY_STONE_BRICKS)) {
            level.setBlock(pos, Blocks.CRACKED_STONE_BRICKS.defaultBlockState(), 3);
            return true;
        }
        if (state.is(Blocks.DEEPSLATE_BRICKS)) {
            level.setBlock(pos, Blocks.CRACKED_DEEPSLATE_BRICKS.defaultBlockState(), 3);
            return true;
        }
        if (state.is(Blocks.DEEPSLATE_TILES)) {
            level.setBlock(pos, Blocks.CRACKED_DEEPSLATE_TILES.defaultBlockState(), 3);
            return true;
        } else if (state.is(Blocks.GRASS_BLOCK) || state.is(Blocks.PODZOL) || state.is(Blocks.MYCELIUM)) {
            level.setBlock(pos, Blocks.DIRT.defaultBlockState(), 3);
            return true;
        }
        return false;
    }

    public static void meltEffect(Level level, double x, double y, double z) {
        if (!level.isClientSide() && level instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleTypes.LARGE_SMOKE,
                    x, y + 1, z,
                    2,
                    0.1, 0, 0.1,
                    0);
            serverLevel.playSound(null, x, y + 1, z, SoundEvents.LAVA_EXTINGUISH, SoundSource.AMBIENT,
                    0.2F + level.random.nextFloat() * 0.2F, 0.9F + level.random.nextFloat() * 0.15F);
        }
    }

    @Override
    public void animateTick(@Nonnull Level level, @Nonnull BlockPos pos,
                            @Nonnull FluidState state, @Nonnull RandomSource random) {
        super.animateTick(level, pos, state, random);

        var above = pos.above();
        if (level.getBlockState(above).isAir() && !level.getBlockState(above).isSolidRender()) {
            if (random.nextInt(300) == 0) {
                double x = pos.getX() + random.nextFloat();
                double y = pos.getY() + 1;
                double z = pos.getZ() + random.nextFloat();
                level.addParticle(ParticleTypes.LARGE_SMOKE, x, y, z, 0, 0, 0);
                level.playLocalSound(x, y, z, SoundEvents.LAVA_EXTINGUISH, SoundSource.AMBIENT,
                        0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
            } else if (random.nextInt(100) == 0) {
                double x = pos.getX() + random.nextFloat();
                double z = pos.getZ() + random.nextFloat();
                if (random.nextInt(5) == 0) {
                    double y = pos.getY() + 0.7;
                    level.playLocalSound(x, y, z,
                            GSESounds.BLIGHTWATER_BUBBLING.get(), SoundSource.AMBIENT,
                            0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
                    for (int i = 0; i < 10; i++) {
                        level.addParticle(GSEParticles.BLIGHTWATER_BUBBLE.get(),
                                x, y, z, 0, 0, 0);
                        x = pos.getX() + random.nextFloat();
                        z = pos.getZ() + random.nextFloat();
                    }
                } else {
                    double y = pos.getY() + 1;
                    level.addParticle(ParticleTypes.SMOKE, x, y, z, 0, 0, 0);
                    level.playLocalSound(x, y, z,
                            GSESounds.BLIGHTWATER_DROP_OF_ACID.get(), SoundSource.AMBIENT,
                            0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
                }
            }
        }
    }

    @Override
    public @Nullable ParticleOptions getDripParticle() {
        return GSEParticles.BLIGHTWATER_DRIP.get();
    }

    public static class Flowing extends BlightwaterFluid {

        @Override
        protected void createFluidStateDefinition(@Nonnull StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        @Override
        public boolean isSource(@Nonnull FluidState state) {
            return false;
        }

    }

    public static class Source extends BlightwaterFluid {

        @Override
        public int getAmount(@Nonnull FluidState state) {
            return 8;
        }

        @Override
        public boolean isSource(@Nonnull FluidState state) {
            return true;
        }

    }

}
