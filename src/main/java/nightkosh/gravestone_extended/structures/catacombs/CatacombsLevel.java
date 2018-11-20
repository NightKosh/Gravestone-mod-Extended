package nightkosh.gravestone_extended.structures.catacombs;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureComponent;
import nightkosh.gravestone_extended.config.ExtendedConfig;
import nightkosh.gravestone_extended.core.logger.GSLogger;
import nightkosh.gravestone_extended.helper.StateHelper;
import nightkosh.gravestone_extended.structures.catacombs.components.CatacombsBaseComponent;
import nightkosh.gravestone_extended.structures.catacombs.components.Corridor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CatacombsLevel {

    private static final StructureComponent.BlockSelector catacombsStoneBlocks = new CatacombsStonesBlocks();
    private static final StructureComponent.BlockSelector catacombsBoneBlocks = new CatacombsBoneBlocks();
    private final int level;
    private Random random;
    private World world;
    private int totalComponentsCount;
    private int componentsCount;
    public static final int DEFAULT_MIN_ROOMS_COUNT_AT_1_LEVEL = 30;
    public static final int DEFAULT_MAX_ROOMS_COUNT_AT_1_LEVEL = 60;
    public static final int DEFAULT_MIN_ROOMS_COUNT_AT_2_LEVEL = 60;
    public static final int DEFAULT_MAX_ROOMS_COUNT_AT_2_LEVEL = 120;
    public static final int DEFAULT_MIN_ROOMS_COUNT_AT_3_LEVEL = 90;
    public static final int DEFAULT_MAX_ROOMS_COUNT_AT_3_LEVEL = 180;
    public static final int DEFAULT_MIN_ROOMS_COUNT_AT_4_LEVEL = 160;
    public static final int DEFAULT_MAX_ROOMS_COUNT_AT_4_LEVEL = 320;
    private List<CatacombsBaseComponent> levelComponents = new ArrayList<>();
    private List<CatacombsBaseComponent> endComponents = new ArrayList<>();

    public CatacombsLevel(List<CatacombsBaseComponent> startComponents, int level, World world, Random random) {
        levelComponents = startComponents;
        this.random = random;
        this.world = world;
        this.level = level;
        GSLogger.logInfo("Catacombs generation - start generation of " + this.level + " level");

        switch (this.level) {
            case 1:
                totalComponentsCount = ExtendedConfig.catacombsMinRoomsCountAt1Level + random.nextInt(ExtendedConfig.catacombsMaxRoomsCountAt1Level - ExtendedConfig.catacombsMinRoomsCountAt1Level);
                break;
            case 2:
                totalComponentsCount = ExtendedConfig.catacombsMinRoomsCountAt2Level + random.nextInt(ExtendedConfig.catacombsMaxRoomsCountAt2Level - ExtendedConfig.catacombsMinRoomsCountAt2Level);
                break;
            case 3:
                totalComponentsCount = ExtendedConfig.catacombsMinRoomsCountAt3Level + random.nextInt(ExtendedConfig.catacombsMaxRoomsCountAt3Level - ExtendedConfig.catacombsMinRoomsCountAt3Level);
                break;
            case 4:
                totalComponentsCount = ExtendedConfig.catacombsMinRoomsCountAt4Level + random.nextInt(ExtendedConfig.catacombsMaxRoomsCountAt4Level - ExtendedConfig.catacombsMinRoomsCountAt4Level);
                break;
        }

        componentsCount = 0;
        prepareLevel(levelComponents);
        generateLevel();

        GSLogger.logInfo("Catacombs generation - " + this.level + " level was successfully generated");
    }

    public static StructureComponent.BlockSelector getCatacombsStones(int level) {
        return (level < 3) ? catacombsStoneBlocks : catacombsBoneBlocks;
    }

    public static IBlockState getCatacombsStairsByLevelId(int level) {
        return (level < 3) ? StateHelper.STONE_BRICK_STAIRS_TOP : StateHelper.BONE_STAIRS_TOP;
    }

    public final void prepareLevel(List<CatacombsBaseComponent> currentComponents) {
        List<CatacombsBaseComponent.Passage> exitsList = new ArrayList<>();
        List<CatacombsBaseComponent.Passage> requiredExitsList = new ArrayList<>();

        for (CatacombsBaseComponent component : currentComponents) {
            requiredExitsList.addAll(component.getRequiredExitList());
            exitsList.addAll(component.getExitList());
        }
        prepareLevel(requiredExitsList, exitsList);
    }

    private void prepareLevel(List<CatacombsBaseComponent.Passage> requiredExitsList, List<CatacombsBaseComponent.Passage> exitsList) {
        List<CatacombsBaseComponent.Passage> newRequiredExitsList = new ArrayList<>();
        List<CatacombsBaseComponent.Passage> newExitsList = new ArrayList<>();
        int resultComponentsCount = 0;

        if (totalComponentsCount > componentsCount) {
            for (CatacombsBaseComponent.Passage exit : requiredExitsList) {
                EnumFacing direction;
                switch (exit.getSide()) {
                    default:
                    case FRONT:
                        direction = exit.getComponent().getDirection();
                        break;
                    case LEFT:
                        direction = exit.getComponent().getLeftDirection();
                        break;
                    case RIGHT:
                        direction = exit.getComponent().getRightDirection();
                        break;
                }

                CatacombsBaseComponent newComponent = tryCreateComponent(exit, direction);
                if (newComponent != null) {
                    newRequiredExitsList.addAll(newComponent.getRequiredExitList());
                    newExitsList.addAll(newComponent.getExitList());
                    resultComponentsCount++;
                    exit.setState(CatacombsBaseComponent.PassageState.CONNECTED);
                } else {
                    exit.setState(CatacombsBaseComponent.PassageState.CLOSED);
                }
            }

            if (!exitsList.isEmpty()) {
//                Collections.shuffle(exitsList, random);
                while (!exitsList.isEmpty()) {
                    CatacombsBaseComponent.Passage exit = exitsList.get(random.nextInt(exitsList.size()));
                    if (!exit.getState().equals(CatacombsBaseComponent.PassageState.CLOSED)) {//TODO temporal fix of ConcurrentModificationException
                        EnumFacing direction;
                        switch (exit.getSide()) {
                            default:
                            case FRONT:
                                direction = exit.getComponent().getDirection();
                                break;
                            case LEFT:
                                direction = exit.getComponent().getLeftDirection();
                                break;
                            case RIGHT:
                                direction = exit.getComponent().getRightDirection();
                                break;
                        }

                        CatacombsBaseComponent newComponent = tryCreateComponent(exit, direction);
                        if (newComponent != null) {
                            newRequiredExitsList.addAll(newComponent.getRequiredExitList());
                            newExitsList.addAll(newComponent.getExitList());
                            resultComponentsCount++;

                            exit.setState(CatacombsBaseComponent.PassageState.CONNECTED);
                            exitsList.remove(exit);
                            break;
                        } else {
                            exit.setState(CatacombsBaseComponent.PassageState.CLOSED);
                            exitsList.remove(exit);
                        }
                    }
                }
            }

            for (CatacombsBaseComponent.Passage exit : exitsList) {//TODO temporal fix of ConcurrentModificationException
                if (exit.getState().equals(CatacombsBaseComponent.PassageState.OPEN)) {
                    newExitsList.add(exit);
                }
            }

            if (resultComponentsCount > 0 && (!newRequiredExitsList.isEmpty() || !newExitsList.isEmpty())) {
                componentsCount += resultComponentsCount;
                prepareLevel(newRequiredExitsList, newExitsList);
            }
        } else if (endComponents.isEmpty()) {
            createEnd(requiredExitsList, exitsList, level);
        }
    }

    private void createEnd(List<CatacombsBaseComponent.Passage> requiredExitsList, List<CatacombsBaseComponent.Passage> exitsList, int level) {
        CatacombsBaseComponent component, newComponent;
        Class componentClass = CatacombsComponentsFactory.getEndComponent(level);
        int ends = 0;

        if (CatacombsComponentsFactory.isEnd(level)) {
            ends = 1;
        } else {
            if (!requiredExitsList.isEmpty()) {
                ends += 1 + random.nextInt(requiredExitsList.size() - 1);
            }
            if (!exitsList.isEmpty()) {
                ends += 1 + random.nextInt(exitsList.size() - 1);
            }
        }
        int endsCount = 0;

        List<CatacombsBaseComponent.Passage> exits = new ArrayList<>(requiredExitsList.size() + exitsList.size());
        Collections.shuffle(requiredExitsList, random);
        Collections.shuffle(exitsList, random);
        exits.addAll(requiredExitsList);
        exits.addAll(exitsList);
        for (CatacombsBaseComponent.Passage exit : exits) {
            if (endsCount >= ends) {
                break;
            }
            EnumFacing direction;
            switch (exit.getSide()) {
                default:
                case FRONT:
                    direction = exit.getComponent().getDirection();
                    break;
                case LEFT:
                    direction = exit.getComponent().getLeftDirection();
                    break;
                case RIGHT:
                    direction = exit.getComponent().getRightDirection();
                    break;
            }

            newComponent = tryCreateEndComponent(exit, componentClass, direction, level);
            if (newComponent != null) {
                levelComponents.add(newComponent);
                endComponents.add(newComponent);
                endsCount++;
            }
        }

        if (endsCount == 0) {
            component = levelComponents.get(levelComponents.size() - 1);

            exits = component.getExitList();
            if (exits != null && exits.size() > 0) {
                CatacombsBaseComponent.Passage exit = exits.get(random.nextInt(exits.size()));
                EnumFacing direction;
                switch (exit.getSide()) {
                    default:
                    case FRONT:
                        direction = component.getDirection();
                        break;
                    case LEFT:
                        direction = component.getLeftDirection();
                        break;
                    case RIGHT:
                        direction = component.getRightDirection();
                        break;
                }
                newComponent = CatacombsComponentsFactory.createComponent(exit, random, direction, level, componentClass);
                levelComponents.add(newComponent);
                endComponents.add(newComponent);
            }
        }
    }

    private CatacombsBaseComponent tryCreateComponent(CatacombsBaseComponent.Passage exit, Class componentClass, EnumFacing direction, int level) {
        Class buildComponent = CatacombsComponentsFactory.getCorridorOrTreasury(random, componentClass, componentsCount);
        CatacombsBaseComponent newComponent = CatacombsComponentsFactory.createComponent(exit, random, direction, level, buildComponent);

        if (!canBePlaced(newComponent)) {
            buildComponent = Corridor.class;
            newComponent = CatacombsComponentsFactory.createComponent(exit, random, direction, level, buildComponent);
        }

        if (canBePlaced(newComponent)) {
            levelComponents.add(newComponent);
            return newComponent;
        } else {
            return null;
        }
    }

    private CatacombsBaseComponent tryCreateEndComponent(CatacombsBaseComponent.Passage exit, Class componentClass, EnumFacing direction, int level) {
        CatacombsBaseComponent newComponent = CatacombsComponentsFactory.createComponent(exit, random, direction, level, componentClass);

        if (!canBePlaced(newComponent)) {
            newComponent = CatacombsComponentsFactory.createComponent(exit, random, direction, level, componentClass);
        }

        if (canBePlaced(newComponent)) {
            levelComponents.add(newComponent);
            return newComponent;
        } else {
            return null;
        }
    }

    private CatacombsBaseComponent tryCreateComponent(CatacombsBaseComponent.Passage exit, EnumFacing direction) {
        return tryCreateComponent(exit, CatacombsComponentsFactory.getNextComponent(exit.getComponent().getClass(), exit.getSide(), random, level), direction, level);
    }

    /**
     * Check is this place availiable for this component
     */
    private boolean canBePlaced(CatacombsBaseComponent component) {
        for (CatacombsBaseComponent xz : levelComponents) {
            if (component.canBePlacedHere(xz.getBoundingBox())) {
                return false;
            }
        }

        return true;
    }

    public final void generateLevel() {
        CatacombsBaseComponent component;

        for (CatacombsBaseComponent levelComponent : levelComponents) {
            component = levelComponent;
            component.addComponentParts(world, random);
        }
    }

    public List<CatacombsBaseComponent> getEndParts() {
        return endComponents;
    }
}
