package nightkosh.gravestone_extended.capability.cemetery;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public interface ICemetery {

    public CemeteryInfo getPlayerCemetery();

    public void setPlayerCemetery(CemeteryInfo cemetery);

    public CemeteryInfo getPetCemetery();

    public void setPetCemetery(CemeteryInfo cemetery);
}
