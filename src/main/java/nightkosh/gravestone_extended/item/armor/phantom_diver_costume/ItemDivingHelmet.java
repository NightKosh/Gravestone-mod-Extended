package nightkosh.gravestone_extended.item.armor.phantom_diver_costume;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone_extended.ModGravestoneExtended;
import nightkosh.gravestone_extended.core.GSTabs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.core.Resources;
import nightkosh.gravestone_extended.models.armor.ArmorModelsHelper;

import javax.annotation.Nullable;
import java.util.List;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemDivingHelmet extends ItemArmor {

    public ItemDivingHelmet() {
        super(ArmorMaterial.IRON, 1, EntityEquipmentSlot.HEAD);
        this.setUnlocalizedName("gravestone.diving_helmet");
        this.setRegistryName(ModInfo.ID, "gs_diving_helmet");
        this.setCreativeTab(GSTabs.otherItemsTab);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        super.onArmorTick(world, player, itemStack);
        player.setAir(300);

        if (player.world.isRemote && player.isInWater()) {
            for (int i = 0; i < 2; i++) {
                player.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, player.posX, player.posY + 1.95F, player.posZ, 0, 0, 0);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(ModGravestoneExtended.proxy.getLocalizedString("item.gravestone.diving_helmet.tooltip"));
    }

    @Nullable
    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, EntityEquipmentSlot armorSlot, ModelBiped defaultModel) {
        if (!stack.isEmpty() && stack.getItem() instanceof ItemArmor) {
            return ArmorModelsHelper.DIVING_HELMET;
        }
        return null;
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        return Resources.DIVING_HELMET;
    }
}
