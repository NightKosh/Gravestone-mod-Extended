package nightkosh.gravestone_extended.structures;

import java.util.Random;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class MemorialGenerationHelper {
    protected static final Random rand = new Random();

    private MemorialGenerationHelper() {
    }

//    public static final EnumMemorials.EnumMemorialType[] GENERATED_PLAYER_MEMORIALS_TYPES = {
//            EnumMemorials.EnumMemorialType.CROSS,
//            EnumMemorials.EnumMemorialType.OBELISK,
//            EnumMemorials.EnumMemorialType.CELTIC_CROSS,
//            EnumMemorials.EnumMemorialType.STEVE_STATUE,
//            EnumMemorials.EnumMemorialType.ANGEL_STATUE
//    };
//    public static final EnumMemorials.EnumMemorialType[] GENERATED_HUMAN_STATUES_TYPES = {
//            EnumMemorials.EnumMemorialType.STEVE_STATUE,
//            EnumMemorials.EnumMemorialType.VILLAGER_STATUE,
//            EnumMemorials.EnumMemorialType.ANGEL_STATUE
//    };
//    public static final EnumMemorials.EnumMemorialType[] GENERATED_VILLAGERS_MEMORIALS_TYPES = {EnumMemorials.EnumMemorialType.VILLAGER_STATUE};
//    public static final EnumMemorials.EnumMemorialType[] GENERATED_DOGS_MEMORIALS_TYPES = {EnumMemorials.EnumMemorialType.DOG_STATUE};
//    public static final EnumMemorials.EnumMemorialType[] GENERATED_CAT_MEMORIALS_TYPES = {EnumMemorials.EnumMemorialType.CAT_STATUE};
//    public static final EnumMemorials.EnumMemorialType[] GENERATED_CREEPER_STATUES_MEMORIALS_TYPES = {EnumMemorials.EnumMemorialType.CREEPER_STATUE};
//
//    public static void placeMemorial(IComponentGraveStone component, World world, Random random, int x, int y, int z, EnumFacing facing) {
//        placeMemorial(component, world, random, x, y, z, facing, null);
//    }
//
//    public static void placeMemorial(IComponentGraveStone component, World world, Random random, int x, int y, int z, EnumFacing facing, EnumMemorials.EnumMemorialType[] memorialTypes) {
//        placeMemorial(component, world, random, x, y, z, facing, memorialTypes, GraveGenerationHelper.EnumGraveTypeByEntity.ALL_GRAVES);
//    }
//
//    public static void placeMemorial(IComponentGraveStone component, World world, Random random, int x, int y, int z, EnumFacing facing,
//                                     EnumMemorials.EnumMemorialType[] memorialTypes, GraveGenerationHelper.EnumGraveTypeByEntity graveTypeByEntity) {
//        component.placeBlockAtCurrentPosition(world, StateHelper.getMemorial(facing), x, y, z, component.getIBoundingBox());
//        TileEntityMemorial tileEntity = (TileEntityMemorial) world.getTileEntity(new BlockPos(component.getIXWithOffset(x, z), component.getIYWithOffset(y), component.getIZWithOffset(x, z)));
//
//        if (tileEntity != null) {
//            setMemorialInfo(tileEntity, getMemorial(world, random,
//                    new BlockPos(component.getIXWithOffset(x, z), component.getIYWithOffset(y), component.getIZWithOffset(x, z)),
//                    memorialTypes, graveTypeByEntity));
//
//            BlockMemorial.placeWalls(world, tileEntity.getPos());
//        }
//    }
//
//    public static void setMemorialInfo(TileEntityMemorial tileEntity, MemorialGenerationInfo iInfo) {
//        tileEntity.setGraveType(iInfo.getMemorial().ordinal());
//        tileEntity.setEnchanted(iInfo.isEnchanted());
//        tileEntity.setMossy(iInfo.isMossy());
//        tileEntity.setDeathTextComponent(iInfo.getDeathText());
//    }
//
//    public static MemorialGenerationInfo getMemorial(World world, Random random, BlockPos pos, EnumMemorials.EnumMemorialType[] memorialTypes, GraveGenerationHelper.EnumGraveTypeByEntity graveTypeByEntity) {
//        switch (graveTypeByEntity) {
//            case HUMAN_GRAVES:
//                graveTypeByEntity = nightkosh.gravestone_extended.helper.GraveGenerationHelper.getRandomHumanGraveType(random);
//                break;
//            case PETS_GRAVES:
//                graveTypeByEntity = nightkosh.gravestone_extended.helper.GraveGenerationHelper.getRandomPetGraveType(random);
//                break;
//            case ALL_GRAVES:
//                graveTypeByEntity = nightkosh.gravestone_extended.helper.GraveGenerationHelper.getRandomGraveType(random);
//                break;
//        }
//
//        GraveStoneDeathText deathText = DeathTextHelper.getRandomDeathTextAndNameForGrave(random, graveTypeByEntity);
//        EnumMemorials memorial;
//        if (GraveWorldGenerationHelper.isFireDamage(deathText.getDeathText()) || GraveWorldGenerationHelper.isLavaDamage(deathText.getDeathText())) {
//            if (memorialTypes != null && memorialTypes.length > 0) {
//                memorial = getMemorialType(memorialTypes, EnumGraveMaterial.OBSIDIAN);
//            } else {
//                memorial = getMemorialType(getDefaultMemorialTypes(graveTypeByEntity), EnumGraveMaterial.OBSIDIAN);
//            }
//        } else {
//            memorial = getMemorialTypeByBiomes(world, pos, memorialTypes, graveTypeByEntity, deathText.getDeathText());
//        }
//
//        boolean enchanted = GraveWorldGenerationHelper.isMagicDamage(deathText.getDeathText());
//        boolean mossy = GraveGenerationHelper.isMossyGrave(world, pos, memorial.getMaterial());
//
//        return new MemorialGenerationInfo(memorial, enchanted, mossy, deathText);
//    }
//
//    public static EnumMemorials getMemorialTypeByBiomes(World world, BlockPos pos, GraveGenerationHelper.EnumGraveTypeByEntity graveTypeByEntity) {
//        return getMemorialTypeByBiomes(world, pos, null, graveTypeByEntity, false);
//    }
//
//    public static EnumMemorials getMemorialTypeByBiomes(World world, BlockPos pos, EnumMemorials.EnumMemorialType[] memorialTypes, GraveGenerationHelper.EnumGraveTypeByEntity graveTypeByEntity) {
//        return getMemorialTypeByBiomes(world, pos, memorialTypes, graveTypeByEntity, false);
//    }
//
//    public static EnumMemorials getMemorialTypeByBiomes(World world, BlockPos pos, EnumMemorials.EnumMemorialType[] memorialTypes, GraveGenerationHelper.EnumGraveTypeByEntity graveTypeByEntity, String deathText) {
//        return getMemorialTypeByBiomes(world, pos, memorialTypes, graveTypeByEntity,
//                GraveGenerationHelper.isBlastDamage(deathText) || GraveGenerationHelper.isFireballDamage(deathText));
//    }
//
//    public static EnumMemorials getMemorialTypeByBiomes(World world, BlockPos pos, EnumMemorials.EnumMemorialType[] memorialTypes, GraveGenerationHelper.EnumGraveTypeByEntity graveTypeByEntity, boolean isCreeper) {
//        EnumGraveMaterial[] materialsArray = GraveGenerationHelper.getGraveMaterialByBiomes(world, pos);
//
//        if (memorialTypes == null || memorialTypes.length == 0) {
//            if (isCreeper) {
//                memorialTypes = GENERATED_CREEPER_STATUES_MEMORIALS_TYPES;
//            } else {
//                memorialTypes = getDefaultMemorialTypes(graveTypeByEntity);
//            }
//        }
//        return getMemorialType(memorialTypes, materialsArray);
//    }
//
//    public boolean isMossy(World world, BlockPos pos, EnumGraveMaterial graveMaterial, EnumMemorials.EnumMemorialType memorialType) {
//        return GraveGenerationHelper.isMossyGrave(world, pos, EnumMemorials.getByTypeAndMaterial(memorialType, graveMaterial).getMaterial());
//    }
//
//    protected static EnumMemorials getMemorialType(EnumMemorials.EnumMemorialType[] memorialTypes, EnumGraveMaterial... materials) {
//        EnumMemorials.EnumMemorialType memorialType = memorialTypes[rand.nextInt(memorialTypes.length)];
//        EnumGraveMaterial material = materials[rand.nextInt(materials.length)];
//
//        return EnumMemorials.getByTypeAndMaterial(memorialType, material);
//    }
//
//    protected static EnumMemorials.EnumMemorialType[] getDefaultMemorialTypes(GraveGenerationHelper.EnumGraveTypeByEntity graveTypeByEntity) {
//        switch (graveTypeByEntity) {
//            case VILLAGERS_GRAVES:
//                return GENERATED_VILLAGERS_MEMORIALS_TYPES;
//            case DOGS_GRAVES:
//                return GENERATED_DOGS_MEMORIALS_TYPES;
//            case CATS_GRAVES:
//                return GENERATED_CAT_MEMORIALS_TYPES;
//            default:
//            case PLAYER_GRAVES:
//                return GENERATED_PLAYER_MEMORIALS_TYPES;
//        }
//    }
//
//    public static class MemorialGenerationInfo {
//        private EnumMemorials memorial;
//        private boolean enchanted;
//        private boolean mossy;
//        private GraveStoneDeathText deathText;
//
//        public MemorialGenerationInfo(EnumMemorials memorial, boolean enchanted, boolean mossy, GraveStoneDeathText deathText) {
//            this.memorial = memorial;
//            this.enchanted = enchanted;
//            this.mossy = mossy;
//            this.deathText = deathText;
//        }
//
//        public EnumMemorials getMemorial() {
//            return memorial;
//        }
//
//        public boolean isMossy() {
//            return mossy;
//        }
//
//        public boolean isEnchanted() {
//            return enchanted;
//        }
//
//        public GraveStoneDeathText getDeathText() {
//            return deathText;
//        }
//    }
}
