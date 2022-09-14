package Books;


import java.io.File;
import java.util.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class BookCatalog {

    private List<Book> books;
    private ListBooks catalog;

    public BookCatalog() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("File name: ");
            String fileName = scanner.nextLine();
            CommandLine commandLine = new CommandLine();
            commandLine.commands("C:/xmlFiles/"+fileName);
            if(commandLine.isStatus()) {
                JAXBContext jaxbContext = JAXBContext.newInstance(ListBooks.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                this.catalog = (ListBooks) jaxbUnmarshaller.unmarshal(new File("C:/xmlFiles/"+fileName));
                books = this.catalog.getBook();
            }

        } catch (JAXBException e) {
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main() {

        BookCatalog bookCatalog = new BookCatalog();
        Scanner scanner=new Scanner(System.in);
        String sort;
        int ch;
        do {
            System.out.println("Choose an author, title or label to sort books.");
            System.out.println("'author':to sort books by author.");
            System.out.println("'title':to sort books by title.");
            System.out.println("'rating':to sort books by rating.");
            System.out.println("'year':to sort books by year.");
            System.out.println("'exit':for exit.");
            System.out.print("Enter: ");
            sort=scanner.nextLine();
            switch (sort) {
                case "author":{
                    System.out.println("--------------Actual Books Author Unsorted--------------------");

                    for (Book t : bookCatalog.books) {
                        System.out.println(t.getAuthor());
                    }
                    System.out.println("*******SORT*******");
                    System.out.println("1. For Ascending sort.");
                    System.out.println("2. For Descending sort.");
                    System.out.print("Enter: ");
                    ch = scanner.nextInt();
                    switch (ch) {
                        case 1:
                            System.out.println("-------------Sort Books By Author Asc--------------------");
                            List<Book> b1 = bookCatalog.sortBooksByAuthor(bookCatalog.books);
                            for (Book t1 : b1) {
                                System.out.println(t1.getAuthor());
                            }
                            break;

                        case 2:
                            System.out.println("-------------Sort Books By Author Desc--------------------");
                            List<Book> b2 = bookCatalog.sortBooksByAuthorDesc(bookCatalog.books);
                            for (Book t2 : b2) {
                                System.out.println(t2.getAuthor());
                            }
                            break;
                    }
                }
                break;
                case "title":{
                    System.out.println("--------------Actual Books Title Unsorted--------------------");

                    for (Book t : bookCatalog.books) {
                        System.out.println(t.getTitle());
                    }
                    System.out.println("*******SORT*******");
                    System.out.println("1. For Ascending sort.");
                    System.out.println("2. For Descending sort.");
                    System.out.print("Enter: ");
                    ch=scanner.nextInt();
                    switch (ch) {
                        case 1:
                            System.out.println("-------------Sort Books By Title Asc--------------------");
                            List<Book> b3 = bookCatalog.sortBooksByTitle(bookCatalog.books);
                            for (Book t3 : b3) {
                                System.out.println(t3.getTitle());
                            }
                            break;
                        case 2:
                            System.out.println("-------------sortBooksByTitleDesc--------------------");
                            List<Book> b4 = bookCatalog.sortBooksByTitleDesc(bookCatalog.books);
                            for (Book t4 : b4) {
                                System.out.println(t4.getTitle());
                            }
                            break;
                    }
                }
                break;
                case "rating":{
                    System.out.println("--------------Actual Books Rating Unsorted--------------------");

                    for (Book t : bookCatalog.books) {
                        System.out.println(t.getRating());
                    }
                    System.out.println("*******SORT*******");
                    System.out.println("1. For Ascending sort.");
                    System.out.println("2. For Descending sort.");
                    System.out.println("Enter: ");
                    ch=scanner.nextInt();
                    switch (ch) {
                        case 1: {
                            System.out.println("-------------Sort Books By RatingAsc--------------------");
                            List<Book> b5 = bookCatalog.sortBookByRating(bookCatalog.books);
                            for (Book t5 : b5) {
                                System.out.println(t5.getRating()+" asc");
                            }
                        }
                        break;
                        case 2: {
                            System.out.println("-------------Sort Books By Rating Desc--------------------");
                            List<Book> b6 = bookCatalog.sortBookByRatingDesc(bookCatalog.books);
                            for (Book t6 : b6) {
                                System.out.println(t6.getRating()+" desc");
                            }
                        }
                        break;
                    }
                }
                break;
                case "year":
                {        System.out.println("--------------Actual Books Year Unsorted--------------------");
                    for (Book t7 : bookCatalog.books) {
                        System.out.println(t7.getYear());
                    }
                    System.out.println("*******SORT*******");
                    System.out.println("1. For Ascending sort.");
                    System.out.println("2. For Descending sort.");
                    System.out.println("Enter: ");
                    ch=scanner.nextInt();
                    switch (ch) {
                        case 1: {
                            System.out.println("-------------Sort Books By Year Asc--------------------");
                            List<Book> b8 = bookCatalog.sortBooksByYear(bookCatalog.books);
                            for (Book t8 : b8) {
                                System.out.println(t8.getYear()+" asc");
                            }
                        }
                        break;
                        case 2: {
                            System.out.println("-------------sortBooksByYearDesc--------------------");
                            List<Book> b9 = bookCatalog.sortBooksByYearDesc(bookCatalog.books);
                            for (Book t9 : b9) {
                                System.out.println(t9.getYear()+" desc");
                            }
                        }
                        break;
                    }


                }
                break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }while(sort.equalsIgnoreCase("exit"));

    }


    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> sortBooksByAuthor(List<Book> book) {
        List<Book> b = book;
        Collections.sort(b, new BookAuthorComparator());
        return b;
    }

    public class BookAuthorComparator implements Comparator<Book> {
        public int compare(Book a, Book b) {
            return a.getAuthor().compareTo(b.getAuthor());

        }
    }
    public List<Book> sortBooksByAuthorDesc(List<Book> book) {
        List<Book> b = book;
        Collections.sort(b, new BookAuthorDescComparator());
        return b;
    }

    public class BookAuthorDescComparator implements Comparator<Book> {
        public int compare(Book a, Book b) {
            return b.getAuthor().compareTo(a.getAuthor());

        }
    }

    public List<Book> sortBooksByTitle(List<Book> book) {
        List<Book> b = book;
        Collections.sort(b, new BookTitleComparator());
        return b;
    }
    public class BookTitleComparator implements Comparator<Book> {
        public int compare(Book a, Book b) {
            return a.getTitle().compareTo(b.getTitle());

        }
    }

    public List<Book> sortBooksByTitleDesc(List<Book> book) {
        List<Book> b = book;
        Collections.sort(b, new BookTitleDescComparator());
        return b;
    }
    public class BookTitleDescComparator implements Comparator<Book> {
        public int compare(Book a, Book b) {
            return b.getTitle().compareTo(a.getTitle());

        }
    }
    public List<Book> sortBookByRating(List<Book> book) {
        List<Book> b = book;
        Collections.sort(b, new BookRatingComparator());
        return b;
    }

    public List<Book> sortBookByRatingDesc(List<Book> book) {
        List<Book> b = book;
        Collections.sort(b, new BookRatingDescComparator());
        //   b.sort(Collections.reverseOrder());
        return b;
    }

    public class BookRatingDescComparator implements Comparator<Book> {
        public int compare(Book a, Book b) {
            return Double.valueOf(b.getRating()).compareTo(Double.valueOf(a.getRating()));

        }
    }
    public class BookRatingComparator implements Comparator<Book> {
        public int compare(Book a, Book b) {
            return Double.valueOf(a.getRating()).compareTo(
                    Double.valueOf(b.getRating()));

        }
    }

    public List<Book> sortBooksByYear(List<Book> book) {
        List<Book> b = book;
        Collections.sort(b, new BookYearComparator());
        return b;
    }
    public class BookYearComparator implements Comparator<Book> {
        public int compare(Book a, Book b) {
            return Integer.valueOf(a.getYear()).compareTo(Integer.valueOf(b.getYear()));
        }
    }
    public List<Book> sortBooksByYearDesc(List<Book> book) {
        List<Book> b = book;
        Collections.sort(b, new BookYearDescComparator());
        return b;
    }
    public class BookYearDescComparator implements Comparator<Book> {
        public int compare(Book a, Book b) {
            return Integer.valueOf(b.getYear()).compareTo(Integer.valueOf(a.getYear()));
        }
    }

}


