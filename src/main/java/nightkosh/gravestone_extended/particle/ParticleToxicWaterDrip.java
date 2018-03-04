package nightkosh.gravestone_extended.particle;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleDrip;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone_extended.core.GSParticles;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ParticleToxicWaterDrip extends ParticleDrip {

    private int bobTimer;

    protected ParticleToxicWaterDrip(World world, double x, double y, double z, Material material) {
        super(world, x, y, z, material);
        this.bobTimer = 40;
    }

    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        this.particleRed = 0.153F;
        this.particleGreen = 1;
        this.particleBlue = 0;

        this.motionY -= this.particleGravity;

        if (this.bobTimer-- > 0) {
            this.motionX *= 0.02;
            this.motionY *= 0.02;
            this.motionZ *= 0.02;
            this.setParticleTextureIndex(113);
        } else {
            this.setParticleTextureIndex(112);
        }

        this.move(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.98;
        this.motionY *= 0.98;
        this.motionZ *= 0.98;

        if (this.particleMaxAge-- <= 0) {
            this.setExpired();
        }

        if (this.onGround) {
            this.setExpired();
            this.world.spawnParticle(GSParticles.TOXIC_WATER_SPLASH, this.posX, this.posY, this.posZ, 0, 0, 0);


            this.motionX *= 0.7;
            this.motionZ *= 0.7;
        }

        BlockPos blockpos = new BlockPos(this.posX, this.posY, this.posZ);
        IBlockState iblockstate = this.world.getBlockState(blockpos);
        Material material = iblockstate.getMaterial();

        if (material.isLiquid() || material.isSolid()) {

            double d1 = MathHelper.floor(this.posY) + 1;

            if (iblockstate.getBlock() instanceof BlockLiquid) {
                d1 -= BlockLiquid.getLiquidHeightPercent(iblockstate.getValue(BlockLiquid.LEVEL));
            }

            if (this.posY < d1) {
                this.setExpired();
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public static class Factory implements IParticleFactory {
        public Particle createParticle(int particleID, World world, double x, double z, double y, double xSpeedIn, double ySpeedIn, double zSpeedIn, int... p_178902_15_) {
            return new ParticleToxicWaterDrip(world, x, z, y, Material.WATER);
        }
    }
}
