package nightkosh.gravestone_extended.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.portal.TeleportTransition;
import net.minecraft.world.level.redstone.Orientation;
import nightkosh.gravestone_extended.core.GSEBlocks;
import nightkosh.gravestone_extended.core.GSEParticles;
import org.jspecify.annotations.Nullable;

import javax.annotation.Nonnull;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class PortalCatacombsBlock extends NetherPortalBlock {

    public PortalCatacombsBlock() {
        super(BlockBehaviour.Properties.of()
                .noCollision()
                .randomTicks()
                .strength(-1)
                .sound(SoundType.GLASS)
                .lightLevel(state -> 11)
                .pushReaction(PushReaction.BLOCK)
                .setId(GSEBlocks.PORTAL_CATACOMBS_RK));
    }

    @Override
    protected void randomTick(
            @Nonnull BlockState state, @Nonnull ServerLevel level, @Nonnull BlockPos pos, @Nonnull RandomSource random) {
        // TODO skeleton spawn????
    }

    @Override
    public @Nullable TeleportTransition getPortalDestination(
            @Nonnull ServerLevel level, @Nonnull Entity entity, @Nonnull BlockPos pos) {
        //TODO
//        if (!entity.isRiding() && !entity.isBeingRidden() && entity.isNonBoss()) {
//            if (!entity.world.isRemote && entity instanceof EntityPlayerMP) {
//                EntityPlayerMP player = (EntityPlayerMP) entity;
//                MinecraftServer minecraftServer = player.getServer();
//                int dimensionId = world.provider.getDimension();
//                int dimensionIn;
//
//                if (player.timeUntilPortal > 0) {
//                    player.timeUntilPortal = 10;
//                } else {
//                    player.invulnerableDimensionChange = true;
//                    if (dimensionId == GSDimensions.CATACOMBS.getId()) {
//                        dimensionIn = 0;
//                    } else {
//                        dimensionIn = GSDimensions.CATACOMBS.getId();
//                    }
//
//                    player.timeUntilPortal = 10;
//                    minecraftServer.getPlayerList().transferPlayerToDimension(player, dimensionIn, new TeleporterCatacombs(minecraftServer.getWorld(dimensionIn)));
//                }
//            }
//        }
        return null;//TODO
    }

    @Override
    public void animateTick(
            @Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos, RandomSource random) {
        if (random.nextInt(100) == 0) {
            level.playLocalSound(
                    pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    SoundEvents.PORTAL_AMBIENT, SoundSource.BLOCKS,
                    0.5F, random.nextFloat() * 0.4F + 0.8F, false);
        }

        for (int i = 0; i < 4; i++) {
            double d0 = pos.getX() + random.nextDouble();
            double d1 = pos.getY() + random.nextDouble();
            double d2 = pos.getZ() + random.nextDouble();
            double d3 = (random.nextFloat() - 0.5) * 0.5;
            double d4 = (random.nextFloat() - 0.5) * 0.5;
            double d5 = (random.nextFloat() - 0.5) * 0.5;
            int j = random.nextInt(2) * 2 - 1;
            if (!level.getBlockState(pos.west()).is(this) &&
                    !level.getBlockState(pos.east()).is(this)) {
                d0 = pos.getX() + 0.5 + 0.25 * j;
                d3 = random.nextFloat() * 2.0F * j;
            } else {
                d2 = pos.getZ() + 0.5 + 0.25 * j;
                d5 = random.nextFloat() * 2.0F * j;
            }

            level.addParticle(GSEParticles.CATACOMBS_PORTAL.get(), d0, d1, d2, d3, d4, d5);
        }
    }

    @Override
    protected void neighborChanged(
            @Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos,
            @Nonnull Block block, @Nullable Orientation orientation, boolean isMoving) {
        // DO nothing !!
    }

}
