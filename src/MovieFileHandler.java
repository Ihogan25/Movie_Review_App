import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class MovieFileHandler {
    //movie txt file to hold all movies watched
    public static String movieFile = "Movies.txt";
    //this function get the last 3 movies watched and prints them to the user
    public static void getRecentMovies() {
        try {
            File file = new File(movieFile);
            Scanner myReader = new Scanner(file);
            List<String> movies = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String movie = myReader.nextLine();
                movies.add(movie);
            }
            myReader.close();
            List<String> recentMovies = movies.subList(Math.max(0, movies.size() - 3), movies.size());
            recentMovies.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    //this function checks if a movie exists in the movie txt file
    public static boolean movieExists(String name) {
        String searchQuery = "Movie: " + name + ".";
        try {
            System.out.println(searchQuery);
            File moviesFile = new File(movieFile);
            Scanner readerMovies = new Scanner(moviesFile);
            while (readerMovies.hasNextLine()) {
                if (readerMovies.nextLine().startsWith(searchQuery)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Movie does not exist in watched movies, please add the movie then make a review." + e);
            System.out.println(searchQuery);
        }
        return false;
    }
    //this function takes in a movie object and adds it to the movies txt file
    public static void  addMovie(Movie movie ) {
        try {
            FileWriter writer = new FileWriter(movieFile, true);
            writer.write("\n");
            writer.write("Movie: " + movie.getName() + ". ");
            writer.write("Genre: " + movie.getGenre() + ". ");
            writer.write("Plot: " + movie.getPlot() + ". ");
            writer.write("Rating: " + (int) movie.getRating() + ". ");
            writer.write("Duration: " + movie.getDuration() + ". ");
            writer.close();
            System.out.println("Added movie " + movie.getName() + " to watched movies");
        }catch (IOException e) {
            System.out.println("Movie already exists");
            e.printStackTrace();
        }
    }
}
