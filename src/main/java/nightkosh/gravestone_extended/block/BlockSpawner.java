package nightkosh.gravestone_extended.block;

import net.minecraft.block.BlockMobSpawner;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone_extended.block.enums.EnumSpawner;
import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.core.GSParticles;
import nightkosh.gravestone_extended.core.GSTabs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.tileentity.TileEntitySpawner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockSpawner extends BlockMobSpawner {

    public static final PropertyEnum VARIANT = PropertyEnum.create("variant", EnumSpawner.class);

    public static final List<EnumSpawner> MOB_SPAWNERS = new ArrayList<>(Arrays.asList(
            EnumSpawner.SKELETON_SPAWNER,
            EnumSpawner.ZOMBIE_SPAWNER,
            EnumSpawner.SPIDER_SPAWNER));
    public static final List<EnumSpawner> CATACOMBS_CROSSING_SPAWNERS = new ArrayList<>(Arrays.asList(
            EnumSpawner.SKELETON_SPAWNER,
            EnumSpawner.ZOMBIE_SPAWNER));
    public static final List<EnumSpawner> BOSS_SPAWNERS = new ArrayList<>(Arrays.asList(
            EnumSpawner.WITHER_SPAWNER));

    public BlockSpawner() {
        super();
        this.setHardness(4);
        this.setLightLevel(0.45F);
        this.setSoundType(SoundType.METAL);
        this.disableStats();
        this.setCreativeTab(GSTabs.otherItemsTab);
        this.setHarvestLevel("pickaxe", 1);
        this.setRegistryName(ModInfo.ID, "gsspawner");
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing
     * the block.
     */
    @Override
    public TileEntity createNewTileEntity(World world, int var2) {
        return new TileEntitySpawner();
    }

    /**
     * The type of render function that is called for this block
     */
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
//        return EnumBlockRenderType.MODEL;
        return EnumBlockRenderType.INVISIBLE;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube? This determines whether
     * or not to render the shared face of two adjacent blocks and also whether
     * the player can attach torches, redstone wire, etc to this block.
     */
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

    private static final AxisAlignedBB BB = new AxisAlignedBB(-0.5F, 0, -0.5F, 1.5F, 0.05F, 1.5F);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess access, BlockPos pos) {
        return BB;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
        return null;
    }

    /**
     * A randomly called display update to be able to add particles or other
     * items for display
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random) {
        if (EnumSpawner.SPIDER_SPAWNER.ordinal() != getMetaFromState(state)) {
            double xPos = pos.getX() + 0.5F;
            double yPos = pos.getY() + 0.85;
            double zPos = pos.getZ() + 0.5F;
            double dRotation = Math.toRadians(72);
            double rotation = Math.toRadians(-36);
            double d = 1.07;
            double dx;
            double dz;

            for (int i = 0; i < 5; i++) {
                dx = -Math.sin(rotation) * d;
                dz = Math.cos(rotation) * d;
                world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, xPos + dx, yPos, zPos + dz, 0, 0, 0);
                world.spawnParticle(GSParticles.GREEN_FLAME, xPos + dx, yPos, zPos + dz, 0, 0, 0);
                rotation += dRotation;
            }
        }
    }

    @Override
    public List<ItemStack> getDrops(IBlockAccess access, BlockPos pos, IBlockState state, int fortune) {
        List<ItemStack> ret = new ArrayList<>();
        if (EnumSpawner.SPIDER_SPAWNER.ordinal() == getMetaFromState(state)) {
            Random random = new Random();
            ret.add(new ItemStack(Blocks.WEB, 1 + random.nextInt(5)));
            ret.add(new ItemStack(Items.STRING, 3 + random.nextInt(5)));
        } else {
            Random random = new Random();
            int metadata = ((Enum) state.getValue(VARIANT)).ordinal();
            ret.add(new ItemStack(getItemDropped(access.getBlockState(pos), random, fortune), quantityDropped(random), getItemMeta(metadata)));

            for (int i = 0; i < 5; i++) {
                if ((fortune > 0 && random.nextInt(100) < 5 * fortune) ||
                        random.nextInt(100) < 5 * fortune) {
                    ret.add(getCustomItemsDropped(metadata));
                }
            }
        }
        return ret;
    }

    public ItemStack getCustomItemsDropped(int meta) {
        switch (EnumSpawner.getById((byte) meta)) {
            case SKELETON_SPAWNER:
                return new ItemStack(GSBlock.SKULL_CANDLE_SKELETON);
            case ZOMBIE_SPAWNER:
                return new ItemStack(GSBlock.SKULL_CANDLE_ZOMBIE);
            case SPIDER_SPAWNER:
                return new ItemStack(Blocks.WEB);
            case WITHER_SPAWNER:
                return new ItemStack(GSBlock.SKULL_CANDLE_WITHER);
            default:
                return ItemStack.EMPTY;
        }
    }


    public int getItemMeta(int metadata) {
        return 15;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random random, int fortune) {
        return Items.DYE;
    }

    @Override
    public int quantityDropped(Random random) {
        return 3;
    }

    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        if (EnumSpawner.SPIDER_SPAWNER.ordinal() == getMetaFromState(state)) {
            entityIn.setInWeb();
        }
    }

    /**
     * Returns a list of blocks with the same ID, but different meta (eg: wood
     * returns 4 blocks)
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
        Item item = Item.getItemFromBlock(this);
        for (EnumSpawner meta : MOB_SPAWNERS) {
            list.add(new ItemStack(item, 1, meta.ordinal()));
        }
        for (EnumSpawner meta : BOSS_SPAWNERS) {
            list.add(new ItemStack(item, 1, meta.ordinal()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(VARIANT, EnumSpawner.getById((byte) meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((EnumSpawner) state.getValue(VARIANT)).ordinal();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{VARIANT});
    }
}
