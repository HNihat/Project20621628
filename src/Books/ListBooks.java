package Books;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
@XmlRootElement(name="Books")
@XmlAccessorType (XmlAccessType.FIELD)
public class ListBooks {
    @XmlElement(name = "Book")
    private List<Book> book = null;

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }
}