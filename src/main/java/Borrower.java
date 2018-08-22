import java.util.ArrayList;
import java.util.List;

public class Borrower {

    private int id;
    private String name;
    private List<Book> itemsBorrowed;

    public Borrower() {
    }

    public Borrower(String name) {
        this.name = name;
        this.itemsBorrowed = new ArrayList<Book>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getItemsBorrowed() {
        return itemsBorrowed;
    }

    public void setItemsBorrowed(List<Book> itemsBorrowed) {
        this.itemsBorrowed = itemsBorrowed;
    }

    public void borrowBook(Book book){
        this.itemsBorrowed.add(book);
        book.setOnLoan(true);
    }

    public void returnBook(Book book){
        if (this.itemsBorrowed.contains(book)){
            this.itemsBorrowed.remove(book);
            book.setOnLoan(false);
        }
    }
}
