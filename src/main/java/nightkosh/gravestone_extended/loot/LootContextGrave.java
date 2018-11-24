package nightkosh.gravestone_extended.loot;

import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTableManager;
import nightkosh.gravestone.api.grave.EnumGraveMaterial;
import nightkosh.gravestone.helper.GraveGenerationHelper;
import nightkosh.gravestone_extended.helper.GraveInventoryHelper;

import javax.annotation.Nullable;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class LootContextGrave extends LootContext {

    private EnumGraveMaterial graveMaterial;
    private GraveInventoryHelper.GraveContentType graveContentType;
    private GraveGenerationHelper.EnumGraveTypeByEntity graveTypeByEntity;
    private GraveInventoryHelper.GraveCorpseContentType corpseContentType;

    public LootContextGrave(float luck, WorldServer world, LootTableManager lootTableManager,
                            @Nullable GraveInventoryHelper.GraveCorpseContentType corpseContentType,
                            @Nullable GraveGenerationHelper.EnumGraveTypeByEntity graveTypeByEntity,
                            @Nullable GraveInventoryHelper.GraveContentType graveContentType,
                            @Nullable EnumGraveMaterial graveMaterial) {
        super(luck, world, lootTableManager, null, null, null);
        this.graveMaterial = graveMaterial;
        this.graveContentType = graveContentType;
        this.graveTypeByEntity = graveTypeByEntity;
        this.corpseContentType = corpseContentType;
    }

    public EnumGraveMaterial getGraveMaterial() {
        return graveMaterial;
    }

    public GraveInventoryHelper.GraveContentType getGraveContentType() {
        return graveContentType;
    }

    public GraveGenerationHelper.EnumGraveTypeByEntity getGraveTypeByEntity() {
        return graveTypeByEntity;
    }

    public GraveInventoryHelper.GraveCorpseContentType getCorpseContentType() {
        return corpseContentType;
    }

    public static class Builder {
        private final WorldServer world;
        private EnumGraveMaterial graveMaterial;
        private GraveInventoryHelper.GraveContentType graveContentType;
        private GraveGenerationHelper.EnumGraveTypeByEntity graveTypeByEntity;
        private GraveInventoryHelper.GraveCorpseContentType corpseContentType;

        public Builder(WorldServer world) {
            this.world = world;
        }

        public Builder withGraveMaterial(EnumGraveMaterial graveMaterial) {
            this.graveMaterial = graveMaterial;
            return this;
        }

        public Builder withGraveContentType(GraveInventoryHelper.GraveContentType graveContentType) {
            this.graveContentType = graveContentType;
            return this;
        }

        public Builder withGraveTypeByEntity(GraveGenerationHelper.EnumGraveTypeByEntity graveTypeByEntity) {
            this.graveTypeByEntity = graveTypeByEntity;
            return this;
        }

        public Builder withCorpseContentType(GraveInventoryHelper.GraveCorpseContentType corpseContentType) {
            this.corpseContentType = corpseContentType;
            return this;
        }

        public LootContextGrave build() {
            return new LootContextGrave(0, this.world, this.world.getLootTableManager(), corpseContentType, graveTypeByEntity, graveContentType, graveMaterial);
        }
    }
}
