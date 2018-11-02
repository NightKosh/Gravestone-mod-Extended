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
    public NBTBase writeNBT(Capability<ICemetery> capability, ICemetery cemetery, EnumFacing side) {
        NBTTagCompound nbt = new NBTTagCompound();

        CemeteryInfo playerCemetery = cemetery.getPlayerCemetery();
        if (playerCemetery != null) {
            nbt.setTag("PlayerCemetery", getCemeteryNBT(playerCemetery));
        }

        CemeteryInfo petCemetery = cemetery.getPlayerCemetery();
        if (playerCemetery != null) {
            nbt.setTag("PetCemetery", getCemeteryNBT(petCemetery));
        }

        return nbt;
    }

    private static NBTTagCompound getCemeteryNBT(CemeteryInfo cemetery) {
        NBTTagCompound cemeteryNbt = new NBTTagCompound();
        cemeteryNbt.setInteger("Dimension", cemetery.getDimensionId());
        cemeteryNbt.setInteger("PosX", cemetery.getPosition().getX());
        cemeteryNbt.setInteger("PosY", cemetery.getPosition().getY());
        cemeteryNbt.setInteger("PosZ", cemetery.getPosition().getZ());
        cemeteryNbt.setInteger("Facing", cemetery.getFacing().getHorizontalIndex());
        return cemeteryNbt;
    }

    @Override
    public void readNBT(Capability<ICemetery> capability, ICemetery cemetery, EnumFacing side, NBTBase nbt) {
        if (((NBTTagCompound) nbt).hasKey("PlayerCemetery")) {
            cemetery.setPlayerCemetery(getCemeteryInfo((NBTTagCompound) ((NBTTagCompound) nbt).getTag("PlayerCemetery")));

        }
        if (((NBTTagCompound) nbt).hasKey("PetCemetery")) {
            cemetery.setPetCemetery(getCemeteryInfo((NBTTagCompound) ((NBTTagCompound) nbt).getTag("PetCemetery")));
        }
    }

    private static CemeteryInfo getCemeteryInfo(NBTTagCompound cemeteryNbt) {
        CemeteryInfo cemeteryInfo = new CemeteryInfo();
        cemeteryInfo.setDimension(cemeteryNbt.getInteger("Dimension"));
        cemeteryInfo.setPosition(new BlockPos(
                cemeteryNbt.getInteger("PosX"),
                cemeteryNbt.getInteger("PosY"),
                cemeteryNbt.getInteger("PosZ")
        ));
        cemeteryInfo.setFacing(EnumFacing.getHorizontal(cemeteryNbt.getInteger("Facing")));

        return cemeteryInfo;
    }
}
