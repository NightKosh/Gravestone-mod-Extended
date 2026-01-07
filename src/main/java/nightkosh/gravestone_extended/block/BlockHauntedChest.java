package nightkosh.gravestone_extended.block;

import nightkosh.gravestone_extended.block.enums.EnumHauntedChest;
import nightkosh.gravestone_extended.core.GSTabs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.tileentity.TileEntityHauntedChest;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockHauntedChest {//TODO extends BlockContainer {
//
//    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
//
//    public BlockHauntedChest() {
//        super(Material.WOOD);
//        this.setSoundType(SoundType.STONE);
//        this.setHardness(2.5F);
//        this.setCreativeTab(GSTabs.otherItemsTab);
//        this.setHarvestLevel("axe", 0);
//        this.setRegistryName(ModInfo.ID, "gshauntedchest");
//    }
//
//    /**
//     * Is this block (a) opaque and (b) a full 1m cube? This determines whether
//     * or not to render the shared face of two adjacent blocks and also whether
//     * the player can attach torches, redstone wire, etc to this block.
//     */
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
//    /**
//     * The type of render function that is called for this block
//     */
//    @Override
//    public EnumBlockRenderType getRenderType(IBlockState state) {
//        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
//    }
//
//    private static final AxisAlignedBB BB = new AxisAlignedBB(0.0625F, 0, 0.0625F, 0.9375F, 0.875F, 0.9375F);
//
//    @Override
//    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess access, BlockPos pos) {
//        return BB;
//    }
//
//    /**
//     * Returns the ID of the items to drop on destruction.
//     */
//    @Override
//    public Item getItemDropped(IBlockState state, Random random, int fortune) {
//        return null;
//    }
//
//    /**
//     * Determines the damage on the item the block drops. Used in cloth and
//     * wood.
//     */
//    @Override
//    public int damageDropped(IBlockState state) {
//        return 0;
//    }
//
//    /**
//     * Return true if a player with Silk Touch can harvest this block directly, and not its normal drops.
//     */
//    @Override
//    public boolean canSilkHarvest() {
//        return true;
//    }
//
//    /**
//     * Called upon block activation (right click on the block.)
//     */
//    @Override
//    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
//        if (player instanceof FakePlayer) {
//            return false;
//        } else {
//            TileEntityHauntedChest te = (TileEntityHauntedChest) world.getTileEntity(pos);
//            if (te != null) {
//                te.openChest();
//            }
//        }
//        return true;
//    }
//
//    @Override
//    public TileEntity createNewTileEntity(World world, int var2) {
//        return new TileEntityHauntedChest();
//    }
//
//    /**
//     * Called when the block is placed in the world.
//     */
//    @Override
//    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
//        EnumFacing enumfacing = EnumFacing.getHorizontal(MathHelper.floor((double) (placer.rotationYaw * 4 / 360F) + 0.5D) & 3).getOpposite();
//        state = state.withProperty(FACING, enumfacing);
//
//        world.setBlockState(pos, state, 3);
//
//        TileEntityHauntedChest tileEntity = (TileEntityHauntedChest) world.getTileEntity(pos);
//
//        if (tileEntity != null) {
//            if (stack.getTagCompound() != null) {
//                tileEntity.setChestType(EnumHauntedChest.getById(stack.getTagCompound().getInteger("ChestType")));
//            }
//        }
//    }
//
//    /**
//     * Called when the player destroys a block with an item that can harvest it.
//     */
//    @Override
//    public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, @Nullable ItemStack stack) {
//    }
//
//    /**
//     * Called when the block is attempted to be harvested
//     */
//    @Override
//    public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
//        player.addExhaustion(0.025F);
//        if (!world.isRemote && !world.restoringBlockSnapshots) {
//            ItemStack itemStack;
//            if (EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, player.getHeldItemMainhand()) > 0) {
//                itemStack = getBlockItemStack(world, pos, state);
//            } else {
//                itemStack = new ItemStack(Blocks.CHEST, 1, 0);
//            }
//
//            if (itemStack != null) {
//                GraveInventory.dropItem(itemStack, world, pos);
//            }
//        }
//    }
//
//    /**
//     * This returns a complete list of items dropped from this block.
//     */
//    @Override
//    public List<ItemStack> getDrops(IBlockAccess access, BlockPos pos, IBlockState state, int fortune) {
//        List<ItemStack> ret = new ArrayList<>();
//        ret.add(new ItemStack(Blocks.CHEST, 1, 0));
//
//        return ret;
//    }
//
//    /**
//     * Get chest block as item block
//     */
//    private ItemStack getBlockItemStack(World world, BlockPos pos, IBlockState state) {
//        ItemStack itemStack = new ItemStack(Item.getItemFromBlock(this), 1);
//        TileEntityHauntedChest tileEntity = (TileEntityHauntedChest) world.getTileEntity(pos);
//
//        if (tileEntity != null) {
//            NBTTagCompound nbt = new NBTTagCompound();
//            nbt.setInteger("ChestType", tileEntity.getChestType().ordinal());
//
//            itemStack.setTagCompound(nbt);
//        }
//
//        return itemStack;
//    }
//
//    @Override
//    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
//        return getBlockItemStack(world, pos, world.getBlockState(pos));
//    }
//
//    @Override
//    @SideOnly(Side.CLIENT)
//    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
//        Item item = Item.getItemFromBlock(this);
//        for (byte i = 0; i < EnumHauntedChest.values().length; i++) {
//            ItemStack stack = new ItemStack(item, 1, 0);
//            NBTTagCompound nbt = new NBTTagCompound();
//            nbt.setInteger("ChestType", i);
//
//            stack.setTagCompound(nbt);
//            list.add(stack);
//        }
//    }
//
//    @Override
//    public IBlockState getStateFromMeta(int meta) {
//        EnumFacing enumfacing = EnumFacing.getFront(meta);
//
//        if (enumfacing.getAxis() == EnumFacing.Axis.Y) {
//            enumfacing = EnumFacing.NORTH;
//        }
//
//        return this.getDefaultState().withProperty(FACING, enumfacing);
//    }
//
//    @Override
//    public int getMetaFromState(IBlockState state) {
//        return ((EnumFacing) state.getValue(FACING)).getIndex();
//    }
//
//    @Override
//    protected BlockStateContainer createBlockState() {
//        return new BlockStateContainer(this, new IProperty[]{FACING});
//    }
}
