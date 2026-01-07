package nightkosh.gravestone_extended.block;

import nightkosh.gravestone_extended.block.enums.EnumPileOfBones;
import nightkosh.gravestone_extended.config.ExtendedConfig;
import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.core.GSTabs;
import nightkosh.gravestone_extended.core.ModInfo;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockPileOfBones {//TODO extends Block {
//
//    public static final PropertyEnum VARIANT = PropertyEnum.create("variant", EnumPileOfBones.class);
//    public static final PropertyDirection FACING = BlockHorizontal.FACING;
//
//    public BlockPileOfBones() {
//        super(Material.CIRCUITS);
//        this.setSoundType(SoundType.STONE);
//        this.setHardness(0.1F);
//        this.setResistance(0);
//        this.setCreativeTab(GSTabs.otherItemsTab);
//        this.setRegistryName(ModInfo.ID, "gspileofbones");
//    }
//
//    @Override
//    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
//        return null;
//    }
//
//    @Override
//    public boolean isOpaqueCube(IBlockState state) {
//        return false;
//    }
//
//    @Override
//    public boolean isFullCube(IBlockState state) {
//        return false;
//    }
//
//    @Override
//    public BlockFaceShape getBlockFaceShape(IBlockAccess access, IBlockState state, BlockPos pos, EnumFacing facing) {
//        return BlockFaceShape.UNDEFINED;
//    }
//
//    private static final AxisAlignedBB BB = new AxisAlignedBB(0.1, 0, 0.1, 0.9, 0.2, 0.9);
//
//    @Override
//    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess access, BlockPos pos) {
//        return BB;
//    }
//
//    @Override
//    protected boolean canSilkHarvest() {
//        return true;
//    }
//
//    @Override
//    public Item getItemDropped(IBlockState state, Random random, int fortune) {
//        return Items.BONE;
//    }
//
//    @Override
//    public int quantityDropped(Random random) {
//        return 4;
//    }
//
//    @Override
//    public int damageDropped(IBlockState state) {
//        return 0;
//    }
//
//    @Override
//    public IBlockState getStateFromMeta(int meta) {
//        IBlockState state = this.getDefaultState().withProperty(VARIANT, EnumPileOfBones.getById((byte) meta / 4));
//        return state.withProperty(FACING, EnumFacing.getHorizontal(meta % 4));
//    }
//
//    @Override
//    public int getMetaFromState(IBlockState state) {
//        return ((EnumPileOfBones) state.getValue(VARIANT)).ordinal() * 4 + state.getValue(FACING).getIndex();
//    }
//
//    @Override
//    protected BlockStateContainer createBlockState() {
//        return new BlockStateContainer(this, new IProperty[]{VARIANT, FACING});
//    }
//
//    public boolean isSkullCrawlerBlock(IBlockState state) {
//        return state.getValue(VARIANT) == EnumPileOfBones.PILE_OF_BONES_WITH_SKULL_CRAWLER;
//    }
//
//    public static IBlockState getCrawlerBlockState() {
//        return GSBlock.PILE_OF_BONES.getDefaultState().withProperty(BlockPileOfBones.VARIANT, EnumPileOfBones.PILE_OF_BONES_WITH_SKULL_CRAWLER);
//    }
//
//    @Override
//    public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state) {
//        if (!world.isRemote && isSkullCrawlerBlock(state) && ExtendedConfig.spawnSkullCrawlersAtPileBonesDestruction) {
//            EntitySkullCrawler skullCrawler = new EntitySkullCrawler(world);
//            skullCrawler.setLocationAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0, 0);
//            world.spawnEntity(skullCrawler);
//            skullCrawler.spawnExplosionParticle();
//        }
//
//        super.onBlockDestroyedByPlayer(world, pos, state);
//    }
//
//    @Override
//    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack stack) {
//        EnumFacing enumfacing = EnumFacing.getHorizontal(MathHelper.floor(entity.rotationYaw * 4 / 360F + 0.5) & 3).getOpposite();
//        world.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
//    }
//
//    @Override
//    @SideOnly(Side.CLIENT)
//    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
//        Item item = Item.getItemFromBlock(this);
//        for (byte i = 0; i < EnumPileOfBones.values().length; i++) {
//            list.add(new ItemStack(item, 1, i * 4));
//        }
//    }
//
//    @Override
//    public boolean canPlaceBlockAt(World world, BlockPos pos) {
//        return world.isSideSolid(pos.down(), EnumFacing.UP);
//    }
//
//    @Override
//    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block,  BlockPos fromPos) {
//        if (!canPlaceBlockAt(world, pos)) {
//            this.dropBlockAsItem(world, pos, state, 0);
//            world.setBlockToAir(pos);
//        }
//    }
}
