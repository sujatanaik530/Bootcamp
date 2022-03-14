package FIDemo2;

public class Water {
    Cookable c = new Cookable() {

        @Override
        public void cook() {
            System.out.println("the water is hot");
        }
    };
}

class Food {
    int time;
    int velocity;

    public Food() {
        time = 2;
        velocity = 3;
    }

    Cookable c = new Cookable() {

        @Override
        public void cook() {
            System.out.println("the food is ready to eat");
        }
    };

    MysteryMathFunction mf = new MysteryMathFunction() {

        @Override
        public int f(int n) {
            return n * time * velocity * MysteryMathFunction.VALUE;
        }
    };

    public void msg() {
        for (int i = 0; i < mf.f(1) / 8; i++) {
            System.out.print(i + " ");
            c.cook();
        }
    }

}