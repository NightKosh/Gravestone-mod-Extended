package nightkosh.gravestone_extended.loot.function;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import nightkosh.gravestone_extended.block.enums.EnumCorpse;
import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.item.corpse.*;
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
                if (rand.nextInt(5) == 0) {
                    switch (rand.nextInt(3)) {
                        case 0:
                            return ZombieCorpseHelper.getRandomCorpse(rand);
                        case 1:
                            return SkeletonCorpseHelper.getRandomCorpse(rand);
                        case 2:
                            return new ItemStack(GSBlock.CORPSE, 1, EnumCorpse.WITCH.ordinal());
                    }
                } else {
                    return VillagerCorpseHelper.getRandomCorpse(rand);
                }
            case VILLAGERS_GRAVES:
            default:
                if (rand.nextInt(5) == 0) {
                    return ZombieVillagerCorpseHelper.getRandomCorpse(rand);
                } else {
                    return VillagerCorpseHelper.getRandomCorpse(rand);
                }
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
