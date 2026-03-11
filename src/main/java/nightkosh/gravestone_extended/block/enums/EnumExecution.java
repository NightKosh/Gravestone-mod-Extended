package nightkosh.gravestone_extended.block.enums;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public enum EnumExecution {//TODO implements IBlockEnum, IStringSerializable {

    GALLOWS("block.execution.gallows", "gallows"),//, Resources.GALLOWS),
    GIBBET("block.execution.gibbet", "gibbet"),//, Resources.GIBBET),
    STOCKS("block.execution.stocks", "stocks"),//, Resources.STOCKS),
    BURNING_STAKE("block.execution.burning_stake", "burning_stake");//, Resources.BURNING_STAKE);

    private String name;
    private String blockModelName;
//    private ResourceLocation texture;

    private EnumExecution(String name, String blockModelName){//}, ResourceLocation texture) {
        this.name = name;
//        this.texture = texture;
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
//
//    public ResourceLocation getTexture() {
//        return this.texture;
//    }

    public static EnumExecution getById(int id) {
        if (id < values().length) {
            return values()[id];
        }
        return GIBBET;
    }
}
