package movies;

public class Movie {
    private int id;
    private String title;
    private double rating;
    private String genre;

    public Movie(int id, String title, double rating, String genre) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", genre='" + genre + '\'' +
                '}';
    }
}
