package nightkosh.gravestone_extended.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import nightkosh.gravestone_extended.core.logger.GSLogger;

import java.util.ArrayList;
import java.util.List;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ConfigsHelper {


    public static List<Integer> getDimensionList(Configuration config, String category, String ConfigID, int defaultValue, String comment) {
        Property dimensionIdProperty = config.get(category, ConfigID, Integer.toString(defaultValue));
        dimensionIdProperty.setComment(comment);
        String ar = dimensionIdProperty.getString();
        String[] ids = ar.split(";");
        List<Integer> dimensionIds = new ArrayList<>(ids.length);
        for (String id : ids) {
            try {
                dimensionIds.add(Integer.parseInt(id));
            } catch (NumberFormatException e) {
                GSLogger.logError("Can't parse Dimension Id list!!!");
                e.printStackTrace();
            }
        }
        if (dimensionIds.isEmpty()) {
            dimensionIds.add(defaultValue);
        }
        return dimensionIds;
    }
}
