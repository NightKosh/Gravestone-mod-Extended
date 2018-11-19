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
public class ItemBoneHelmet extends AbstractBoneArmor {

    public ItemBoneHelmet() {
        super(EntityEquipmentSlot.HEAD);
        this.setUnlocalizedName("gravestone.bone_helmet");
        this.setRegistryName(ModInfo.ID, "bone_helmet");
        this.setCreativeTab(GSTabs.otherItemsTab);
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        return Resources.BONE_HELMET;
    }

    @Nullable
    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, EntityEquipmentSlot armorSlot, ModelBiped defaultModel) {
        if (!stack.isEmpty() && stack.getItem() instanceof ItemArmor) {
            return ArmorModelsHelper.BONE_HELMET;
        }
        return null;
    }
}
