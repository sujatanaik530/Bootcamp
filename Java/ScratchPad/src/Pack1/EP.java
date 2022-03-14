package Pack1;

public class EP {
    public static void main(String[] args) {
        FI myFI = (a, b) -> { return a + b;};
        System.out.println(myFI.fnOne(2, 3));
    }
}
