package nightkosh.gravestone_extended.capability.cemetery;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Cemetery implements ICemetery {

    private static final BlockPos DEFAULT_POS = new BlockPos(0, 0, 0);

    private boolean hasPlayerCemetery = false;
    private BlockPos playerPos = DEFAULT_POS;
    private EnumFacing playerFacing = EnumFacing.NORTH;

    private boolean hasPetCemetery = false;
    private BlockPos petPos = DEFAULT_POS;
    private EnumFacing petFacing = EnumFacing.NORTH;

    @Override
    public boolean hasPlayerCemetery() {
        return hasPlayerCemetery;
    }

    @Override
    public void setPlayerCemetery(boolean hasCemetery) {
        this.hasPlayerCemetery = hasCemetery;
    }

    @Override
    public void setPlayerPosition(BlockPos pos) {
        this.playerPos = pos;
    }

    @Override
    public BlockPos getPlayerPosition() {
        return playerPos;
    }

    @Override
    public void setPlayerFacing(EnumFacing facing) {
        this.playerFacing = facing;
    }

    @Override
    public EnumFacing getPlayerFacing() {
        return playerFacing;
    }

    @Override
    public boolean hasPetCemetery() {
        return hasPetCemetery;
    }

    @Override
    public void setPetCemetery(boolean hasCemetery) {
        this.hasPetCemetery = hasCemetery;
    }

    @Override
    public void setPetPosition(BlockPos pos) {
        this.petPos = pos;

    }

    @Override
    public BlockPos getPetPosition() {
        return petPos;
    }

    @Override
    public void setPetFacing(EnumFacing facing) {
        this.petFacing = facing;
    }

    @Override
    public EnumFacing getPetFacing() {
        return petFacing;
    }
}
