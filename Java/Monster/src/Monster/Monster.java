package Monster;

public class Monster {
    protected String mName;

    public Monster(String name) {
        mName = name;
    }

    public String attack() {
        return "";
    }

    public String getName() {
        return this.mName;
    }
}
