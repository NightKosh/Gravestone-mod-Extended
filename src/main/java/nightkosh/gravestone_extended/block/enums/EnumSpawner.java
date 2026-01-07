package nightkosh.gravestone_extended.block.enums;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public enum EnumSpawner {//TODO implements IBlockEnum, IStringSerializable {

    WITHER_SPAWNER("block.spawner.wither", "wither_spawner"),
    SKELETON_SPAWNER("block.spawner.skeleton", "skeleton_spawner"),
    ZOMBIE_SPAWNER("block.spawner.zombie", "zombie_spawner"),
    SPIDER_SPAWNER("block.spawner.spider", "spider_spawner");
    private String name;
    private String blockModelName;

    private EnumSpawner(String name, String blockModelName) {
        this.name = name;
        this.blockModelName = blockModelName;
    }

//    @Override
//    public String getUnLocalizedName() {
//        return this.name;
//    }
//
//    @Override
//    public String getName() {
//        return blockModelName;
//    }

    public static EnumSpawner getById(byte id) {
        if (id < values().length) {
            return values()[id];
        }
        return ZOMBIE_SPAWNER;
    }
}
