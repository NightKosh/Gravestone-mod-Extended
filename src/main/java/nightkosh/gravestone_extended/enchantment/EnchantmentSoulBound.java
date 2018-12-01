package nightkosh.gravestone_extended.enchantment;

import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import nightkosh.gravestone_extended.core.GSEnchantment;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.core.logger.GSLogger;
import nightkosh.gravestone_extended.helper.GSEnchantmentHelper;
import nightkosh.gravestone_extended.helper.GameRuleHelper;

import java.util.ListIterator;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EnchantmentSoulBound extends EnchantmentTreasure {

    public EnchantmentSoulBound() {
        super(Rarity.VERY_RARE, EnumEnchantmentType.ALL, new EntityEquipmentSlot[]{});
        this.setName("soul_bound");
        this.setRegistryName(ModInfo.ID, "soul_bound");
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 15;
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return super.getMinEnchantability(enchantmentLevel) + 50;
    }

    @Override
    public boolean canApply(ItemStack stack) {
        return true;
    }

    public static void applyEffect(PlayerDropsEvent event) {
        if (FMLCommonHandler.instance().getEffectiveSide().isServer() && event.getEntityLiving() != null && event.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntityLiving();
            if (!GameRuleHelper.checkKeepInventory(player.world)) {
                try {
                    ListIterator<EntityItem> it = event.getDrops().listIterator();
                    while (it.hasNext()) {
                        ItemStack item = it.next().getItem();
                        if (item != null && !item.isEmpty() && GSEnchantmentHelper.hasEnchantment(item, GSEnchantment.SOUL_BOUND)) {
                            if (saveItem(player, item)) {
                                it.remove();
                            }
                        }
                    }
                } catch (Exception e) {
                    GSLogger.logError("Can't save soulbound items!");
                }
            }
        }
    }

    private static boolean saveItem(EntityPlayer entityPlayer, ItemStack item) {
        NonNullList<ItemStack> inventory = entityPlayer.inventory.mainInventory;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).isEmpty()) {
                inventory.set(i, item.copy());
                return true;
            }
        }

        return false;
    }

    public static void restoreItems(EntityPlayer playerOld, EntityPlayer playerNew) {
        if (playerOld != null && playerNew != null && !GameRuleHelper.checkKeepInventory(playerNew.world)) {
            try {
                for (int i = 0; i < playerOld.inventory.mainInventory.size(); i++) {
                    ItemStack item = playerOld.inventory.mainInventory.get(i);
                    if (GSEnchantmentHelper.hasEnchantment(item, GSEnchantment.SOUL_BOUND) && saveItem(playerNew, item)) {
                        playerOld.inventory.mainInventory.set(i, ItemStack.EMPTY);
                    }
                }
            } catch (Exception e) {
                GSLogger.logError("Can't restore soulbound items!");
            }
        }
    }
}
