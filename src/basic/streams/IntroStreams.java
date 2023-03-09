package basic.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntroStreams {
    public static void main(String[] args) {
        // Get Popular Horror Books

        List<Book> books = new ArrayList<>();

        books.add(new Book("The Alchemist", "Paulo Coelho", "Adventure", 4.408));
        books.add(new Book("The Notebook", "Nicholas Sparks", "Romance", 4.10));
        books.add(new Book("Horror Cocktails", "Robert Bloch", "Horror", 2.67));
        books.add(new Book("House Of Leaves", "Mark Z. Danielewski", "Horror", 4.109));

        List<Book> popularHorrorBooks = books.stream()
                .filter((book) -> book.getGenre().equalsIgnoreCase("Horror"))
                .filter((book) -> book.getRating() > 3)
                .collect(Collectors.toList());

        popularHorrorBooks.forEach(System.out::println); // method reference

        List<Book> popularRomanticBooks = books.stream()
                .filter((book) -> book.getGenre().equalsIgnoreCase("Romance"))
                .filter((book) -> book.getRating() > 3)
                .collect(Collectors.toList());

        popularRomanticBooks.forEach(System.out::println);

        // Observing the process

        //1. Source
        Stream<Book> stream = books.stream();

        //2. Intermediate Operation
        Stream<Book> HorrorBookStream = stream.filter((book) -> book.getGenre().equalsIgnoreCase("Horror"));

        //3. Intermediate Operation
        Stream<Book> popHrBooks = HorrorBookStream.filter((book) ->
                book.getRating() > 3);

        //4. Terminal Operation
        List<Book> collect = popHrBooks.collect(Collectors.toList());
    }
}

class Book {
    private String name;
    private String Author;
    private String genre;
    private double rating;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", Author='" + Author + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                '}';
    }

    public Book(String name, String author, String genre, double rating) {
        this.name = name;
        Author = author;
        this.genre = genre;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
