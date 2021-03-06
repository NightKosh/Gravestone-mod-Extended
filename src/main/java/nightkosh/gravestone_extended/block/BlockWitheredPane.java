package nightkosh.gravestone_extended.block;

import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone_extended.core.GSTabs;
import nightkosh.gravestone_extended.core.ModInfo;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockWitheredPane extends BlockPane {

    public BlockWitheredPane() {
        super(Material.GLASS, false);
        this.setHardness(30);
        this.setResistance(2000);
        this.setHarvestLevel("pickaxe", 3);
        this.setUnlocalizedName("withered_glass_pane");
        this.setRegistryName(ModInfo.ID, "gs_withered_glass_pane");
        this.setCreativeTab(GSTabs.otherItemsTab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean canEntityDestroy(IBlockState state, IBlockAccess world, BlockPos pos, Entity entity) {
        return false;
    }
}
