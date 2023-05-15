public class Movie {
    private final String name;
    private final String genre;
    private final String plot;
    private final int duration;
    private final float rating;
    //movie consructor
    public Movie(String name, String genre, String plot, float rating, int duration) {
        this.name = name;
        this.genre = genre;
        this.plot = plot;
        this.rating = rating;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }
    public String getGenre() {
        return genre;
    }
    public String getPlot() {
        return plot;
    }
    public float getRating() {
        return rating;
    }
    public int getDuration() {
        return duration;
    }
    public String toString() {
        return "Name: " + name + "\n" + "Genre: " + genre + "\n" + "Plot: " + plot + "\n" + "Rating: " + rating + "\n" + "Duration: " + duration + " mins\n";
    }
}
