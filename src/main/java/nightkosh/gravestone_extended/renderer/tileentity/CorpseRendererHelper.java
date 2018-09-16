package nightkosh.gravestone_extended.renderer.tileentity;

import com.google.common.collect.Maps;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelHorse;
import net.minecraft.client.model.ModelOcelot;
import net.minecraft.client.model.ModelWolf;
import net.minecraft.client.renderer.texture.LayeredTexture;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.registries.ForgeRegistry;
import nightkosh.gravestone.models.ModelRendererSkull;
import nightkosh.gravestone_extended.block.enums.EnumCorpse;
import nightkosh.gravestone_extended.core.Resources;
import nightkosh.gravestone_extended.entity.monster.horse.EntitySkeletonHorse;
import nightkosh.gravestone_extended.entity.monster.horse.EntityZombieHorse;
import nightkosh.gravestone_extended.entity.monster.pet.EnumUndeadMobType;
import nightkosh.gravestone_extended.helper.GameProfileHelper;
import nightkosh.gravestone_extended.item.corpse.*;
import nightkosh.gravestone_extended.models.block.execution.*;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;
import java.util.Map;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CorpseRendererHelper {

    private static final Map horsesTexturesMap = Maps.newHashMap();
    private static final ModelWolf dogModel = new ModelWolf();
    private static final ModelOcelot catModel = new ModelOcelot();
    private static final ModelHorse horseModel = new ModelHorse();

    static {
        dogModel.isChild = false;
        catModel.isChild = false;
    }

    private static final ModelHangedBiped bipedModel = new ModelHangedBiped(false, true);
    private static final ModelHangedBiped zombieModel = new ModelHangedBiped(false, true);
    private static final ModelHangedBiped zombiePigmenModel = new ModelHangedBiped(false, true);
    private static final ModelHangedSkeleton skeletonModel = new ModelHangedSkeleton(false);
    private static final ModelHangedSkeleton witherSkeletonModel = new ModelHangedSkeleton(false, ModelRendererSkull.EnumSkullType.WITHER_SKULL);
    private static final ModelHangedSkeleton straySkeletonModel = new ModelHangedSkeleton(false, ModelRendererSkull.EnumSkullType.STRAY_SKULL);
    private static final ModelHangedVillager villagerModel = new ModelHangedVillager(false);
    private static final ModelHangedZombieVillager zombieVillagerModel = new ModelHangedZombieVillager(false);
    private static final ModelHangedWitch witchModel = new ModelHangedWitch(false);

    private static final ModelHangedVillager villagerInStocksModel = new ModelHangedVillager(true);
    private static final ModelHangedZombieVillager zombieVillagerInStocksModel = new ModelHangedZombieVillager(true);
    private static final ModelHangedWitch witchInStocksModel = new ModelHangedWitch(true);

    private static final Map<Integer, ResourceLocation> MODDED_VILLAGERS = new HashMap<>();

    private static final Entity modelEntity = new Entity(null) {
        @Override
        protected void entityInit() {
        }

        @Override
        protected void readEntityFromNBT(NBTTagCompound tagCompund) {
        }

        @Override
        protected void writeEntityToNBT(NBTTagCompound tagCompound) {
        }
    };

    static {
        zombieModel.isChild = false;
        zombieVillagerModel.isChild = false;
        zombiePigmenModel.isChild = false;
        skeletonModel.isChild = false;
        witherSkeletonModel.isChild = false;
    }

    private static EntityWolf dog;
    private static EntityHorse horse;
    private static EntityDonkey donkey;
    private static EntityMule mule;
    private static EntityZombieHorse zombieHorse;
    private static EntitySkeletonHorse skeletonHorse;

    public static void renderCorpse(EnumCorpse corpseType, NBTTagCompound nbt, boolean atAltar) {
        renderCorpse(corpseType, nbt, atAltar, false);
    }

    public static void renderCorpse(EnumCorpse corpseType, NBTTagCompound nbt, boolean atAltar, boolean isExecuted) {
        renderCorpse(corpseType, nbt, atAltar, isExecuted, false);
    }

    public static void renderCorpse(EnumCorpse corpseType, NBTTagCompound nbt, boolean atAltar, boolean isExecuted, boolean isInStocks) {
        if (!isExecuted) {
            GL11.glRotatef(180, 1, 0, 0);
        }

        float xz = 0.0625F;
        switch (corpseType) {
            case STEVE:
                if (atAltar) {
                    GL11.glTranslatef(0, -1.2F, 0);
                } else if (!isExecuted) {
                    GL11.glTranslatef(0, -1.3F, -0.85F);
                }

                GameProfileHelper.bindPlayerTexture(nbt);
                zombieModel.renderAll(isInStocks);
                break;
            case VILLAGER:
                if (atAltar) {
                    GL11.glTranslatef(0, -1.2F, 0);
                } else if (!isExecuted) {
                    GL11.glTranslatef(0, -1.3F, -0.85F);
                }
                int profession = (nbt == null) ? 0 : VillagerCorpseHelper.getVillagerType(nbt);
                bindVillagerTexture(profession);
                if (isInStocks) {
                    villagerInStocksModel.renderAll();
                } else {
                    villagerModel.renderAll();
                }
                break;
            case DOG:
                if (atAltar) {
                    GL11.glTranslatef(0, -1.2F, 0);
                } else if (!isExecuted) {
                    GL11.glTranslatef(0, -2, -0.85F);
                }
                switch (DogCorpseHelper.getMobType(nbt)) {
                    case OTHER:
                    default:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.WOLF);
                        break;
                    case ZOMBIE:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.ZOMBIE_DOG);
                        break;
                    case HUSK:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.GREEN_ZOMBIE_DOG);
                        break;
                    case SKELETON:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.SKELETON_DOG);
                        break;
//                    case WITHER:
//                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.);
//                        break;
//                    case STRAY:
//                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.);
//                        break;
                }
                if (dog == null) {
                    dog = new EntityWolf(Minecraft.getMinecraft().world);
                }
                dogModel.setLivingAnimations(dog, 0, 0, 0);
                dogModel.render(null, xz, xz, xz, xz, xz, xz);
                break;
            case CAT:
                if (atAltar) {
                    GL11.glTranslatef(0, -1.2F, 0);
                } else if (!isExecuted) {
                    GL11.glTranslatef(0, -2F, -0.85F);
                }
                bindCatTexture(CatCorpseHelper.getCatType(nbt), CatCorpseHelper.getMobType(nbt));
                catModel.render(null, xz, xz, xz, xz, xz, xz);
                break;
            case HORSE:
                if (atAltar) {
                    GL11.glTranslatef(0, -1.3F, 0);
                } else if (!isExecuted) {
                    GL11.glTranslatef(0, -1.5F, -0.85F);
                }
                HorseCorpseHelper.EnumHorseType horseType = HorseCorpseHelper.EnumHorseType.HORSE;
                if (nbt != null) {
                    horseType = HorseCorpseHelper.EnumHorseType.getById(HorseCorpseHelper.getHorseType(nbt));
                }
                switch (horseType) {
                    case DONKEY:
                        if (donkey == null) {
                            donkey = new EntityDonkey(Minecraft.getMinecraft().world);
                        }
                        renderHorse(horseType, donkey);
                        break;
                    case MULE:
                        if (mule == null) {
                            mule = new EntityMule(Minecraft.getMinecraft().world);
                        }
                        renderHorse(horseType, mule);
                        break;
                    case ZOMBIE:
                        if (zombieHorse == null) {
                            zombieHorse = new EntityZombieHorse(Minecraft.getMinecraft().world);
                        }
                        renderHorse(horseType, zombieHorse);
                        break;
                    case SKELETON:
                        if (skeletonHorse == null) {
                            skeletonHorse = new EntitySkeletonHorse(Minecraft.getMinecraft().world);
                        }
                        renderHorse(horseType, skeletonHorse);
                        break;
                    case HORSE:
                    default:
                        if (horse == null) {
                            horse = new EntityHorse(Minecraft.getMinecraft().world);
                        }
                        horse.setHorseVariant((nbt == null) ? 0 : HorseCorpseHelper.getHorseVariant(nbt));
                        renderHorse(horseType, horse);
                        break;
                }
                break;
            case ZOMBIE:
                if (atAltar) {
                    GL11.glTranslatef(0, -1.2F, 0);
                } else if (!isExecuted) {
                    GL11.glTranslatef(0, -1.3F, -0.85F);
                }

                switch (ZombieCorpseHelper.getMobType(nbt)) {
                    case ZOMBIE:
                    default:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.ZOMBIE);
                        break;
                    case HUSK:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.HUSK_ZOMBIE);
                        break;
                    case PIGMAN:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.ZOMBIE_PIGMAN);
                        break;
                }
                zombieModel.renderAll(isInStocks);
                break;
            case ZOMBIE_VILLAGER:
                if (atAltar) {
                    GL11.glTranslatef(0, -1.2F, 0);
                } else if (!isExecuted) {
                    GL11.glTranslatef(0, -1.3F, -0.85F);
                }
                int prof = ZombieVillagerCorpseHelper.getProfession(nbt);
                switch (prof) {
                    case 0:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.ZOMBIE_FARMER);
                        break;
                    case 1:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.ZOMBIE_LIBRARIAN);
                        break;
                    case 2:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.ZOMBIE_PRIEST);
                        break;
                    case 3:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.ZOMBIE_SMITH);
                        break;
                    case 4:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.ZOMBIE_BUTCHER);
                        break;
                    default:
                        VillagerRegistry.VillagerProfession corpseProfession = ((VillagerRegistry.VillagerProfession) ((ForgeRegistry) ForgeRegistries.VILLAGER_PROFESSIONS).getValue(prof));
                        if (corpseProfession == null) {
                            Minecraft.getMinecraft().renderEngine.bindTexture(Resources.ZOMBIE_VILLAGER);
                        } else {
                            Minecraft.getMinecraft().renderEngine.bindTexture(corpseProfession.getZombieSkin());
                        }
                }
                if (isInStocks) {
                    zombieVillagerInStocksModel.renderAll();
                } else {
                    zombieVillagerModel.renderAll();
                }
                break;
            case SKELETON:
                if (atAltar) {
                    GL11.glTranslatef(0, -1.2F, 0);
                } else if (!isExecuted) {
                    GL11.glTranslatef(0, -1.3F, -0.85F);
                }

                switch (SkeletonCorpseHelper.getMobType(nbt)) {
                    case SKELETON:
                    default:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.SKELETON);
                        skeletonModel.renderAll(isInStocks);
                        break;
                    case STRAY:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.STRAY_SKELETON);
                        straySkeletonModel.renderStray(isInStocks);
                        break;
                    case WITHER:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.WITHER_SKELETON);
                        witherSkeletonModel.renderAll(isInStocks);
                        break;
                }
                break;
            case WITCH:
                if (atAltar) {
                    GL11.glTranslatef(0, -1.2F, 0);
                } else if (!isExecuted) {
                    GL11.glTranslatef(0, -1.3F, -0.85F);
                }
                Minecraft.getMinecraft().renderEngine.bindTexture(Resources.WITCH);
                if (isInStocks) {
                    witchInStocksModel.renderAll();
                } else {
                    witchModel.renderAll();
                }
                break;
        }
    }

    public static void renderCorpseInsideSlime(EnumCorpse corpseType, NBTTagCompound nbt, double x, double y, double z) {
        GL11.glPushMatrix();
        GL11.glTranslated(x - 0.25, y + 1.2, z - 0.25);
        GL11.glRotatef(45, 0, 0, 1);
        GL11.glRotatef(-25 + 180, 1, 0, 0);

        float xz = 0.0625F;
        switch (corpseType) {
            case STEVE:
                GameProfileHelper.bindPlayerTexture(nbt);
                zombieModel.renderAll(false);
                break;
            case VILLAGER:
                int profession = (nbt == null) ? 0 : VillagerCorpseHelper.getVillagerType(nbt);
                bindVillagerTexture(profession);
                villagerModel.renderAll();
                break;
            case DOG:
                GL11.glTranslated(-0.1, -0.5, 0);
                switch (DogCorpseHelper.getMobType(nbt)) {
                    case OTHER:
                    default:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.WOLF);
                        break;
                    case ZOMBIE:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.ZOMBIE_DOG);
                        break;
                    case HUSK:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.GREEN_ZOMBIE_DOG);
                        break;
                    case SKELETON:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.SKELETON_DOG);
                        break;
//                    case WITHER:
//                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.);
//                        break;
//                    case STRAY:
//                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.);
//                        break;
                }
                if (dog == null) {
                    dog = new EntityWolf(Minecraft.getMinecraft().world);
                }
                dogModel.setLivingAnimations(dog, 0, 0, 0);
                dogModel.render(null, xz, xz, xz, xz, xz, xz);
                break;
            case CAT:
                GL11.glTranslated(-0.1, -0.5, 0);
                GL11.glScaled(0.8, 0.8, 0.8);
                bindCatTexture(CatCorpseHelper.getCatType(nbt), CatCorpseHelper.getMobType(nbt));
                catModel.render(null, xz, xz, xz, xz, xz, xz);
                break;
            case ZOMBIE:
                switch (ZombieCorpseHelper.getMobType(nbt)) {
                    case ZOMBIE:
                    default:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.ZOMBIE);
                        break;
                    case HUSK:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.HUSK_ZOMBIE);
                        break;
                    case PIGMAN:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.ZOMBIE_PIGMAN);
                        break;
                }
                zombieModel.renderAll(false);
                break;
            case ZOMBIE_VILLAGER:
                switch (ZombieVillagerCorpseHelper.getProfession(nbt)) {
                    case -1:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.ZOMBIE_VILLAGER);
                        break;
                    case 0:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.ZOMBIE_FARMER);
                        break;
                    case 1:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.ZOMBIE_LIBRARIAN);
                        break;
                    case 2:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.ZOMBIE_PRIEST);
                        break;
                    case 3:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.ZOMBIE_SMITH);
                        break;
                    case 4:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.ZOMBIE_BUTCHER);
                        break;
                }
                zombieVillagerModel.renderAll();
                break;
            case SKELETON:
                switch (SkeletonCorpseHelper.getMobType(nbt)) {
                    case SKELETON:
                    default:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.SKELETON);
                        skeletonModel.renderAll(false);
                        break;
                    case STRAY:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.STRAY_SKELETON);
                        straySkeletonModel.renderStray(false);
                        break;
                    case WITHER:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.WITHER_SKELETON);
                        witherSkeletonModel.renderAll(false);
                        break;
                }
                break;
            case WITCH:
                GL11.glScaled(0.7, 0.7, 0.7);
                Minecraft.getMinecraft().renderEngine.bindTexture(Resources.WITCH);
                witchModel.renderAll();
                break;
        }
        GL11.glPopMatrix();
    }

    private static void bindVillagerTexture(int profession) {
        switch (profession) {
            case 0:
                Minecraft.getMinecraft().renderEngine.bindTexture(Resources.VILLAGER_FARMER);
                break;
            case 1:
                Minecraft.getMinecraft().renderEngine.bindTexture(Resources.VILLAGER_LIBRARIAN);
                break;
            case 2:
                Minecraft.getMinecraft().renderEngine.bindTexture(Resources.VILLAGER_PRIEST);
                break;
            case 3:
                Minecraft.getMinecraft().renderEngine.bindTexture(Resources.VILLAGER_SMITH);
                break;
            case 4:
                Minecraft.getMinecraft().renderEngine.bindTexture(Resources.VILLAGER_BUTCHER);
                break;
            default:
                ResourceLocation skin = Resources.VILLAGER;
                if (MODDED_VILLAGERS.containsKey(profession)) {
                    skin = MODDED_VILLAGERS.get(profession);
                } else {
                    VillagerRegistry.VillagerProfession villager = VillagerRegistry.getById(profession);
                    if (villager != null) {
                        skin = villager.getSkin();
                    }
                    MODDED_VILLAGERS.put(profession, skin);
                }

                Minecraft.getMinecraft().renderEngine.bindTexture(skin);
                break;
        }
    }

    private static void bindCatTexture(int catType, EnumUndeadMobType mobType) {
        switch (mobType) {
            case OTHER:
                switch (catType) {
                    case 0:
                    default:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.OCELOT);
                        break;
                    case 1:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.BLACK_CAT);
                        break;
                    case 2:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.RED_CAT);
                        break;
                    case 3:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.SIAMESE_CAT);
                        break;
                }
                break;
            case ZOMBIE:
                switch (catType) {
                    case 0:
                    default:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.ZOMBIE_OZELOT);
                        break;
                    case 1:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.ZOMBIE_CAT_BLACK);
                        break;
                    case 2:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.ZOMBIE_CAT_RED);
                        break;
                    case 3:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.ZOMBIE_CAT_SIAMESE);
                        break;
                }
                break;
            case HUSK:
                switch (catType) {
                    case 0:
                    default:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.GREEN_ZOMBIE_OZELOT);
                        break;
                    case 1:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.GREEN_ZOMBIE_CAT_BLACK);
                        break;
                    case 2:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.GREEN_ZOMBIE_CAT_RED);
                        break;
                    case 3:
                        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.GREEN_ZOMBIE_CAT_SIAMESE);
                        break;
                }
                break;
            case SKELETON:
                Minecraft.getMinecraft().renderEngine.bindTexture(Resources.SKELETON_CAT);
                break;
//            case STRAY:
//            case WITHER:
        }
    }

    private static void renderHorse(HorseCorpseHelper.EnumHorseType horseType, AbstractHorse horse) {
        float xz = 0.0625F;
        bindHorseTexture(horseType.ordinal());
        horseModel.setLivingAnimations(horse, 0, 0, 0);
        horseModel.render(horse, xz, xz, xz, xz, xz, xz);
    }

    private static void bindHorseTexture(int horseType) {
        switch (horseType) {
            case 0:
                String horseTexturePath = horse.getHorseTexture();
                ResourceLocation horseResourceLocation = (ResourceLocation) horsesTexturesMap.get(horseTexturePath);
                if (horseResourceLocation == null) {
                    horseResourceLocation = new ResourceLocation(horseTexturePath);
                    Minecraft.getMinecraft().getTextureManager().loadTexture(horseResourceLocation, new LayeredTexture(horse.getVariantTexturePaths()));
                    horsesTexturesMap.put(horseTexturePath, horseResourceLocation);
                }
                Minecraft.getMinecraft().renderEngine.bindTexture(horseResourceLocation);
                break;
            case 1:
                Minecraft.getMinecraft().renderEngine.bindTexture(Resources.DONKEY);
                break;
            case 2:
                Minecraft.getMinecraft().renderEngine.bindTexture(Resources.MULE);
                break;
            case 3:
                Minecraft.getMinecraft().renderEngine.bindTexture(Resources.ZOMBIE_HORSE);
                break;
            case 4:
                Minecraft.getMinecraft().renderEngine.bindTexture(Resources.SKELETON_HORSE);
                break;
        }
    }
}
