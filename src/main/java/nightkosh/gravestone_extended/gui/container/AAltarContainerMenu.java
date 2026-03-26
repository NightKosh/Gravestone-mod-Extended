package nightkosh.gravestone_extended.gui.container;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.BlockEntity;
import nightkosh.gravestone_extended.block_entity.AltarBlockEntity;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class AAltarContainerMenu extends AbstractContainerMenu {

    public final AltarBlockEntity altar;

    protected AAltarContainerMenu(MenuType menuType, int containerId, BlockEntity blockEntity) {
        super(menuType, containerId);
        this.altar = ((AltarBlockEntity) blockEntity);
    }

    public abstract int getRequiredLevel();

}
