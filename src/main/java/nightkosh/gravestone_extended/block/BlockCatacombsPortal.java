package nightkosh.gravestone_extended.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone_extended.core.GSDimensions;
import nightkosh.gravestone_extended.core.GSParticles;
import nightkosh.gravestone_extended.core.GSTabs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.teleporter.TeleporterCatacombs;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockCatacombsPortal extends BlockPortal {

    public BlockCatacombsPortal() {
        super();
        this.setHardness(Float.MAX_VALUE);
        this.setResistance(Float.MAX_VALUE);
        this.setUnlocalizedName("catacombs_portal");
        this.setRegistryName(ModInfo.ID, "gs_catacombs_portal");
        this.setCreativeTab(GSTabs.otherItemsTab);
    }

    @Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
        if (!entity.isRiding() && !entity.isBeingRidden() && entity.isNonBoss()) {
            if (!entity.world.isRemote && entity instanceof EntityPlayerMP) {
                EntityPlayerMP player = (EntityPlayerMP) entity;
                MinecraftServer minecraftServer = player.getServer();
                int dimensionId = world.provider.getDimension();
                int dimensionIn;

                if (player.timeUntilPortal > 0) {
                    player.timeUntilPortal = 10;
                } else {
                    if (dimensionId == GSDimensions.CATACOMBS.getId()) {
                        dimensionIn = 0;
                    } else {
                        dimensionIn = GSDimensions.CATACOMBS.getId();
                    }

                    player.timeUntilPortal = 10;
                    minecraftServer.getPlayerList().transferPlayerToDimension(player, dimensionIn, new TeleporterCatacombs(minecraftServer.getWorld(dimensionIn)));
                }
            }
        }
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack stack) {
        world.setBlockState(pos, state.withProperty(AXIS, EnumFacing.fromAngle(entity.rotationYaw).rotateY().getAxis()), 2);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
        if (rand.nextInt(100) == 0) {
            world.playSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
        }

        for (int i = 0; i < 4; ++i) {
            double x = pos.getX() + rand.nextFloat();
            double y = pos.getY() + rand.nextFloat();
            double z = pos.getZ() + rand.nextFloat();
            double d3 = (rand.nextFloat() - 0.5) * 0.5;
            double d4 = (rand.nextFloat() - 0.5) * 0.5;
            double d5 = (rand.nextFloat() - 0.5) * 0.5;
            int j = rand.nextInt(2) * 2 - 1;

            if (world.getBlockState(pos.west()).getBlock() != this && world.getBlockState(pos.east()).getBlock() != this) {
                x = pos.getX() + 0.5 + 0.25 * j;
                d3 = rand.nextFloat() * 2 * j;
            } else {
                z = pos.getZ() + 0.5 + 0.25 * j;
                d5 = rand.nextFloat() * 2 * j;
            }

            world.spawnParticle(GSParticles.CATACOMBS_PORTAL, x, y, z, d3, d4, d5);
        }
    }
}
