package pt.uma.tpsi;

public class Supervisor extends Employee {

    private int level;
    public Supervisor (final String name, final String ssn, final int level) {

    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "(" + getName() + ", " + getSsn() + ", " + getLevel() + ")";
    }
}
