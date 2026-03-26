package nightkosh.gravestone_extended.structures.memorials;

import nightkosh.gravestone_extended.structures.GSStructureGenerator;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class MemorialGenerator implements GSStructureGenerator {

    public static final MemorialGenerator INSTANCE = new MemorialGenerator();

    public static final double DEFAULT_GENERATION_CHANCE = 0.05;
    public static final short RANGE = 400;
//    private static List<ChunkPos> structuresList = new ArrayList<>();
//
//    @Override
//    public boolean generate(World world, Random rand, int x, int z, EnumFacing direction, double chance, boolean isCommand) {
//        if (!isCommand) {
//            x = x + (16 - ComponentMemorial.X_LENGTH) / 2;
//            z = z + (16 - ComponentMemorial.Z_LENGTH) / 2;
//        }
//        if (isCommand || (ExtendedConfig.generateMemorials && canSpawnStructureAtCoords(world, x, z, chance) && isNoWarterUnder(world, x, z))) {
//            new ComponentMemorial(0, direction, rand, x, z).addComponentParts(world, rand);
//            GSLogger.logInfo("Generate memorial at " + x + "x" + z);
//            structuresList.add(new ChunkPos(x, z));
//            return true;
//        }
//
//        return false;
//    }
//
//    protected static boolean canSpawnStructureAtCoords(World world, int x, int z, double chance) {
//        return chance < ExtendedConfig.memorialsGenerationChance && isBiomeAllowed(world, x, z) && noAnyInRange(x, z);
//    }
//
//    protected static boolean isBiomeAllowed(World world, int x, int z) {
//        List<BiomeDictionary.Type> biomeTypesList = new ArrayList<>(BiomeDictionary.getTypes(world.getBiome(new BlockPos(x, 0, z))));
//        return !biomeTypesList.contains(BiomeDictionary.Type.WATER);
//    }
//
//    protected static boolean noAnyInRange(int x, int z) {
//        for (ChunkPos position : structuresList) {
//            if (position.x > x - RANGE && position.x < x + RANGE
//                    && position.z > z - RANGE && position.z < z + RANGE) {
//                return false;
//            }
//        }
//
//        for (ChunkPos position : CatacombsGenerator.getStructuresList()) {
//            if (position.x > x - CatacombsGenerator.CATACOMBS_RANGE && position.x < x + CatacombsGenerator.CATACOMBS_RANGE
//                    && position.z > z - CatacombsGenerator.CATACOMBS_RANGE && position.z < z + CatacombsGenerator.CATACOMBS_RANGE) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    public static List<ChunkPos> getStructuresList() {
//        return structuresList;
//    }
//
//    private static boolean isNoWarterUnder(World world, int x, int z) {
//        BlockPos pos = world.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z));
//        IBlockState state = world.getBlockState(pos);
//        return !state.getBlock().getMaterial(state).equals(Material.WATER);
//    }
}