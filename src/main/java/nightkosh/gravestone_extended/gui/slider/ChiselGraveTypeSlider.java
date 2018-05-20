package nightkosh.gravestone_extended.gui.slider;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone.api.grave.EnumGraveMaterial;
import nightkosh.gravestone.api.grave.EnumGraveType;
import nightkosh.gravestone.block.enums.EnumGraves;
import nightkosh.gravestone_extended.ModGravestoneExtended;
import nightkosh.gravestone_extended.gui.GSChiselCraftingGui;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@SideOnly(Side.CLIENT)
public class ChiselGraveTypeSlider extends AbstractSlider {

    protected GSChiselCraftingGui gui;

    public ChiselGraveTypeSlider(int id, int xPos, int yPos, int width, int height, double currentVal, GSChiselCraftingGui gui) {
        this(id, xPos, yPos, width, height, EnumGraveType.values().length - 4, currentVal, gui,
                slider -> gui.setGraveType(EnumGraveType.values()[slider.getValueInt()]));
    }

    public ChiselGraveTypeSlider(int id, int xPos, int yPos, int width, int height, int maxVal, double currentVal, GSChiselCraftingGui gui, ISlider slider) {
        super(id, xPos, yPos, width, height, "", "", 0, maxVal, currentVal, false, false, slider);

        this.gui = gui;
    }

    @Override
    public String getString() {
        int num = this.getValueInt() * EnumGraveMaterial.values().length;
        if (this.gui != null) {
            num += this.gui.getMaterial().ordinal();
        }
        return ModGravestoneExtended.proxy.getLocalizedString(getName(num) + ".name");
    }

    protected String getName(int num) {
        return EnumGraves.getById(num).getUnLocalizedName();
    }

    public EnumGraveType getGraveType() {
        return EnumGraveType.values()[this.getValueInt()];
    }
}