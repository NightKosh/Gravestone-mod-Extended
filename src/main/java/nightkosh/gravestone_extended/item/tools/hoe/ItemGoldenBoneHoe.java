package nightkosh.gravestone_extended.item.tools.hoe;

import nightkosh.gravestone_extended.core.ModInfo;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemGoldenBoneHoe extends ItemBoneHoe {

    public ItemGoldenBoneHoe() {
        super(ToolMaterial.GOLD);
        this.setUnlocalizedName("gravestone.bone_hoe_golden");
        this.setRegistryName(ModInfo.ID, "gs_bone_hoe_golden");
        this.setCreativeTab(null);
    }
}
