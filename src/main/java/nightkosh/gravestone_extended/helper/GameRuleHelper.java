package nightkosh.gravestone_extended.helper;

import net.minecraft.world.World;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GameRuleHelper {

    public static final String RULE_MOB_GRIEFING = "mobGriefing";
    public static final String RULE_KEEP_INVENTORY = "keepInventory";
    public static final String RULE_DO_FIRE_TICK = "doFireTick";

    public static boolean checkRule(World world, String rule) {
        return world.getGameRules().getBoolean(rule);
    }

    public static boolean checkMobGriefing(World world) {
        return checkRule(world, RULE_MOB_GRIEFING);
    }

    public static boolean checkKeepInventory(World world) {
        return checkRule(world, RULE_KEEP_INVENTORY);
    }

    public static boolean checkFireTick(World world) {
        return checkRule(world, RULE_DO_FIRE_TICK);
    }
}
