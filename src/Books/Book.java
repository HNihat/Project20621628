package Books;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Book")
public class Book {
    private String author;
    private String title;
    private String genre;
    private String description;
    private String keywords;
    private int year;
    private int isbn;
    private double rating;

    private static List<Object> books = new ArrayList<>();

    public Book(String author, String title, String genre, String description, String keywords, int year, int isbn, double rating) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.keywords = keywords;
        this.year = year;
        this.isbn = isbn;
        this.rating = rating;
    }

    public Book(){}

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public static List<Object> getBooks() {
        return books;
    }

    public static void setBooks(List<Object> books) {
        Book.books = books;
    }

    public void createBooks() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ListBooks.class);
        Unmarshaller ums = context.createUnmarshaller();
        ListBooks books = (ListBooks) ums.unmarshal(new File("C:/xmlFiles/bookInfo.xml"));

        for (Book b : books.getBook()) {
            getBooks().add(b.author);
            getBooks().add(b.title);
            getBooks().add(b.genre);
            getBooks().add(b.description);
            getBooks().add(b.keywords);
            getBooks().add(b.year);
            getBooks().add(b.isbn);
            getBooks().add(b.rating);

        }
        System.out.println();
    }
}
