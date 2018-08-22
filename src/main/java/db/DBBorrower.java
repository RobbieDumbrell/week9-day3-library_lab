package db;

import models.Book;
import models.Borrower;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBBorrower {

    private static Session session;

    public static void borrowBook(Book book, Borrower borrower){
        borrower.borrowBook(book);
        DBHelper.save(borrower);
        DBHelper.save(book);
    }

    public static void returnBook(Book book, Borrower borrower){
        borrower.returnBook(book);
        DBHelper.save(book);
        DBHelper.save(borrower);
    }

    public static List<Book> booksOnLoan(Borrower borrower){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Book> results = null;
        try {
            Criteria cr = session.createCriteria(Book.class);
            cr.add(Restrictions.eq("currentBorrower", borrower));
            results = cr.list();
        } catch(HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
