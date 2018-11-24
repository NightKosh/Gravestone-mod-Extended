package nightkosh.gravestone_extended.loot.condition;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import nightkosh.gravestone.helper.GraveGenerationHelper;
import nightkosh.gravestone_extended.loot.LootContextGrave;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class LootConditionGraveTypeByEntity implements LootCondition {

    private final GraveGenerationHelper.EnumGraveTypeByEntity graveTypeByEntity;

    public LootConditionGraveTypeByEntity(GraveGenerationHelper.EnumGraveTypeByEntity graveTypeByEntity) {
        this.graveTypeByEntity = graveTypeByEntity;
    }

    @Override
    public boolean testCondition(Random rand, LootContext context) {
        return ((LootContextGrave) context).getGraveTypeByEntity() == this.graveTypeByEntity;
    }

    public static class Serializer extends LootCondition.Serializer<LootConditionGraveTypeByEntity> {
        public Serializer() {
            super(new ResourceLocation("grave_type"), LootConditionGraveTypeByEntity.class);
        }

        @Override
        public void serialize(JsonObject json, LootConditionGraveTypeByEntity value, JsonSerializationContext context) {
            json.addProperty("type", Float.valueOf(value.graveTypeByEntity.name()));
        }

        @Override
        public LootConditionGraveTypeByEntity deserialize(JsonObject json, JsonDeserializationContext context) {
            return new LootConditionGraveTypeByEntity(GraveGenerationHelper.EnumGraveTypeByEntity.valueOf(JsonUtils.getString(json, "type")));
        }
    }
}
