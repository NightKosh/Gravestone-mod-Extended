package nightkosh.gravestone_extended.helper;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.ProfileLookupCallback;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import nightkosh.gravestone_extended.core.Resources;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GameProfileHelper {
    //TODO
//    private static final Map<GameProfile, ResourceLocation> playersTextureMap = new HashMap<>();
//
//    public static void dropItem(MinecraftServer minecraftServer, ICommandSender sender, String playerName, Block block, int meta) {
//        if (StringUtils.isNotBlank(playerName)) {
//            GameProfile profile = minecraftServer.getPlayerProfileCache().getGameProfileForUsername(playerName);
//            if (profile == null) {
//                String[] profArr = new String[1];
//                profArr[0] = playerName;
//                minecraftServer.getGameProfileRepository().findProfilesByNames(profArr, Agent.MINECRAFT, new ProfileLookupCallback() {
//                    @Override
//                    public void onProfileLookupSucceeded(GameProfile profile) {
//                        GraveInventory.dropItem(getBlock(profile, block, meta), sender.getEntityWorld(), sender.getPosition());
//                    }
//
//                    @Override
//                    public void onProfileLookupFailed(GameProfile gameProfile, Exception e) {
//                        sender.sendMessage(new TextComponentTranslation("commands.corpse_search_failed").setStyle(new Style().setColor(TextFormatting.RED)));
//                    }
//                });
//            } else {
//                GraveInventory.dropItem(getBlock(profile, block, meta), sender.getEntityWorld(), sender.getPosition());
//            }
//        }
//    }
//
//    public static ItemStack getBlock(GameProfile profile, Block block, int meta) {
//        NBTTagCompound nbt = new NBTTagCompound();
//        nbt.setTag("Owner", NBTUtil.writeGameProfile(new NBTTagCompound(), profile));
//
//        ItemStack stack = new ItemStack(block, 1, meta);
//        stack.setTagCompound(nbt);
//
//        return stack;
//    }
//
//    public static boolean hasProfile(NBTTagCompound nbtTag) {
//        return nbtTag != null && nbtTag.hasKey("Owner", 10);
//    }
//
//    public static GameProfile getProfile(NBTTagCompound nbtTag) {
//        if (hasProfile(nbtTag)) {
//            return NBTUtil.readGameProfileFromNBT(nbtTag.getCompoundTag("Owner"));
//        } else {
//            return null;
//        }
//    }
//
//    public static ResourceLocation getPlayerTexture(NBTTagCompound nbt) {
//        return getPlayerTexture(getProfile(nbt));
//    }
//
//    public static ResourceLocation getPlayerTexture(GameProfile playerProfile) {
//        ResourceLocation texture = Resources.STEVE;
//        if (playerProfile != null) {
//            if (playersTextureMap.containsKey(playerProfile)) {
//                texture = playersTextureMap.get(playerProfile);
//            } else {
//                Minecraft minecraft = Minecraft.getMinecraft();
//                Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> map = minecraft.getSkinManager().loadSkinFromCache(playerProfile);
//
//                if (map.containsKey(MinecraftProfileTexture.Type.SKIN)) {
//                    texture = minecraft.getSkinManager().loadSkin(map.get(MinecraftProfileTexture.Type.SKIN), MinecraftProfileTexture.Type.SKIN);
//                    playersTextureMap.put(playerProfile, texture);
//                } else {
//                    minecraft.getSkinManager().loadProfileTextures(playerProfile, (type, texture1, profileTexture) -> playersTextureMap.put(playerProfile, texture1), true);
//                }
//            }
//        }
//
//        return texture;
//    }
//
//    public static void bindPlayerTexture(NBTTagCompound nbt) {
//        Minecraft.getMinecraft().renderEngine.bindTexture(getPlayerTexture(nbt));
//    }
//
//    public static void bindPlayerTexture(GameProfile playerProfile) {
//        Minecraft.getMinecraft().renderEngine.bindTexture(getPlayerTexture(playerProfile));
//    }
}
