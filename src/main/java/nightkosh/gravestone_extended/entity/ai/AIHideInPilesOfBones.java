package nightkosh.gravestone_extended.entity.ai;

import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.entity.monster.crawler.EntitySkullCrawler;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AIHideInPilesOfBones extends EntityAIWander {
    private EntitySkullCrawler crawler;
    private EnumFacing enumFacing;
    private boolean doHide;
    private int ticks;

    public AIHideInPilesOfBones(EntitySkullCrawler crawler) {
        super(crawler, 1, 10);
        this.setMutexBits(1);
        this.crawler = crawler;
    }

    @Override
    public boolean shouldExecute() {
        ticks++;
        if (ticks >= 100 && crawler.canHideInBones() && !crawler.getHideInBonesAI().isExecuting()) {
            if (crawler.getAttackTarget() != null || !crawler.getNavigator().noPath()) {
                return false;
            } else {
                Random random = crawler.getRNG();

                if (random.nextInt(10) == 0) {
                    this.enumFacing = EnumFacing.random(random);

                    BlockPos blockPos = new BlockPos(crawler.posX, crawler.posY + 0.5, crawler.posZ).offset(this.enumFacing);
                    IBlockState blockState = crawler.getEntityWorld().getBlockState(blockPos);

                    if (blockState.getBlock().isAir(blockState, crawler.getEntityWorld(), blockPos)) {
                        if (crawler.getEntityWorld().isSideSolid(blockPos.down(), EnumFacing.UP)) {
                            this.doHide = true;
                            return true;
                        }
                    }
                }

                this.doHide = false;
                return super.shouldExecute();
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean shouldContinueExecuting() {
        return !this.doHide && super.shouldContinueExecuting();
    }

    @Override
    public void startExecuting() {
        if (crawler.canHideInBones()) {
            if (!this.doHide) {
                super.startExecuting();
            } else {
                World world = crawler.getEntityWorld();
                BlockPos blockPos = new BlockPos(crawler.posX, crawler.posY + 0.5, crawler.posZ).offset(this.enumFacing);
                world.setBlockState(blockPos, GSBlock.PILE_OF_BONES.getCrawlerBlockState(), 3);
                crawler.spawnExplosionParticle();
                crawler.setDead();
            }
        }
    }
}
