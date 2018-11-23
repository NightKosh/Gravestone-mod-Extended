package nightkosh.gravestone_extended.core.proxy;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.model.ModelRotation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.Item;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import nightkosh.gravestone.tileentity.TileEntityGrave;
import nightkosh.gravestone_extended.block.enums.EnumCorpse;
import nightkosh.gravestone_extended.block.enums.EnumExecution;
import nightkosh.gravestone_extended.block.enums.EnumMemorials;
import nightkosh.gravestone_extended.block.enums.EnumSpawner;
import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.core.GSItem;
import nightkosh.gravestone_extended.core.GSParticles;
import nightkosh.gravestone_extended.core.ResourcesModels;
import nightkosh.gravestone_extended.core.event.RenderEventHandler;
import nightkosh.gravestone_extended.entity.EntityRaven;
import nightkosh.gravestone_extended.entity.helper.EntityGroupOfGravesMobSpawnerHelper;
import nightkosh.gravestone_extended.entity.monster.*;
import nightkosh.gravestone_extended.entity.monster.bat.EntityVampireBat;
import nightkosh.gravestone_extended.entity.monster.bat.EntityWitheredBat;
import nightkosh.gravestone_extended.entity.monster.crawler.*;
import nightkosh.gravestone_extended.entity.monster.crawler.EntitySkullCrawler.SkullCrawlerType;
import nightkosh.gravestone_extended.entity.monster.horse.EntitySkeletonHorse;
import nightkosh.gravestone_extended.entity.monster.horse.EntityZombieHorse;
import nightkosh.gravestone_extended.entity.monster.pet.EntitySkeletonCat;
import nightkosh.gravestone_extended.entity.monster.pet.EntitySkeletonDog;
import nightkosh.gravestone_extended.entity.monster.pet.EntityZombieCat;
import nightkosh.gravestone_extended.entity.monster.pet.EntityZombieDog;
import nightkosh.gravestone_extended.entity.monster.water.EntityDrowned;
import nightkosh.gravestone_extended.entity.monster.water.EntityPhantomDiver;
import nightkosh.gravestone_extended.entity.monster.water.EntitySwampThing;
import nightkosh.gravestone_extended.entity.projectile.EntityBoneFishHook;
import nightkosh.gravestone_extended.gui.GSGraveTextGui;
import nightkosh.gravestone_extended.item.ItemGSMonsterPlacer;
import nightkosh.gravestone_extended.models.entity.ModelDamnedWarrior;
import nightkosh.gravestone_extended.models.entity.ModelUndeadCat;
import nightkosh.gravestone_extended.particle.*;
import nightkosh.gravestone_extended.renderer.entity.*;
import nightkosh.gravestone_extended.renderer.entity.projectile.RendererBoneFishHook;
import nightkosh.gravestone_extended.renderer.item.TEISRCorpse;
import nightkosh.gravestone_extended.renderer.item.TEISRExecution;
import nightkosh.gravestone_extended.renderer.item.TEISRMemorial;
import nightkosh.gravestone_extended.renderer.item.TEISRSpawner;
import nightkosh.gravestone_extended.renderer.tileentity.*;
import nightkosh.gravestone_extended.tileentity.*;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void registerEggs() {
        FMLClientHandler.instance().getClient().getItemColors().registerItemColorHandler((stack, tintIndex) -> {
            int itemDamage = stack.getItemDamage();
            if (itemDamage >= 0 && itemDamage < ItemGSMonsterPlacer.EnumEggs.values().length) {
                if ((tintIndex & 1) == 0) {
                    return ItemGSMonsterPlacer.EnumEggs.getById(itemDamage).getBackgroundColor();
                } else {
                    return ItemGSMonsterPlacer.EnumEggs.getById(itemDamage).getForegroundColor();
                }
            }
            return 0xFFFFFF;
        }, GSItem.SPAWN_EGG);
    }

    @Override
    public void registerTERenderers() {
        // register Memorials renderers
        ClientRegistry.registerTileEntity(TileEntityMemorial.class, "GSMemorial", new TileEntityMemorialRenderer());

        // register Execution renderers
        ClientRegistry.registerTileEntity(TileEntityExecution.class, "GSExecution", new TileEntityExecutionRenderer());

        // spawner renderer
        ClientRegistry.registerTileEntity(TileEntitySpawner.class, "GSSpawner", new TileEntitySpawnerRenderer());

        // register HauntedChest renderer
        ClientRegistry.registerTileEntity(TileEntityHauntedChest.class, "GSHauntedChest", new TileEntityHauntedChestRenderer());

        ClientRegistry.registerTileEntity(TileEntityAltar.class, "GSAltar", new TileEntityRenderAltar());
    }

    @Override
    public void registerFluidRenderers(Block block, ModelResourceLocation modelResourceLocation) {
        ModelLoader.setCustomStateMapper(block, new StateMapperBase() {
            protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                return modelResourceLocation;
            }
        });
    }

    @Override
    public void registerMobsRenderers() {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

        // zombie dog
        RenderingRegistry.registerEntityRenderingHandler(EntityZombieDog.class, new RenderUndeadDog(renderManager));

        // zombie cat
        RenderingRegistry.registerEntityRenderingHandler(EntityZombieCat.class, new RenderUndeadCat(renderManager, new ModelUndeadCat(), 0));

        // skeleton dog
        RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonDog.class, new RenderUndeadDog(renderManager));

        // zombie cat
        RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonCat.class, new RenderUndeadCat(renderManager, new ModelUndeadCat(), 0));

        // skull crawler
        RenderingRegistry.registerEntityRenderingHandler(EntitySkullCrawler.class, new RenderSkullCrawler(SkullCrawlerType.SKELETON, renderManager));
        RenderingRegistry.registerEntityRenderingHandler(EntityStraySkullCrawler.class, new RenderSkullCrawler(SkullCrawlerType.STRAY, renderManager));
        RenderingRegistry.registerEntityRenderingHandler(EntityWitherSkullCrawler.class, new RenderSkullCrawler(SkullCrawlerType.WITHER, renderManager));
        RenderingRegistry.registerEntityRenderingHandler(EntityZombieSkullCrawler.class, new RenderSkullCrawler(SkullCrawlerType.ZOMBIE, renderManager));
        RenderingRegistry.registerEntityRenderingHandler(EntityHuskSkullCrawler.class, new RenderSkullCrawler(SkullCrawlerType.HUSK, renderManager));
        RenderingRegistry.registerEntityRenderingHandler(EntityPigmanSkullCrawler.class, new RenderSkullCrawler(SkullCrawlerType.PIGMAN, renderManager));

        // Skeleton
        RenderingRegistry.registerEntityRenderingHandler(EntityGSSkeleton.class, new RenderGSSkeleton(renderManager));
        // Horses
        RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonHorse.class, new RenderUndeadHorse(renderManager));
        RenderingRegistry.registerEntityRenderingHandler(EntityZombieHorse.class, new RenderUndeadHorse(renderManager));

        // raven
        RenderingRegistry.registerEntityRenderingHandler(EntityRaven.class, new RenderRaven(renderManager));

        // toxic sludge
        RenderingRegistry.registerEntityRenderingHandler(EntityToxicSludge.class, new RendererToxicSludge(renderManager));

        // Possessed armor
        RenderingRegistry.registerEntityRenderingHandler(EntityPossessedArmor.class, new RendererPossessedArmor(renderManager));

        // Mummy
        RenderingRegistry.registerEntityRenderingHandler(EntityMummy.class, new RendererMummy(renderManager));

        // Drowned
        RenderingRegistry.registerEntityRenderingHandler(EntityDrowned.class, new RenderDrowned(renderManager));
        RenderingRegistry.registerEntityRenderingHandler(EntityPhantomDiver.class, new RenderPhantomDiver(renderManager));

        // Bats
        RenderingRegistry.registerEntityRenderingHandler(EntityVampireBat.class, new RenderVampireBat(renderManager));
        RenderingRegistry.registerEntityRenderingHandler(EntityWitheredBat.class, new RenderWitheredBat(renderManager));

        // Barghest
        RenderingRegistry.registerEntityRenderingHandler(EntityBarghest.class, new RenderBarghest(renderManager));

        // Swamp Thing
        RenderingRegistry.registerEntityRenderingHandler(EntitySwampThing.class, new RenderSwampThing(renderManager));

        // Damned Warrior
        RenderingRegistry.registerEntityRenderingHandler(EntityDamnedWarrior.class, new RenderDamnedWarrior(renderManager, new ModelDamnedWarrior()));

        // Spawner Helper
        RenderingRegistry.registerEntityRenderingHandler(EntityGroupOfGravesMobSpawnerHelper.class, new RenderSpawnerHelper(renderManager));

        RenderingRegistry.registerEntityRenderingHandler(EntityBoneFishHook.class, new RendererBoneFishHook(renderManager));
    }

    @Override
    public String getLocalizedString(String str) {
        return I18n.translateToLocal(str);
    }

    @Override
    public String getLocalizedEntityName(String name) {
        return I18n.translateToLocal(name);
    }

    @Override
    public void openGraveTextGui(TileEntityGrave tileEntity) {
        FMLClientHandler.instance().getClient().displayGuiScreen(new GSGraveTextGui(tileEntity));
    }

    @Override
    public void registerHandlers() {
        MinecraftForge.EVENT_BUS.register(new RenderEventHandler());
    }


    @Override
    public void registerParticles() {
        Minecraft.getMinecraft().effectRenderer.registerParticle(GSParticles.GREEN_FLAME.getParticleID(), new ParticleGreenFlameFX.Factory());
        Minecraft.getMinecraft().effectRenderer.registerParticle(GSParticles.CATACOMBS_PORTAL.getParticleID(), new ParticleCatacombsPortal.Factory());
        Minecraft.getMinecraft().effectRenderer.registerParticle(GSParticles.TOXIC_WATER_DRIP.getParticleID(), new ParticleToxicWaterDrip.Factory());
        Minecraft.getMinecraft().effectRenderer.registerParticle(GSParticles.TOXIC_WATER_SPLASH.getParticleID(), new ParticleToxicWaterSplash.Factory());
        Minecraft.getMinecraft().effectRenderer.registerParticle(GSParticles.TOXIC_WATER_BUBBLE.getParticleID(), new ParticleToxicWaterBubble.Factory());
        Minecraft.getMinecraft().effectRenderer.registerParticle(GSParticles.TOXIC_WATER_WAKE.getParticleID(), new ParticleToxicWaterWake.Factory());
    }

    @Override
    public void addModelRotationsAndTEISR() {
        Class<?>[] rotationParams = {
                int.class, int.class
        };
        ModelRotation X0_Y45 = EnumHelper.addEnum(ModelRotation.class, "X0_Y45", rotationParams, 0, 45);
        ModelRotation X0_Y135 = EnumHelper.addEnum(ModelRotation.class, "X0_Y135", rotationParams, 0, 135);
        ModelRotation X0_Y225 = EnumHelper.addEnum(ModelRotation.class, "X0_Y225", rotationParams, 0, 225);
        ModelRotation X0_Y315 = EnumHelper.addEnum(ModelRotation.class, "X0_Y315", rotationParams, 0, 315);

        ModelRotation.MAP_ROTATIONS.put(Integer.valueOf(X0_Y45.combinedXY), X0_Y45);
        ModelRotation.MAP_ROTATIONS.put(Integer.valueOf(X0_Y135.combinedXY), X0_Y135);
        ModelRotation.MAP_ROTATIONS.put(Integer.valueOf(X0_Y225.combinedXY), X0_Y225);
        ModelRotation.MAP_ROTATIONS.put(Integer.valueOf(X0_Y315.combinedXY), X0_Y315);


        //memorials
        registerTEISR(EnumMemorials.WOODEN_CROSS.ordinal(), EnumMemorials.ICE_CREEPER_STATUE.ordinal(),
                GSBlock.MEMORIAL_IB, new TEISRMemorial(), GSBlock.MEMORIAL, ResourcesModels.MEMORIAL);
        //executions
        registerTEISR(EnumExecution.GALLOWS.ordinal(), EnumExecution.BURNING_STAKE.ordinal(),
                GSBlock.EXECUTION_IB, new TEISRExecution(), GSBlock.EXECUTION, ResourcesModels.EXECUTION);
        //spawners
        registerTEISR(EnumSpawner.WITHER_SPAWNER.ordinal(), EnumSpawner.SPIDER_SPAWNER.ordinal(),
                GSBlock.SPAWNER_IB, new TEISRSpawner(), GSBlock.SPAWNER, ResourcesModels.SPAWNER);
        //corpses
        registerTEISR(EnumCorpse.STEVE.ordinal(), EnumCorpse.WITCH.ordinal(),
                GSBlock.CORPSE_IB, new TEISRCorpse(), GSBlock.CORPSE, ResourcesModels.CORPSE);
    }


    private static void registerTEISR(int startMeta, int endMeta, Item item, TileEntityItemStackRenderer renderer, Block block, ModelResourceLocation model) {
        item.setTileEntityItemStackRenderer(renderer);
        for (int meta = startMeta; meta <= endMeta; meta++) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, model);
        }
    }
}
