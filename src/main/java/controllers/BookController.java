package controllers;

import db.DBHelper;
import models.Book;
import models.Borrower;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class BookController {

    public BookController() {
        this.setUpEndPoints();
    }

    private void setUpEndPoints(){

//        Index
        get("/books", (req, res) -> {

            List<Book> allBooks = DBHelper.getAll(Book.class);

            Map<String, Object> model = new HashMap<>();
            model.put("allBooks", allBooks);
            model.put("template", "templates/books/index.vtl");

            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());

//        New


//        Create

//        Show

//        Edit
        get("/books/:id/edit", (req, res) -> {

            int bookId = Integer.parseInt(req.params(":id"));

            Book editingBook = DBHelper.find(bookId, Book.class);

            List<Borrower> allBorrowers = DBHelper.getAll(Borrower.class);

            Map<String, Object> model = new HashMap<>();
            model.put("editingBook", editingBook);
            model.put("allBorrowers", allBorrowers);
            model.put("template", "templates/books/edit.vtl");

            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());

//        Update

//        Destroy

    }
}
