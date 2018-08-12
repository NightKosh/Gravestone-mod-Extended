package nightkosh.gravestone_extended.renderer.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone.models.ModelRendererSkull;
import nightkosh.gravestone.renderer.tileentity.TileEntityRenderer;
import nightkosh.gravestone_extended.block.enums.EnumSpawner;
import nightkosh.gravestone_extended.core.Resources;
import nightkosh.gravestone_extended.models.block.ModelSpawnerBase;
import nightkosh.gravestone_extended.models.block.ModelSpawnerPentagram;
import nightkosh.gravestone_extended.models.block.ModelSpiderSpawner;
import nightkosh.gravestone_extended.tileentity.TileEntitySpawner;
import org.lwjgl.opengl.GL11;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@SideOnly(Side.CLIENT)
public class TileEntitySpawnerRenderer extends TileEntityRenderer {

    private static ModelSpawnerBase witherSpawnerModel = new ModelSpawnerPentagram(ModelRendererSkull.EnumSkullType.WITHER_SKULL);
    private static ModelSpawnerBase skeletonSpawnerModel = new ModelSpawnerPentagram(ModelRendererSkull.EnumSkullType.SKELETON_SKULL);
    private static ModelSpawnerBase zombieSpawnerModel = new ModelSpawnerPentagram(ModelRendererSkull.EnumSkullType.ZOMBIE_SKULL);
    private static ModelSpawnerBase spiderSpawnerModel = new ModelSpiderSpawner();

    public static TileEntitySpawnerRenderer instance;

    private static final TileEntitySpawner SPAWNER_TE = new TileEntitySpawner();

    public TileEntitySpawnerRenderer() {
        instance = this;
    }

    public void renderSpawnerPentagramAt(TileEntitySpawner tileEntity, float x, float y, float z) {
        if (tileEntity == null) {
            tileEntity = SPAWNER_TE;
        }
        EnumSpawner spawnerType = EnumSpawner.getById((byte) tileEntity.getBlockMetadata());

        renderSpawner(spawnerType, tileEntity.getWorld(), x, y, z);
    }

    public void renderSpawnerAsItem(EnumSpawner spawnerType) {
        renderSpawner(spawnerType, null, 0, 0, 0);
    }

    private void renderSpawner(EnumSpawner spawnerType, World world, float x, float y, float z) {
        GL11.glPushMatrix();
        if (world != null) {
            if (spawnerType == EnumSpawner.SPIDER_SPAWNER) {
                GL11.glTranslatef(x + 0.5F, y + 0.75F, z + 0.5F);
                GL11.glScalef(0.5F, -0.5F, -0.5F);
            } else {
                GL11.glTranslatef(x + 0.5F, y + 1.5F, z + 0.5F);
                GL11.glScalef(1, -1, -1);
            }
        } else {
            GL11.glRotatef(35, 1, 0, 0);
            if (spawnerType == EnumSpawner.SPIDER_SPAWNER) {
                GL11.glTranslatef(x + 0.5F, y + 1F, z + 0.5F);
                GL11.glScalef(0.3F, -0.3F, -0.3F);
            } else {
                GL11.glTranslatef(x + 0.5F, y + 1.4F, z + 0.5F);
                GL11.glScalef(0.4F, -0.4F, -0.4F);
            }
        }
        GL11.glTranslated(0, -0.01, 0);
        if (spawnerType == EnumSpawner.SPIDER_SPAWNER) {
            this.bindTexture(Resources.SPIDER_SPAWNER);
        } else {
            this.bindTexture(Resources.PENTAGRAM);
        }
        ModelSpawnerBase spawner = getSpawnerModel(spawnerType);
        spawner.renderAll();
        GL11.glPopMatrix();
    }

    @Override
    public void render(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        this.renderSpawnerPentagramAt((TileEntitySpawner) te, (float) x, (float) y, (float) z);
    }

    private static ModelSpawnerBase getSpawnerModel(EnumSpawner spawnerType) {
        switch (spawnerType) {
            case WITHER_SPAWNER:
                return witherSpawnerModel;
            case SKELETON_SPAWNER:
                return skeletonSpawnerModel;
            case SPIDER_SPAWNER:
                return spiderSpawnerModel;
            case ZOMBIE_SPAWNER:
            default:
                return zombieSpawnerModel;
        }
    }
}
