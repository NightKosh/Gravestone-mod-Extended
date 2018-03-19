package nightkosh.gravestone_extended.gui.slider;

import nightkosh.gravestone_extended.block.enums.EnumMemorials;
import nightkosh.gravestone_extended.gui.GSChiselCraftingGui;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ChiselMemorialTypeSlider extends ChiselGraveTypeSlider {

    public ChiselMemorialTypeSlider(int id, int xPos, int yPos, int width, int height, double currentVal, GSChiselCraftingGui gui) {
        this(id, xPos, yPos, width, height, EnumMemorials.EnumMemorialType.values().length - 1, currentVal, gui, slider -> {
                    gui.setMemorialType(EnumMemorials.EnumMemorialType.values()[slider.getValueInt()]);
                    gui.sendMessage();
                }
        );
    }

    public ChiselMemorialTypeSlider(int id, int xPos, int yPos, int width, int height, int maxVal, double currentVal, GSChiselCraftingGui gui, ISlider slider) {
        super(id, xPos, yPos, width, height, maxVal, currentVal, gui, slider);
    }

    @Override
    protected String getName(int num) {
        return EnumMemorials.getById(num).getUnLocalizedName();
    }

    public EnumMemorials.EnumMemorialType getMemorialType() {
        return EnumMemorials.EnumMemorialType.values()[this.getValueInt()];
    }
}
