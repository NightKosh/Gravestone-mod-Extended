package nightkosh.gravestone_extended.item.weapon;

import nightkosh.gravestone_extended.core.ModInfo;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemIronBoneSword extends ItemBoneSword {

    public ItemIronBoneSword() {
        super(ToolMaterial.IRON);
        this.setUnlocalizedName("gravestone.bone_sword_iron");
        this.setRegistryName(ModInfo.ID, "gs_bone_sword_iron");
        this.setCreativeTab(null);
    }
}
