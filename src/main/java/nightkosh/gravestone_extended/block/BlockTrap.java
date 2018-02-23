package nightkosh.gravestone_extended.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone_extended.ModGravestoneExtended;
import nightkosh.gravestone_extended.block.enums.EnumTrap;
import nightkosh.gravestone_extended.config.ExtendedConfig;
import nightkosh.gravestone_extended.core.GSDimensions;
import nightkosh.gravestone_extended.core.GSPotion;
import nightkosh.gravestone_extended.core.GSTabs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.helper.TimeHelper;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockTrap extends Block {

    public static final PropertyEnum VARIANT = PropertyEnum.create("variant", EnumTrap.class);
    public static final String NIGHT_STONE_CURSE_TEXT = "block.trap.curse";

    public BlockTrap() {
        super(Material.ROCK);
        this.setSoundType(SoundType.STONE);
        this.setHardness(4.5F);
        this.setResistance(5);
        this.setCreativeTab(GSTabs.otherItemsTab);
        this.setHarvestLevel("pickaxe", 1);
        this.setRegistryName(ModInfo.ID, "gstrap");
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    @Override
    public Item getItemDropped(IBlockState state, Random random, int fortune) {
        switch ((EnumTrap) state.getValue(VARIANT)) {
            case THUNDER_STONE:
                return Item.getItemFromBlock(Blocks.STONEBRICK);
            case NIGHT_STONE:
            default:
                return Item.getItemFromBlock(Blocks.NETHER_BRICK);
        }
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and
     * wood.
     */
    @Override
    public int damageDropped(IBlockState state) {
        return ((Enum) state.getValue(VARIANT)).ordinal();
    }

    /**
     * Return true if a player with Silk Touch can harvest this block directly,
     * and not its normal drops.
     */
    @Override
    public boolean canSilkHarvest() {
        return true;
    }

    @Override
    public void onEntityWalk(World world, BlockPos pos, Entity entity) {
        if (entity instanceof EntityPlayer) {
            IBlockState state = world.getBlockState(pos);
            if (state.getValue(VARIANT) == EnumTrap.NIGHT_STONE) {
                if (ExtendedConfig.enableNightStone) {
                    if (world.provider.getDimension() != GSDimensions.CATACOMBS.getId()) {
                        long time = world.getWorldTime();
                        long dayTime = TimeHelper.getDayTime(time);
                        if (dayTime < TimeHelper.PRE_NIGHT || dayTime > TimeHelper.PRE_MORNING) {
                            time = time - dayTime + TimeHelper.PRE_NIGHT;
                            world.setWorldTime(time);
                            if (ExtendedConfig.showNightStoneMessage) {
                                entity.sendMessage(new TextComponentTranslation(ModGravestoneExtended.proxy.getLocalizedString(NIGHT_STONE_CURSE_TEXT)));
                            }
                        } else if (dayTime > 20000 && dayTime < TimeHelper.PRE_MORNING) {
                            time = time - dayTime + TimeHelper.NIGHT;
                            world.setWorldTime(time);
                        }
                    }
                    ((EntityPlayer) entity).addPotionEffect(new PotionEffect(GSPotion.CURSE, 1200));
                }
            } else {
                if (ExtendedConfig.enableThunderStone) {
                    if (!world.isThundering() || world.getWorldInfo().getThunderTime() < 1000) {
                        world.getWorldInfo().setRaining(true);
                        world.getWorldInfo().setRainTime(10000);
                        world.getWorldInfo().setThundering(true);
                        world.getWorldInfo().setThunderTime(10000);
                    }
                }
            }
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(VARIANT, EnumTrap.getById((byte) meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((EnumTrap) state.getValue(VARIANT)).ordinal();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{VARIANT});
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
        Item item = Item.getItemFromBlock(this);
        for (byte meta = 0; meta < EnumTrap.values().length; meta++) {
            list.add(new ItemStack(item, 1, meta));
        }
    }
}
