public class MovieReview {
    private final String review;
    private final String name;

    //moviereview constructor
    public MovieReview(String name, String review) {
        this.name = name;
        this.review = review;
    }

    public String getName() {
        return name;
    }

    public String getReview() {
        return review;
    }
}
