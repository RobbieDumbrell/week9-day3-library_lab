import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {

    Borrower borrower1;
    Book book1;
    Book book2;

    @Before
    public void before(){
        book1 = new Book("The Bible");
        book2 = new Book("Harry Potter");
        borrower1 = new Borrower("Mark");
    }

    @Test
    public void hasName(){
        assertEquals("Mark", borrower1.getName());
    }

    @Test
    public void startsWithNoBooks(){
        assertEquals(0, borrower1.getItemsBorrowed().size());
    }

    @Test
    public void canBorrowBook(){
        borrower1.borrowBook(book1);
        assertEquals(1, borrower1.getItemsBorrowed().size());
        assertEquals(true, book1.getOnLoan());
    }

    @Test
    public void canReturnBook(){
        borrower1.borrowBook(book1);
        borrower1.returnBook(book1);
        assertEquals(0, borrower1.getItemsBorrowed().size());
        assertEquals(false, book1.getOnLoan());
    }

    @Test
    public void canNotReturnBookThatHasNotBorrowed(){
        borrower1.borrowBook(book1);
        borrower1.returnBook(book2);
        assertEquals(1, borrower1.getItemsBorrowed().size());
        assertEquals(true, book1.getOnLoan());
        assertEquals(false, book2.getOnLoan());
    }


}
