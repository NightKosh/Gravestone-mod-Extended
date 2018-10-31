package nightkosh.gravestone_extended.capability.choke;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ChokeProvider implements ICapabilitySerializable<NBTBase> {

    @CapabilityInject(IChoke.class)
    public static final Capability<IChoke> AIR_CAP = null;
    private IChoke instance = AIR_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == AIR_CAP;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == AIR_CAP ? AIR_CAP.<T>cast(this.instance) : null;

    }

    @Override
    public NBTBase serializeNBT() {
        return AIR_CAP.getStorage().writeNBT(AIR_CAP, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        AIR_CAP.getStorage().readNBT(AIR_CAP, this.instance, null, nbt);
    }
}
