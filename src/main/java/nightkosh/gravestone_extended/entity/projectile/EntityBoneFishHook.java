package nightkosh.gravestone_extended.entity.projectile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.advanced_fishing.api.AdvancedFishingAPI;
import nightkosh.advanced_fishing.core.CatchManager;
import nightkosh.advanced_fishing.entity.projectile.EntityCustomFishHook;
import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.core.GSLootTables;
import nightkosh.gravestone_extended.core.GSParticles;
import nightkosh.gravestone_extended.item.tools.IBoneFishingPole;

import java.util.List;
import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntityBoneFishHook extends EntityCustomFishHook {

    public EntityBoneFishHook(World world) {
        super(world);
    }

    @SideOnly(Side.CLIENT)
    public EntityBoneFishHook(World world, EntityPlayer player, double x, double y, double z) {
        super(world, player, x, y, z);
    }

    public EntityBoneFishHook(World world, EntityPlayer player) {
        super(world, player);
    }

    @Override
    protected boolean isFishingPoleStack(ItemStack stack) {
        return stack.getItem() instanceof IBoneFishingPole;
    }

    protected static List<ItemStack> getToxicWaterCatch(World world, BlockPos pos, float luck) {
        return CatchManager.getCatch(world, GSLootTables.FISHING_TOXIC_WATER, luck);
    }

    static {
        AdvancedFishingAPI.PARTICLES_MANAGER.addSplashParticles(GSBlock.TOXIC_WATER, EntityBoneFishHook::spawnToxicWaterSplashParticles);
        AdvancedFishingAPI.PARTICLES_MANAGER.addBubbleParticles(GSBlock.TOXIC_WATER, EntityBoneFishHook::spawnToxicWaterBubbleParticles);
        AdvancedFishingAPI.PARTICLES_MANAGER.addWakeParticles(GSBlock.TOXIC_WATER, EntityBoneFishHook::spawnToxicWaterWakeParticles);

        AdvancedFishingAPI.CATCH_MANAGER.addCatch(GSBlock.TOXIC_WATER, EntityBoneFishHook::getToxicWaterCatch);
    }

    protected static void spawnToxicWaterSplashParticles(WorldServer world, Random rand, double x, double y, double z) {
        int num = 2 + rand.nextInt(2);
        world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x, y, z, num, 0.1, 0, 0.1, 0);
        world.spawnParticle(GSParticles.TOXIC_WATER_SPLASH, x, y, z, num, 0.1, 0, 0.1, 0);
    }

    protected static void spawnToxicWaterBubbleParticles(WorldServer world, double x, double y, double z, int num, double xOffset, double yOffset, double zOffset, double speed) {
        world.spawnParticle(GSParticles.TOXIC_WATER_BUBBLE, x, y, z, num, xOffset, yOffset, zOffset, speed);
    }

    protected static void spawnToxicWaterWakeParticles(WorldServer world, double x, double y, double z, int num, double xOffset, double yOffset, double zOffset, double speed) {
        world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x, y, z, num, xOffset, yOffset, zOffset, speed);
        world.spawnParticle(GSParticles.TOXIC_WATER_WAKE, x, y, z, num, xOffset, yOffset, zOffset, speed);
    }
}
