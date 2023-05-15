import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ReviewFileHandler {
    //review file to hold movie reviews
    public static String movieReviewsFile = "Reviews.txt";

    //this function get the last 3 reviews made and prints them to the user
    public static void getRecentReviews() {
        try {
            File file = new File(movieReviewsFile);
            Scanner reader = new Scanner(file);
            List<String> reviews = new ArrayList<>();
            while (reader.hasNextLine()) {
                String review = reader.nextLine();
                reviews.add(review);
            }
            reader.close();
            List<String> recentReviews = reviews.subList(Math.max(0, reviews.size() - 3), reviews.size());
            recentReviews.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. Please add Reviews. ");
            e.printStackTrace();
        }
    }

    //this function takes in a revirw object and adds it to the movie review file
    public static void addReview(MovieReview review) {
        try {
            FileWriter writer = new FileWriter(movieReviewsFile, true);
            writer.write("\n");
            writer.write("Name: " + review.getName() + ". ");
            writer.write("Review: " + review.getReview());
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

