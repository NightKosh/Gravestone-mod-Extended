package nightkosh.gravestone_extended.entity.monster.water;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.MobEffects;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntityWaterWalkingMob extends EntityMob {

    protected int autoJumpTime;

    public EntityWaterWalkingMob(World worldIn) {
        super(worldIn);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (this.autoJumpTime > 0) {
            this.autoJumpTime--;
            this.jump();
        }
    }

    @Override
    public void move(MoverType type, double x, double y, double z) {
        double posX = this.posX;
        double posZ = this.posZ;
        super.move(type, x, y, z);
        if (this.inWater) {
            this.updateAutoJump(this.posX - posX, this.posZ - posZ);
        }
    }


    // Copied from EntityPlayerSP
    protected void updateAutoJump(double posX, double posZ) {
        if (this.autoJumpTime <= 0 && this.onGround && !this.getNavigator().noPath()) {
            Vec3d vec2f = this.getNavigator().getPath().getCurrentPos();
            Vec3d vec3d = new Vec3d(this.posX, this.getEntityBoundingBox().minY, this.posZ);
            Vec3d vec3d1 = new Vec3d(this.posX + posX, this.getEntityBoundingBox().minY, this.posZ + posZ);
            Vec3d vec3d2 = new Vec3d(posX, 0, posZ);
            double f1 = vec3d2.lengthSquared();

            if (f1 <= 0.001) {
                double f2 = this.getAIMoveSpeed() * vec2f.x;
                double f3 = this.getAIMoveSpeed() * vec2f.z;
                float f4 = MathHelper.sin(this.rotationYaw * 0.017453292F);
                float f5 = MathHelper.cos(this.rotationYaw * 0.017453292F);
                vec3d2 = new Vec3d((f2 * f5 - f3 * f4), vec3d2.y, (f3 * f5 + f2 * f4));
                f1 = vec3d2.lengthSquared();

                if (f1 <= 0.001) {
                    return;
                }
            }

            double f12 = MathHelper.fastInvSqrt(f1);
            Vec3d vec3d12 = vec3d2.scale(f12);
            Vec3d vec3d13 = Vec3d.fromPitchYaw(this.rotationPitch, this.rotationYaw);

            if (vec3d13.x * vec3d12.x + vec3d13.z * vec3d12.z >= -0.15) {
                BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().maxY, this.posZ);
                IBlockState iblockstate = this.world.getBlockState(blockpos);

                if (iblockstate.getCollisionBoundingBox(this.world, blockpos) == null) {
                    blockpos = blockpos.up();
                    IBlockState iblockstate1 = this.world.getBlockState(blockpos);

                    if (iblockstate1.getCollisionBoundingBox(this.world, blockpos) == null) {
                        double f7 = 1.2;

                        if (this.isPotionActive(MobEffects.JUMP_BOOST)) {
                            f7 +=  (this.getActivePotionEffect(MobEffects.JUMP_BOOST).getAmplifier() + 1) * 0.75;
                        }

                        Vec3d vec3d4 = vec3d1.add(vec3d12.scale(Math.max(this.getAIMoveSpeed() * 7, 1 / f12)));
                        Vec3d maxV = vec3d4.addVector(0, this.height, 0);
                        AxisAlignedBB axisalignedbb = new AxisAlignedBB(vec3d.x, vec3d.y, vec3d.z, maxV.x, maxV.y, maxV.z).grow(this.width, 0, this.width);

                        Vec3d lvt_19_1_ = vec3d.addVector(0, 0.51, 0);
                        vec3d4 = vec3d4.addVector(0, 0.51, 0);
                        Vec3d vec3d6 = vec3d12.crossProduct(new Vec3d(0, 1, 0)).scale(this.width * 0.5);
                        Vec3d vec3d7 = lvt_19_1_.subtract(vec3d6);
                        Vec3d vec3d8 = vec3d4.subtract(vec3d6);
                        Vec3d vec3d9 = lvt_19_1_.add(vec3d6);
                        Vec3d vec3d10 = vec3d4.add(vec3d6);
                        List<AxisAlignedBB> list = this.world.getCollisionBoxes(this, axisalignedbb);

                        double f11 = Float.MIN_VALUE;
                        label86:

                        for (AxisAlignedBB axisAlignedBB2 : list) {

                            if (axisAlignedBB2.intersects(Math.min(vec3d7.x, vec3d8.x), Math.min(vec3d7.y, vec3d8.y), Math.min(vec3d7.z, vec3d8.z),
                                        Math.max(vec3d7.x, vec3d8.x), Math.max(vec3d7.y, vec3d8.y), Math.max(vec3d7.z, vec3d8.z)) ||
                                    axisAlignedBB2.intersects(Math.min(vec3d9.x, vec3d10.x), Math.min(vec3d9.y, vec3d10.y), Math.min(vec3d9.z, vec3d10.z),
                                        Math.max(vec3d9.x, vec3d10.x), Math.max(vec3d9.y, vec3d10.y), Math.max(vec3d9.z, vec3d10.z))) {
                                f11 = axisAlignedBB2.maxY;
                                Vec3d vec3d11 = new Vec3d(axisAlignedBB2.minX + (axisAlignedBB2.maxX - axisAlignedBB2.minX) * 0.5,
                                        axisAlignedBB2.minY + (axisAlignedBB2.maxY - axisAlignedBB2.minY) * 0.5,
                                        axisAlignedBB2.minZ + (axisAlignedBB2.maxZ - axisAlignedBB2.minZ) * 0.5);
                                BlockPos blockPos1 = new BlockPos(vec3d11);
                                int i = 1;

                                while (true) {
                                    if (i >= f7) {
                                        break label86;
                                    }

                                    BlockPos blockPos2 = blockPos1.up(i);
                                    AxisAlignedBB axisAlignedBB1 = this.world.getBlockState(blockPos2).getCollisionBoundingBox(this.world, blockPos2);

                                    if (axisAlignedBB1 != null) {
                                        f11 = axisAlignedBB1.maxY + blockPos2.getY();

                                        if (f11 - this.getEntityBoundingBox().minY > f7) {
                                            return;
                                        }
                                    }

                                    if (i > 1) {
                                        blockpos = blockpos.up();
                                        if (this.world.getBlockState(blockpos).getCollisionBoundingBox(this.world, blockpos) != null) {
                                            return;
                                        }
                                    }

                                    i++;
                                }
                            }
                        }

                        if (f11 != Float.MIN_VALUE) {
                            double f14 = f11 - this.getEntityBoundingBox().minY;

                            if (f14 > 0.5 && f14 <= f7) {
                                this.autoJumpTime = 1;
                            }
                        }
                    }
                }
            }
        }
    }
}
