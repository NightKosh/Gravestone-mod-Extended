package nightkosh.gravestone_extended.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockVine;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone.inventory.GraveInventory;
import nightkosh.gravestone_extended.ModGravestoneExtended;
import nightkosh.gravestone_extended.block.enums.EnumMemorials;
import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.core.GSTabs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.core.logger.GSLogger;
import nightkosh.gravestone_extended.structures.MemorialGenerationHelper;
import nightkosh.gravestone_extended.tileentity.TileEntityMemorial;

import javax.annotation.Nullable;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockMemorial extends BlockContainer {

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    public BlockMemorial() {
        super(Material.ROCK);
        this.setSoundType(SoundType.STONE);
        this.setHardness(1);
        this.setResistance(5);
        this.setCreativeTab(GSTabs.memorialsTab);
        this.setRegistryName(ModInfo.ID, "gsmemorial");
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack itemStack) {
        EnumFacing enumfacing = EnumFacing.getHorizontal(MathHelper.floor((double) (player.rotationYaw * 4 / 360F) + 0.5) & 3).getOpposite();
        state = state.withProperty(FACING, enumfacing);
        world.setBlockState(pos, state, 2);

        TileEntityMemorial tileEntity = (TileEntityMemorial) world.getTileEntity(pos);

        if (tileEntity != null) {
            if (itemStack.hasTagCompound()) {
                NBTTagCompound nbt = itemStack.getTagCompound();
                if (nbt.hasKey("isLocalized") && nbt.getBoolean("isLocalized")) {
                    tileEntity.getDeathTextComponent().setLocalized();

                    if (nbt.hasKey("name") && nbt.hasKey("KillerName")) {
                        tileEntity.getDeathTextComponent().setName(nbt.getString("name"));
                        tileEntity.getDeathTextComponent().setKillerName(nbt.getString("KillerName"));
                    }
                }

                if (nbt.hasKey("DeathText")) {
                    tileEntity.getDeathTextComponent().setDeathText(nbt.getString("DeathText"));
                }

                tileEntity.setGraveType(itemStack.getItemDamage());
                tileEntity.setMossy(nbt.getBoolean("Mossy"));
                tileEntity.setEnchanted(nbt.getBoolean("Enchanted"));

                tileEntity.setPlayerProfile(nbt);

                placeWalls(world, pos);
            }
        }
    }

    public static void placeWalls(World world, BlockPos pos) {
        TileEntityMemorial tileEntity = (TileEntityMemorial) world.getTileEntity(pos);

        if (tileEntity != null) {
            //TODO almost the same code in ItemBlockGSMemorial
            byte maxY;
            byte maxX = 1;
            byte maxZ = 1;
            byte startX = 0;
            byte startZ = 0;

            switch (tileEntity.getMemorialType().getMemorialType()) {
                case CROSS:
                case OBELISK:
                    maxY = 5;
                    maxX = 2;
                    maxZ = 2;
                    startX = -1;
                    startZ = -1;
                    break;
                case DOG_STATUE:
                case CAT_STATUE:
                    maxY = 2;
                    break;
                case CELTIC_CROSS:
                case STEVE_STATUE:
                case VILLAGER_STATUE:
                case ANGEL_STATUE:
                case CREEPER_STATUE:
                default:
                    maxY = 3;
                    break;
            }
            for (byte shiftY = 0; shiftY < maxY; shiftY++) {
                for (byte shiftZ = startZ; shiftZ < maxZ; shiftZ++) {
                    for (byte shiftX = startX; shiftX < maxX; shiftX++) {
                        BlockPos newPos = new BlockPos(pos.getX() + shiftX, pos.getY() + shiftY, pos.getZ() + shiftZ);
                        if (world.getBlockState(newPos).getBlock() == Blocks.AIR) {
                            world.setBlockState(newPos, GSBlock.INVISIBLE_WALL.getDefaultState());
                        }
                    }
                }
            }
        }
    }

    @Override
    public void onBlockDestroyedByExplosion(World world, BlockPos pos, Explosion explosionIn) {
        removeWalls(world, pos);
        super.onBlockDestroyedByExplosion(world, pos, explosionIn);
    }

    @Override
    public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest) {
        removeWalls(world, pos);
        return super.removedByPlayer(state, world, pos, player, willHarvest);
    }

    private static void removeWalls(World world, BlockPos pos) {
        //TODO almost the same code in ItemBlockGSMemorial
        byte maxY;
        byte maxX = 1;
        byte maxZ = 1;
        byte startX = 0;
        byte startZ = 0;

        TileEntityMemorial tileEntity = (TileEntityMemorial) world.getTileEntity(pos);

        if (tileEntity != null) {
            switch (tileEntity.getMemorialType().getMemorialType()) {
                case CROSS:
                case OBELISK:
                    maxY = 5;
                    maxX = 2;
                    maxZ = 2;
                    startX = -1;
                    startZ = -1;
                    break;
                case DOG_STATUE:
                case CAT_STATUE:
                    maxY = 2;
                    break;
                case CELTIC_CROSS:
                case STEVE_STATUE:
                case VILLAGER_STATUE:
                case ANGEL_STATUE:
                case CREEPER_STATUE:
                default:
                    maxY = 3;
                    break;
            }
            for (byte shiftY = 0; shiftY < maxY; shiftY++) {
                for (byte shiftZ = startZ; shiftZ < maxZ; shiftZ++) {
                    for (byte shiftX = startX; shiftX < maxX; shiftX++) {
                        BlockPos newPos = new BlockPos(pos.getX() + shiftX, pos.getY() + shiftY, pos.getZ() + shiftZ);
                        if (world.getBlockState(newPos).getBlock() == GSBlock.INVISIBLE_WALL) {
                            world.setBlockState(new BlockPos(pos.getX() + shiftX, pos.getY() + shiftY, pos.getZ() + shiftZ), Blocks.AIR.getDefaultState());
                        }
                    }
                }
            }
        }
    }

    private static final AxisAlignedBB CROSS_BB = new AxisAlignedBB(-1, 0, -1, 2, 5, 2);
    private static final AxisAlignedBB STEVE_BB = new AxisAlignedBB(0.125, 0, 0.125, 0.875, 3, 0.875);
    private static final AxisAlignedBB PET_BB = new AxisAlignedBB(0.125, 0, 0.125, 0.875, 2, 0.875);
    private static final AxisAlignedBB CREEPER_BB = new AxisAlignedBB(0.125, 0, 0.125, 0.875, 2.5, 0.875);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess access, BlockPos pos) {
        EnumMemorials.EnumMemorialType memorialType;
        TileEntityMemorial tileEntity = (TileEntityMemorial) access.getTileEntity(pos);

        if (tileEntity != null) {
            memorialType = tileEntity.getMemorialType().getMemorialType();
        } else {
            memorialType = EnumMemorials.EnumMemorialType.CROSS;
        }

        switch (memorialType) {
            case CROSS:
            case OBELISK:
            default:
                return CROSS_BB;
            case CELTIC_CROSS:
            case STEVE_STATUE:
            case VILLAGER_STATUE:
            case ANGEL_STATUE:
                return STEVE_BB;
            case DOG_STATUE:
            case CAT_STATUE:
                return PET_BB;
            case CREEPER_STATUE:
                return CREEPER_BB;
        }
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess access, IBlockState state, BlockPos pos, EnumFacing facing) {
        return BlockFaceShape.UNDEFINED;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        TileEntityMemorial te = (TileEntityMemorial) world.getTileEntity(pos);

        if (te != null) {
            ItemStack item = player.inventory.getCurrentItem();
            if (item != null) {
                if (te.isMossy()) {
                    if (item.getItem() instanceof ItemShears) {
                        if (!world.isRemote) {
                            GraveInventory.dropItem(new ItemStack(Blocks.VINE, 1), world, pos);
                        }
                        te.setMossy(false);
                        return false;
                    }
                } else {
                    if (net.minecraft.block.Block.getBlockFromItem(item.getItem()) instanceof BlockVine) {
                        te.setMossy(true);
                        player.inventory.getCurrentItem().setCount(player.inventory.getCurrentItem().getCount() - 1);
                        return true;
                    }
                }
            }

            if (world.isRemote) {
                String name;
                String killerName;
                String deathText = te.getDeathTextComponent().getDeathText();

                if (deathText.length() != 0) {
                    if (te.getDeathTextComponent().isLocalized()) {
                        name = ModGravestoneExtended.proxy.getLocalizedEntityName(te.getDeathTextComponent().getName());
                        if (name.length() != 0) {
                            killerName = ModGravestoneExtended.proxy.getLocalizedEntityName(te.getDeathTextComponent().getKillerName());

                            if (killerName.length() == 0) {
                                player.sendMessage(new TextComponentTranslation(deathText, new Object[]{name}));
                            } else {
                                player.sendMessage(new TextComponentTranslation(deathText, new Object[]{name, killerName}));
                            }
                            return false;
                        }
                    }
                    player.sendMessage(new TextComponentTranslation(deathText));
                }
            }
        }

        return false;
    }

    @Override
    public boolean isTranslucent(IBlockState state) {
        return true;
    }
    @Override
    public boolean isFullBlock(IBlockState state) {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int var2) {
        return new TileEntityMemorial(world);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
        Item item = Item.getItemFromBlock(this);
        for (EnumMemorials memorial : EnumMemorials.values()) {
            list.add(getMemorialItemForCreativeInventory(item, memorial.ordinal()));
        }
    }

    private static ItemStack getMemorialItemForCreativeInventory(Item item, int graveType) {
        return new ItemStack(item, 1, graveType);
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        player.addExhaustion(0.025F);

        if (!world.isRemote && !world.restoringBlockSnapshots) {
            ItemStack itemStack;
            if (EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, player.getHeldItemMainhand()) > 0) {
                itemStack = getBlockItemStack(world, pos);
            } else {
                itemStack = getBlockItemStackWithoutInfo(world, pos);
            }

            if (itemStack != null) {
                GraveInventory.dropItem(itemStack, world, pos);
            }
        }
    }

    private ItemStack getBlockItemStack(World world, BlockPos pos) {
        ItemStack itemStack = new ItemStack(Item.getItemFromBlock(this), 1);
        TileEntityMemorial tileEntity = (TileEntityMemorial) world.getTileEntity(pos);

        if (tileEntity != null) {
            itemStack.setItemDamage(tileEntity.getGraveTypeNum());
            NBTTagCompound nbt = new NBTTagCompound();
            if (tileEntity.getDeathTextComponent().isLocalized()) {
                nbt.setBoolean("isLocalized", true);
                nbt.setString("name", tileEntity.getDeathTextComponent().getName());
                nbt.setString("KillerName", tileEntity.getDeathTextComponent().getKillerName());
            }
            nbt.setString("DeathText", tileEntity.getDeathTextComponent().getDeathText());

            nbt.setBoolean("Enchanted", tileEntity.isEnchanted());

            nbt.setBoolean("Mossy", tileEntity.isMossy());

            if (tileEntity.getPlayerProfile() != null) {
                nbt.setTag("Owner", NBTUtil.writeGameProfile(new NBTTagCompound(), tileEntity.getPlayerProfile()));
            }

            itemStack.setTagCompound(nbt);
        }

        return itemStack;
    }

    private ItemStack getBlockItemStackWithoutInfo(World world, BlockPos pos) {
        ItemStack itemStack = new ItemStack(Item.getItemFromBlock(this), 1);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileEntityMemorial) {
            TileEntityMemorial tileEntity = (TileEntityMemorial) te;

            if (tileEntity != null) {
                itemStack.setItemDamage(tileEntity.getGraveTypeNum());
                NBTTagCompound nbt = new NBTTagCompound();
                nbt.setBoolean("Mossy", tileEntity.isMossy());
                if (tileEntity.getPlayerProfile() != null) {
                    nbt.setTag("Owner", NBTUtil.writeGameProfile(new NBTTagCompound(), tileEntity.getPlayerProfile()));
                }

                itemStack.setTagCompound(nbt);
            }
        } else {
            GSLogger.logError("Can't create memorial item stack - wrong tileentity!");
        }

        return itemStack;
    }

    @Override
    public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, @Nullable ItemStack stack) {
    }

    public void dropCreeperMemorial(World world, BlockPos pos) {
        ItemStack itemStack = new ItemStack(this, 1, MemorialGenerationHelper.getMemorialTypeByBiomes(world, pos, MemorialGenerationHelper.GENERATED_CREEPER_STATUES_MEMORIALS_TYPES, null, true).ordinal());
        GraveInventory.dropItem(itemStack, world, pos);
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        ItemStack itemStack = new ItemStack(Item.getItemFromBlock(this), 1);
        TileEntityMemorial tileEntity = (TileEntityMemorial) world.getTileEntity(pos);

        if (tileEntity != null) {
            if (itemStack != null) {
                itemStack.setItemDamage(tileEntity.getGraveTypeNum());
                NBTTagCompound nbt = new NBTTagCompound();
                nbt.setBoolean("Mossy", tileEntity.isMossy());
                if (tileEntity.getPlayerProfile() != null) {
                    nbt.setTag("Owner", NBTUtil.writeGameProfile(new NBTTagCompound(), tileEntity.getPlayerProfile()));
                }

                itemStack.setTagCompound(nbt);
            }
        }
        return itemStack;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y) {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return (state.getValue(FACING)).getIndex();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{FACING});
    }
}
