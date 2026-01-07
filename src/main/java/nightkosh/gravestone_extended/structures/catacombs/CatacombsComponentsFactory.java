package nightkosh.gravestone_extended.structures.catacombs;

import nightkosh.gravestone_extended.structures.catacombs.components.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CatacombsComponentsFactory {

    /**
     * Return component for level
     */
    public static Class getNextComponentForLevel(Class componentClass, Random random, int level) {
        if (componentClass != Corridor.class) {
            return Corridor.class;
        } else {
            int chance = random.nextInt(100);

            switch (level) {
                case 1:
                    if (chance >= 25) {
                        return getCorridorType(random);
                    } else if (chance >= 10) {
                        if (componentClass == Crossing.class) {
                            return getCorridorType(random);
                        } else {
                            return getCrossingType(random);
                        }
                    } else if (chance >= 5) {
                        if (componentClass == SpidersCorridor.class) {
                            return getCorridorType(random);
                        } else {
                            return SpidersCorridor.class;
                        }
                    } else {
                        if (componentClass == EnderHall.class) {
                            return getCorridorType(random);
                        } else {
                            return EnderHall.class;
                        }
                    }
                default:
                    if (chance >= 55) {
                        return getCorridorType(random);
                    } else if (chance >= 40) {
                        if (componentClass == Crossing.class) {
                            return getCorridorType(random);
                        } else {
                            return getCrossingType(random);
                        }
                    } else if (chance >= 30) {
                        if (componentClass == SpidersCorridor.class) {
                            return getCorridorType(random);
                        } else {
                            return SpidersCorridor.class;
                        }
                    } else if (chance >= 20) {
                        if (componentClass == EnderHall.class) {
                            return getCorridorType(random);
                        } else {
                            return EnderHall.class;
                        }
                    } else if (chance >= 10) {
                        return getHallType(random);
                    } else if (chance >= 5) {
                        if (componentClass == Bridge.class) {
                            return getCorridorType(random);
                        } else {
                            return Bridge.class;
                        }
                    } else {
                        return Treasury.class;
                    }
            }
        }
    }


    public static Class getNextComponent(Class componentClass, CatacombsBaseComponent.ComponentSide componentSide, Random random, int level) {
        if (componentSide == CatacombsBaseComponent.ComponentSide.FRONT) {
            return CatacombsComponentsFactory.getNextComponentForLevel(componentClass, random, level);
        } else {
            if (level == 1 || random.nextInt(100) >= 5) {
                return Corridor.class;
            } else {
                return Treasury.class;
            }
        }
    }

    /**
     * Return ranfom class of corridor component
     */
    public static Class getCorridorType(Random random) {
        int corridorChance = random.nextInt(100);

        if (corridorChance >= 65) {
            return Corridor.class;
        } else if (corridorChance >= 10) {
            return GraveCorridor.class;
        } else {
            return TrapCorridor.class;
        }
    }

    /**
     * Return ranfom class of crossing component
     */
    private static Class getCrossingType(Random random) {
        if (random.nextInt(100) >= 10) {
            return Crossing.class;
        } else {
            return CreeperRoom.class;
        }
    }

    private static Class getHallType(Random random) {
        int hallChance = random.nextInt(10);

        if (hallChance >= 2) {
            return GraveHall.class;
        } else {
            return StatuesHall.class;
        }
    }

    public static Class getEndComponent(int level) {
        if (level == 4) {
            return WitherHall.class;
        } else {
            return Stairs.class;
        }
    }

    public static boolean isEnd(int level) {
        return level == 4;
    }

    public static Class<CatacombsBaseComponent> getCorridorOrTreasury(Random random, Class componentClass, int componentsCount) {
        if (componentsCount < 30 && componentClass == Treasury.class) {
            return getCorridorType(random);
        }
        return componentClass;
    }

//    public static CatacombsBaseComponent createComponent(CatacombsBaseComponent.Passage exit, Random random, EnumFacing facing, int level, Class<CatacombsBaseComponent> buildComponent) {
//        CatacombsBaseComponent component = exit.getComponent();
//        if (component != null) {
//            try {
//                Constructor<CatacombsBaseComponent> constructor = buildComponent.getConstructor(EnumFacing.class, int.class, Random.class, int.class, int.class, int.class);
//                component = constructor.newInstance(facing, level, random, component.getXEnd(exit), component.getYEnd(exit), component.getZEnd(exit));
//                return component;
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return null;
//    }
}
