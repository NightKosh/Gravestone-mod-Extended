package nightkosh.gravestone_extended.structures;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.template.TemplateManager;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ComponentGraveStone extends StructureComponent implements IComponentGraveStone {

    protected ComponentGraveStone(int componentType, EnumFacing facing) {
        super(componentType);
        this.setCoordBaseMode(facing);
    }

    /**
     * second Part of Structure generating, this for example places Spiderwebs,
     * Mob Spawners, it closes Mineshafts at the end, it adds Fences... not
     * used!!!
     */
    @Override
    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureBoundingBox) {
        return true;
    }

    /**
     * Build component
     */
    public boolean addComponentParts(World world, Random random) {
        return true;
    }

    /**
     * Place block
     */
    @Override
    public void setBlockState(World world, IBlockState blockState, int x, int y, int z, StructureBoundingBox boundingBox) {
        super.setBlockState(world, blockState, x, y, z, boundingBox);
    }

    @Override
    public void placeBlockAtCurrentPosition(World world, IBlockState blockState, int x, int y, int z, StructureBoundingBox boundingBox) {
        setBlockState(world, blockState, x, y, z, boundingBox);
    }

    @Override
    protected void fillWithBlocks(World world, StructureBoundingBox boundingBox, int startX, int startY, int startZ, int endX, int endY, int endZ, IBlockState boundaryBlockState, IBlockState insideBlockState, boolean existingOnly) {
        super.fillWithBlocks(world, boundingBox, startX, startY, startZ, endX, endY, endZ, boundaryBlockState, insideBlockState, existingOnly);
    }

    protected void fillWithBlocks(World world, StructureBoundingBox boundingBox, int startX, int startY, int startZ, int endX, int endY, int endZ, IBlockState state, boolean existingOnly) {
        fillWithBlocks(world, boundingBox, startX, startY, startZ, endX, endY, endZ, state, state, existingOnly);
    }

    protected void fillWithBlocks(World world, StructureBoundingBox boundingBox, int startX, int startY, int startZ, int endX, int endY, int endZ, IBlockState state) {
        fillWithBlocks(world, boundingBox, startX, startY, startZ, endX, endY, endZ, state, state, false);
    }

    protected void fillWithBlocksRandomly(World world, StructureBoundingBox boundingBox, Random random, float chance, int startX, int startY, int startZ, int endX, int endY, int endZ, IBlockState state1, IBlockState state2, boolean replace) {
//        super.fillWithBlocksRandomly(world, boundingBox, random, chance, startX, startY, startZ, endX, endY, endZ, state1, state2, replace);
        super.generateMaybeBox(world, boundingBox, random, chance, startX, startY, startZ, endX, endY, endZ, state1, state2, replace, 0);
    }

    protected void randomlyFillWithBlocks(World world, StructureBoundingBox boundingBox, Random random, float chance, int startX, int startY, int startZ, int endX, int endY, int endZ, IBlockState state1, IBlockState state2, boolean replace) {
        fillWithBlocksRandomly(world, boundingBox, random, chance, startX, startY, startZ, endX, endY, endZ, state1, state2, replace);
    }

    protected void randomlyFillWithBlocks(World world, StructureBoundingBox boundingBox, Random random, float chance, int startX, int startY, int startZ, int endX, int endY, int endZ, IBlockState state, boolean replace) {
        randomlyFillWithBlocks(world, boundingBox, random, chance, startX, startY, startZ, endX, endY, endZ, state, state, replace);
    }

    /**
     * Return world X coord
     *
     * @param x Bounding box X coord
     * @param z Bounding box Z coord
     */
    @Override
    public int getXWithOffset(int x, int z) {
        return super.getXWithOffset(x, z);
    }

    @Override
    public int getIXWithOffset(int x, int z) {
        return getXWithOffset(x, z);
    }

    /**
     * Return world y coord
     *
     * @param y Bounding box Y coord
     */
    @Override
    public int getYWithOffset(int y) {
        return super.getYWithOffset(y);
    }

    @Override
    public int getIYWithOffset(int y) {
        return getYWithOffset(y);
    }

    /**
     * Return world Z coord
     *
     * @param x Bounding box X coord
     * @param z Bounding box Z coord
     */
    @Override
    public int getZWithOffset(int x, int z) {
        return super.getZWithOffset(x, z);
    }

    @Override
    public int getIZWithOffset(int x, int z) {
        return getZWithOffset(x, z);
    }

    /**
     * Used to generate chests with items in it. ex: Temple Chests, Village
     * Blacksmith Chests, Mineshaft Chests.
     */
    @Override
    public boolean generateChest(World world, StructureBoundingBox boundingBox, Random random, int x, int y, int z, ResourceLocation loot) {
        return super.generateChest(world, boundingBox, random, x, y, z, loot);
    }

    @Override
    protected void writeStructureToNBT(NBTTagCompound nbttagcompound) {
    }

    @Override
    protected void readStructureFromNBT(NBTTagCompound tagCompound, TemplateManager p_143011_2_) {

    }

    @Override
    public StructureBoundingBox getIBoundingBox() {
        return getBoundingBox();
    }
}
