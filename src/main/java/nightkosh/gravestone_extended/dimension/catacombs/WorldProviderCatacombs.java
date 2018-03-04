package nightkosh.gravestone_extended.dimension.catacombs;

import net.minecraft.init.Biomes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone_extended.core.GSDimensions;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class WorldProviderCatacombs extends WorldProvider {

    public void createBiomeProvider() {
        this.biomeProvider = new BiomeProviderSingle(Biomes.VOID);
        this.hasSkyLight = false;
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new ChunkProviderCatacombs(this.world);
    }

    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks) {
        return 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float[] calcSunriseSunsetColors(float celestialAngle, float partialTicks) {
        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Vec3d getFogColor(float p_76562_1_, float p_76562_2_) {
        return new Vec3d(1, 1, 1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean isSkyColored() {
        return false;
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getCloudHeight() {
        return 8;
    }

    @Override
    public boolean canCoordinateBeSpawn(int x, int z) {
        return false;
    }

    @Override
    public int getAverageGroundLevel() {
        return 150;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean doesXZShowFog(int x, int z) {
        return false;
    }

    @Override
    public DimensionType getDimensionType() {
        return GSDimensions.CATACOMBS;
    }

    @Override
    public void onWorldSave() {

    }

    @Override
    public void onWorldUpdateEntities() {

    }

    @Override
    public boolean canDoRainSnowIce(Chunk chunk) {
        return false;
    }

    @Override
    public boolean canDoLightning(Chunk chunk) {
        return false;
    }

    @Override
    public int getHeight() {
        return 256;
    }

    @Override
    public int getActualHeight() {
        return 256;
    }

    @Override
    public long getSeed() {
        return 0;//this.world.getSeed();
    }
}
