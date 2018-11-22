package nightkosh.gravestone_extended.loot;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.conditions.RandomChance;
import nightkosh.gravestone_extended.helper.GraveInventoryHelper;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class LootConditionGraveContentMaterial implements LootCondition {

    private final GraveInventoryHelper.ContentMaterials contentMaterial;

    public LootConditionGraveContentMaterial(GraveInventoryHelper.ContentMaterials contentMaterial) {
        this.contentMaterial = contentMaterial;
    }

    public boolean testCondition(Random rand, LootContext context) {
        return ((LootContextGrave) context).getContentMaterial() == this.contentMaterial;
    }

    public static class Serializer extends LootCondition.Serializer<LootConditionGraveContentMaterial> {
        public Serializer() {
            super(new ResourceLocation("grave_material"), LootConditionGraveContentMaterial.class);
        }

        public void serialize(JsonObject json, LootConditionGraveContentMaterial value, JsonSerializationContext context) {
            json.addProperty("material", Float.valueOf(value.contentMaterial.name()));
        }

        public LootConditionGraveContentMaterial deserialize(JsonObject json, JsonDeserializationContext context) {
            return new LootConditionGraveContentMaterial(GraveInventoryHelper.ContentMaterials.valueOf(JsonUtils.getString(json, "material")));
        }
    }
}
