package LambdaDemo3;

public class Generator {
    public static void main(String[] args) {
        ComparatorInterface reverser_space = (str) -> {
            String substr = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                substr += str.charAt(i);
            }
            return substr;
        };
        ComparatorInterface normal_nospace = (str) -> {
            String substr = "";
            for (int i = 0; i < str.length(); i++) {
                String s = Character.toString(str.charAt(i));
                if (!s.equals(" ")) {
                    substr += s;
                }
            }
            return substr;
        };
        System.out.println(reverser_space.comparator("Hello class of JD"));
        System.out.println(normal_nospace.comparator("Hello class of JD"));
    }
}
