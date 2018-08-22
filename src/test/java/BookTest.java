import models.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    Book book1;

    @Before
    public void before(){
        book1 = new Book("The Bible");
    }

    @Test
    public void hasTitle(){
        assertEquals("The Bible", book1.getTitle());
    }

    @Test
    public void startsNotOnLoan(){
        assertEquals(false, book1.getOnLoan());
    }

    @Test
    public void startsWithNoBorrower(){
        assertEquals(null, book1.getCurrentBorrower());
    }



}
