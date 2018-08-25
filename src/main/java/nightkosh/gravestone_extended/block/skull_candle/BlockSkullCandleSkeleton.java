package nightkosh.gravestone_extended.block.skull_candle;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone_extended.core.GSTabs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.helper.TimeHelper;
import nightkosh.gravestone_extended.particle.ParticleGreenFlameFX;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockSkullCandleSkeleton extends Block {

    public static final PropertyEnum FACING = PropertyEnum.create("facing", EnumAdvancedFacing.class);

    public static enum EnumAdvancedFacing implements IStringSerializable {
        SOUTH("south"),
        SOUTH_WEST("south_west"),
        WEST("west"),
        WEST_NORTH("west_north"),
        NORTH("north"),
        NORTH_EAST("north_east"),
        EAST("east"),
        EAST_SOUTH("east_south");

        private String facing;

        private EnumAdvancedFacing(String facing) {
            this.facing = facing;
        }

        @Override
        public String getName() {
            return facing;
        }

        public static EnumAdvancedFacing getById(int id) {
            if (id < values().length) {
                return values()[id];
            }
            return NORTH;
        }
    }

    public BlockSkullCandleSkeleton() {
        this("gsskullcandle");
    }

    public BlockSkullCandleSkeleton(String registryName) {
        super(Material.CIRCUITS);
        this.setSoundType(SoundType.STONE);
        this.setHardness(0.5F);
        this.setResistance(5);
        this.setLightLevel(1);
        this.setCreativeTab(GSTabs.otherItemsTab);
        this.setRegistryName(ModInfo.ID, registryName);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    private static final AxisAlignedBB BB = new AxisAlignedBB(0.25, 0, 0.25, 0.75, 0.5, 0.75);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess access, BlockPos pos) {
        return BB;
    }

    @Override
    public int damageDropped(IBlockState state) {
        return 0;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumAdvancedFacing.getById(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((EnumAdvancedFacing) state.getValue(FACING)).ordinal();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{FACING});
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack stack) {
        double skullRotation = entity.rotationYaw - 180 - 22.5;
        if (skullRotation < 0) {
            skullRotation = 360 + skullRotation % 360;
        } else if (skullRotation > 360) {
            skullRotation = skullRotation % 360;
        }
        int id = MathHelper.ceil(skullRotation * 8 / 360D);
        if (id == EnumAdvancedFacing.values().length) {
            id = 0;
        }
        world.setBlockState(pos, this.getDefaultState().withProperty(FACING, EnumAdvancedFacing.getById(id)), 2);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random) {
        double xPos = pos.getX() + 0.5;
        double yPos = pos.getY() + 0.85;
        double zPos = pos.getZ() + 0.5;
        double rotation = Math.toRadians(((EnumAdvancedFacing) state.getValue(FACING)).ordinal() * 360 / 8D);
        double d = -0.1;
        double dx = -Math.sin(rotation) * d;
        double dz = Math.cos(rotation) * d;

        long dayTime = TimeHelper.getDayTime(world);
        if (dayTime < TimeHelper.SUN_SET || dayTime > TimeHelper.SUN_RISING) {
            world.spawnParticle(EnumParticleTypes.FLAME, xPos + dx, yPos, zPos + dz, 0, 0, 0);
        } else {
            Particle entityFx = new ParticleGreenFlameFX(world, xPos + dx, yPos, zPos + dz, 0, 0, 0);
            Minecraft.getMinecraft().effectRenderer.addEffect(entityFx);
        }

        world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, xPos + dx, yPos, zPos + dz, 0, 0, 0);
    }
}
