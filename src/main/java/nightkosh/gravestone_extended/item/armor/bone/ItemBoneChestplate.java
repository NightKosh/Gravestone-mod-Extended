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
public class ItemBoneChestplate extends AbstractBoneArmor {

    public ItemBoneChestplate() {
        super(EntityEquipmentSlot.CHEST);
        this.setUnlocalizedName("gravestone.bone_chestplate");
        this.setRegistryName(ModInfo.ID, "bone_chestplate");
        this.setCreativeTab(GSTabs.otherItemsTab);
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        return Resources.BONE_CHESTPLATE;
    }

    @Nullable
    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, EntityEquipmentSlot armorSlot, ModelBiped defaultModel) {
        if (!stack.isEmpty() && stack.getItem() instanceof ItemArmor) {
            return ArmorModelsHelper.BONE_CHESTPLATE;
        }
        return null;
    }
}
