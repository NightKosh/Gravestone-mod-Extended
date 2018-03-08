package nightkosh.gravestone_extended.entity.monster;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.core.GSEnchantment;
import nightkosh.gravestone_extended.core.GSSound;
import nightkosh.gravestone_extended.helper.MobsHelper;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntityPossessedArmor extends EntityMob {

    private static final List<Map<EntityEquipmentSlot, Item>> ARMOR_LIST = new ArrayList<>(3);

    static {
        Map<EntityEquipmentSlot, Item> ironArmorMap = new HashMap<>();
        ironArmorMap.put(EntityEquipmentSlot.HEAD, Items.IRON_HELMET);
        ironArmorMap.put(EntityEquipmentSlot.CHEST, Items.IRON_CHESTPLATE);
        ironArmorMap.put(EntityEquipmentSlot.LEGS, Items.IRON_LEGGINGS);
        ironArmorMap.put(EntityEquipmentSlot.FEET, Items.IRON_BOOTS);
        ARMOR_LIST.add(ironArmorMap);

        Map<EntityEquipmentSlot, Item> goldenArmorMap = new HashMap<>();
        goldenArmorMap.put(EntityEquipmentSlot.HEAD, Items.GOLDEN_HELMET);
        goldenArmorMap.put(EntityEquipmentSlot.CHEST, Items.GOLDEN_CHESTPLATE);
        goldenArmorMap.put(EntityEquipmentSlot.LEGS, Items.GOLDEN_LEGGINGS);
        goldenArmorMap.put(EntityEquipmentSlot.FEET, Items.GOLDEN_BOOTS);
        ARMOR_LIST.add(goldenArmorMap);

        Map<EntityEquipmentSlot, Item> diamondArmorMap = new HashMap<>();
        diamondArmorMap.put(EntityEquipmentSlot.HEAD, Items.DIAMOND_HELMET);
        diamondArmorMap.put(EntityEquipmentSlot.CHEST, Items.DIAMOND_CHESTPLATE);
        diamondArmorMap.put(EntityEquipmentSlot.LEGS, Items.DIAMOND_LEGGINGS);
        diamondArmorMap.put(EntityEquipmentSlot.FEET, Items.DIAMOND_BOOTS);
        ARMOR_LIST.add(diamondArmorMap);
    }

    public EntityPossessedArmor(World world) {
        super(world);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1, false));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8));
        this.tasks.addTask(8, new EntityAILookIdle(this));

        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4);
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }

    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        livingdata = super.onInitialSpawn(difficulty, livingdata);

        Map<EntityEquipmentSlot, Item> armorMap = ARMOR_LIST.get(this.rand.nextInt(ARMOR_LIST.size()));

        ItemStack helmet = new ItemStack(armorMap.get(EntityEquipmentSlot.HEAD));
        helmet.addEnchantment(Enchantment.getEnchantmentByLocation("binding_curse"), 1);
        helmet.addEnchantment(GSEnchantment.CURSE_STARVATION, 1);

        ItemStack chestPlate = new ItemStack(armorMap.get(EntityEquipmentSlot.CHEST));
        chestPlate.addEnchantment(Enchantment.getEnchantmentByLocation("binding_curse"), 1);
        chestPlate.addEnchantment(GSEnchantment.CURSE_STARVATION, 1);

        ItemStack leggings = new ItemStack(armorMap.get(EntityEquipmentSlot.LEGS));
        leggings.addEnchantment(Enchantment.getEnchantmentByLocation("binding_curse"), 1);
        leggings.addEnchantment(GSEnchantment.CURSE_STARVATION, 1);

        ItemStack boots = new ItemStack(armorMap.get(EntityEquipmentSlot.FEET));
        boots.addEnchantment(Enchantment.getEnchantmentByLocation("binding_curse"), 1);
        boots.addEnchantment(GSEnchantment.CURSE_STARVATION, 1);

        this.setItemStackToSlot(EntityEquipmentSlot.HEAD, helmet);
        this.setItemStackToSlot(EntityEquipmentSlot.CHEST, chestPlate);
        this.setItemStackToSlot(EntityEquipmentSlot.LEGS, leggings);
        this.setItemStackToSlot(EntityEquipmentSlot.FEET, boots);


        return livingdata;
    }

    @Override
    public void onLivingUpdate() {
        if (this.world.isDaytime() && !this.world.isRemote) {
            float f = this.getBrightness();

            if (f > 0.5 && this.rand.nextFloat() * 30 < (f - 0.4) * 2 && this.world.canSeeSky(new BlockPos(this.posX, this.posY + this.getEyeHeight(), this.posZ))) {
                this.setFire(8);
            }
        }

        super.onLivingUpdate();
    }

    @Override
    public float getEyeHeight() {
        return 1.9F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_CHAIN;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return GSSound.ENTITY_POSSESSED_ARMOR_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ITEM_SHIELD_BREAK;
    }

    @Override
    protected void playStepSound(BlockPos pos, Block block) {
        this.playSound(GSSound.ENTITY_POSSESSED_ARMOR_STEP, 0.15F, 1);
    }

    @Override
    public boolean getCanSpawnHere() {
        return super.getCanSpawnHere() && MobsHelper.isDimensionAllowedForSpawn(this.world);
    }
}
