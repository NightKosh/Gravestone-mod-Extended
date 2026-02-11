package nightkosh.gravestone_extended.block_entity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import nightkosh.gravestone_extended.block_entity.inventory.CorpseInventory;
import nightkosh.gravestone_extended.block_entity.inventory.DisenchantmentInventory;
import nightkosh.gravestone_extended.block_entity.inventory.EnchantmentInventory;
import nightkosh.gravestone_extended.core.GSEBlockEntities;
import nightkosh.gravestone_extended.gui.container.DisenchantmentContainerMenu;
import nightkosh.gravestone_extended.gui.container.ResurrectionContainerMenu;

import javax.annotation.Nonnull;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AltarBlockEntity extends BlockEntity implements MenuProvider {

    private final CorpseInventory corpseInventory;
    private final EnchantmentInventory enchantmentInventory;
    private final DisenchantmentInventory disenchantmentInventory;

    public AltarBlockEntity(BlockPos pos, BlockState blockState) {
        this(GSEBlockEntities.ALTAR.get(), pos, blockState);
    }

    public AltarBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
        this.corpseInventory = new CorpseInventory(this);
        this.enchantmentInventory = new EnchantmentInventory(this);
        this.disenchantmentInventory = new DisenchantmentInventory(this);
    }

    public CorpseInventory getCorpseInventory() {
        return corpseInventory;
    }

    public EnchantmentInventory getEnchantmentInventory() {
        return enchantmentInventory;
    }

    public DisenchantmentInventory getDisenchantmentInventory() {
        return disenchantmentInventory;
    }

    @Nonnull
    @Override
    public Component getDisplayName() {
        return Component.empty();
    }

    @Nonnull
    @Override
    public AbstractContainerMenu createMenu(
            int containerId, @Nonnull Inventory playerInventory, @Nonnull Player player) {
        return new ResurrectionContainerMenu(containerId, playerInventory, this);
    }

    @Override
    public void handleUpdateTag(@Nonnull ValueInput in) {
        this.loadAdditional(in);
    }

    @Override
    public void loadAdditional(@Nonnull ValueInput in) {
        super.loadAdditional(in);
        corpseInventory.loadAdditional(in);
        enchantmentInventory.loadAdditional(in);
        disenchantmentInventory.loadAdditional(in);
    }

    @Override
    public void saveAdditional(@Nonnull ValueOutput out) {
        super.saveAdditional(out);
        corpseInventory.saveAdditional(out);
        enchantmentInventory.saveAdditional(out);
        disenchantmentInventory.saveAdditional(out);
    }

    @Override
    public void preRemoveSideEffects(@Nonnull BlockPos pos, @Nonnull BlockState state) {
        super.preRemoveSideEffects(pos, state);
        dropItems(corpseInventory);
        dropItems(enchantmentInventory);
        dropItems(disenchantmentInventory);
    }

    private void dropItems(Container container) {
        for (int i = 0; i < container.getContainerSize(); i++) {
            var item = container.getItem(i);
            if (!item.isEmpty()) {
                this.level.addFreshEntity(
                        new ItemEntity(
                                this.level,
                                this.getBlockPos().getX(),
                                this.getBlockPos().getY(),
                                this.getBlockPos().getZ(),
                                item));
                container.removeItemNoUpdate(i);
            }
        }
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

}
