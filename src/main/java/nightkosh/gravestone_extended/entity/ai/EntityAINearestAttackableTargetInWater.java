package nightkosh.gravestone_extended.entity.ai;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Predicate;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntityAINearestAttackableTargetInWater{//TODO <T extends EntityLivingBase> extends EntityAINearestAttackableTarget {

//    protected final int targetChance;
//
//    public EntityAINearestAttackableTargetInWater(EntityCreature creature, Class classTarget, boolean checkSight) {
//        this(creature, classTarget, checkSight, false);
//    }
//
//    public EntityAINearestAttackableTargetInWater(EntityCreature creature, Class classTarget, boolean checkSight, boolean onlyNearby) {
//        this(creature, classTarget, 10, checkSight, onlyNearby, null);
//    }
//
//    public EntityAINearestAttackableTargetInWater(EntityCreature creature, Class classTarget, int chance, boolean checkSight, boolean onlyNearby, @Nullable Predicate targetSelector) {
//        super(creature, classTarget, chance, checkSight, onlyNearby, targetSelector);
//        this.targetChance = chance;
//    }
//
//    public boolean shouldExecute() {
//        if (this.targetChance > 0 && this.taskOwner.getRNG().nextInt(this.targetChance) != 0) {
//            return false;
//        } else if (this.targetClass != EntityPlayer.class && this.targetClass != EntityPlayerMP.class) {
//            List<T> list = this.taskOwner.world.getEntitiesWithinAABB(this.targetClass, this.getTargetableArea(this.getTargetDistance()), this.targetEntitySelector);
//
//            if (list.isEmpty()) {
//                return false;
//            } else {
//                Collections.sort(list, this.sorter);
//                this.targetEntity = list.get(0);
//                return true;
//            }
//        } else {
//            this.targetEntity = getNearestAttackablePlayerInWater(this.taskOwner.world, this.taskOwner.posX, this.taskOwner.posY + this.taskOwner.getEyeHeight(), this.taskOwner.posZ,
//                    this.getTargetDistance(), this.getTargetDistance(), player -> {
//                        ItemStack itemstack = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
//
//                        if (itemstack.getItem() == Items.SKULL) {
//                            int i = itemstack.getItemDamage();
//                            boolean flag = EntityAINearestAttackableTargetInWater.this.taskOwner instanceof EntitySkeleton && i == 0;
//                            boolean flag1 = EntityAINearestAttackableTargetInWater.this.taskOwner instanceof EntityZombie && i == 2;
//                            boolean flag2 = EntityAINearestAttackableTargetInWater.this.taskOwner instanceof EntityCreeper && i == 4;
//
//                            if (flag || flag1 || flag2) {
//                                return 0.5;
//                            }
//                        }
//
//                        return 1D;
//                    }, (Predicate<EntityPlayer>) this.targetEntitySelector);
//            return this.targetEntity != null;
//        }
//    }
//
//
//    @Nullable
//    public EntityPlayer getNearestAttackablePlayerInWater(World world, double posX, double posY, double posZ,
//                                                          double maxXZDistance, double maxYDistance,
//                                                          @Nullable Function<EntityPlayer, Double> playerToDouble,
//                                                          @Nullable Predicate<EntityPlayer> playerPrediate) {
//        double minDistanceToPlayer = -1;
//        EntityPlayer entityplayer = null;
//
//        for (int j2 = 0; j2 < world.playerEntities.size(); j2++) {
//            EntityPlayer player = world.playerEntities.get(j2);
//
//            if (!player.capabilities.disableDamage && player.isEntityAlive() && !player.isSpectator() && player.isInWater() && (playerPrediate == null || playerPrediate.apply(player))) {
//                double distanceToPlayer = player.getDistanceSq(posX, player.posY, posZ);
//                double maxXZdist = maxXZDistance;
//
//                if (player.isSneaking()) {
//                    maxXZdist = maxXZDistance * 0.8;
//                }
//
//                if (player.isInvisible()) {
//                    float f = player.getArmorVisibility();
//                    if (f < 0.1) {
//                        f = 0.1F;
//                    }
//
//                    maxXZdist *= 0.7F * f;
//                }
//
//                if (playerToDouble != null) {
//                    maxXZdist *= MoreObjects.firstNonNull(playerToDouble.apply(player), (double) 1);
//                }
//
//                maxXZdist = net.minecraftforge.common.ForgeHooks.getPlayerVisibilityDistance(player, maxXZdist, maxYDistance);
//
//                if ((maxYDistance < 0 || Math.abs(player.posY - posY) < maxYDistance * maxYDistance) && (maxXZDistance < 0 || distanceToPlayer < maxXZdist * maxXZdist) && (minDistanceToPlayer == -1 || distanceToPlayer < minDistanceToPlayer)) {
//                    minDistanceToPlayer = distanceToPlayer;
//                    entityplayer = player;
//                }
//            }
//        }
//
//        return entityplayer;
//    }
}
