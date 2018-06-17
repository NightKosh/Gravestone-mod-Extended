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
        this.updateAutoJump(this.posX - posX, this.posZ - posZ);
    }


    // Copied from EntityPlayerSP
    protected void updateAutoJump(double posX, double posZ) {
        if (this.autoJumpTime <= 0 && this.onGround && !this.getNavigator().noPath()) {
            Vec3d vec2f = this.getNavigator().getPath().getCurrentPos();
            Vec3d vec3d = new Vec3d(this.posX, this.getEntityBoundingBox().minY, this.posZ);
            double d0 = this.posX + posX;
            double d1 = this.posZ + posZ;
            Vec3d vec3d1 = new Vec3d(d0, this.getEntityBoundingBox().minY, d1);
            Vec3d vec3d2 = new Vec3d(posX, 0, posZ);
            float f = this.getAIMoveSpeed();
            double f1 = vec3d2.lengthSquared();

            if (f1 <= 0.001) {
                double f2 = f * vec2f.x;
                double f3 = f * vec2f.z;
                float f4 = MathHelper.sin(this.rotationYaw * 0.017453292F);
                float f5 = MathHelper.cos(this.rotationYaw * 0.017453292F);
                vec3d2 = new Vec3d((f2 * f5 - f3 * f4), vec3d2.y, (f3 * f5 + f2 * f4));
                f1 = vec3d2.lengthSquared();

                if (f1 <= 0.001) {
                    return;
                }
            }

            float f12 = (float) MathHelper.fastInvSqrt(f1);
            Vec3d vec3d12 = vec3d2.scale(f12);
            Vec3d vec3d13 = this.getForward();

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

                        float f8 = Math.max(f * 7, 1 / f12);
                        Vec3d vec3d4 = vec3d1.add(vec3d12.scale(f8));
                        float f9 = this.width;
                        float f10 = this.height;
                        AxisAlignedBB axisalignedbb = (new AxisAlignedBB(vec3d, vec3d4.addVector(0, f10, 0))).grow(f9, 0, f9);
                        Vec3d lvt_19_1_ = vec3d.addVector(0, 0.51, 0);
                        vec3d4 = vec3d4.addVector(0, 0.51, 0);
                        Vec3d vec3d5 = vec3d12.crossProduct(new Vec3d(0, 1, 0));
                        Vec3d vec3d6 = vec3d5.scale(f9 * 0.5);
                        Vec3d vec3d7 = lvt_19_1_.subtract(vec3d6);
                        Vec3d vec3d8 = vec3d4.subtract(vec3d6);
                        Vec3d vec3d9 = lvt_19_1_.add(vec3d6);
                        Vec3d vec3d10 = vec3d4.add(vec3d6);
                        List<AxisAlignedBB> list = this.world.getCollisionBoxes(this, axisalignedbb);

                        float f11 = Float.MIN_VALUE;
                        label86:

                        for (AxisAlignedBB axisalignedbb2 : list) {
                            if (axisalignedbb2.intersects(vec3d7, vec3d8) || axisalignedbb2.intersects(vec3d9, vec3d10)) {
                                f11 = (float) axisalignedbb2.maxY;
                                Vec3d vec3d11 = axisalignedbb2.getCenter();
                                BlockPos blockpos1 = new BlockPos(vec3d11);
                                int i = 1;

                                while (true) {
                                    if (i >= f7) {
                                        break label86;
                                    }

                                    BlockPos blockpos2 = blockpos1.up(i);
                                    IBlockState iblockstate2 = this.world.getBlockState(blockpos2);
                                    AxisAlignedBB axisalignedbb1;

                                    if ((axisalignedbb1 = iblockstate2.getCollisionBoundingBox(this.world, blockpos2)) != null) {
                                        f11 = (float) axisalignedbb1.maxY + (float) blockpos2.getY();

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
                            double f14 = (f11 - this.getEntityBoundingBox().minY);

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
