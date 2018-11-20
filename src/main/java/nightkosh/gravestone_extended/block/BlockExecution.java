package nightkosh.gravestone_extended.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone.inventory.GraveInventory;
import nightkosh.gravestone_extended.ModGravestoneExtended;
import nightkosh.gravestone_extended.block.enums.EnumExecution;
import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.core.GSTabs;
import nightkosh.gravestone_extended.core.GuiHandler;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.particle.ParticleBigFlameFX;
import nightkosh.gravestone_extended.tileentity.TileEntityExecution;

import javax.annotation.Nullable;
import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockExecution extends BlockContainer {

    public static final PropertyEnum VARIANT = PropertyEnum.create("variant", EnumExecution.class);

    public BlockExecution() {
        super(Material.ROCK);
        this.setSoundType(SoundType.WOOD);
        this.setHardness(1);
        this.setResistance(5);
        this.setCreativeTab(GSTabs.otherItemsTab);
        this.setRegistryName(ModInfo.ID, "gsexecution");
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityExecution();
    }

    private static final AxisAlignedBB GALLOWS_BB = new AxisAlignedBB(0, 0, 0, 1, 3, 1);
    private static final AxisAlignedBB STOCKS_SOUTH_NORTH_BB = new AxisAlignedBB(-0.5F, 0, 0, 1.5F, 2, 1);
    private static final AxisAlignedBB STOCKS_EAST_WEST_BB = new AxisAlignedBB(0, 0, -0.5F, 1, 2, 1.5F);
    private static final AxisAlignedBB ITEM_BB = new AxisAlignedBB(0, 0, 0, 1, 1, 1);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess access, BlockPos pos) {
        TileEntityExecution tileEntity = (TileEntityExecution) access.getTileEntity(pos);

        EnumFacing facing;
        EnumExecution executionBlockType;
        if (tileEntity != null) {
            facing = EnumFacing.values()[tileEntity.getDirection()];
            executionBlockType = (EnumExecution) access.getBlockState(pos).getValue(VARIANT);
        } else {
            facing = EnumFacing.NORTH;
            executionBlockType = EnumExecution.GALLOWS;
        }

        switch (executionBlockType) {
            case GALLOWS:
            case GIBBET:
            case BURNING_STAKE:
            default:
                return GALLOWS_BB;
            case STOCKS:
                switch (facing) {
                    case SOUTH:
                    case NORTH:
                    default:
                        return STOCKS_SOUTH_NORTH_BB;
                    case EAST:
                    case WEST:
                        return STOCKS_EAST_WEST_BB;
                }
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
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        TileEntityExecution te = (TileEntityExecution) world.getTileEntity(pos);

        if (te != null && !player.isSneaking()) {
            player.openGui(ModGravestoneExtended.instance, GuiHandler.EXECUTION_GUI_ID, world, pos.getX(), pos.getY(), pos.getZ());
            return true;
        }

        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
        Item item = Item.getItemFromBlock(this);
        for (EnumExecution executionBlock : EnumExecution.values()) {
            list.add(new ItemStack(item, 1, executionBlock.ordinal()));
        }
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        player.addExhaustion(0.025F);

        if (!world.isRemote && !world.restoringBlockSnapshots) {
            GraveInventory.dropItem(getBlockItemStackWithoutInfo(world, pos), world, pos);

            TileEntityExecution tileEntity = (TileEntityExecution) world.getTileEntity(pos);
            if (tileEntity != null) {
                ItemStack corpse = tileEntity.getCorpse();
                if (corpse != null) {
                    GraveInventory.dropItem(corpse, world, pos);
                }
            }
        }
    }

    private ItemStack getBlockItemStackWithoutInfo(World world, BlockPos pos) {
        return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
    }

    @Override
    public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, @Nullable ItemStack stack) {
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        ItemStack itemStack = new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
        TileEntityExecution tileEntity = (TileEntityExecution) world.getTileEntity(pos);

        if (tileEntity != null && !itemStack.isEmpty()) {
            NBTTagCompound nbt = new NBTTagCompound();

            if (tileEntity.getCorpse() != null) {
                NBTTagCompound corpseNBT = new NBTTagCompound();
                tileEntity.getCorpse().writeToNBT(corpseNBT);
                nbt.setTag("Corpse", corpseNBT);
            }

            itemStack.setTagCompound(nbt);
        }
        return itemStack;
    }

    @Override
    public int getLightValue(IBlockState state, IBlockAccess access, BlockPos pos) {
        TileEntityExecution tileEntity = (TileEntityExecution) access.getTileEntity(pos);

        if (tileEntity != null && access.getBlockState(pos).getValue(VARIANT) == EnumExecution.BURNING_STAKE &&
                tileEntity.getCorpseType() != null && tileEntity.getCorpseType().canBeHanged()) {
            return 15;
        } else {
            return super.getLightValue(state, access, pos);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random) {
        TileEntityExecution tileEntity = (TileEntityExecution) world.getTileEntity(pos);
        if (tileEntity != null && state.getValue(VARIANT) == EnumExecution.BURNING_STAKE &&
                tileEntity.getCorpseType() != null && tileEntity.getCorpseType().canBeHanged()) {
            double xPos, zPos, yPos;

            yPos = pos.getY() + 0.25;
            for (int angle = 0; angle < 20; angle++) {
                xPos = pos.getX() + 0.5 + Math.sin(angle * 0.2792) * 0.75;
                zPos = pos.getZ() + 0.5 + Math.cos(angle * 0.2792) * 0.75;

                Particle entityfx = new ParticleBigFlameFX(world, xPos, yPos, zPos);
                Minecraft.getMinecraft().effectRenderer.addEffect(entityfx);
            }

            yPos += 0.25;
            for (int angle = 0; angle < 11; angle++) {
                xPos = pos.getX() + 0.5 + Math.sin(angle * 0.5584) * 0.5;
                zPos = pos.getZ() + 0.5 + Math.cos(angle * 0.5584) * 0.5;

                Particle entityfx = new ParticleBigFlameFX(world, xPos, yPos, zPos);
                Minecraft.getMinecraft().effectRenderer.addEffect(entityfx);
            }

            yPos += 0.35;
            for (int angle = 0; angle < 5; angle++) {
                xPos = pos.getX() + 0.5 + Math.sin(angle * 1.1168) * 0.2;
                zPos = pos.getZ() + 0.5 + Math.cos(angle * 1.1168) * 0.2;

                Particle entityfx = new ParticleBigFlameFX(world, xPos, yPos, zPos);
                Minecraft.getMinecraft().effectRenderer.addEffect(entityfx);
                world.spawnParticle(EnumParticleTypes.LAVA, xPos, yPos, zPos, 0, 0, 0);
                world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, xPos, yPos, zPos, 0, 0, 0);
            }
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(VARIANT, EnumExecution.getById((byte) meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((EnumExecution) state.getValue(VARIANT)).ordinal();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{VARIANT});
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack itemStack) {
        world.setBlockState(pos, getStateFromMeta(itemStack.getItemDamage()), 2);

        TileEntityExecution tileEntity = (TileEntityExecution) world.getTileEntity(pos);

        if (tileEntity != null) {
            tileEntity.setDirection((byte) EnumFacing.getHorizontal(MathHelper.floor((double) (player.rotationYaw * 4 / 360F) + 0.5D) & 3).getOpposite().ordinal());

            if (itemStack.hasTagCompound()) {
                NBTTagCompound nbt = itemStack.getTagCompound();

                if (nbt.hasKey("Corpse")) {
                    tileEntity.setCorpse(new ItemStack(nbt.getCompoundTag("Corpse")));
                }

                placeWalls(world, pos);
            }
        }
    }

    public static void placeWalls(World world, BlockPos pos) {
        placeAdditionalBlock(world, pos, GSBlock.INVISIBLE_WALL.getDefaultState(), Blocks.AIR);
    }

    private static void dropCorpse(World world, BlockPos pos) {
        if (!world.isRemote) {
            TileEntityExecution tileEntity = (TileEntityExecution) world.getTileEntity(pos);

            if (tileEntity != null) {
                ItemStack corpse = tileEntity.getCorpse();
                if (corpse != null) {
                    GraveInventory.dropItem(corpse, world, pos);
                    tileEntity.setCorpse(null);
                }
            }
        }
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess access, IBlockState state, BlockPos pos, EnumFacing facing) {
        return BlockFaceShape.UNDEFINED;
    }

    @Override
    public void onBlockDestroyedByExplosion(World world, BlockPos pos, Explosion explosionIn) {
        removeWalls(world, pos);
        dropCorpse(world, pos);
        super.onBlockDestroyedByExplosion(world, pos, explosionIn);
    }

    @Override
    public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest) {
        removeWalls(world, pos);
        dropCorpse(world, pos);
        return super.removedByPlayer(state, world, pos, player, willHarvest);
    }


    private static void removeWalls(World world, BlockPos pos) {
        placeAdditionalBlock(world, pos, Blocks.AIR.getDefaultState(), GSBlock.INVISIBLE_WALL);
    }

    public static void placeAdditionalBlock(World world, BlockPos pos, IBlockState blockState, Block replaceableBlock) {
        TileEntityExecution tileEntity = (TileEntityExecution) world.getTileEntity(pos);

        if (tileEntity != null) {
            byte maxY = 0;
            byte maxX = 1;
            byte maxZ = 1;
            byte startY = 0;
            byte startX = 0;
            byte startZ = 0;

            EnumFacing facing = EnumFacing.values()[tileEntity.getDirection()];
            switch ((EnumExecution) world.getBlockState(pos).getValue(VARIANT)) {
                case GALLOWS:
                case GIBBET:
                    maxY = 3;
                    switch (facing) {
                        case NORTH:
                            startZ = -1;
                            break;
                        case EAST:
                            maxX = 2;
                            break;
                        case SOUTH:
                            maxZ = 2;
                            break;
                        case WEST:
                            startX = -1;
                            break;
                    }
                    break;
                case STOCKS:
                    maxY = 2;
                    if (facing == EnumFacing.NORTH || facing == EnumFacing.SOUTH) {
                        startX = -1;
                        maxX = 2;
                    } else {
                        startZ = -1;
                        maxZ = 2;
                    }
                    break;
                case BURNING_STAKE:
                    startY = 2;
                    maxY = 3;
                    break;
            }
            for (byte shiftY = startY; shiftY < maxY; shiftY++) {
                for (byte shiftZ = startZ; shiftZ < maxZ; shiftZ++) {
                    for (byte shiftX = startX; shiftX < maxX; shiftX++) {
                        BlockPos newPos = new BlockPos(pos.getX() + shiftX, pos.getY() + shiftY, pos.getZ() + shiftZ);
                        if (world.getBlockState(newPos).getBlock() == replaceableBlock) {
                            world.setBlockState(new BlockPos(pos.getX() + shiftX, pos.getY() + shiftY, pos.getZ() + shiftZ), blockState);
                        }
                    }
                }
            }
        }
    }
}
