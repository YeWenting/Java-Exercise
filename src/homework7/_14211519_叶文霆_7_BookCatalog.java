package homework7;

import java.util.HashMap;

/**
 * Created by YeWenting on 2017/1/3.
 */
public class _14211519_叶文霆_7_BookCatalog
{
    /* The data field */
    HashMap<String, _14211519_叶文霆_7_ProductSpecification> books = new HashMap<>();
    _14211519_叶文霆_7_PricingStrategyFactory factory = _14211519_叶文霆_7_PricingStrategyFactory.getInstance();

    /* The constructor method */
    public _14211519_叶文霆_7_BookCatalog() {}

    /* The data access wrapper */
    public _14211519_叶文霆_7_ProductSpecification add(_14211519_叶文霆_7_ProductSpecification book) { books.put(book.getISBN(), book); return book; }
    public _14211519_叶文霆_7_ProductSpecification get(String ISBN) { return books.get(ISBN); }
    public String[][] getAllData()
    {
        int i = 0;
        String[][] data = new String[books.size()][];

        for (_14211519_叶文霆_7_ProductSpecification book : books.values()) {
            data[i] = new String[]{
                    book.getISBN(),
                    book.getTitle(),
                    _14211519_叶文霆_7_ProductSpecification.idxToStr[book.getType()],
                    String.valueOf(book.getPrice()),
                    factory.getStrategyOfBook(book.getType()).getType()
            };
            i++;
        }

        return data;
    }
}
