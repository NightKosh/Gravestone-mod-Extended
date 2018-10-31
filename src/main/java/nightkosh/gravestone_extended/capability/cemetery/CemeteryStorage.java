package nightkosh.gravestone_extended.capability.cemetery;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CemeteryStorage implements Capability.IStorage<ICemetery> {

    @Nullable
    @Override
    public NBTBase writeNBT(Capability<ICemetery> capability, ICemetery instance, EnumFacing side) {
        NBTTagCompound nbt = new NBTTagCompound();

        nbt.setBoolean("HasPlayerCemetery", instance.hasPlayerCemetery());
        nbt.setInteger("PlayerPosX", instance.getPlayerPosition().getX());
        nbt.setInteger("PlayerPosY", instance.getPlayerPosition().getY());
        nbt.setInteger("PlayerPosZ", instance.getPlayerPosition().getZ());
        nbt.setInteger("PlayerFacing", instance.getPlayerFacing().getHorizontalIndex());

        nbt.setBoolean("HasPetCemetery", instance.hasPetCemetery());
        nbt.setInteger("PetPosX", instance.getPetPosition().getX());
        nbt.setInteger("PetPosY", instance.getPetPosition().getY());
        nbt.setInteger("PetPosZ", instance.getPetPosition().getZ());
        nbt.setInteger("PetFacing", instance.getPetFacing().getHorizontalIndex());

        return nbt;
    }

    @Override
    public void readNBT(Capability<ICemetery> capability, ICemetery instance, EnumFacing side, NBTBase nbt) {

        instance.setPlayerCemetery(((NBTTagCompound) nbt).getBoolean("HasPlayerCemetery"));
        instance.setPlayerPosition(new BlockPos(
                ((NBTTagCompound) nbt).getInteger("PlayerPosX"),
                ((NBTTagCompound) nbt).getInteger("PlayerPosY"),
                ((NBTTagCompound) nbt).getInteger("PlayerPosZ")));
        instance.setPlayerFacing(EnumFacing.getHorizontal(((NBTTagCompound) nbt).getInteger("PlayerFacing")));

        instance.setPetCemetery(((NBTTagCompound) nbt).getBoolean("HasPetCemetery"));
        instance.setPetPosition(new BlockPos(
                ((NBTTagCompound) nbt).getInteger("PetPosX"),
                ((NBTTagCompound) nbt).getInteger("PetPosY"),
                ((NBTTagCompound) nbt).getInteger("PetPosZ")));
        instance.setPetFacing(EnumFacing.getHorizontal(((NBTTagCompound) nbt).getInteger("PetFacing")));
    }
}
