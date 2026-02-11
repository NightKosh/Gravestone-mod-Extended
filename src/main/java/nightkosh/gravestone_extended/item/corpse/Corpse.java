package nightkosh.gravestone_extended.item.corpse;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import nightkosh.gravestone_extended.core.ModInfo;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Corpse extends Item {

    public Corpse(ResourceKey<Item> id) {
        super(new Properties()
                .stacksTo(64)
                .setId(id));
    }

    @Override
    public void appendHoverText(
            @Nonnull ItemStack stack, @Nonnull Item.TooltipContext context,
            @Nonnull TooltipDisplay tooltipDisplay, @Nonnull Consumer<Component> consumer,
            @Nonnull TooltipFlag flag) {
        var data = stack.get(DataComponents.CUSTOM_DATA);
        if (data != null) {
            var tag = data.copyTag();
//            if (tag.contains("FoodAmount")) {
//                consumer.accept(Component.translatable("item.sophisticated_wolves.dog_bowl.amount_of_food")
//                        .append(Component.literal(String.valueOf(tag.getInt("FoodAmount").get()))));
//            }
        }
    }
//
//    @Override
//    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
//        if (stack.getTagCompound() == null) {
//            stack.setTagCompound(new NBTTagCompound());
//        }
//    }
//
//    @Override
//    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
//        if (stack.getTagCompound() == null) {
//            stack.setTagCompound(new NBTTagCompound());
//        } else {
//            CorpseHelper.addInfo(stack.getItemDamage(), tooltip, stack.getTagCompound());
//        }
//    }
//
//    @Override
//    public int getMetadata(int metadata) {
//        return metadata;
//    }
//
//    @Override
//    public String getItemStackDisplayName(ItemStack itemStack) {
//        if (itemStack.getItemDamage() == EnumCorpse.STEVE.ordinal()) {
//            NBTTagCompound nbt = itemStack.getTagCompound();
//            if (nbt != null && nbt.hasKey("Owner", 10)) {
//                GameProfile playerProfile = NBTUtil.readGameProfileFromNBT(nbt.getCompoundTag("Owner"));
//                if (playerProfile != null) {
//                    return EnumCorpse.getPlayerUnLocalizedName() + " - " + playerProfile.getName();
//                }
//            }
//        }
//        return EnumCorpse.getById((byte) itemStack.getItemDamage()).getUnLocalizedName();
//    }
}
