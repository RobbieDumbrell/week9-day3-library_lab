package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="borrowers")

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "currentBorrower")
    public List<Book> getItemsBorrowed() {
        return itemsBorrowed;
    }

    public void setItemsBorrowed(List<Book> itemsBorrowed) {
        this.itemsBorrowed = itemsBorrowed;
    }

    public void borrowBook(Book book){
        this.itemsBorrowed.add(book);
        book.setOnLoan(true);
        book.setCurrentBorrower(this);
    }

    public void returnBook(Book book){
        if (this.itemsBorrowed.contains(book)){
            this.itemsBorrowed.remove(book);
            book.setOnLoan(false);
            book.setCurrentBorrower(null);
        }
    }
}
