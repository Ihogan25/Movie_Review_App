import java.util.Scanner;

public class ValidateUserInput {
    //function to check if user input is an int
    public static boolean isInt(Object input) {
        return input instanceof Integer;
    }

    //combined with he isInt() function this function validates the users input to choose an option
    public static int validateUserOption() {
        int option = 0;
        Scanner scanner = new Scanner(System.in);
        while (option < 1 || option > 5 && !isInt(option)) {
            MovieUI.displayOptions();
            option = scanner.nextInt();
        }
        return option;
    }

    //this function validates the user input to make sure it is a float
    public static float validateInputFloat(String prompt) {
        Scanner scanner = new Scanner(System.in);
        float input = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print(prompt);
            try {
                input = Float.parseFloat(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        return input;
    }

    //this function validates user input to make sure it is an int
    public static int validateInputInt(String prompt) {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print(prompt);
            try {
                input = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        return input;

    }

    //this function can be used for different string inputs as needed as it validates the string and takes in an argument for different prompts
    public static String validateInputString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        boolean validInput = false;
        while (!validInput) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        return input;
    }
}
