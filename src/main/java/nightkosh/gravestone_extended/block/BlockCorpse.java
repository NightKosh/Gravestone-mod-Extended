package nightkosh.gravestone_extended.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone_extended.block.enums.EnumCorpse;
import nightkosh.gravestone_extended.core.GSTabs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.item.corpse.CorpseHelper;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockCorpse extends Block {

    public BlockCorpse() {
        super(Material.CARPET);
        this.setUnlocalizedName("Corpse");
        this.setHardness(0);
        this.setCreativeTab(GSTabs.corpseTab);
        this.setRegistryName(ModInfo.ID, "gscorpse");
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
        return null;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
        Item item = Item.getItemFromBlock(this);
        if (Minecraft.getMinecraft().world != null) {
            Minecraft.getMinecraft().world.playerEntities.forEach(player -> {
                list.add(CorpseHelper.getDefaultPlayerCorpse(player.getGameProfile()));
            });
        }
        for (int damage = 0; damage < EnumCorpse.values().length; damage++) {
            list.addAll(CorpseHelper.getDefaultCorpse(damage));
        }
    }
}
