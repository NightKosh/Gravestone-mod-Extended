package nightkosh.gravestone_extended.item.itemblock;

import com.mojang.authlib.GameProfile;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.block.enums.EnumCorpse;
import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.item.corpse.CorpseHelper;

import javax.annotation.Nullable;
import java.util.List;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class IBCorpse extends ItemBlock {

    public IBCorpse(Block block) {
        super(block);
        this.setUnlocalizedName("Corpse");
        this.setRegistryName(GSBlock.CORPSE.getRegistryName());
    }

    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
        if (stack.getTagCompound() == null) {
            stack.setTagCompound(new NBTTagCompound());
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (stack.getTagCompound() == null) {
            stack.setTagCompound(new NBTTagCompound());
        } else {
            CorpseHelper.addInfo(stack.getItemDamage(), tooltip, stack.getTagCompound());
        }
    }

    @Override
    public int getMetadata(int metadata) {
        return metadata;
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack) {
        if (itemStack.getItemDamage() == EnumCorpse.STEVE.ordinal()) {
            NBTTagCompound nbt = itemStack.getTagCompound();
            if (nbt != null && nbt.hasKey("Owner", 10)) {
                GameProfile playerProfile = NBTUtil.readGameProfileFromNBT(nbt.getCompoundTag("Owner"));
                if (playerProfile != null) {
                    return EnumCorpse.getPlayerUnLocalizedName() + " - " + playerProfile.getName();
                }
            }
        }
        return EnumCorpse.getById((byte) itemStack.getItemDamage()).getUnLocalizedName();
    }
}
