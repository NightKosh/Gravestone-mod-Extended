package nightkosh.gravestone_extended.loot.condition;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import nightkosh.gravestone_extended.helper.GraveInventoryHelper;
import nightkosh.gravestone_extended.loot.LootContextGrave;

import java.util.Random;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class LootConditionCorpseContentType {//TODO implements LootCondition {

    private final GraveInventoryHelper.GraveCorpseContentType corpseContentType;

    public LootConditionCorpseContentType(GraveInventoryHelper.GraveCorpseContentType corpseContentType) {
        this.corpseContentType = corpseContentType;
    }
//
//    @Override
//    public boolean testCondition(Random rand, LootContext context) {
//        return ((LootContextGrave) context).getCorpseContentType() == this.corpseContentType;
//    }
//
//    public static class Serializer extends LootCondition.Serializer<LootConditionCorpseContentType> {
//        public Serializer() {
//            super(new ResourceLocation("corpse_content_type"), LootConditionCorpseContentType.class);
//        }
//
//        @Override
//        public void serialize(JsonObject json, LootConditionCorpseContentType value, JsonSerializationContext context) {
//            json.addProperty("type", Float.valueOf(value.corpseContentType.name()));
//        }
//
//        @Override
//        public LootConditionCorpseContentType deserialize(JsonObject json, JsonDeserializationContext context) {
//            return new LootConditionCorpseContentType(GraveInventoryHelper.GraveCorpseContentType.valueOf(JsonUtils.getString(json, "type")));
//        }
//    }
}
