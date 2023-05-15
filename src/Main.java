public class Main {
    public static void main(String[] args) {
        //while true the program will contine to prompt user for the options after they are done with the option they picked
        while (true) {
            //option of the user
            int option = ValidateUserInput.validateUserOption();
            //option execution
            MovieUI.executeOption(option);
        }

    }
}