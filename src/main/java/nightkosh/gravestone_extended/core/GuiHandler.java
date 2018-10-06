package nightkosh.gravestone_extended.core;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.gui.*;
import nightkosh.gravestone_extended.gui.container.*;
import nightkosh.gravestone_extended.tileentity.TileEntityAltar;
import nightkosh.gravestone_extended.tileentity.TileEntityExecution;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GuiHandler extends nightkosh.gravestone.core.GuiHandler {

    public static final int ALTAR_RESURRECTION_GUI_ID = 1;
    public static final int CHISEL_CRAFTING_GUI_ID = 2;
    public static final int EXECUTION_GUI_ID = 3;
    public static final int ALTAR_DISENCHANTMENT_GUI_ID = 4;
    public static final int ALTAR_ENCHANTMENT_GUI_ID = 5;

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity;
        switch (id) {
            case ALTAR_RESURRECTION_GUI_ID:
                tileEntity = world.getTileEntity(new BlockPos(x, y, z));
                if (tileEntity instanceof TileEntityAltar) {
                    return new AltarResurrectionContainer(player.inventory, ((TileEntityAltar) tileEntity).getCorpseInventory());
                }
                break;
            case ALTAR_DISENCHANTMENT_GUI_ID:
                tileEntity = world.getTileEntity(new BlockPos(x, y, z));
                if (tileEntity instanceof TileEntityAltar) {
                    return new AltarDisenchantmentContainer(player.inventory, ((TileEntityAltar) tileEntity).getDisenchantmentInventory());
                }
                break;
            case ALTAR_ENCHANTMENT_GUI_ID:
                tileEntity = world.getTileEntity(new BlockPos(x, y, z));
                if (tileEntity instanceof TileEntityAltar) {
                    return new AltarEnchantmentContainer(player.inventory, ((TileEntityAltar) tileEntity).getEnchantmentInventory());
                }
                break;
            case CHISEL_CRAFTING_GUI_ID:
                return new ChiselContainer(player, player.inventory);
            case EXECUTION_GUI_ID:
                tileEntity = world.getTileEntity(new BlockPos(x, y, z));
                if (tileEntity instanceof TileEntityExecution) {
                    return new ExecutionContainer(player.inventory, (TileEntityExecution) tileEntity);
                }
                break;
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity;
        switch (id) {
            case ALTAR_RESURRECTION_GUI_ID:
                tileEntity = world.getTileEntity(new BlockPos(x, y, z));
                if (tileEntity instanceof TileEntityAltar) {
                    return new AltarResurrectionGui(player.inventory, (TileEntityAltar) tileEntity);
                }
                break;
            case ALTAR_DISENCHANTMENT_GUI_ID:
                tileEntity = world.getTileEntity(new BlockPos(x, y, z));
                if (tileEntity instanceof TileEntityAltar) {
                    return new AltarDisenchantmentGui(player.inventory, (TileEntityAltar) tileEntity);
                }
                break;
            case ALTAR_ENCHANTMENT_GUI_ID:
                tileEntity = world.getTileEntity(new BlockPos(x, y, z));
                if (tileEntity instanceof TileEntityAltar) {
                    return new AltarEnchantmentGui(player.inventory, (TileEntityAltar) tileEntity);
                }
                break;
            case CHISEL_CRAFTING_GUI_ID:
                return new GSChiselCraftingGui(player, player.inventory);
            case EXECUTION_GUI_ID:
                tileEntity = world.getTileEntity(new BlockPos(x, y, z));
                if (tileEntity instanceof TileEntityExecution) {
                    return new ExecutionGui(player.inventory, (TileEntityExecution) tileEntity);
                }
                break;
        }
        return null;
    }
}
