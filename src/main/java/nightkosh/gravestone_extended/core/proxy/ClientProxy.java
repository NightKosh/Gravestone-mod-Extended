package nightkosh.gravestone_extended.core.proxy;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ClientProxy {//TODO extends CommonProxy {
//
//    @Override
//    public void registerTERenderers() {
//        // register Memorials renderers
//        ClientRegistry.registerTileEntity(TileEntityMemorial.class, "GSMemorial", new TileEntityMemorialRenderer());
//
//        // register Execution renderers
//        ClientRegistry.registerTileEntity(TileEntityExecution.class, "GSExecution", new TileEntityExecutionRenderer());
//
//        // register HauntedChest renderer
//        ClientRegistry.registerTileEntity(TileEntityHauntedChest.class, "GSHauntedChest", new TileEntityHauntedChestRenderer());
//    }
//
//    @Override
//    public void registerFluidRenderers(Block block, ModelResourceLocation modelResourceLocation) {
//        ModelLoader.setCustomStateMapper(block, new StateMapperBase() {
//            protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
//                return modelResourceLocation;
//            }
//        });
//    }
//
//    @Override
//    public void registerParticles() {
//        Minecraft.getMinecraft().effectRenderer.registerParticle(GSParticles.GREEN_FLAME.getParticleID(), new ParticleGreenFlameFX.Factory());
//        Minecraft.getMinecraft().effectRenderer.registerParticle(GSParticles.CATACOMBS_PORTAL.getParticleID(), new ParticleCatacombsPortal.Factory());
//        Minecraft.getMinecraft().effectRenderer.registerParticle(GSParticles.TOXIC_WATER_DRIP.getParticleID(), new ParticleToxicWaterDrip.Factory());
//        Minecraft.getMinecraft().effectRenderer.registerParticle(GSParticles.TOXIC_WATER_SPLASH.getParticleID(), new ParticleToxicWaterSplash.Factory());
//        Minecraft.getMinecraft().effectRenderer.registerParticle(GSParticles.TOXIC_WATER_BUBBLE.getParticleID(), new ParticleToxicWaterBubble.Factory());
//        Minecraft.getMinecraft().effectRenderer.registerParticle(GSParticles.TOXIC_WATER_WAKE.getParticleID(), new ParticleToxicWaterWake.Factory());
//    }
//
//    @Override
//    public void addModelRotationsAndTEISR() {
//        Class<?>[] rotationParams = {
//                int.class, int.class
//        };
//        ModelRotation X0_Y45 = EnumHelper.addEnum(ModelRotation.class, "X0_Y45", rotationParams, 0, 45);
//        ModelRotation X0_Y135 = EnumHelper.addEnum(ModelRotation.class, "X0_Y135", rotationParams, 0, 135);
//        ModelRotation X0_Y225 = EnumHelper.addEnum(ModelRotation.class, "X0_Y225", rotationParams, 0, 225);
//        ModelRotation X0_Y315 = EnumHelper.addEnum(ModelRotation.class, "X0_Y315", rotationParams, 0, 315);
//
//        ModelRotation.MAP_ROTATIONS.put(Integer.valueOf(X0_Y45.combinedXY), X0_Y45);
//        ModelRotation.MAP_ROTATIONS.put(Integer.valueOf(X0_Y135.combinedXY), X0_Y135);
//        ModelRotation.MAP_ROTATIONS.put(Integer.valueOf(X0_Y225.combinedXY), X0_Y225);
//        ModelRotation.MAP_ROTATIONS.put(Integer.valueOf(X0_Y315.combinedXY), X0_Y315);
//
//
//        //memorials
//        registerTEISR(EnumMemorials.WOODEN_CROSS.ordinal(), EnumMemorials.ICE_CREEPER_STATUE.ordinal(),
//                GSBlock.MEMORIAL_IB, new TEISRMemorial(), GSBlock.MEMORIAL, ResourcesModels.MEMORIAL);
//        //executions
//        registerTEISR(EnumExecution.GALLOWS.ordinal(), EnumExecution.BURNING_STAKE.ordinal(),
//                GSBlock.EXECUTION_IB, new TEISRExecution(), GSBlock.EXECUTION, ResourcesModels.EXECUTION);
//        //spawners
//        registerTEISR(EnumSpawner.WITHER_SPAWNER.ordinal(), EnumSpawner.SPIDER_SPAWNER.ordinal(),
//                GSBlock.SPAWNER_IB, new TEISRSpawner(), GSBlock.SPAWNER, ResourcesModels.SPAWNER);
//        //corpses
//        registerTEISR(EnumCorpse.STEVE.ordinal(), EnumCorpse.WITCH.ordinal(),
//                GSBlock.CORPSE_IB, new TEISRCorpse(), GSBlock.CORPSE, ResourcesModels.CORPSE);
//    }
//
//
//    private static void registerTEISR(int startMeta, int endMeta, Item item, TileEntityItemStackRenderer renderer, Block block, ModelResourceLocation model) {
//        item.setTileEntityItemStackRenderer(renderer);
//        for (int meta = startMeta; meta <= endMeta; meta++) {
//            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, model);
//        }
//    }
}
