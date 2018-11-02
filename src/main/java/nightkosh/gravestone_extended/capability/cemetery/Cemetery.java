package nightkosh.gravestone_extended.capability.cemetery;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Cemetery implements ICemetery {

    private CemeteryInfo playerCemetery;
    private CemeteryInfo petCemetery;

    @Override
    public CemeteryInfo getPlayerCemetery() {
        return playerCemetery;
    }

    @Override
    public void setPlayerCemetery(CemeteryInfo cemetery) {
        this.playerCemetery = cemetery;
    }

    @Override
    public CemeteryInfo getPetCemetery() {
        return petCemetery;
    }

    @Override
    public void setPetCemetery(CemeteryInfo cemetery) {
        this.petCemetery = cemetery;
    }
}
