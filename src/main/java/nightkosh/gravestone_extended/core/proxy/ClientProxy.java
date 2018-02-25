package nightkosh.gravestone_extended.core.proxy;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.RenderFish;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import nightkosh.gravestone.tileentity.TileEntityGrave;
import nightkosh.gravestone_extended.core.GSItem;
import nightkosh.gravestone_extended.core.GSParticles;
import nightkosh.gravestone_extended.core.event.RenderEventHandler;
import nightkosh.gravestone_extended.entity.EntityRaven;
import nightkosh.gravestone_extended.entity.helper.EntityGroupOfGravesMobSpawnerHelper;
import nightkosh.gravestone_extended.entity.item.EntityFireproofItem;
import nightkosh.gravestone_extended.entity.monster.*;
import nightkosh.gravestone_extended.entity.monster.crawler.*;
import nightkosh.gravestone_extended.entity.monster.crawler.EntitySkullCrawler.SkullCrawlerType;
import nightkosh.gravestone_extended.entity.monster.horse.EntitySkeletonHorse;
import nightkosh.gravestone_extended.entity.monster.horse.EntityZombieHorse;
import nightkosh.gravestone_extended.entity.monster.pet.EntitySkeletonCat;
import nightkosh.gravestone_extended.entity.monster.pet.EntitySkeletonDog;
import nightkosh.gravestone_extended.entity.monster.pet.EntityZombieCat;
import nightkosh.gravestone_extended.entity.monster.pet.EntityZombieDog;
import nightkosh.gravestone_extended.entity.projectile.EntityBoneFishHook;
import nightkosh.gravestone_extended.entity.projectile.EntityCustomFishHook;
import nightkosh.gravestone_extended.gui.GSGraveTextGui;
import nightkosh.gravestone_extended.item.ItemGSMonsterPlacer;
import nightkosh.gravestone_extended.models.entity.ModelDamnedWarrior;
import nightkosh.gravestone_extended.models.entity.ModelUndeadCat;
import nightkosh.gravestone_extended.particle.ParticleCatacombsPortal;
import nightkosh.gravestone_extended.particle.ParticleToxicWaterBubble;
import nightkosh.gravestone_extended.particle.ParticleToxicWaterSplash;
import nightkosh.gravestone_extended.particle.ParticleToxicWaterWake;
import nightkosh.gravestone_extended.renderer.entity.*;
import nightkosh.gravestone_extended.renderer.entity.item.RendererFireproofItem;
import nightkosh.gravestone_extended.renderer.entity.projectile.RendererBoneFishHook;
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
        ClientRegistry.registerTileEntity(TileEntityMemorial.Obelisk.class, "GSMemorialObelisk", new TileEntityMemorialRenderer.Obelisk());
        ClientRegistry.registerTileEntity(TileEntityMemorial.CelticCross.class, "GSMemorialCelticCross", new TileEntityMemorialRenderer.CelticCross());
        ClientRegistry.registerTileEntity(TileEntityMemorial.SteveStatue.class, "GSMemorialSteveStatue", new TileEntityMemorialRenderer.SteveStatue());
        ClientRegistry.registerTileEntity(TileEntityMemorial.VillagerStatue.class, "GSMemorialVillagerStatue", new TileEntityMemorialRenderer.VillagerStatue());
        ClientRegistry.registerTileEntity(TileEntityMemorial.AngelStatue.class, "GSMemorialAngelStatue", new TileEntityMemorialRenderer.AngelStatue());
        ClientRegistry.registerTileEntity(TileEntityMemorial.DogStatue.class, "GSMemorialDogStatue", new TileEntityMemorialRenderer.DogStatue());
        ClientRegistry.registerTileEntity(TileEntityMemorial.CatStatue.class, "GSMemorialCatStatue", new TileEntityMemorialRenderer.CatStatue());
        ClientRegistry.registerTileEntity(TileEntityMemorial.CreeperStatue.class, "GSMemorialCreeperStatue", new TileEntityMemorialRenderer.CreeperStatue());

        // register Execution renderers
        ClientRegistry.registerTileEntity(TileEntityExecution.class, "GSExecution", new TileEntityExecutionRenderer());
        ClientRegistry.registerTileEntity(TileEntityExecution.Gibbet.class, "GSExecutionGibbet", new TileEntityExecutionRenderer.Gibbet());
        ClientRegistry.registerTileEntity(TileEntityExecution.Stocks.class, "GSExecutionStocks", new TileEntityExecutionRenderer.Stocks());
        ClientRegistry.registerTileEntity(TileEntityExecution.BurningStake.class, "GSExecutionBurningStake", new TileEntityExecutionRenderer.BurningStake());

        // spawner renderer
        ClientRegistry.registerTileEntity(TileEntitySpawner.class, "GSSpawner", new TileEntitySpawnerRenderer());
        ClientRegistry.registerTileEntity(TileEntitySpawner.Skeleton.class, "GSSpawnerSkeleton", new TileEntitySpawnerRenderer.Skeleton());
        ClientRegistry.registerTileEntity(TileEntitySpawner.Zombie.class, "GSSpawnerZombie", new TileEntitySpawnerRenderer.Zombie());
        ClientRegistry.registerTileEntity(TileEntitySpawner.Spider.class, "GSSpawnerSpider", new TileEntitySpawnerRenderer.Spider());

        // register HauntedChest renderer
        ClientRegistry.registerTileEntity(TileEntityHauntedChest.class, "GSHauntedChest", new TileEntityHauntedChestRenderer());

        // register SkullCandle renderer
        ClientRegistry.registerTileEntity(TileEntitySkullCandle.class, "GSSkullCandle", new TileEntitySkullCandleRenderer());
        ClientRegistry.registerTileEntity(TileEntitySkullCandle.Zombie.class, "GSSkullCandleZombie", new TileEntitySkullCandleRenderer.Zombie());
        ClientRegistry.registerTileEntity(TileEntitySkullCandle.Wither.class, "GSSkullCandleWither", new TileEntitySkullCandleRenderer.Wither());

        // candle
        ClientRegistry.registerTileEntity(TileEntityCandle.class, "GSCandle", new TileEntityCandleRenderer());

        // pile of bones
        ClientRegistry.registerTileEntity(TileEntityPileOfBones.class, "GSPileOfBones", new TileEntityPileOfBonesRenderer());
        ClientRegistry.registerTileEntity(TileEntityPileOfBones.Skull.class, "GSPileOfBonesSkull", new TileEntityPileOfBonesRenderer.Skull());
        ClientRegistry.registerTileEntity(TileEntityPileOfBones.Crawler.class, "GSPileOfBonesCrawler", new TileEntityPileOfBonesRenderer.Crawler());

        // corpses
        ClientRegistry.registerTileEntity(TileEntityCorpse.class, "GSCorpse", new TileEntityCorpseRenderer());
        ClientRegistry.registerTileEntity(TileEntityCorpse.Steve.class, "GSCorpseSteve", new TileEntityCorpseRenderer.Steve());
        ClientRegistry.registerTileEntity(TileEntityCorpse.Villager.class, "GSCorpseVillager", new TileEntityCorpseRenderer.Villager());
        ClientRegistry.registerTileEntity(TileEntityCorpse.Dog.class, "GSCorpseDog", new TileEntityCorpseRenderer.Dog());
        ClientRegistry.registerTileEntity(TileEntityCorpse.Cat.class, "GSCorpseCat", new TileEntityCorpseRenderer.Cat());
        ClientRegistry.registerTileEntity(TileEntityCorpse.Horse.class, "GSCorpseHorse", new TileEntityCorpseRenderer.Horse());
        ClientRegistry.registerTileEntity(TileEntityCorpse.Zombie.class, "GSCorpseZombie", new TileEntityCorpseRenderer.Zombie());
        ClientRegistry.registerTileEntity(TileEntityCorpse.ZombieVillager.class, "GSCorpseZombieVillager", new TileEntityCorpseRenderer.ZombieVillager());
        ClientRegistry.registerTileEntity(TileEntityCorpse.Skeleton.class, "GSCorpseSkeleton", new TileEntityCorpseRenderer.Skeleton());
        ClientRegistry.registerTileEntity(TileEntityCorpse.Witch.class, "GSCorpseWitch", new TileEntityCorpseRenderer.Witch());

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

        // Vampire Bat
        RenderingRegistry.registerEntityRenderingHandler(EntityVampireBat.class, new RenderVampireBat(renderManager));

        // Barghest
        RenderingRegistry.registerEntityRenderingHandler(EntityBarghest.class, new RenderBarghest(renderManager));

        // Swamp Thing
        RenderingRegistry.registerEntityRenderingHandler(EntitySwampThing.class, new RenderSwampThing(renderManager));

        // Damned Warrior
        RenderingRegistry.registerEntityRenderingHandler(EntityDamnedWarrior.class, new RenderDamnedWarrior(renderManager, new ModelDamnedWarrior()));

        // Spawner Helper
        RenderingRegistry.registerEntityRenderingHandler(EntityGroupOfGravesMobSpawnerHelper.class, new RenderSpawnerHelper(renderManager));

        RenderingRegistry.registerEntityRenderingHandler(EntityCustomFishHook.class, new RenderFish(renderManager));
        RenderingRegistry.registerEntityRenderingHandler(EntityBoneFishHook.class, new RendererBoneFishHook(renderManager));

        RenderingRegistry.registerEntityRenderingHandler(EntityFireproofItem.class, new RendererFireproofItem(renderManager, renderItem));
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
        Minecraft.getMinecraft().effectRenderer.registerParticle(GSParticles.CATACOMBS_PORTAL.getParticleID(), new ParticleCatacombsPortal.Factory());
        Minecraft.getMinecraft().effectRenderer.registerParticle(GSParticles.TOXIC_WATER_SPLASH.getParticleID(), new ParticleToxicWaterSplash.Factory());
        Minecraft.getMinecraft().effectRenderer.registerParticle(GSParticles.TOXIC_WATER_BUBBLE.getParticleID(), new ParticleToxicWaterBubble.Factory());
        Minecraft.getMinecraft().effectRenderer.registerParticle(GSParticles.TOXIC_WATER_WAKE.getParticleID(), new ParticleToxicWaterWake.Factory());
    }
}
