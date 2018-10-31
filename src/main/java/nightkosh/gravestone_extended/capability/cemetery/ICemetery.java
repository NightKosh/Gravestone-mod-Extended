package nightkosh.gravestone_extended.capability.cemetery;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public interface ICemetery {

    public boolean hasPlayerCemetery();

    public void setPlayerCemetery(boolean hasCemetery);

    public void setPlayerPosition(BlockPos pos);

    public BlockPos getPlayerPosition();

    public void setPlayerFacing(EnumFacing facing);

    public EnumFacing getPlayerFacing();



    public boolean hasPetCemetery();

    public void setPetCemetery(boolean hasCemetery);

    public void setPetPosition(BlockPos pos);

    public BlockPos getPetPosition();

    public void setPetFacing(EnumFacing facing);

    public EnumFacing getPetFacing();
}
