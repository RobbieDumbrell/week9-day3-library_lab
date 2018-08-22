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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getOnLoan() {
        return onLoan;
    }

    public void setOnLoan(Boolean onLoan) {
        this.onLoan = onLoan;
    }

    public Borrower getCurrentBorrower() {
        return currentBorrower;
    }

    public void setCurrentBorrower(Borrower currentBorrower) {
        this.currentBorrower = currentBorrower;
    }


}
