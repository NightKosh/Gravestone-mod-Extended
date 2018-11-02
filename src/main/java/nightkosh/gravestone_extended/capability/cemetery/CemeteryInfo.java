package nightkosh.gravestone_extended.capability.cemetery;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CemeteryInfo {

    private int dimensionId;
    private BlockPos pos;
    private EnumFacing facing;


    public void setDimension(int id) {
        this.dimensionId = id;
    }

    public int getDimensionId() {
        return this.dimensionId;
    }

    public void setPosition(BlockPos pos) {
        this.pos = pos;
    }

    public BlockPos getPosition() {
        return pos;
    }

    public void setFacing(EnumFacing facing) {
        this.facing = facing;
    }

    public EnumFacing getFacing() {
        return facing;
    }
}
