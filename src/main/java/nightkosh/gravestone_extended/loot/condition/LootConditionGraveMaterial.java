package nightkosh.gravestone_extended.loot.condition;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import nightkosh.gravestone.api.grave.EnumGraveMaterial;
import nightkosh.gravestone_extended.loot.LootContextGrave;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class LootConditionGraveMaterial implements LootCondition {

    private final EnumGraveMaterial graveMaterial;

    public LootConditionGraveMaterial(EnumGraveMaterial graveMaterial) {
        this.graveMaterial = graveMaterial;
    }

    public boolean testCondition(Random rand, LootContext context) {
        return ((LootContextGrave) context).getGraveMaterial() == this.graveMaterial;
    }

    public static class Serializer extends LootCondition.Serializer<LootConditionGraveMaterial> {
        public Serializer() {
            super(new ResourceLocation("grave_material"), LootConditionGraveMaterial.class);
        }

        public void serialize(JsonObject json, LootConditionGraveMaterial value, JsonSerializationContext context) {
            json.addProperty("material", Float.valueOf(value.graveMaterial.name()));
        }

        public LootConditionGraveMaterial deserialize(JsonObject json, JsonDeserializationContext context) {
            return new LootConditionGraveMaterial(EnumGraveMaterial.valueOf(JsonUtils.getString(json, "material")));
        }
    }
}
