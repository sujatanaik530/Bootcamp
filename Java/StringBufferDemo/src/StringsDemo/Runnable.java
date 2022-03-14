package StringsDemo;

public class Runnable {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("12345678910");
        System.out.println(sb);
        //System.out.println(sb.delete(2,5));
        System.out.println(sb.replace(0,5,"abcd"));
    }
}
