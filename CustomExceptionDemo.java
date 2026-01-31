// Step 1: Create the User-defined Exception class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        // Pass the message to the parent Exception class
        super(message);
    }
}

public class CustomExceptionDemo {
    // A method that uses the 'throw' keyword
    static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            // Step 2: Explicitly 'throw' the exception
            throw new InvalidAgeException("Not eligible to vote!");
        } else {
            System.out.println("Welcome to vote!");
        }
    }

    public static void main(String[] args) {
        try {
            // Step 3: Call the method that might throw the exception
            checkAge(15);
        } catch (InvalidAgeException e) {
            // Catching and printing the custom message
            System.out.println("Caught Exception: " + e.getMessage());
        }
        System.out.println("Rest of the code...");
    }
}