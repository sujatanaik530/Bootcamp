package CustomException;

public class Runnable {
    // With the below throws usage, whoever calls the main method has to handle the exception.
    public static void main(String[] args) throws CustomException {
        throw new CustomException("My custom exception");
    }

    // With the below try-catch usage, the main method handles the exception.
    /*public static void main(String[] args) {
        try {
            throw new CustomException("My custom exception");
        }
        catch (CustomException e) {
            System.out.println(e);
        }
    }*/
}
