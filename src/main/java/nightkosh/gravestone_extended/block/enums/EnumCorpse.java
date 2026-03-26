package nightkosh.gravestone_extended.block.enums;

import nightkosh.gravestone_extended.ModGravestoneExtended;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public enum EnumCorpse {//TODO implements IBlockEnum, IStringSerializable {
    STEVE("item.corpse.steve", "corpse_steve", false),
    VILLAGER("item.corpse.villager", "corpse_villager"),
    DOG("item.corpse.dog", "corpse_dog", true, false),
    CAT("item.corpse.cat", "corpse_cat", true, false),
    HORSE("item.corpse.horse", "corpse_horse", true, false),
    ZOMBIE("item.corpse.zombie", "corpse_zombie", false),
    ZOMBIE_VILLAGER("item.corpse.zombie_villager", "corpse_zombie_villager", false),
    SKELETON("item.corpse.skeleton", "corpse_skeleton", false),
    WITCH("item.corpse.witch", "corpse_witch", false);

    private String name;
    private String blockModelName;
    private boolean canBeResurrected;
    private boolean canBeHanged;

    private EnumCorpse(String name, String blockModelName) {
        this(name, blockModelName, true);
    }

    private EnumCorpse(String name, String blockModelName, boolean canBeResurrected) {
        this(name, blockModelName, canBeResurrected, true);
    }

    private EnumCorpse(String name, String blockModelName, boolean canBeResurrected, boolean canBeHanged) {
        this.name = name;
        this.blockModelName = blockModelName;
        this.canBeResurrected = canBeResurrected;
        this.canBeHanged = canBeHanged;
    }

//    @Override
//    public String getUnLocalizedName() {
//        return ModGravestoneExtended.proxy.getLocalizedString(this.name);
//    }
//
//    public static String getPlayerUnLocalizedName() {
//        return ModGravestoneExtended.proxy.getLocalizedString("item.corpse.player");
//    }
//
//    @Override
//    public String getName() {
//        return blockModelName;
//    }

    public boolean canBeHanged() {
        return this.canBeHanged;
    }

    public boolean canBeResurrected() {
        return this.canBeResurrected;
    }

    public static EnumCorpse getById(byte id) {
        if (id < values().length) {
            return values()[id];
        }
        return VILLAGER;
    }
}
