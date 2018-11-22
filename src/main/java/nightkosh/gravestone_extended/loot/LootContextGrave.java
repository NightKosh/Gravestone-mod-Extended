package nightkosh.gravestone_extended.loot;

import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTableManager;
import nightkosh.gravestone_extended.helper.GraveInventoryHelper;

import javax.annotation.Nullable;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class LootContextGrave extends LootContext {

    private GraveInventoryHelper.ContentMaterials contentMaterial;

    public LootContextGrave(float luck, WorldServer world, LootTableManager lootTableManager, @Nullable GraveInventoryHelper.ContentMaterials contentMaterial) {
        super(luck, world, lootTableManager, null, null, null);
        this.contentMaterial = contentMaterial;
    }

    public GraveInventoryHelper.ContentMaterials getContentMaterial() {
        return contentMaterial;
    }

    public static class Builder {
        private final WorldServer world;
        private GraveInventoryHelper.ContentMaterials contentMaterial;

        public Builder(WorldServer world) {
            this.world = world;
        }


        public Builder withContentMaterial(GraveInventoryHelper.ContentMaterials contentMaterial) {
            this.contentMaterial = contentMaterial;
            return this;
        }

        public LootContextGrave build() {
            return new LootContextGrave(0, this.world, this.world.getLootTableManager(), contentMaterial);
        }
    }
}
