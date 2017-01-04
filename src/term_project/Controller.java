package term_project;

import java.awt.print.Book;
import java.util.HashSet;

/**
 * Created by YeWenting on 2017/1/3.
 */
public class Controller
{
    /* The book catalog data field */
    private BookCatalog bookCatalog = new BookCatalog();
    private static Controller instance;
    private PricingStrategyFactory factory = PricingStrategyFactory.getInstance();
    private Sale sale = new Sale();

    /* Singleton pattern */
    private Controller() {}
    public static Controller getInstance()
    {
        if (instance == null)
            instance = new Controller();
        return instance;
    }

    /**
     *  The Book Management Wrapper
     */
    public void addBook(String isbn, double price, String title, int type)
    {
        PricingStrategy strategy = factory.getStrategyOfBook(type);
        ProductSpecification book = new ProductSpecification(isbn, price, title, type);
        bookCatalog.add(book);
    }

    public String[][] getAllBooksInfo() { return bookCatalog.getAllData(); }

    public String[][] getAllStrategiesInfo() { return factory.getAllStratetiesInfo(); }

    public PricingStrategy deleteStrategy(String ID) { return factory.removePricingStrategy(ID); }

    public PricingStrategy addStrategy(int type, String paras, HashSet<Integer> books, String ID, String name)
        throws Exception
    {
        return factory.createPricingStrategy(type, paras, books, ID, name);
    }

    public PricingStrategy updateStrategy(int type, String paras, HashSet<Integer> books, String ID, String name)
        throws Exception
    {
        factory.removePricingStrategy(ID);
        return factory.createPricingStrategy(type, paras, books, ID, name);
    }

    public SaleLineItem buyBook(String ISBN, int num)
        throws Exception
    {
        ProductSpecification bookInfo = bookCatalog.get(ISBN);
        if (bookInfo == null) throw new Exception("ISBN号无效");
        return sale.add(new SaleLineItem(num, bookInfo, factory.getStrategyOfBook(bookInfo.getType())));
    }
}
