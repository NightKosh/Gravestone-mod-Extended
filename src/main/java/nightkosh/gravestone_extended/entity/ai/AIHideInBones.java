package nightkosh.gravestone_extended.entity.ai;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AIHideInBones {//TODO extends EntityAIWander {
//    private EntitySkullCrawler crawler;
//    private EnumFacing enumFacing;
//    private boolean doMerge;
//    private boolean isExecuting = false;
//    private int ticks;
//
//    public AIHideInBones(EntitySkullCrawler crawler) {
//        super(crawler, 1, 10);
//        this.setMutexBits(1);
//        this.crawler = crawler;
//    }
//
//    @Override
//    public boolean shouldExecute() {
//        ticks++;
//        if (ticks >= 200 && crawler.canHideInBones()) {
//            if (crawler.getAttackTarget() != null || !crawler.getNavigator().noPath()) {
//                return false;
//            } else {
//                Random random = crawler.getRNG();
//
//                if (random.nextInt(10) == 0) {
//                    this.enumFacing = EnumFacing.random(random);
//                    BlockPos blockPos = (new BlockPos(crawler.posX, crawler.posY + 0.5, crawler.posZ)).offset(this.enumFacing);
//                    IBlockState blockState = crawler.getEntityWorld().getBlockState(blockPos);
//
//                    if (BlockBoneBlock.canContainCrawler(blockState)) {
//                        this.doMerge = true;
//                        return true;
//                    }
//                }
//
//                this.doMerge = false;
//                return super.shouldExecute();
//            }
//        } else {
//            return false;
//        }
//    }
//
//    @Override
//    public boolean shouldContinueExecuting() {
//        boolean continueExecuting = !this.doMerge && super.shouldContinueExecuting();
//        if (!continueExecuting) {
//            isExecuting = false;
//        }
//
//        return continueExecuting;
//    }
//
//    @Override
//    public void startExecuting() {
//        if (crawler.canHideInBones()) {
//            if (!this.doMerge) {
//                super.startExecuting();
//            } else {
//                isExecuting = true;
//                World world = crawler.getEntityWorld();
//                BlockPos blockPos = (new BlockPos(crawler.posX, crawler.posY + 0.5D, crawler.posZ)).offset(this.enumFacing);
//                IBlockState blockState = world.getBlockState(blockPos);
//                if (BlockBoneBlock.canContainCrawler(blockState)) {
//                    world.setBlockState(blockPos, GSBlock.BONE_BLOCK.getCrawlerBlockState(blockState), 3);
//                    crawler.spawnExplosionParticle();
//                    crawler.setDead();
//                }
//            }
//        }
//    }
//
//    public boolean isExecuting() {
//        return isExecuting;
//    }
}
