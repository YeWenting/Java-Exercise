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
    private Controller()
    {
        // Initialize the data (as required)
        addBook("978-7-302-2", 18, "《UML与模式应用》", 1);
        addBook("978-7-312-3", 34, "《Java与模式》", 0);
        addBook("968-6-302-1", 58, "《Headfirst设计模式》", 0);
        addBook("958-1-302-2", 30, "《爱丽丝历险记》", 2);
        addBook("900-7-392-2", 20, "《煲汤大全》", 3);

        try {
            addStrategy(0, "1", new HashSet<Integer>(){{ add(1); }}, "Discount001", "绝对值优惠策略1");
            addStrategy(1, "7", new HashSet<Integer>(){{ add(2); }}, "Discount002", "百分比折扣策略1");
            addStrategy(1, "3", new HashSet<Integer>(){{ add(0); }}, "Discount003", "百分比折扣策略2");
            addStrategy(2, "Discount001|Discount003",
                    new HashSet<Integer>(){{ add(3); }}, "Discount004", "顾客最优策略1");
        }
        catch (Exception e)
        {
            // There won't be an Exception
        }
    }
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

    public Sale getSale() { return sale; }
}
