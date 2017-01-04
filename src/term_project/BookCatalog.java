package term_project;

import java.util.HashMap;

/**
 * Created by YeWenting on 2017/1/3.
 */
public class BookCatalog
{
    /* The data field */
    HashMap<String, ProductSpecification> books = new HashMap<>();
    PricingStrategyFactory factory = PricingStrategyFactory.getInstance();

    /* The constructor method */
    public BookCatalog() {}

    /* The data access wrapper */
    public ProductSpecification add(ProductSpecification book) { books.put(book.getISBN(), book); return book; }
    public ProductSpecification get(String ISBN) { return books.get(ISBN); }
    public String[][] getAllData()
    {
        int i = 0;
        String[][] data = new String[books.size()][];

        for (ProductSpecification book : books.values()) {
            data[i] = new String[]{
                    book.getISBN(),
                    book.getTitle(),
                    ProductSpecification.idxToStr[book.getType()],
                    String.valueOf(book.getPrice()),
                    factory.getStrategyOfBook(book.getType()).getType()
            };
            i++;
        }

        return data;
    }
}
