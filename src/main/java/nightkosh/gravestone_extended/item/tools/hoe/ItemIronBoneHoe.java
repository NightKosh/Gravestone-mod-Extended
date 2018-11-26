package nightkosh.gravestone_extended.item.tools.hoe;

import nightkosh.gravestone_extended.core.ModInfo;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemIronBoneHoe extends ItemBoneHoe {

    public ItemIronBoneHoe() {
        super(ToolMaterial.IRON);
        this.setUnlocalizedName("gravestone.bone_hoe_iron");
        this.setRegistryName(ModInfo.ID, "gs_bone_hoe_iron");
        this.setCreativeTab(null);
    }
}
