package nightkosh.gravestone_extended.models.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone_extended.models.armor.bone.ModelBoneBoots;
import nightkosh.gravestone_extended.models.armor.bone.ModelBoneChestplate;
import nightkosh.gravestone_extended.models.armor.bone.ModelBoneHelmet;
import nightkosh.gravestone_extended.models.armor.bone.ModelBoneLeggings;
import nightkosh.gravestone_extended.models.armor.phantom_diver_costume.ModelDivingHelmet;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@SideOnly(Side.CLIENT)
public class ArmorModelsHelper {

    public static final ModelBiped DIVING_HELMET = new ModelDivingHelmet();

    public static final ModelBiped BONE_HELMET = new ModelBoneHelmet();
    public static final ModelBiped BONE_CHESTPLATE = new ModelBoneChestplate();
    public static final ModelBiped BONE_LEGGINGS = new ModelBoneLeggings();
    public static final ModelBiped BONE_BOOTS = new ModelBoneBoots();
}
