package nightkosh.gravestone_extended.loot.condition;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import nightkosh.gravestone_extended.loot.LootContextGrave;

import java.util.Random;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class LootConditionGraveMaterial {//TODO implements LootCondition {
//
//    private final EnumGraveMaterial graveMaterial;
//
//    public LootConditionGraveMaterial(EnumGraveMaterial graveMaterial) {
//        this.graveMaterial = graveMaterial;
//    }
//
//    @Override
//    public boolean testCondition(Random rand, LootContext context) {
//        return ((LootContextGrave) context).getGraveMaterial() == this.graveMaterial;
//    }
//
//    public static class Serializer extends LootCondition.Serializer<LootConditionGraveMaterial> {
//        public Serializer() {
//            super(new ResourceLocation("grave_material"), LootConditionGraveMaterial.class);
//        }
//
//        @Override
//        public void serialize(JsonObject json, LootConditionGraveMaterial value, JsonSerializationContext context) {
//            json.addProperty("material", Float.valueOf(value.graveMaterial.name()));
//        }
//
//        @Override
//        public LootConditionGraveMaterial deserialize(JsonObject json, JsonDeserializationContext context) {
//            return new LootConditionGraveMaterial(EnumGraveMaterial.valueOf(JsonUtils.getString(json, "material")));
//        }
//    }
}
