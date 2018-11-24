package nightkosh.gravestone_extended.loot.function;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import nightkosh.gravestone_extended.item.corpse.CatCorpseHelper;
import nightkosh.gravestone_extended.item.corpse.DogCorpseHelper;
import nightkosh.gravestone_extended.item.corpse.HorseCorpseHelper;
import nightkosh.gravestone_extended.item.corpse.VillagerCorpseHelper;
import nightkosh.gravestone_extended.loot.LootContextGrave;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class LootFunctionCorpse extends LootFunction {

    public LootFunctionCorpse(LootCondition[] conditions) {
        super(conditions);
    }

    @Override
    public ItemStack apply(ItemStack stack, Random rand, LootContext context) {
        switch (((LootContextGrave) context).getGraveTypeByEntity()) {
            case DOGS_GRAVES:
                return DogCorpseHelper.getRandomCorpse(rand);
            case CATS_GRAVES:
                return CatCorpseHelper.getRandomCorpse(rand);
            case HORSE_GRAVES:
                return HorseCorpseHelper.getRandomCorpse(rand);
            case PLAYER_GRAVES:
            case VILLAGERS_GRAVES:
            default:
                return VillagerCorpseHelper.getRandomCorpse(rand);
        }
    }

    public static class Serializer extends LootFunction.Serializer<LootFunctionCorpse> {
        public Serializer() {
            super(new ResourceLocation("set_corpse"), LootFunctionCorpse.class);
        }

        @Override
        public void serialize(JsonObject object, LootFunctionCorpse functionClazz, JsonSerializationContext serializationContext) {

        }

        @Override
        public LootFunctionCorpse deserialize(JsonObject object, JsonDeserializationContext deserializationContext, LootCondition[] conditions) {
            return new LootFunctionCorpse(conditions);
        }
    }
}
