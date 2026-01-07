package nightkosh.gravestone_extended.entity.monster.pet;

import nightkosh.gravestone_extended.ModGravestoneExtended;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public enum EnumUndeadMobType {
    OTHER(""),
    ZOMBIE("mobtype.zombie"),
    SKELETON("mobtype.skeleton"),
    GHOST("mobtype.ghost"),
    HUSK("mobtype.husk"),
    STRAY("mobtype.stray"),
    WITHER("mobtype.wither"),
    PIGMAN("mobtype.pigman");

    private String name;
    private EnumUndeadMobType(String name) {
        this.name =  name;
    }

    public static EnumUndeadMobType getById(int id) {
        if (id < EnumUndeadMobType.values().length) {
            return EnumUndeadMobType.values()[id];
        } else {
            return OTHER;
        }
    }

    public String getName() {
        return this.name;
    }

    public boolean sunLightProtected() {
        return this == HUSK || fireProtected();
    }

    public boolean fireProtected() {
        return this == WITHER;
    }
}
