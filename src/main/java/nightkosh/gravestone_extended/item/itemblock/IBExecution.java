package nightkosh.gravestone_extended.item.itemblock;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone_extended.block.enums.EnumExecution;
import nightkosh.gravestone_extended.core.GSBlock;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class IBExecution extends ItemBlock {

    public IBExecution(Block block) {
        super(block);
        this.setHasSubtypes(true);
        this.setRegistryName(GSBlock.EXECUTION.getRegistryName());
    }

    @Override
    public int getMetadata(int damageValue) {
        return 0;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return EnumExecution.getById(itemStack.getItemDamage()).getUnLocalizedName();
    }

    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }
    }

    /**
     * Returns true if the given ItemBlock can be placed on the given side of
     * the given block position.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean canPlaceBlockOnSide(World world, BlockPos pos, EnumFacing side, EntityPlayer player, ItemStack stack) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        switch (side) {
            case DOWN:
                return false;
            case UP:
                y++;
                break;
            case NORTH:
                z--;
                break;
            case SOUTH:
                z++;
                break;
            case WEST:
                x--;
                break;
            case EAST:
                x++;
                break;
        }

        EnumExecution execution = EnumExecution.getById(stack.getItemDamage());
        byte maxY = 0;
        byte maxX = 1;
        byte maxZ = 1;
        byte startX = 0;
        byte startZ = 0;

        EnumFacing rotation = EnumFacing.getHorizontal(MathHelper.floor((double) (player.rotationYaw * 4 / 360F) + 0.5D) & 3).getOpposite();
        switch (execution) {
            case GALLOWS:
            case GIBBET:
                maxY = 3;
                switch (rotation) {
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
                if (rotation == EnumFacing.NORTH || rotation == EnumFacing.SOUTH) {
                    startX = -1;
                    maxX = 2;
                } else {
                    startZ = -1;
                    maxZ = 2;
                }
                break;
            case BURNING_STAKE:
                maxY = 3;
                break;
        }

        int airBlockId = Block.getIdFromBlock(Blocks.AIR);
        for (byte shiftY = 0; shiftY < maxY; shiftY++) {
            for (byte shiftZ = startZ; shiftZ < maxZ; shiftZ++) {
                for (byte shiftX = startX; shiftX < maxX; shiftX++) {
                    if (Block.getIdFromBlock(world.getBlockState(new BlockPos(x + shiftX, y + shiftY, z + shiftZ)).getBlock()) != airBlockId) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
