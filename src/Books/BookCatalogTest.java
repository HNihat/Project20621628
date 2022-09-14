package Books;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class BookCatalogTest {

    public static BookCatalog b;

    @BeforeClass
    public static void runBeforeClass() {
        b = new BookCatalog();
    }

    @Test
    public void testSortBooksByAuthor() {
        List<Book> books = b.sortBooksByAuthor(b.getBooks());
        String firstBook = books.get(0).getAuthor();
        String secondBook = "";
        int length = books.size();
        for (int i = 1; i < length; i++) {
            secondBook = books.get(i).getAuthor();
            if (firstBook.compareTo(secondBook) > 0) {
                fail("Sort Books By Author failed");
                break;
            } else {
                firstBook = secondBook;
            }
        }
    }


    @Test
    public void testSortBooksByTitle() {
        List<Book> books = b.sortBooksByTitle(b.getBooks());
        String firstBook = books.get(0).getTitle();
        String secondBook = "";
        int length = books.size();
        for (int i = 1; i < length; i++) {
            secondBook = books.get(i).getTitle();
            if (firstBook.compareTo(secondBook) > 0) {
                fail("Sort Books By Title failed");
                break;
            }
            else {
                firstBook = secondBook;
            }
        }
    }

    @Test
    public void testSortBookByRating() {
        List<Book> books = b.sortBookByRating(b.getBooks());
        double firstBook = books.get(0).getRating();
        double secondBook = 0;
        int length = books.size();
        for (int i = 1; i < length; i++) {
            secondBook = books.get(i).getRating();
            if (Double.valueOf(firstBook).compareTo(Double.valueOf(secondBook)) > 0) {
                fail("Sort Books By Rating failed");
                break;
            } else {
                firstBook = secondBook;
            }
        }
    }

    @Test
    public void testSortBooksByYear() {
        List<Book> books = b.sortBooksByYear(b.getBooks());
        int firstBook = books.get(0).getYear();
        int secondBook = 0;
        int length = books.size();
        for (int i = 1; i < length; i++) {
            secondBook = books.get(i).getYear();
            if (Integer.valueOf(firstBook).compareTo(Integer.valueOf(secondBook)) > 0) {
                fail("Sort Books By Rating failed");
                break;
            } else {
                firstBook = secondBook;
            }
        }
    }

}
