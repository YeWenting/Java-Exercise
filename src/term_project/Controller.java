package term_project;

/**
 * Created by YeWenting on 2017/1/3.
 */
public class Controller
{
    /* The book catalog data field */
    private BookCatalog bookCatalog = new BookCatalog();
    private static Controller instance;

    /* Singleton pattern */
    private Controller() {}
    public static Controller getInstance()
    {
        if (instance == null)
            instance = new Controller();
        return instance;
    }

    /* The control wrapper */
    public void addBook(String isbn, double price, String title, int type)
    {
        PricingStrategy strategy = PricingStrategyFactory.getInstance().getStrategyOfBook(type);
        ProductSpecification book = new ProductSpecification(isbn, price, title, type);
        bookCatalog.add(book);
    }

    public void addCompositeStrategy(){}
}
