package nightkosh.gravestone_extended.capability.choke;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ChokeStorage implements Capability.IStorage<IChoke> {

    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IChoke> capability, IChoke instance, EnumFacing side) {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setBoolean("IsActive", instance.isActive());
        nbt.setInteger("Air", instance.getAir());
        return nbt;
    }

    @Override
    public void readNBT(Capability<IChoke> capability, IChoke instance, EnumFacing side, NBTBase nbt) {
        instance.setActive(((NBTTagCompound) nbt).getBoolean("IsActive"));
        instance.setAir(((NBTTagCompound) nbt).getInteger("Air"));
    }
}
