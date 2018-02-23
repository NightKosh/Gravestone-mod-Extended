package nightkosh.gravestone_extended.dimension.catacombs;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ChunkProviderCatacombs implements IChunkGenerator {

    private final World world;
    private final Random rand;

    public ChunkProviderCatacombs(World world) {
        super();
        this.world = world;
        this.rand = new Random(world.getSeed());
        this.world.setSeaLevel(150);
    }

    @Override
    public Chunk generateChunk(int x, int z) {
        ChunkPrimer chunkprimer = new ChunkPrimer();

        Chunk chunk = new Chunk(this.world, chunkprimer, x, z);
        byte[] abyte = chunk.getBiomeArray();

        for (int l = 0; l < abyte.length; ++l) {
            abyte[l] = (byte) Biome.getIdForBiome(Biomes.VOID);
        }

        chunk.generateSkylightMap();
        return chunk;
    }

    @Override
    public void populate(int x, int z) {

    }

    @Override
    public boolean generateStructures(Chunk chunk, int x, int z) {
        return false;
    }

    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
        List<Biome.SpawnListEntry> list = new ArrayList();
        return list;
    }

    @Nullable
    @Override
    public BlockPos getNearestStructurePos(World world, String structureName, BlockPos position, boolean findUnexplored) {
        return null;
    }

    @Override
    public void recreateStructures(Chunk chunk, int x, int z) {

    }

    @Override
    public boolean isInsideStructure(World world, String structureName, BlockPos pos) {
        return false;
    }
}
