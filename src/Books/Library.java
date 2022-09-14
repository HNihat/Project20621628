package Books;

import javax.xml.bind.JAXBException;
import java.util.Scanner;
import Users.*;
import Exception.*;
import Books.*;
public class Library  {
    public void library() {
        DataForUsers.dataForAdmin();
        Book book = new Book();
        try {
            book.createBooks();
        } catch (JAXBException e) {
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
        }
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            Scanner scannerString = new Scanner(System.in);
            Scanner scannerInt = new Scanner(System.in);
            Scanner scannerDouble = new Scanner(System.in);
            System.out.println("1. Login");
            System.out.println("2. Logout");
            System.out.println("3. Books All");
            System.out.println("4. Books Info <isbn_value>");
            System.out.println("5. Books Find <option> <option_string>");
            System.out.println("6. Books Sort <option> [asc | desc]");
            System.out.println("7. Users Add <user> <password>");
            System.out.println("8. Users remove <user>");
            System.out.println("9. Books Add <author> <title> <genre> <description> <keywords> <year> <isbn> <rating>");
            System.out.println("10.Books Remove <title> <isbn>");
            System.out.println("11.Books View");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    Login login = new Login();
                    System.out.print("Username: ");
                    String username = scannerString.nextLine();
                    System.out.print("Password: ");
                    String password = scannerString.nextLine();
                    try{
                        login.login(username,password);
                    }catch (Exception e){
                        System.out.println(e);
                    }

                    break;
                case 2:
                    Logout logout = new Logout();
                    try {
                        logout.logout();
                    } catch (NotLoggedIn e) {
                        System.out.println(e);

                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 3:
                    BooksAll booksAll = new BooksAll();
                    try {
                        booksAll.booksAll();
                    } catch (JAXBException e) {
                        System.out.println(e);
                    } catch (NotLoggedIn e) {
                        System.out.println(e);
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 4:
                    BookInfo bookInfo = new BookInfo();
                    System.out.print("ISBN: ");
                    try {
                        int isbn = scannerInt.nextInt();
                        bookInfo.bookInfo(isbn);
                    } catch (JAXBException e) {
                        System.out.println(e);
                    } catch (InvalidData e) {
                        System.out.println(e);
                    } catch (NotLoggedIn e) {
                        System.out.println(e);
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 5:
                    BooksFind booksFind = new BooksFind();
                    System.out.print("Option title/author/tag: ");
                    String option = scannerString.nextLine();
                    System.out.print("Option String: ");
                    String optionString = scannerString.nextLine();
                    try {
                        booksFind.findBook(option, optionString);
                    }
                    catch (JAXBException e) {
                        System.out.println(e);
                    } catch (NotLoggedIn e) {
                        System.out.println(e);
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 6:
                    if(Login.getAccess().equals("admin") || !Login.isLogin()){
                        try {
                            throw new NotLoggedIn();
                        } catch (NotLoggedIn e) {
                            System.out.println(e);
                        }catch (Exception e){
                            System.out.println(e);
                        }
                    }
                    else{
                        BookCatalog.main();
                    }

                    break;
                case 7:
                    UsersAdd usersAdd = new UsersAdd();
                    System.out.print("Username: ");
                    String username1 = scannerString.nextLine();
                    System.out.print("Password: ");
                    String password1 = scannerString.nextLine();
                    try {
                        usersAdd.addUser(username1,password1);
                    } catch (InvalidName e) {
                        System.out.println(e);
                    } catch (JAXBException e) {
                        System.out.println(e);
                    } catch (NotLoggedIn notLoggedIn) {
                        System.out.println(notLoggedIn);
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 8:
                    UsersRemove usersRemove = new UsersRemove();
                    System.out.print("Username: ");
                    String username2 = scannerString.nextLine();
                    try {
                        usersRemove.removeUser(username2);
                    } catch (JAXBException e) {
                        System.out.println(e);
                    } catch (InvalidName e) {
                        System.out.println(e);
                    } catch (NotLoggedIn notLoggedIn) {
                        System.out.println(notLoggedIn);
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 9:
                    BooksAdd booksAdd = new BooksAdd();
                    String author;
                    String title;
                    String genre;
                    String description;
                    String keywords;
                    int year;
                    int isbn1;
                    double rating;



                    try{
                        System.out.print("author: ");
                        author=scannerString.nextLine();
                        System.out.print("title: ");
                        title=scannerString.nextLine();
                        System.out.print("genre: ");
                        genre=scannerString.nextLine();
                        System.out.print("description: ");
                        description=scannerString.nextLine();
                        System.out.print("keywords: ");
                        keywords=scannerString.nextLine();
                        System.out.print("year: ");
                        year=scannerInt.nextInt();
                        System.out.print("isbn: ");
                        isbn1=scannerInt.nextInt();
                        System.out.print("rating: ");
                        rating=scannerDouble.nextDouble();
                        booksAdd.addBooks(author,title,genre,description,keywords,year,isbn1,rating);
                    }catch (Exception e){
                        System.out.println(e);
                    }

                    break;
                case 10:
                    BooksRemove booksRemove = new BooksRemove();
                    try {
                        System.out.print("Title: ");
                        String title1 = scannerString.nextLine();
                        System.out.print("Isbn: ");
                        int isbn2 = scannerInt.nextInt();
                        booksRemove.removeBook(title1,isbn2);
                    } catch (NotLoggedIn e) {
                        System.out.println(e);
                    } catch (JAXBException e) {
                        System.out.println(e);
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 11:
                    BooksView booksView = new BooksView();
                    try {
                        booksView.booksView();
                    } catch (NotLoggedIn | JAXBException e) {
                        System.out.println(e);
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;

            }

        }while(choice != 0);
    }
}

