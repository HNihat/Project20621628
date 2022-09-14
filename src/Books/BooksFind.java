package Books;
import Exception.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Scanner;

public class BooksFind {
    public void findBook(String option,String option_string) throws JAXBException, NotLoggedIn {
        boolean checkTitle = false;
        boolean checkAuthor = false;
        boolean checkKeywords = false;
        if(Login.getAccess().equals("admin") || !Login.isLogin()){
            throw new NotLoggedIn();
        }
        else{
            Scanner scanner = new Scanner(System.in);
            System.out.print("File name: ");
            String fileName = scanner.nextLine();
            CommandLine commandLine = new CommandLine();
            commandLine.commands("C:/xmlFiles/"+fileName);
            if(commandLine.isStatus()){
                JAXBContext jaxbContext = JAXBContext.newInstance(ListBooks.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                ListBooks books = (ListBooks) jaxbUnmarshaller.unmarshal(new File(("C:/xmlFiles/"+fileName)));
                for (Book book : books.getBook()) {
                    if (option.equalsIgnoreCase("title")) {
                        if(option_string.equalsIgnoreCase(book.getTitle())){
                            System.out.println("Book find title  " + book.getTitle());
                            checkTitle = true;
                        }

                    }
                    if (option.equalsIgnoreCase("author")){
                        if(option_string.equalsIgnoreCase(book.getAuthor())){
                            System.out.println("Book find author " + book.getAuthor());
                            checkAuthor = true;
                        }
                    }
                    if (option.equalsIgnoreCase("tag")) {
                        if(option_string.equalsIgnoreCase(book.getKeywords())){
                            System.out.println("Book find keyword  " + book.getKeywords());
                            checkKeywords = true;
                        }
                    }
                }
                if (option.equalsIgnoreCase("title")) {
                    if (!checkTitle) {
                        System.out.println("Invalid title!");
                    }
                }
                if (option.equalsIgnoreCase("author")){
                    if(!checkAuthor) {
                        System.out.println("Invalid author");
                    }
                }

                if (option.equalsIgnoreCase("tag")) {
                    if(!checkKeywords) {
                        System.out.println("Invalid tag");
                    }
                }


            }
        }

    }
}

