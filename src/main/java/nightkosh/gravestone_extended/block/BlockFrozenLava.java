package nightkosh.gravestone_extended.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.core.GSTabs;
import nightkosh.gravestone_extended.core.ModInfo;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockFrozenLava extends Block {

    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 3);

    public BlockFrozenLava() {
        super(Material.ROCK);
        this.setCreativeTab(GSTabs.otherItemsTab);
        this.setLightLevel(0.2F);
        this.setTickRandomly(true);
        this.setUnlocalizedName("frozen_lava");
        this.setRegistryName(ModInfo.ID, "frozen_lava");
        this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, 0));
    }

    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess world, BlockPos pos) {
        return MapColor.NETHERRACK;
    }

    @Override
    public void onEntityWalk(World world, BlockPos pos, Entity entity) {
        //TODO
        if (!entity.isImmuneToFire() && entity instanceof EntityLivingBase && !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase) entity)) {
            entity.attackEntityFrom(DamageSource.HOT_FLOOR, 1);
        }

        super.onEntityWalk(world, pos, entity);
    }

    @Override
    public boolean canEntitySpawn(IBlockState state, Entity entity) {
        return entity.isImmuneToFire();
    }


    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(AGE);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(AGE, MathHelper.clamp(meta, 0, 3));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{AGE});
    }

    @Override
    public ItemStack getItem(World world, BlockPos pos, IBlockState state) {
        return ItemStack.EMPTY;
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        if ((rand.nextInt(3) == 0 || this.countNeighbors(world, pos) < 4) && world.getLightFromNeighbors(pos) > 11 - state.getValue(AGE) - state.getLightOpacity()) {
            this.slightlyMelt(world, pos, state, rand, true);
        } else {
            world.scheduleUpdate(pos, this, MathHelper.getInt(rand, 20, 40));
        }
    }

    @Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
        if (block == this) {
            int i = this.countNeighbors(world, pos);

            if (i < 2) {
                this.turnIntoLava(world, pos);
            }
        }
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    private int countNeighbors(World worldIn, BlockPos pos) {
        int i = 0;

        for (EnumFacing enumfacing : EnumFacing.values()) {
            if (worldIn.getBlockState(pos.offset(enumfacing)).getBlock() == this) {
                ++i;

                if (i >= 4) {
                    return i;
                }
            }
        }

        return i;
    }

    protected void slightlyMelt(World worldIn, BlockPos pos, IBlockState state, Random rand, boolean meltNeighbors) {
        int i = state.getValue(AGE);

        if (i < 3) {
            worldIn.setBlockState(pos, state.withProperty(AGE, i + 1), 2);
            worldIn.scheduleUpdate(pos, this, MathHelper.getInt(rand, 20, 40));
        } else {
            this.turnIntoLava(worldIn, pos);

            if (meltNeighbors) {
                for (EnumFacing enumfacing : EnumFacing.values()) {
                    BlockPos blockpos = pos.offset(enumfacing);
                    IBlockState iblockstate = worldIn.getBlockState(blockpos);

                    if (iblockstate.getBlock() == this) {
                        this.slightlyMelt(worldIn, blockpos, iblockstate, rand, false);
                    }
                }
            }
        }
    }

    protected void turnIntoLava(World worldIn, BlockPos pos) {
        this.dropBlockAsItem(worldIn, pos, worldIn.getBlockState(pos), 0);
        worldIn.setBlockState(pos, Blocks.LAVA.getDefaultState());
        worldIn.neighborChanged(pos, Blocks.LAVA, pos);
    }
}
