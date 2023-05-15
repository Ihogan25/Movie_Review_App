import java.util.InputMismatchException;


public class MovieUI {
    //Messagee to welcome user
    public static String welcomeMessage = "Hello, Please select an option by number.";
    //An array options user can choose
    public static String[] options = {
            "1. Review a Movie.",
            "2. Peek Recently Reviewed Movies.(Recent 3).",
            "3. Peek Recently Watched Movies.(Recent 3).",
            "4. Add a movie to watched movies",
            "5. Exit Program. Bye :p"};

    //Function to print out options to user
    public static void displayOptions() {
        System.out.println(welcomeMessage);
        for (String option : options) {
            System.out.println(option);
        }
        System.out.println("--------------------");
        System.out.print("Option: ");
    }

    //Function that prompts user for movie info and returns a movie object
    public static Movie promptMovieInfo() {
        String name;
        String genre;
        String plot;
        float rating;
        int length;
        name = ValidateUserInput.validateInputString("Name: ");
        genre = ValidateUserInput.validateInputString("Genre: ");
        plot = ValidateUserInput.validateInputString("Plot: ");
        rating = ValidateUserInput.validateInputFloat("Rating: ");
        length = ValidateUserInput.validateInputInt("Duration: ");
        return new Movie(name, genre, plot, rating, length);

    }

    //function to execute the option that user chooses
    public static void executeOption(int option) {
        if (option == 1) {
            System.out.println("Creating review...");
            String name = ValidateUserInput.validateInputString("Name: ");
            if (MovieFileHandler.movieExists(name)) {
                String review = ValidateUserInput.validateInputString("Review: ");
                MovieReview movieReview = new MovieReview(name, review);
                ReviewFileHandler.addReview(movieReview);
            }
        } else if (option == 2) {
            System.out.println("Getting Recent reviews...");
            ReviewFileHandler.getRecentReviews();
        } else if (option == 3) {
            System.out.println("Getting recently watched movies...");
            MovieFileHandler.getRecentMovies();
        } else if (option == 4) {
            System.out.println("Creating movie...");
            Movie movie = MovieUI.promptMovieInfo();
            MovieFileHandler.addMovie(movie);
        } else {
            System.out.println("Exiting...");
            System.exit(0);
        }
    }
}
