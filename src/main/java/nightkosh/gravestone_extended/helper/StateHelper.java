package nightkosh.gravestone_extended.helper;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nightkosh.gravestone.block.BlockGraveStone;
import nightkosh.gravestone_extended.block.*;
import nightkosh.gravestone_extended.block.enums.EnumBoneBlock;
import nightkosh.gravestone_extended.block.enums.EnumPileOfBones;
import nightkosh.gravestone_extended.block.enums.EnumSpawner;
import nightkosh.gravestone_extended.core.GSBlock;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class StateHelper {
    public static final IBlockState AIR = Blocks.AIR.getDefaultState();
    public static final IBlockState DEADBUSH = Blocks.DEADBUSH.getDefaultState();
    public static final IBlockState NETHERRACK = Blocks.NETHERRACK.getDefaultState();
    public static final IBlockState FIRE = Blocks.FIRE.getDefaultState();
    public static final IBlockState LAVA = Blocks.LAVA.getDefaultState();
    public static final IBlockState FLOWING_LAVA = Blocks.FLOWING_LAVA.getDefaultState();
    public static final IBlockState FLOWING_WATER = Blocks.FLOWING_WATER.getDefaultState();
    public static final IBlockState OBSIDIAN = Blocks.OBSIDIAN.getDefaultState();
    public static final IBlockState PORTAL = Blocks.PORTAL.getDefaultState();
    public static final IBlockState DIAMOND = Blocks.DIAMOND_BLOCK.getDefaultState();
    public static final IBlockState EMERALD = Blocks.EMERALD_BLOCK.getDefaultState();
    public static final IBlockState GLOWSTONE = Blocks.GLOWSTONE.getDefaultState();
    public static final IBlockState WEB = Blocks.WEB.getDefaultState();
    public static final IBlockState TNT = Blocks.TNT.getDefaultState();
    public static final IBlockState IRON_BARS = Blocks.IRON_BARS.getDefaultState();
    public static final IBlockState SAND = Blocks.SAND.getDefaultState();
    public static final IBlockState GRASS = Blocks.GRASS.getDefaultState();
    public static final IBlockState DIRT = Blocks.DIRT.getDefaultState();
    public static final IBlockState PODZOL = Blocks.DIRT.getStateFromMeta(BlockDirt.DirtType.PODZOL.getMetadata());
    public static final IBlockState BOOKSHELF = Blocks.BOOKSHELF.getDefaultState();
    public static final IBlockState DISPENSER = Blocks.DISPENSER.getDefaultState();
    public static final IBlockState DISPENSER_TRIGGERED = DISPENSER.withProperty(BlockDispenser.TRIGGERED, Boolean.valueOf(false));
    public static final IBlockState MOB_SPAWNER = Blocks.MOB_SPAWNER.getDefaultState();
    public static final IBlockState TRIPWIRE = Blocks.TRIPWIRE.getDefaultState();
    public static final IBlockState TRIPWIRE_HOOK = Blocks.TRIPWIRE_HOOK.getDefaultState();
    public static final IBlockState PLANKS = Blocks.PLANKS.getDefaultState();
    public static final IBlockState PLANKS_DARK_OAK = PLANKS.withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.DARK_OAK);
    public static final IBlockState STONE = Blocks.STONE.getDefaultState();
    public static final IBlockState COBBLESTONE = Blocks.COBBLESTONE.getDefaultState();
    public static final IBlockState STONEBRICK = Blocks.STONEBRICK.getDefaultState();
    public static final IBlockState STONEBRICK_CRACKED = Blocks.STONEBRICK.getStateFromMeta(BlockStoneBrick.CRACKED_META);
    public static final IBlockState STONEBRICK_MOSSY = Blocks.STONEBRICK.getStateFromMeta(BlockStoneBrick.MOSSY_META);
    public static final IBlockState STONEBRICK_MONSTER = Blocks.MONSTER_EGG.getStateFromMeta(BlockSilverfish.EnumType.STONEBRICK.getMetadata());
    public static final IBlockState STONEBRICK_CHISELED = STONEBRICK.withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.CHISELED);
    public static final IBlockState STONE_SLAB = Blocks.STONE_SLAB.getDefaultState();
    public static final IBlockState SMOOTHBRICK_SLAB = STONE_SLAB.withProperty(BlockStoneSlab.VARIANT, BlockStoneSlab.EnumType.SMOOTHBRICK);
    public static final IBlockState SMOOTHBRICK_SLAB_BOTTOM = SMOOTHBRICK_SLAB.withProperty(BlockSlab.HALF, BlockSlab.EnumBlockHalf.BOTTOM);
    public static final IBlockState NETHERBRICK_SLAB = STONE_SLAB.withProperty(BlockStoneSlab.VARIANT, BlockStoneSlab.EnumType.NETHERBRICK);
    public static final IBlockState NETHERBRICK_SLAB_BOTTOM = NETHERBRICK_SLAB.withProperty(BlockSlab.HALF, BlockSlab.EnumBlockHalf.BOTTOM);
    public static final IBlockState NETHERBRICK_SLAB_TOP = NETHERBRICK_SLAB.withProperty(BlockSlab.HALF, BlockSlab.EnumBlockHalf.TOP);
    public static final IBlockState NETHER_BRICK = Blocks.NETHER_BRICK.getDefaultState();
    public static final IBlockState NETHER_BRICK_STAIRS = Blocks.NETHER_BRICK_STAIRS.getDefaultState();
    public static final IBlockState NETHER_BRICK_STAIRS_NORTH = NETHER_BRICK_STAIRS.withProperty(BlockStairs.FACING, EnumFacing.NORTH);
    public static final IBlockState NETHER_BRICK_STAIRS_EAST = NETHER_BRICK_STAIRS.withProperty(BlockStairs.FACING, EnumFacing.EAST);
    public static final IBlockState NETHER_BRICK_STAIRS_SOUTH = NETHER_BRICK_STAIRS.withProperty(BlockStairs.FACING, EnumFacing.SOUTH);
    public static final IBlockState NETHER_BRICK_STAIRS_WEST = NETHER_BRICK_STAIRS.withProperty(BlockStairs.FACING, EnumFacing.WEST);
    public static final IBlockState BED = Blocks.BED.getDefaultState();
    public static final IBlockState BED_FOOT = BED.withProperty(BlockBed.PART, BlockBed.EnumPartType.FOOT);
    public static final IBlockState BED_HEAD = BED.withProperty(BlockBed.PART, BlockBed.EnumPartType.HEAD);
    public static final IBlockState STAINED_GLASS_PANE = Blocks.STAINED_GLASS_PANE.getDefaultState();
    public static final IBlockState STAINED_GLASS_PANE_GRAY = STAINED_GLASS_PANE.withProperty(BlockStainedGlassPane.COLOR, EnumDyeColor.GRAY);
    public static final IBlockState STAINED_HARDENED_CLAY = Blocks.STAINED_HARDENED_CLAY.getDefaultState();
    public static final IBlockState STAINED_HARDENED_CLAY_BLACK = STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.BLACK);
    public static final IBlockState STAINED_HARDENED_CLAY_BROWN = STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.BROWN);
    public static final IBlockState COBBLESTONE_WALL = Blocks.COBBLESTONE_WALL.getStateFromMeta(BlockWall.EnumType.NORMAL.getMetadata());
    public static final IBlockState COBBLESTONE_WALL_MOSSY = Blocks.COBBLESTONE_WALL.getStateFromMeta(BlockWall.EnumType.MOSSY.getMetadata());
    public static final IBlockState DARK_OAK_FENCE = Blocks.DARK_OAK_FENCE.getDefaultState();
    public static final IBlockState DARK_OAK_FENCE_GATE = Blocks.DARK_OAK_FENCE_GATE.getDefaultState();
    public static final IBlockState STONE_BRICK_STAIRS = Blocks.STONE_BRICK_STAIRS.getDefaultState();
    public static final IBlockState STONE_BRICK_STAIRS_TOP = STONE_BRICK_STAIRS.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.TOP);
    public static final IBlockState CHEST = Blocks.CHEST.getDefaultState();
    public static final IBlockState TRAPPED_CHEST = Blocks.TRAPPED_CHEST.getDefaultState();
    public static final IBlockState DARK_OAK_STAIRS = Blocks.DARK_OAK_STAIRS.getDefaultState();
    public static final IBlockState WOODEN_SLAB = Blocks.WOODEN_SLAB.getDefaultState();
    public static final IBlockState WOODEN_SLAB_DARK_OAK = WOODEN_SLAB.withProperty(BlockWoodSlab.VARIANT, BlockPlanks.EnumType.DARK_OAK);
    public static final IBlockState SEA_LANTERN = Blocks.SEA_LANTERN.getDefaultState();
    public static final IBlockState STAINED_GLASS = Blocks.STAINED_GLASS.getDefaultState();
    public static final IBlockState STAINED_GLASS_LIME = STAINED_GLASS.withProperty(BlockStainedGlass.COLOR, EnumDyeColor.LIME);


    public static final IBlockState NIGHTSTONE = GSBlock.TRAP.getDefaultState();
    public static final IBlockState CANDLE = GSBlock.CANDLE.getDefaultState();
    public static final IBlockState SKELETON_SKULL_CANDLE = GSBlock.SKULL_CANDLE_SKELETON.getDefaultState();
    public static final IBlockState BONE_BLOCK = GSBlock.BONE_BLOCK.getDefaultState();
    public static final IBlockState BONE_BLOCK_SKULL = BONE_BLOCK.withProperty(BlockBoneBlock.VARIANT, EnumBoneBlock.SKULL_BONE_BLOCK);
    public static final IBlockState BONE_BLOCK_CRAWLER = BONE_BLOCK.withProperty(BlockBoneBlock.VARIANT, EnumBoneBlock.CRAWLER_BONE_BLOCK);
    public static final IBlockState BONE_BLOCK_SKULL_CRAWLER = BONE_BLOCK.withProperty(BlockBoneBlock.VARIANT, EnumBoneBlock.CRAWLER_SKULL_BONE_BLOCK);
    public static final IBlockState PILE_OF_BONES = GSBlock.PILE_OF_BONES.getDefaultState();
    public static final IBlockState PILE_OF_BONES_WITH_SKULL = PILE_OF_BONES.withProperty(BlockPileOfBones.VARIANT, EnumPileOfBones.PILE_OF_BONES_WITH_SKULL);
    public static final IBlockState PILE_OF_BONES_WITH_SKULL_CRAWLER = PILE_OF_BONES.withProperty(BlockPileOfBones.VARIANT, EnumPileOfBones.PILE_OF_BONES_WITH_SKULL_CRAWLER);
    public static final IBlockState GRAVESTONE = GSBlock.GRAVE_STONE.getDefaultState();
    public static final IBlockState GRAVESTONE_NORTH = GRAVESTONE.withProperty(BlockGraveStone.FACING, EnumFacing.NORTH);
    public static final IBlockState GRAVESTONE_EAST = GRAVESTONE.withProperty(BlockGraveStone.FACING, EnumFacing.EAST);
    public static final IBlockState GRAVESTONE_SOUTH = GRAVESTONE.withProperty(BlockGraveStone.FACING, EnumFacing.SOUTH);
    public static final IBlockState GRAVESTONE_WEST = GRAVESTONE.withProperty(BlockGraveStone.FACING, EnumFacing.WEST);
    public static final IBlockState MEMORIAL = GSBlock.MEMORIAL.getDefaultState();
    public static final IBlockState MEMORIAL_NORTH = MEMORIAL.withProperty(BlockMemorial.FACING, EnumFacing.NORTH);
    public static final IBlockState MEMORIAL_EAST = MEMORIAL.withProperty(BlockMemorial.FACING, EnumFacing.EAST);
    public static final IBlockState MEMORIAL_SOUTH = MEMORIAL.withProperty(BlockMemorial.FACING, EnumFacing.SOUTH);
    public static final IBlockState MEMORIAL_WEST = MEMORIAL.withProperty(BlockMemorial.FACING, EnumFacing.WEST);
    public static final IBlockState SPAWNER = GSBlock.SPAWNER.getDefaultState();
    public static final IBlockState SPAWNER_SKELETON = SPAWNER.withProperty(BlockSpawner.VARIANT, EnumSpawner.SKELETON_SPAWNER);
    public static final IBlockState SPAWNER_ZOMBIE = SPAWNER.withProperty(BlockSpawner.VARIANT, EnumSpawner.ZOMBIE_SPAWNER);
    public static final IBlockState SPAWNER_SPIDER = SPAWNER.withProperty(BlockSpawner.VARIANT, EnumSpawner.SPIDER_SPAWNER);
    public static final IBlockState HAUNTED_CHEST = GSBlock.HAUNTED_CHEST.getDefaultState();
    public static final IBlockState BONE_STAIRS = GSBlock.BONE_STAIRS.getDefaultState();
    public static final IBlockState BONE_STAIRS_TOP = BONE_STAIRS.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.TOP);
    public static final IBlockState TOXIC_WATER = GSBlock.TOXIC_WATER.getDefaultState();
    public static final IBlockState CATACOMBS_PORTAL = GSBlock.CATACOMBS_PORTAL.getDefaultState();

    public static IBlockState getCatacombsPortal(EnumFacing facing) {
        return CATACOMBS_PORTAL.withProperty(BlockPortal.AXIS, facing.getAxis());
    }

    public static IBlockState getNetherBrickStairs(EnumFacing direction) {
        switch (direction) {
            case NORTH:
            default:
                return NETHER_BRICK_STAIRS_NORTH;
            case EAST:
                return NETHER_BRICK_STAIRS_EAST;
            case SOUTH:
                return NETHER_BRICK_STAIRS_SOUTH;
            case WEST:
                return NETHER_BRICK_STAIRS_WEST;
        }
    }

    public static IBlockState getGravestone(EnumFacing direction) {
        switch (direction) {
            case NORTH:
            default:
                return GRAVESTONE_NORTH;
            case EAST:
                return GRAVESTONE_EAST;
            case SOUTH:
                return GRAVESTONE_SOUTH;
            case WEST:
                return GRAVESTONE_WEST;
        }
    }

    public static IBlockState getMemorial(EnumFacing direction) {
        switch (direction) {
            case NORTH:
            default:
                return MEMORIAL_NORTH;
            case EAST:
                return MEMORIAL_EAST;
            case SOUTH:
                return MEMORIAL_SOUTH;
            case WEST:
                return MEMORIAL_WEST;
        }
    }

    public static IBlockState getPileOfBones(EnumPileOfBones type) {
        switch (type) {
            default:
                return PILE_OF_BONES;
            case PILE_OF_BONES_WITH_SKULL:
                return PILE_OF_BONES_WITH_SKULL;
            case PILE_OF_BONES_WITH_SKULL_CRAWLER:
                return PILE_OF_BONES_WITH_SKULL_CRAWLER;
        }
    }

    public static IBlockState getSpawner(EnumSpawner type) {
        switch (type) {
            default:
                return SPAWNER;
            case SKELETON_SPAWNER:
                return SPAWNER_SKELETON;
            case ZOMBIE_SPAWNER:
                return SPAWNER_ZOMBIE;
            case SPIDER_SPAWNER:
                return SPAWNER_SPIDER;
        }
    }

    public static IBlockState getChest(IBlockState chest, EnumFacing direction) {
        return chest.withProperty(BlockChest.FACING, direction);
    }

    public static IBlockState getDarkOakFenceGate(EnumFacing direction) {
        return DARK_OAK_FENCE_GATE.withProperty(BlockFenceGate.FACING, direction);
    }

    public static IBlockState getHauntedChest(EnumFacing direction) {
        return HAUNTED_CHEST.withProperty(BlockHauntedChest.FACING, direction);
    }

    public static IBlockState getTripWireHook(EnumFacing direction) {
        return TRIPWIRE_HOOK.withProperty(BlockTripWireHook.FACING, direction);
    }

    public static IBlockState getStairs(IBlockState stairs, EnumFacing direction) {
        return stairs.withProperty(BlockStairs.FACING, direction);
    }

    public static IBlockState getBedState(IBlockState bed, EnumFacing direction) {
        return bed.withProperty(BlockBed.FACING, direction);
    }

    public static boolean isWoodMaterial(World world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        return state.getBlock().getMaterial(state).equals(Material.WOOD);
    }

    public static boolean isLeavesMaterial(World world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        return state.getBlock().getMaterial(state).equals(Material.LEAVES);
    }
}
