package nightkosh.gravestone_extended.core.compatibility;

import nightkosh.gravestone_extended.config.ExtendedConfig;
import nightkosh.gravestone_extended.core.logger.GSLogger;
import nightkosh.gravestone_extended.entity.monster.bat.EntityVampireBat;
import nightkosh.gravestone_extended.entity.monster.bat.EntityWitheredBat;
import nightkosh.gravestone_extended.entity.monster.crawler.*;
import nightkosh.gravestone_extended.entity.monster.pet.EntitySkeletonCat;
import nightkosh.gravestone_extended.entity.monster.pet.EntitySkeletonDog;
import nightkosh.gravestone_extended.entity.monster.pet.EntityZombieCat;
import nightkosh.gravestone_extended.entity.monster.pet.EntityZombieDog;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CompatibilityInfernalMobs {

    public static final String ID = "infernalmobs";
    protected static boolean isInstalled = false;

    public static void disableInfernalMobs() {
        if (ExtendedConfig.disableInfernalMobs) {
            try {
                Class<?> clazz = Class.forName("atomicstryker.infernalmobs.common.InfernalMobsCore");
                Method instanceMethod = clazz.getDeclaredMethod("instance");
                Object result = instanceMethod.invoke(null);

                Field field = clazz.getDeclaredField("classesAllowedMap");
                field.setAccessible(true);

                HashMap<String, Boolean> classesAllowedMap = (HashMap<String, Boolean>) field.get(result);
                classesAllowedMap.put(EntitySkeletonCat.class.getSimpleName(), false);
                classesAllowedMap.put(EntityZombieCat.class.getSimpleName(), false);
                classesAllowedMap.put(EntitySkeletonDog.class.getSimpleName(), false);
                classesAllowedMap.put(EntityZombieDog.class.getSimpleName(), false);
                classesAllowedMap.put(EntityVampireBat.class.getSimpleName(), false);
                classesAllowedMap.put(EntityWitheredBat.class.getSimpleName(), false);
                classesAllowedMap.put(EntitySkullCrawler.class.getSimpleName(), false);
                classesAllowedMap.put(EntityWitherSkullCrawler.class.getSimpleName(), false);
                classesAllowedMap.put(EntityStraySkullCrawler.class.getSimpleName(), false);
                classesAllowedMap.put(EntityZombieSkullCrawler.class.getSimpleName(), false);
                classesAllowedMap.put(EntityHuskSkullCrawler.class.getSimpleName(), false);
                classesAllowedMap.put(EntityPigmanSkullCrawler.class.getSimpleName(), false);

            } catch (ClassNotFoundException e) {
                GSLogger.logError("Can't find InfernalMobsCore class");
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                GSLogger.logError("Can't find instance method");
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                GSLogger.logError("Can't invoke instance method");
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                GSLogger.logError("Can't change classesAllowedMap field access modifier");
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                GSLogger.logError("Can't find classesAllowedMap field");
                e.printStackTrace();
            }
        }
    }
}
