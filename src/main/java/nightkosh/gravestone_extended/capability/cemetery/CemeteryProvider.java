package nightkosh.gravestone_extended.capability.cemetery;

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
public class CemeteryProvider implements ICapabilitySerializable<NBTBase> {

    @CapabilityInject(ICemetery.class)
    public static final Capability<ICemetery> CEMETERY_CAP = null;
    private ICemetery instance = CEMETERY_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == CEMETERY_CAP;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == CEMETERY_CAP ? CEMETERY_CAP.<T>cast(this.instance) : null;

    }

    @Override
    public NBTBase serializeNBT() {
        return CEMETERY_CAP.getStorage().writeNBT(CEMETERY_CAP, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        CEMETERY_CAP.getStorage().readNBT(CEMETERY_CAP, this.instance, null, nbt);
    }
}
