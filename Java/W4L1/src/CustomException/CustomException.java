package CustomException;

// 1. extends
// 2. constructor with only one parameter, use super()

// Custom exception are checked exceptions.
// So, they are handled using try-catch or throws.

public class CustomException extends Exception {
    CustomException(String str) {
        super(str);
    }
}
