package nightkosh.gravestone_extended.tileentity;

import com.mojang.authlib.GameProfile;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.world.World;
import nightkosh.gravestone.tileentity.GraveStoneDeathText;
import nightkosh.gravestone.tileentity.TileEntityGrave;
import nightkosh.gravestone_extended.block.enums.EnumMemorials;
import nightkosh.gravestone_extended.helper.GameProfileHelper;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileEntityMemorial extends TileEntityGrave {

    private GameProfile playerProfile = null;

    public TileEntityMemorial() {
        super();
    }

    public TileEntityMemorial(World world) {
        this();
        this.setWorld(world);
    }

    /**
     * Called when a client event is received with the event number and
     * argument, see World.sendClientEvent
     */
    @Override
    public boolean receiveClientEvent(int par1, int par2) {
        return true;
    }

    /**
     * Reads a tile entity from NBT.
     */
    @Override
    public void readFromNBT(NBTTagCompound nbtTag) {
        super.readFromNBT(nbtTag);
        // death text
        deathText.readText(nbtTag);

        setPlayerProfile(nbtTag);
    }

    /**
     * Writes a tile entity to NBT.
     */
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbtTag) {
        nbtTag = super.writeToNBT(nbtTag);
        // death text
        deathText.saveText(nbtTag);

        if (this.playerProfile != null) {
            nbtTag.setTag("Owner", NBTUtil.writeGameProfile(new NBTTagCompound(), this.playerProfile));
        }

        return nbtTag;
    }

    public void setMemorialContent(Random random) {
    }

    @Override
    public GraveStoneDeathText getDeathTextComponent() {
        return deathText;
    }

    public EnumMemorials getMemorialType() {
        return EnumMemorials.getById(graveType);
    }

    public GameProfile getPlayerProfile() {
        return this.playerProfile;
    }

    public void setPlayerProfile(NBTTagCompound nbtTag) {
        this.playerProfile = GameProfileHelper.getProfile(nbtTag);
    }

    public void setPlayerProfile(GameProfile playerProfile) {
        this.playerProfile = playerProfile;
    }
}
