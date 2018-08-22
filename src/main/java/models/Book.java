package models;

import javax.persistence.*;

@Entity
@Table(name="books")

public class Book {

    private int id;
    private String title;
    private Boolean onLoan;
    private Borrower currentBorrower;

    public Book() {
    }

    public Book(String title) {
        this.title = title;
        this.onLoan = false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="on_loan")
    public Boolean getOnLoan() {
        return onLoan;
    }

    public void setOnLoan(Boolean onLoan) {
        this.onLoan = onLoan;
    }

    @ManyToOne
    @JoinColumn(name= "borrower_id")
    public Borrower getCurrentBorrower() {
        return currentBorrower;
    }

    public void setCurrentBorrower(Borrower currentBorrower) {
        this.currentBorrower = currentBorrower;
    }

    public String prettyLoanStatus(){
        if(this.getOnLoan() == true){
            return "Loaned Out";
        } else {
            return "Available";
        }
    }

    public String giveBorrowerName(){
        if(this.currentBorrower != null){
            return this.currentBorrower.getName();
        } else {
            return "N/A";
        }
    }


}
