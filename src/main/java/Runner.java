import db.DBBorrower;
import db.DBHelper;
import models.Book;
import models.Borrower;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Book book = new Book("The Bible 2");
        Book book1 = new Book("Paradise Lost");
        DBHelper.save(book);
        DBHelper.save(book1);


        Borrower borrower1 = new Borrower("Pope");
        DBHelper.save(borrower1);

        DBBorrower.borrowBook(book,borrower1);
        DBBorrower.borrowBook(book1,borrower1);

//        DBBorrower.returnBook(book,borrower1);

        List<Book> borrower1Books = DBBorrower.booksOnLoan(borrower1);

    }
}
