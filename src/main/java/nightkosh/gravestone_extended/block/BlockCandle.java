package nightkosh.gravestone_extended.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone_extended.core.GSParticles;
import nightkosh.gravestone_extended.core.GSTabs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.helper.TimeHelper;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockCandle extends Block {

    public BlockCandle() {
        super(Material.CARPET);
        this.setSoundType(SoundType.CLOTH);
        this.setUnlocalizedName("candle");
        this.setHardness(0);
        this.setLightLevel(1);
        this.setResistance(0);
        this.setCreativeTab(GSTabs.otherItemsTab);
        this.setRegistryName(ModInfo.ID, "gscandle");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random) {
        double xPos = pos.getX() + 0.5;
        double yPos = pos.getY() + 0.5;
        double zPos = pos.getZ() + 0.5;

        long dayTime = TimeHelper.getDayTime(world);
        if (dayTime < TimeHelper.SUN_SET || dayTime > TimeHelper.SUN_RISING) {
            world.spawnParticle(EnumParticleTypes.FLAME, xPos, yPos, zPos, 0, 0, 0);
        } else {
            world.spawnParticle(GSParticles.GREEN_FLAME, xPos, yPos, zPos, 0, 0, 0);
        }
        world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, xPos, yPos, zPos, 0, 0, 0);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
        return null;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    private static final AxisAlignedBB BB = new AxisAlignedBB(0.4F, 0, 0.4F, 0.6F, 0.6F, 0.6F);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess access, BlockPos pos) {
        return BB;
    }

    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos) {
        return canPlaceCandleOn(world, pos.down());
    }

    @Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block,  BlockPos fromPos) {
        if (!this.canPlaceCandleOn(world, pos.down())) {
            this.dropBlockAsItem(world, pos, state, 0);
            world.setBlockToAir(pos);
        }
    }

    private boolean canPlaceCandleOn(World world, BlockPos pos) {
        if (world.isSideSolid(pos, EnumFacing.UP)) {
            return true;
        } else {
            IBlockState state = world.getBlockState(pos);
            return (state.getBlock() != null && state.getBlock().canPlaceTorchOnTop(state, world, pos));
        }
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess access, IBlockState state, BlockPos pos, EnumFacing facing) {
        return BlockFaceShape.UNDEFINED;
    }
}
