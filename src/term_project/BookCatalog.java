package term_project;

import java.util.HashMap;

/**
 * Created by YeWenting on 2017/1/3.
 */
public class BookCatalog
{
    /* The data field */
    HashMap<String, ProductSpecification> books = new HashMap<>();

    /* The constructor method */
    public BookCatalog() {}

    /* The data access wrapper */
    public ProductSpecification add(ProductSpecification book) { books.put(book.getISBN(), book); return book; }
    public ProductSpecification get(String ISBN) { return books.get(ISBN); }
}
