package Monster;

public class EntryPoint {
    public static void main(String[] args) {
        Monster wm = new WaterMonster("The Water Monster");
        Monster fm = new FireMonster("The Fire Monster");
        Monster sm = new StoneMonster("The Stone Monster");

        System.out.println(wm.getName() + ": " + wm.attack());
        System.out.println(fm.getName() + ": " + fm.attack());
        System.out.println(sm.getName() + ": " + sm.attack());
    }
}
