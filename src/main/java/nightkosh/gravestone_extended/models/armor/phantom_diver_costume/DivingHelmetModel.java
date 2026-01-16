package nightkosh.gravestone_extended.models.armor.phantom_diver_costume;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.LivingEntity;
import nightkosh.gravestone_extended.core.ModInfo;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class DivingHelmetModel<T extends LivingEntity> extends HumanoidModel<HumanoidRenderState> {

    public static final ModelLayerLocation LAYER =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(ModInfo.ID, "diving_helmet"), "main");

    public DivingHelmetModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createLayerDefinition() {
        var mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0);
        var root = mesh.getRoot();
        var head = root.getChild("head");

        head.addOrReplaceChild("helmet_base",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-4.5F, -8.5F, -4.5F, 9, 9, 9),
                PartPose.ZERO
        );

        head.addOrReplaceChild("rim",
                CubeListBuilder.create()
                        .texOffs(0, 22)
                        .addBox(-4, -8, -6, 8, 8, 2),
                PartPose.ZERO
        );

        head.clearChild("hat");
        root.clearChild("head");
        root.clearChild("body");
        root.clearChild("right_arm");
        root.clearChild("left_arm");
        root.clearChild("right_leg");
        root.clearChild("left_leg");

        return LayerDefinition.create(mesh, 64, 32);
    }

}
