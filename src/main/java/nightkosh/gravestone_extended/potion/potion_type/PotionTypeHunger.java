package nightkosh.gravestone_extended.potion.potion_type;

import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import nightkosh.gravestone_extended.core.ModInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class PotionTypeHunger extends PotionType {

    public PotionTypeHunger(PotionEffect... effects) {
        super(effects);
        this.setRegistryName(ModInfo.ID, "gs_hunger_type");
    }

    @Override
    public List<PotionEffect> getEffects() {
        List<PotionEffect> effectList = new ArrayList<>(1);
        effectList.add(new PotionEffect(MobEffects.HUNGER, 1200));
        return effectList;
    }
}
