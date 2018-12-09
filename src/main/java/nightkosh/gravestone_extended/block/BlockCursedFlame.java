package nightkosh.gravestone_extended.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.core.GSTabs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.helper.GameRuleHelper;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockCursedFlame extends BlockFire {

    public BlockCursedFlame() {
        super();
        this.setUnlocalizedName("cursed_flame");
        this.setCreativeTab(GSTabs.otherItemsTab);
        this.setRegistryName(ModInfo.ID, "cursed_flame");
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
        entity.setFire(8);//TODO !!!!!!!!!!!!!!!!!!!
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        if (GameRuleHelper.checkFireTick(world)) {
            if (world.isAreaLoaded(pos, 2)) { // Forge: prevent loading unloaded chunks when spreading fire
                Block block = world.getBlockState(pos.down()).getBlock();
                boolean flag = block.isFireSource(world, pos.down(), EnumFacing.UP);

                int i = state.getValue(AGE);

                if (!flag && world.isRaining() && this.canDie(world, pos) && rand.nextFloat() < 0.2F + i * 0.03F) {
                } else {
                    if (i < 15) {
                        state = state.withProperty(AGE, i + rand.nextInt(3) / 2);
                        world.setBlockState(pos, state, 4);
                    }

                    world.scheduleUpdate(pos, this, this.tickRate(world) + rand.nextInt(10));

                    if (!flag) {
                        if (!this.canNeighborCatchFire(world, pos)) {
                            return;
                        }

                        if (!this.canCatchFire(world, pos.down(), EnumFacing.UP) && i == 15 && rand.nextInt(4) == 0) {
                            return;
                        }
                    }

                    boolean flag1 = world.isBlockinHighHumidity(pos);
                    int j = 0;

                    if (flag1) {
                        j = -50;
                    }

                    this.tryCatchFire(world, pos.east(), 300 + j, rand, i, EnumFacing.WEST);
                    this.tryCatchFire(world, pos.west(), 300 + j, rand, i, EnumFacing.EAST);
                    this.tryCatchFire(world, pos.down(), 250 + j, rand, i, EnumFacing.UP);
                    this.tryCatchFire(world, pos.up(), 250 + j, rand, i, EnumFacing.DOWN);
                    this.tryCatchFire(world, pos.north(), 300 + j, rand, i, EnumFacing.SOUTH);
                    this.tryCatchFire(world, pos.south(), 300 + j, rand, i, EnumFacing.NORTH);

                    for (int k = -1; k <= 1; ++k) {
                        for (int l = -1; l <= 1; ++l) {
                            for (int i1 = -1; i1 <= 4; ++i1) {
                                if (k != 0 || i1 != 0 || l != 0) {
                                    int j1 = 100;

                                    if (i1 > 1) {
                                        j1 += (i1 - 1) * 100;
                                    }

                                    BlockPos blockpos = pos.add(k, i1, l);
                                    int k1 = this.getNeighborEncouragement(world, blockpos);

                                    if (k1 > 0) {
                                        int l1 = (k1 + 40 + world.getDifficulty().getDifficultyId() * 7) / (i + 30);

                                        if (flag1) {
                                            l1 /= 2;
                                        }

                                        if (l1 > 0 && rand.nextInt(j1) <= l1 && (!world.isRaining() || !this.canDie(world, blockpos))) {
                                            int i2 = i + rand.nextInt(5) / 4;

                                            if (i2 > 15) {
                                                i2 = 15;
                                            }

                                            world.setBlockState(blockpos, state.withProperty(AGE, i2), 3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    protected boolean canDie(World world, BlockPos pos) {
        return false;
    }

    protected void tryCatchFire(World world, BlockPos pos, int chance, Random random, int age, EnumFacing face) {
        int i = world.getBlockState(pos).getBlock().getFlammability(world, pos, face);

        if (random.nextInt(chance) < i) {
            IBlockState iblockstate = world.getBlockState(pos);

            if (random.nextInt(age + 10) < 5 && !world.isRainingAt(pos)) {
                int j = age + random.nextInt(5) / 4;

                if (j > 15) {
                    j = 15;
                }

                world.setBlockState(pos, this.getDefaultState().withProperty(AGE, j), 3);
            } else {
                world.setBlockToAir(pos);
            }

            if (iblockstate.getBlock() == Blocks.TNT) {
                Blocks.TNT.onBlockDestroyedByPlayer(world, pos, iblockstate.withProperty(BlockTNT.EXPLODE, true));
            }
        }
    }
}
