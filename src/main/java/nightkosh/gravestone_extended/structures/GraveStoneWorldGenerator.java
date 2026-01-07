package nightkosh.gravestone_extended.structures;

import nightkosh.gravestone_extended.config.ExtendedConfig;
import nightkosh.gravestone_extended.structures.catacombs.CatacombsGenerator;
import nightkosh.gravestone_extended.structures.graves.SingleGraveGenerator;
import nightkosh.gravestone_extended.structures.memorials.MemorialGenerator;

import java.util.Random;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GraveStoneWorldGenerator {//TODOimplements IWorldGenerator {

    public static final int DEFAULT_DIMENSION_ID = 0;

    public GraveStoneWorldGenerator() {
    }

//    @Override
//    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
//        if (ExtendedConfig.structuresDimensionIds.contains(world.provider.getDimension())) {
//            generateSurface(world, random, chunkX * 16, chunkZ * 16);
//        }
//    }
//
//    public void generateSurface(World world, Random rand, int x, int z) {
//        double chance = rand.nextDouble();
//        EnumFacing direction = EnumFacing.Plane.HORIZONTAL.facings()[rand.nextInt(EnumFacing.Plane.HORIZONTAL.facings().length)];
//
//        if (!CatacombsGenerator.INSTANCE.generate(world, rand, x, z, direction, chance, false)) {
//            if (!MemorialGenerator.INSTANCE.generate(world, rand, x, z, direction, chance, false)) {
//                SingleGraveGenerator.INSTANCE.generate(world, rand, x, z, direction, chance, false);
//            }
//        }
//    }
}