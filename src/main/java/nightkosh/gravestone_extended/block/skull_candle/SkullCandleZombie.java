package nightkosh.gravestone_extended.block.skull_candle;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.PushReaction;
import nightkosh.gravestone_extended.core.GSEBlocks;

import javax.annotation.Nonnull;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class SkullCandleZombie extends ASkullCandle {

    private static final MapCodec<ASkullCandle> CODEC = simpleCodec(SkullCandleZombie::new);

    public SkullCandleZombie(Properties properties) {
        super(properties);
    }

    public SkullCandleZombie() {
        this(BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.ZOMBIE)
                .setId(GSEBlocks.SKULL_CANDLE_ZOMBIE_RK)
                .sound(SoundType.BONE_BLOCK)
                .lightLevel(state -> 14)
                .noCollision()
                .pushReaction(PushReaction.DESTROY)
                .strength(0.1F, 0));
    }

    @Nonnull
    @Override
    protected MapCodec<? extends ASkullCandle> codec() {
        return CODEC;
    }

}
