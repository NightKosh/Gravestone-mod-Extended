package nightkosh.gravestone_extended.item.armor.bone;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone_extended.core.GSTabs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.core.Resources;
import nightkosh.gravestone_extended.models.armor.ArmorModelsHelper;

import javax.annotation.Nullable;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemBoneBoots extends AbstractBoneArmor {

    public ItemBoneBoots() {
        super(EntityEquipmentSlot.FEET);
        this.setUnlocalizedName("gravestone.bone_boots");
        this.setRegistryName(ModInfo.ID, "bone_boots");
        this.setCreativeTab(GSTabs.otherItemsTab);
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        return Resources.BONE_BOOTS;
    }

    @Nullable
    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, EntityEquipmentSlot armorSlot, ModelBiped defaultModel) {
        if (!stack.isEmpty() && stack.getItem() instanceof ItemArmor) {
            return ArmorModelsHelper.BONE_BOOTS;
        }
        return null;
    }
}
