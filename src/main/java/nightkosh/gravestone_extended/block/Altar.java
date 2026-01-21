package nightkosh.gravestone_extended.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import nightkosh.gravestone_extended.core.GSEBlocks;
import org.jspecify.annotations.Nullable;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Altar extends BaseEntityBlock {

    public static final MapCodec<Altar> CODEC = simpleCodec(Altar::new);

    public Altar(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public Altar() {
        this(BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.BASEDRUM)
                .mapColor(MapColor.COLOR_RED)
                .setId(GSEBlocks.ALTAR_RK)
                .strength(5, Integer.MAX_VALUE));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }
//
//    /**
//     * Called upon block activation (right click on the block.)
//     */
//    @Override
//    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
//        if (world.getTileEntity(pos) != null && !player.isSneaking()) {
//            player.openGui(ModGravestoneExtended.instance, GuiHandler.ALTAR_RESURRECTION_GUI_ID, world, pos.getX(), pos.getY(), pos.getZ());
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public boolean isOpaqueCube(IBlockState state) {
//        return false;
//    }
//
//    @Override
//    public BlockFaceShape getBlockFaceShape(IBlockAccess access, IBlockState state, BlockPos pos, EnumFacing facing) {
//        return BlockFaceShape.UNDEFINED;
//    }
//
//    @Override
//    public EnumBlockRenderType getRenderType(IBlockState state) {
//        return EnumBlockRenderType.MODEL;
//    }
//
//    private static final AxisAlignedBB BB = new AxisAlignedBB(0, 0, 0, 1, 0.75F, 1);
//
//    @Override
//    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess access, BlockPos pos) {
//        return BB;
//    }
//
//    @Override
//    public TileEntity createNewTileEntity(World world, int meta) {
//        return new TileEntityAltar();
//    }
//
//    @Override
//    public void breakBlock(World world, BlockPos pos, IBlockState state) {
//        TileEntityAltar tileEntity = (TileEntityAltar) world.getTileEntity(pos);
//
//        if (tileEntity != null) {
//            tileEntity.dropItems();
//        }
//
//        super.breakBlock(world, pos, state);
//    }
}
