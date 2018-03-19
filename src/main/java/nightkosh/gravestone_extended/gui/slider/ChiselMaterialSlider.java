package nightkosh.gravestone_extended.gui.slider;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone.ModGraveStone;
import nightkosh.gravestone.api.grave.EnumGraveMaterial;
import nightkosh.gravestone_extended.ModGravestoneExtended;
import nightkosh.gravestone_extended.gui.GSChiselCraftingGui;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@SideOnly(Side.CLIENT)
public class ChiselMaterialSlider extends AbstractSlider {

    public ChiselMaterialSlider(int id, int xPos, int yPos, int width, int height, double currentVal, GSChiselCraftingGui gui) {
        super(id, xPos, yPos, width, height, "", "", 0, EnumGraveMaterial.values().length - 2, currentVal, false, false, (slider) -> {

            gui.setMaterial(EnumGraveMaterial.values()[slider.getValueInt()]);
            gui.sendMessage();
        });
    }

    @Override
    public String getString() {
        return new StringBuilder(ModGravestoneExtended.proxy.getLocalizedString("material.title"))
                .append(" ")
                .append(ModGraveStone.proxy.getLocalizedMaterial(EnumGraveMaterial.values()[this.getValueInt()]))
                .toString();
    }

    public EnumGraveMaterial getMaterial() {
        return EnumGraveMaterial.values()[this.getValueInt()];
    }
}
