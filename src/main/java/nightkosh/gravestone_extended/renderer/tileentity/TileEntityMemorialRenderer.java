package nightkosh.gravestone_extended.renderer.tileentity;

import com.google.common.collect.Maps;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.LayeredTexture;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone.api.grave.EnumGraveMaterial;
import nightkosh.gravestone.models.block.ModelCelticCross;
import nightkosh.gravestone.models.block.ModelGraveStone;
import nightkosh.gravestone.models.block.ModelObelisk;
import nightkosh.gravestone.renderer.tileentity.TileEntityRenderer;
import nightkosh.gravestone_extended.block.enums.EnumMemorials;
import nightkosh.gravestone_extended.core.Resources;
import nightkosh.gravestone_extended.helper.GameProfileHelper;
import nightkosh.gravestone_extended.models.block.ModelMemorial;
import nightkosh.gravestone_extended.models.block.memorials.*;
import nightkosh.gravestone_extended.tileentity.TileEntityMemorial;
import org.lwjgl.opengl.GL11;

import java.util.Map;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@SideOnly(Side.CLIENT)
public class TileEntityMemorialRenderer extends TileEntityRenderer {

    private static final Map<EnumMemorials, ResourceLocation> mossyTextures = Maps.newHashMap();
    private static final Map<EnumGraveMaterial, ResourceLocation> mossyPedestalTextures = Maps.newHashMap();
    private static final Map<EnumGraveMaterial, ResourceLocation> mossyArmorTextures = Maps.newHashMap();
    public static ModelMemorial cross = new ModelMemorialCross();
    public static ModelGraveStone obelisk = new ModelObelisk();
    public static ModelGraveStone celticCross = new ModelCelticCross();
    public static ModelMemorial steveStatue = new ModelSteveStatueMemorial();
    public static ModelMemorial villagerStatue = new ModelVillagerMemorial();
    public static ModelMemorial angelStatue = new ModelAngelStatueMemorial();
    public static ModelMemorial dogStatue = new ModelDogStatueMemorial();
    public static ModelMemorial catStatue = new ModelCatStatueMemorial();
    public static ModelMemorial creeperStatue = new ModelCreeperStatueMemorial();

    public static TileEntityMemorialRenderer instance;

    private static final TileEntityMemorial MEMORIAL_TE = new TileEntityMemorial();

    static {
        MEMORIAL_TE.setGraveType(EnumMemorials.STONE_CROSS.ordinal());
    }

    public TileEntityMemorialRenderer() {
        instance = this;
    }

    @Override
    public void render(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        TileEntityMemorial tileEntity = (TileEntityMemorial) te;

        if (tileEntity == null) {
            tileEntity = MEMORIAL_TE;
        }
        EnumMemorials memorial = tileEntity.getMemorialType();
        int meta = 0;

        if (tileEntity.getWorld() != null) {
            meta = tileEntity.getBlockMetadata();
        }
        EnumFacing facing = EnumFacing.values()[meta];

        renderMemorial(tileEntity, x, y, z, tileEntity.getWorld(), memorial, memorial.getMemorialType(), tileEntity.isEnchanted(), tileEntity.isMossy(), facing);

    }

    private void renderMemorial(TileEntityMemorial te, double x, double y, double z, World world, EnumMemorials memorial, EnumMemorials.EnumMemorialType memorialType,
                                boolean isEnchanted, boolean isMossy, EnumFacing facing) {
        GL11.glPushMatrix();

        if (world != null) {
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            GL11.glScalef(1, -1, -1);
        } else {
            GL11.glRotatef(-35, 0, 1, 0);
            switch (memorialType) {
                case CROSS:
                case OBELISK:
                    GL11.glTranslatef((float) x + 0.9F, (float) y + 0.3F, (float) z + 0.5F);
                    GL11.glScalef(0.2F, -0.2F, -0.2F);
                    break;
                default:
                    GL11.glTranslatef((float) x + 0.9F, (float) y + 0.6F, (float) z + 0.5F);
                    GL11.glScalef(0.4F, -0.4F, -0.4F);
                    break;
            }
        }

        switch (facing) {
            case SOUTH:
                GL11.glRotatef(0, 0, 1, 0);
                break;
            case WEST:
                GL11.glRotatef(90, 0, 1, 0);
                break;
            case NORTH:
                GL11.glRotatef(180, 0, 1, 0);
                break;
            case EAST:
                GL11.glRotatef(270, 0, 1, 0);
                break;
        }

        renderMemorial(te, memorial, memorialType, isEnchanted, isMossy);

        GL11.glPopMatrix();
    }

    public void renderMemorialAsItem(EnumMemorials memorial, EnumMemorials.EnumMemorialType memorialType, boolean isEnchanted, boolean isMossy) {
        GL11.glPushMatrix();

        GL11.glRotatef(-35, 0, 1, 0);
        switch (memorialType) {
            case CROSS:
            case OBELISK:
                GL11.glTranslatef(0.9F, 0.3F, 0.5F);
                GL11.glScalef(0.2F, -0.2F, -0.2F);
                break;
            default:
                GL11.glTranslatef(0.9F, 0.6F, 0.5F);
                GL11.glScalef(0.4F, -0.4F, -0.4F);
                break;
        }

        switch (EnumFacing.values()[0]) {//TODO 0
            case SOUTH:
                GL11.glRotatef(0, 0, 1, 0);
                break;
            case WEST:
                GL11.glRotatef(90, 0, 1, 0);
                break;
            case NORTH:
                GL11.glRotatef(180, 0, 1, 0);
                break;
            case EAST:
                GL11.glRotatef(270, 0, 1, 0);
                break;
        }

        renderMemorial(null, memorial, memorialType, isEnchanted, isMossy);//TODO null

        GL11.glPopMatrix();
    }

    public void renderMemorial(TileEntityMemorial te, EnumMemorials memorial, EnumMemorials.EnumMemorialType memorialType, boolean isEnchanted, boolean isMossy) {
        ModelGraveStone model = getModel(memorialType);
        model.setPedestalTexture(getPedestalTexture(memorial, isMossy));
        switch (memorialType) {
            case CREEPER_STATUE:
                bindTextureByName(getTexture(memorial, memorial.getTexture(), isMossy));
                model.customRender(isEnchanted);
                break;
            case STEVE_STATUE:
                if (te != null && te.getPlayerProfile() != null) {
                    GameProfileHelper.bindPlayerTexture(te.getPlayerProfile());
                } else {
                    bindTextureByName(getTexture(memorial, memorial.getTexture(), isMossy));
                }
                ((ModelMemorial) model).customRender(getArmorTexture(memorial, isMossy), isEnchanted);
                break;
            default:
                bindTextureByName(getTexture(memorial, memorial.getTexture(), isMossy));
                if (isEnchanted) {
                    model.renderEnchanted();
                } else {
                    model.renderAll();
                }
        }
    }

    private static ResourceLocation getTexture(EnumMemorials memorialType, ResourceLocation texture, boolean isMossy) {
        if (isMossy) {
            ResourceLocation mixedMossyTexture = mossyTextures.get(memorialType);
            if (mixedMossyTexture == null) {
                ResourceLocation mossyTexture = getMossyTexture(memorialType.getMemorialType());
                mixedMossyTexture = new ResourceLocation(texture.getResourceDomain() + ":mossy_" + texture.getResourcePath());
                Minecraft.getMinecraft().getTextureManager().loadTexture(mixedMossyTexture,
                        new LayeredTexture(texture.getResourceDomain() + ":" + texture.getResourcePath(),
                                mossyTexture.getResourceDomain() + ":" + mossyTexture.getResourcePath()));
                mossyTextures.put(memorialType, mixedMossyTexture);
                return mixedMossyTexture;
            } else {
                return mixedMossyTexture;
            }
        } else {
            return texture;
        }
    }

    private static ResourceLocation getPedestalTexture(EnumMemorials memorialType, boolean isMossy) {
        ResourceLocation texture = memorialType.getPedestalTexture();
        if (isMossy && texture != null) {
            ResourceLocation mixedMossyTexture = mossyPedestalTextures.get(memorialType.getMaterial());
            if (mixedMossyTexture == null) {
                ResourceLocation mossyTexture = getMossyPedestalTexture(memorialType.getMemorialType());
                mixedMossyTexture = new ResourceLocation(texture.getResourceDomain() + ":mossy_" + texture.getResourcePath());
                Minecraft.getMinecraft().getTextureManager().loadTexture(mixedMossyTexture,
                        new LayeredTexture(texture.getResourceDomain() + ":" + texture.getResourcePath(),
                                mossyTexture.getResourceDomain() + ":" + mossyTexture.getResourcePath()));
                mossyPedestalTextures.put(memorialType.getMaterial(), mixedMossyTexture);
                return mixedMossyTexture;
            } else {
                return mixedMossyTexture;
            }
        } else {
            return texture;
        }
    }

    private static ResourceLocation getArmorTexture(EnumMemorials memorialType, boolean isMossy) {
        ResourceLocation texture = getArmorTexture(memorialType);
        if (isMossy) {
            ResourceLocation mixedMossyTexture = mossyArmorTextures.get(memorialType.getMaterial());
            if (mixedMossyTexture == null) {
                ResourceLocation mossyTexture = Resources.MOSSY_ARMOR;
                mixedMossyTexture = new ResourceLocation(texture.getResourceDomain() + ":mossy_" + texture.getResourcePath());
                Minecraft.getMinecraft().getTextureManager().loadTexture(mixedMossyTexture,
                        new LayeredTexture(texture.getResourceDomain() + ":" + texture.getResourcePath(),
                                mossyTexture.getResourceDomain() + ":" + mossyTexture.getResourcePath()));
                mossyArmorTextures.put(memorialType.getMaterial(), mixedMossyTexture);
                return mixedMossyTexture;
            } else {
                return mixedMossyTexture;
            }
        } else {
            return texture;
        }
    }

    private static ResourceLocation getMossyTexture(EnumMemorials.EnumMemorialType memorialType) {
        switch (memorialType) {
            case CROSS:
            default:
                return Resources.MEMORIAL_MOSSY_CROSS;
            case OBELISK:
                return Resources.MOSSY_OBELISK;
            case CELTIC_CROSS:
                return Resources.MOSSY_CELTIC_CROSS;
            case STEVE_STATUE:
                return Resources.MEMORIAL_MOSSY_STEVE_STATUE;
            case VILLAGER_STATUE:
                return Resources.MOSSY_VILLAGER_STATUE;
            case ANGEL_STATUE:
                return Resources.MEMORIAL_MOSSY_ANGEL_STATUE;
            case DOG_STATUE:
                return Resources.MOSSY_DOG_STATUE;
            case CAT_STATUE:
                return Resources.MOSSY_CAT_STATUE;
            case CREEPER_STATUE:
                return Resources.MOSSY_CREEPER_STATUE;
        }
    }

    private static ResourceLocation getMossyPedestalTexture(EnumMemorials.EnumMemorialType memorialType) {
        return Resources.MEMORIAL_MOSSY_BIG_PEDESTAL;
    }

    private static ResourceLocation getArmorTexture(EnumMemorials memorialType) {
        switch (memorialType) {
            case WOODEN_STEVE_STATUE:
            default:
                return Resources.WOODEN_ARMOR;
            case SANDSTONE_STEVE_STATUE:
                return Resources.SANDSTONE_ARMOR;
            case RED_SANDSTONE_STEVE_STATUE:
                return Resources.RED_SANDSTONE_ARMOR;
            case STONE_STEVE_STATUE:
                return Resources.STONE_ARMOR;
            case DIORITE_STEVE_STATUE:
                return Resources.DIORITE_ARMOR;
            case ANDESITE_STEVE_STATUE:
                return Resources.ANDESITE_ARMOR;
            case GRANITE_STEVE_STATUE:
                return Resources.GRANITE_ARMOR;
            case IRON_STEVE_STATUE:
                return Resources.IRON_ARMOR;
            case GOLDEN_STEVE_STATUE:
                return Resources.GOLDEN_ARMOR;
            case DIAMOND_STEVE_STATUE:
                return Resources.DIAMOND_ARMOR;
            case EMERALD_STEVE_STATUE:
                return Resources.EMERALD_ARMOR;
            case LAPIS_STEVE_STATUE:
                return Resources.LAPIS_ARMOR;
            case REDSTONE_STEVE_STATUE:
                return Resources.REDSTONE_ARMOR;
            case OBSIDIAN_STEVE_STATUE:
                return Resources.OBSIDIAN_ARMOR;
            case QUARTZ_STEVE_STATUE:
                return Resources.QUARTZ_ARMOR;
            case PRIZMARINE_STEVE_STATUE:
                return Resources.PRIZMARINE_ARMOR;
            case ICE_STEVE_STATUE:
                return Resources.ICE_ARMOR;
        }
    }

    private static ModelGraveStone getModel(EnumMemorials.EnumMemorialType memorialType) {
        switch (memorialType) {
            case CROSS:
            default:
                return cross;
            case OBELISK:
                return obelisk;
            case CELTIC_CROSS:
                return celticCross;
            case STEVE_STATUE:
                return steveStatue;
            case VILLAGER_STATUE:
                return villagerStatue;
            case ANGEL_STATUE:
                return angelStatue;
            case DOG_STATUE:
                return dogStatue;
            case CAT_STATUE:
                return catStatue;
            case CREEPER_STATUE:
                return creeperStatue;
        }
    }
}
