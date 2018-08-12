package nightkosh.gravestone_extended.core.proxy;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nightkosh.gravestone.tileentity.TileEntityGrave;
import nightkosh.gravestone_extended.tileentity.*;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CommonProxy {

    public void registerEggs() {
    }

    public void registerMobsRenderers() {
    }

    public String getLocalizedString(String str) {
        return str;
    }

    public String getLocalizedEntityName(String str) {
        return str;
    }

    public void openGraveTextGui(TileEntityGrave tileEntity) {
    }

    public void registerHandlers() {
    }

    public void registerFluidRenderers(Block block, ModelResourceLocation modelResourceLocation) {

    }

    public void registerTERenderers() {
        GameRegistry.registerTileEntity(TileEntityMemorial.class, "Memorial");
        GameRegistry.registerTileEntity(TileEntityExecution.class, "Execution");
        GameRegistry.registerTileEntity(TileEntitySpawner.class, "GS Spawner");
        GameRegistry.registerTileEntity(TileEntityHauntedChest.class, "GSHaunted Chest");
        GameRegistry.registerTileEntity(TileEntitySkullCandle.class, "GSSkull Candle");
        GameRegistry.registerTileEntity(TileEntityPileOfBones.class, "GSTEPileOfBones");
        GameRegistry.registerTileEntity(TileEntityAltar.class, "GSAltarTE");
        GameRegistry.registerTileEntity(TileEntityCorpse.class, "GSTECorpse");//TODO ?????
    }

    public void registerParticles() {

    }
}
