package nightkosh.gravestone_extended.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.ModGravestoneExtended;
import nightkosh.gravestone_extended.core.GSTabs;
import nightkosh.gravestone_extended.core.GuiHandler;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.tileentity.TileEntityAltar;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockAltar extends BlockContainer {

    public BlockAltar() {
        super(Material.ROCK);
        this.setLightOpacity(0);
        this.setUnlocalizedName("altar");
        this.setCreativeTab(GSTabs.otherItemsTab);
        this.setHardness(5);
        this.setResistance(2000);
        this.setRegistryName(ModInfo.ID, "gsaltar");
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (world.getTileEntity(pos) != null && !player.isSneaking()) {
            player.openGui(ModGravestoneExtended.instance, GuiHandler.ALTAR_RESURRECTION_GUI_ID, world, pos.getX(), pos.getY(), pos.getZ());
            return true;
        }
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess access, IBlockState state, BlockPos pos, EnumFacing facing) {
        return BlockFaceShape.UNDEFINED;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    private static final AxisAlignedBB BB = new AxisAlignedBB(0, 0, 0, 1, 0.75F, 1);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess access, BlockPos pos) {
        return BB;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityAltar();
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntityAltar tileEntity = (TileEntityAltar) world.getTileEntity(pos);

        if (tileEntity != null) {
            tileEntity.dropItems();
        }

        super.breakBlock(world, pos, state);
    }
}
