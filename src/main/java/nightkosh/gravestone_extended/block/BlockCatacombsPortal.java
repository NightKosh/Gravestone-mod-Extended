package nightkosh.gravestone_extended.block;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockCatacombsPortal {//TODO extends BlockPortal {
//
//    public BlockCatacombsPortal() {
//        super();
//        this.setHardness(Float.MAX_VALUE);
//        this.setResistance(Float.MAX_VALUE);
//        this.setUnlocalizedName("catacombs_portal");
//        this.setRegistryName(ModInfo.ID, "gs_catacombs_portal");
//        this.setCreativeTab(GSTabs.otherItemsTab);
//    }
//
//    @Override
//    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
//    }
//
//    @Override
//    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
//    }
//
//    @Override
//    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
//        if (!entity.isRiding() && !entity.isBeingRidden() && entity.isNonBoss()) {
//            if (!entity.world.isRemote && entity instanceof EntityPlayerMP) {
//                EntityPlayerMP player = (EntityPlayerMP) entity;
//                MinecraftServer minecraftServer = player.getServer();
//                int dimensionId = world.provider.getDimension();
//                int dimensionIn;
//
//                if (player.timeUntilPortal > 0) {
//                    player.timeUntilPortal = 10;
//                } else {
//                    player.invulnerableDimensionChange = true;
//                    if (dimensionId == GSDimensions.CATACOMBS.getId()) {
//                        dimensionIn = 0;
//                    } else {
//                        dimensionIn = GSDimensions.CATACOMBS.getId();
//                    }
//
//                    player.timeUntilPortal = 10;
//                    minecraftServer.getPlayerList().transferPlayerToDimension(player, dimensionIn, new TeleporterCatacombs(minecraftServer.getWorld(dimensionIn)));
//                }
//            }
//        }
//    }
//
//    @Override
//    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack stack) {
//        world.setBlockState(pos, state.withProperty(AXIS, EnumFacing.fromAngle(entity.rotationYaw).rotateY().getAxis()), 2);
//    }
//
//    @Override
//    @SideOnly(Side.CLIENT)
//    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
//        if (rand.nextInt(100) == 0) {
//            world.playSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
//        }
//
//        for (int i = 0; i < 4; ++i) {
//            double x = pos.getX() + rand.nextFloat();
//            double y = pos.getY() + rand.nextFloat();
//            double z = pos.getZ() + rand.nextFloat();
//            double d3 = (rand.nextFloat() - 0.5) * 0.5;
//            double d4 = (rand.nextFloat() - 0.5) * 0.5;
//            double d5 = (rand.nextFloat() - 0.5) * 0.5;
//            int j = rand.nextInt(2) * 2 - 1;
//
//            if (world.getBlockState(pos.west()).getBlock() != this && world.getBlockState(pos.east()).getBlock() != this) {
//                x = pos.getX() + 0.5 + 0.25 * j;
//                d3 = rand.nextFloat() * 2 * j;
//            } else {
//                z = pos.getZ() + 0.5 + 0.25 * j;
//                d5 = rand.nextFloat() * 2 * j;
//            }
//
//            world.spawnParticle(GSParticles.CATACOMBS_PORTAL, x, y, z, d3, d4, d5);
//        }
//    }
}
