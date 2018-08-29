package nightkosh.gravestone_extended.structures;

import net.minecraft.block.BlockDispenser;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import nightkosh.gravestone_extended.block.BlockPileOfBones;
import nightkosh.gravestone_extended.block.BlockSpawner;
import nightkosh.gravestone_extended.block.enums.EnumHauntedChest;
import nightkosh.gravestone_extended.block.enums.EnumPileOfBones;
import nightkosh.gravestone_extended.block.enums.EnumSpawner;
import nightkosh.gravestone_extended.helper.PotionHelper;
import nightkosh.gravestone_extended.helper.StateHelper;
import nightkosh.gravestone_extended.tileentity.TileEntityHauntedChest;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ObjectsGenerationHelper {

    private ObjectsGenerationHelper() {
    }

    public static void generatePileOfBones(ComponentGraveStone component, World world, int xCoord, int yCoord, int zCoord, EnumFacing facing, IBlockState state) {
        BlockPos pos = new BlockPos(component.getXWithOffset(xCoord, zCoord), component.getYWithOffset(yCoord), component.getZWithOffset(xCoord, zCoord));
        world.setBlockState(pos, state.withProperty(BlockPileOfBones.FACING, facing), 2);
    }

    public static void generatePileOfBones(ComponentGraveStone component, World world, int xCoord, int yCoord, int zCoord, IBlockState state) {
        generatePileOfBones(component, world, xCoord, yCoord, zCoord, EnumFacing.getHorizontal(world.rand.nextInt(4)), state);
    }

    public static void generatePileOfBones(ComponentGraveStone component, World world, int xCoord, int yCoord, int zCoord, EnumFacing facing, EnumPileOfBones type) {
        generatePileOfBones(component, world, xCoord, yCoord, zCoord, facing, StateHelper.getPileOfBones(type));
    }

    /**
     * Generate chest with random loot type or haunted chest
     */
    public static void generateChest(ComponentGraveStone component, World world, Random random, int xCoord, int yCoord, int zCoord, EnumFacing facing, boolean defaultChest, EnumChestTypes chestType) {
        if (chestType.equals(EnumChestTypes.ALL_CHESTS) && random.nextInt(7) == 0) {
            generateHauntedChest(component, world, random, xCoord, yCoord, zCoord, facing);
        } else {
            generateVanillaChest(component, world, random, xCoord, yCoord, zCoord, facing, defaultChest, chestType);
        }
    }

    /**
     * Generate chest with random loot type
     */
    public static void generateVanillaChest(ComponentGraveStone component, World world, Random random, int xCoord, int yCoord, int zCoord, EnumFacing facing, boolean defaultChest, EnumChestTypes chestType) {
        ResourceLocation loot = getChest(random, chestType);
        if (defaultChest) {
            generateChestContents(component, world, random, xCoord, yCoord, zCoord, facing, loot, false);
        } else {
            generateChestContents(component, world, random, xCoord, yCoord, zCoord, facing, loot, true);
        }
    }

    public static void generateHauntedChest(ComponentGraveStone component, World world, Random random, int xCoord, int yCoord, int zCoord, EnumFacing facing) {
        int x = component.getXWithOffset(xCoord, zCoord);
        int y = component.getYWithOffset(yCoord);
        int z = component.getZWithOffset(xCoord, zCoord);

        BlockPos pos = new BlockPos(x, y, z);
        world.setBlockState(pos, StateHelper.getHauntedChest(facing), 2);
        TileEntityHauntedChest te = (TileEntityHauntedChest) world.getTileEntity(pos);
        if (te != null) {
            te.setChestType(EnumHauntedChest.getById(random.nextInt(EnumHauntedChest.values().length)));
        }
    }

    /**
     * Generate trapped chests with items.
     */
    public static void generateChestContents(ComponentGraveStone component, World world, Random random, int xCoord, int yCoord, int zCoord, EnumFacing facing, ResourceLocation loot, boolean trapped) {
        int x = component.getXWithOffset(xCoord, zCoord);
        int y = component.getYWithOffset(yCoord);
        int z = component.getZWithOffset(xCoord, zCoord);

        BlockPos pos = new BlockPos(x, y, z);
        IBlockState chest;
        if (trapped) {
            chest = StateHelper.getChest(StateHelper.TRAPPED_CHEST, facing);
        } else {
            chest = StateHelper.getChest(StateHelper.CHEST, facing);
        }
        world.setBlockState(pos, chest, 2);
        TileEntityChest tileentity = (TileEntityChest) world.getTileEntity(pos);

        if (tileentity != null) {
            tileentity.setLootTable(loot, random.nextLong());
        }
    }

    private static ResourceLocation getChest(Random random, EnumChestTypes chestType) {
        switch (chestType) {
            case VALUABLE_CHESTS:
                switch (random.nextInt(7)) {
                    case 1:
                        return LootTableList.CHESTS_SIMPLE_DUNGEON;
                    case 2:
                        return LootTableList.CHESTS_ABANDONED_MINESHAFT;
                    case 3:
                        return LootTableList.CHESTS_DESERT_PYRAMID;
                    case 4:
                        return LootTableList.CHESTS_STRONGHOLD_CROSSING;
                    case 5:
                        return LootTableList.CHESTS_STRONGHOLD_LIBRARY;
                    case 6:
                        return LootTableList.CHESTS_NETHER_BRIDGE;
                    case 0:
                    default:
                        return LootTableList.CHESTS_STRONGHOLD_CORRIDOR;
                }
            case ALL_CHESTS:
            default:
                switch (random.nextInt(9)) {
                    case 1:
                        return LootTableList.CHESTS_SIMPLE_DUNGEON;
                    case 2:
                        return LootTableList.CHESTS_ABANDONED_MINESHAFT;
                    case 3:
                        return LootTableList.CHESTS_DESERT_PYRAMID;
                    case 4:
                        return LootTableList.CHESTS_JUNGLE_TEMPLE;
                    case 5:
                        return LootTableList.CHESTS_STRONGHOLD_CROSSING;
                    case 6:
                        return LootTableList.CHESTS_STRONGHOLD_LIBRARY;
                    case 7:
                        return LootTableList.CHESTS_VILLAGE_BLACKSMITH;
                    case 8:
                        return LootTableList.CHESTS_NETHER_BRIDGE;
                    case 0:
                    default:
                        return LootTableList.CHESTS_STRONGHOLD_CORRIDOR;
                }
        }
    }

    /**
     * Generate mob spawner
     *
     * @param component Component instatnce
     * @param world     World object
     * @param xCoord    X coord
     * @param yCoord    Y coord
     * @param zCoord    Z coord
     */
    public static void generateSpawner(ComponentGraveStone component, World world, Random random, int xCoord, int yCoord, int zCoord) {
        generateSpawner(component, world, xCoord, yCoord, zCoord, BlockSpawner.CATACOMBS_CROSSING_SPAWNERS.get(random.nextInt(BlockSpawner.CATACOMBS_CROSSING_SPAWNERS.size())));
    }

    /**
     * Generate mob spawner
     *
     * @param component Component instatnce
     * @param world     World object
     * @param xCoord    X coord
     * @param yCoord    Y coord
     * @param zCoord    Z coord
     */
    public static void generateSpawner(ComponentGraveStone component, World world, int xCoord, int yCoord, int zCoord, EnumSpawner spawnerType) {
        int y = component.getYWithOffset(yCoord);
        int x = component.getXWithOffset(xCoord, zCoord);
        int z = component.getZWithOffset(xCoord, zCoord);

        world.setBlockState(new BlockPos(x, y, z), StateHelper.getSpawner(spawnerType), 2);
    }

    /**
     * Generate mob spawner
     *
     * @param component Component instatnce
     * @param world     World object
     * @param xCoord    X coord
     * @param yCoord    Y coord
     * @param zCoord    Z coord
     * @param mobNmae   Spawned mob name
     */
    public static void generateMinecraftSpawner(ComponentGraveStone component, World world, int xCoord, int yCoord, int zCoord, ResourceLocation mobNmae) {
        int y = component.getYWithOffset(yCoord);
        int x = component.getXWithOffset(xCoord, zCoord);
        int z = component.getZWithOffset(xCoord, zCoord);

        BlockPos pos = new BlockPos(x, y, z);
        world.setBlockState(pos, StateHelper.MOB_SPAWNER);
        TileEntityMobSpawner tileEntity = (TileEntityMobSpawner) world.getTileEntity(pos);

        if (tileEntity != null) {
            tileEntity.getSpawnerBaseLogic().setEntityId(mobNmae);
        }
    }

    /**
     * Used to generate dispenser contents for structures. ex: Jungle Temples.
     */
    public static void generateDispenser(World world, ComponentGraveStone component, Random random, int xCoord, int yCoord, int zCoord, EnumFacing direction) {
        int x = component.getXWithOffset(xCoord, zCoord);
        int y = component.getYWithOffset(yCoord);
        int z = component.getZWithOffset(xCoord, zCoord);

        BlockPos pos = new BlockPos(x, y, z);
        world.setBlockState(pos, StateHelper.DISPENSER);
        world.setBlockState(pos, StateHelper.DISPENSER_TRIGGERED.withProperty(BlockDispenser.FACING, direction));
        TileEntityDispenser dispenser = (TileEntityDispenser) world.getTileEntity(pos);
        if (dispenser != null) {
            generateDispenserContents(random, dispenser);
        }
    }

    /**
     * Generates dispenser contents.
     */
    public static void generateDispenserContents(Random random, TileEntityDispenser dispenserEntity) {
        for (int i = 0; i < 9; i++) {
            dispenserEntity.setInventorySlotContents(i, PotionHelper.getCatacombsDispenserPotion(random));
        }
    }

    public enum EnumChestTypes {
        ALL_CHESTS,
        VALUABLE_CHESTS
    }
}
