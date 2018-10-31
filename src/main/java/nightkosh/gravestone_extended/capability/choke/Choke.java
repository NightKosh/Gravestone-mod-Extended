package nightkosh.gravestone_extended.capability.choke;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Choke implements IChoke {

    private int air = 300;
    private boolean active = false;

    @Override
    public void setAir(int air) {
        this.air = air;
    }

    @Override
    public int getAir() {
        return air;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }
}
