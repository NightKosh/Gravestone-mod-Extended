package nightkosh.gravestone_extended.capability.choke;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public interface IChoke {

    public void setAir(int air);

    public int getAir();

    public boolean isActive();

    public void setActive(boolean active);
}
