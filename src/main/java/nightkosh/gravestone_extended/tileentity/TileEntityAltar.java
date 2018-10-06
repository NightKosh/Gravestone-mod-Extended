package nightkosh.gravestone_extended.tileentity;

import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import nightkosh.gravestone.inventory.GraveInventory;
import nightkosh.gravestone_extended.inventory.AltarCorpseInventory;
import nightkosh.gravestone_extended.inventory.AltarDisenchantmentInventory;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileEntityAltar extends TileEntity {

    private AltarCorpseInventory corpseInventory;
    private AltarDisenchantmentInventory disenchantmentInventory;

    public TileEntityAltar() {
        this.corpseInventory = new AltarCorpseInventory(this);
        this.disenchantmentInventory = new AltarDisenchantmentInventory(this);
    }

    public AltarCorpseInventory getCorpseInventory() {
        return corpseInventory;
    }

    public AltarDisenchantmentInventory getDisenchantmentInventory() {
        return disenchantmentInventory;
    }

    public void dropItems() {
        dropItems(corpseInventory);
        dropItems(disenchantmentInventory);
    }

    private void dropItems(IInventory inventory) {
        for (int i = 0; i < inventory.getSizeInventory(); i++) {
            GraveInventory.dropItem(inventory.getStackInSlot(i), this.world, this.pos);
        }
        inventory.clear();
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTag) {
        super.readFromNBT(nbtTag);

        corpseInventory.readItems(nbtTag);
        disenchantmentInventory.readItems(nbtTag);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbtTag) {
        nbtTag = super.writeToNBT(nbtTag);

        corpseInventory.saveItems(nbtTag);
        disenchantmentInventory.saveItems(nbtTag);

        return nbtTag;
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
        readFromNBT(packet.getNbtCompound());
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 1, this.getUpdateTag());
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }
}
