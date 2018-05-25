package nightkosh.gravestone_extended.entity.monster;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.core.GSLootTables;

import javax.annotation.Nullable;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntityPhantomDiver extends EntityDrowned {
    public EntityPhantomDiver(World world) {
        super(world);
    }

    @Nullable
    protected ResourceLocation getLootTable() {
        return GSLootTables.PHANTOM_DIVER;
    }
}
