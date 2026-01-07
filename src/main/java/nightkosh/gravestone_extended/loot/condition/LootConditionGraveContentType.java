package nightkosh.gravestone_extended.loot.condition;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import nightkosh.gravestone_extended.helper.GraveInventoryHelper;
import nightkosh.gravestone_extended.loot.LootContextGrave;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class LootConditionGraveContentType {//TODO implements LootCondition {
//
//    private final GraveInventoryHelper.GraveContentType graveContentType;
//
//    public LootConditionGraveContentType(GraveInventoryHelper.GraveContentType graveContentType) {
//        this.graveContentType = graveContentType;
//    }
//
//    @Override
//    public boolean testCondition(Random rand, LootContext context) {
//        return ((LootContextGrave) context).getGraveContentType() == this.graveContentType;
//    }
//
//    public static class Serializer extends LootCondition.Serializer<LootConditionGraveContentType> {
//        public Serializer() {
//            super(new ResourceLocation("content_type"), LootConditionGraveContentType.class);
//        }
//
//        @Override
//        public void serialize(JsonObject json, LootConditionGraveContentType value, JsonSerializationContext context) {
//            json.addProperty("type", Float.valueOf(value.graveContentType.name()));
//        }
//
//        @Override
//        public LootConditionGraveContentType deserialize(JsonObject json, JsonDeserializationContext context) {
//            return new LootConditionGraveContentType(GraveInventoryHelper.GraveContentType.valueOf(JsonUtils.getString(json, "type")));
//        }
//    }
}
