package nightkosh.gravestone_extended.entity.monster;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.core.GSItem;

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


    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        super.dropFewItems(wasRecentlyHit, lootingModifier);

        if (wasRecentlyHit && (this.rand.nextInt(200) <= lootingModifier)) {
            this.entityDropItem(new ItemStack(GSItem.DIVING_HELMET), 0);
        }
    }

    @Override
    protected Item getDropItem() {
        return GSItem.PIECE_OF_DIVING_SUIT;
    }
}
