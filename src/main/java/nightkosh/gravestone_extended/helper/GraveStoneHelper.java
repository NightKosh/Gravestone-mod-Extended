package nightkosh.gravestone_extended.helper;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GraveStoneHelper {//TODO extends nightkosh.gravestone.helper.GraveStoneHelper {
//
//    public static final Item[] GENERATED_SWORD_GRAVES = {
//            Items.WOODEN_SWORD,
//            Items.STONE_SWORD
//    };
//
//    public static final List<net.minecraft.block.Block> FLOWERS_GROUND = Arrays.asList(
//            Blocks.GRASS, Blocks.DIRT);
//
//    public GraveStoneHelper() {
//    }
//
//    /**
//     * Return random grave type
//     *
//     * @param random
//     * @param graveType
//     */
//    public static int getGraveType(World world, BlockPos pos, Random random, GraveGenerationHelper.EnumGraveTypeByEntity graveType) {
//        ArrayList<EnumGraves> petsGravesList;
//        switch (graveType) {
//            case PLAYER_GRAVES:
//                if (random.nextFloat() > 0.1) {
//                    return 0;//TODO getRandomGrave(GraveGenerationHelper.getPlayerGraveTypesByBiomes(world, pos), random).ordinal();
//                } else {
//                    return EnumGraves.SWORD.ordinal();
//                }
//            case PETS_GRAVES:
//                petsGravesList = new ArrayList<>();
//                //TODO petsGravesList.addAll(GraveGenerationHelper.getDogGraveTypesByBiome(world, pos));
//                //TODO petsGravesList.addAll(GraveGenerationHelper.getCatGraveTypesByBiome(world, pos));
//                return getRandomGrave(petsGravesList, random).ordinal();
//            case DOGS_GRAVES:
//                return 0;//TODO getRandomGrave(GraveGenerationHelper.getDogGraveTypesByBiome(world, pos), random).ordinal();
//            case CATS_GRAVES:
//                return 0;//TODO getRandomGrave(GraveGenerationHelper.getCatGraveTypesByBiome(world, pos), random).ordinal();
//            case ALL_GRAVES:
//            default:
//                if (random.nextFloat() > 0.2) {
//                    if (random.nextFloat() > 0.1) {
//                        return 0;//TODO getRandomGrave(GraveGenerationHelper.getPlayerGraveTypesByBiomes(world, pos), random).ordinal();
//                    } else {
//                        return EnumGraves.SWORD.ordinal();
//                    }
//                } else {
//                    petsGravesList = new ArrayList<>();
//                    //TODO petsGravesList.addAll(GraveGenerationHelper.getDogGraveTypesByBiome(world, pos));
//                    //TODO petsGravesList.addAll(GraveGenerationHelper.getCatGraveTypesByBiome(world, pos));
//                    return getRandomGrave(petsGravesList, random).ordinal();
//                }
//        }
//    }
//
//    public static int getTreasuryGraveType(World world, BlockPos pos, Random random) {
//        ArrayList<EnumGraves> petsGravesList;
//        if (random.nextFloat() > 0.1) {
//            return 0;//TODO !!!!!!!!!!!!!getRandomGrave(GraveGenerationHelper.getPlayerGraveTypesByBiomes(world, pos), random).ordinal();
//        } else {
//            return EnumGraves.SWORD.ordinal();
//        }
//    }
//
//    /**
//     * Check is grave - pet grave
//     *
//     * @param graveType Grave type
//     */
//    public static boolean isPetGrave(int graveType) {
//        return EnumGraves.getById(graveType).getGraveType() == EnumGraveType.DOG_STATUE ||
//                EnumGraves.getById(graveType).getGraveType() == EnumGraveType.CAT_STATUE;
//    }
//
//    //TODO
//    public static void spawnMob(World world, BlockPos pos) {
//        if (ExtendedConfig.spawnMobAtGraveDestruction && world.rand.nextInt(10) == 0) {
//            TileEntityGraveStone tileEntity = (TileEntityGraveStone) world.getTileEntity(pos);
//
//            if (tileEntity != null) {
//                Entity mob = MobSpawn.getMobEntity(world, tileEntity.getGraveType(), pos.getX(), pos.getY(), pos.getZ());
//
//                if (mob != null) {
//                    MobSpawn.spawnMob(world, mob, pos.getX(), pos.getY(), pos.getZ(), false);
//                }
//            }
//        }
//    }
//
//    public static Item getRandomSwordForGeneration(int graveType, Random random) {
//        if (graveType == EnumGraves.SWORD.ordinal()) {
//            return GENERATED_SWORD_GRAVES[random.nextInt(GENERATED_SWORD_GRAVES.length)];
//        } else {
//            return null;
//        }
//    }
//
//    public static EnumGraves getRandomGrave(List<EnumGraves> graveTypes, Random rand) {
//        if (graveTypes.size() > 0) {
//            return graveTypes.get(rand.nextInt(graveTypes.size()));
//        } else {
//            return EnumGraves.WOODEN_VERTICAL_PLATE;
//        }
//    }
}