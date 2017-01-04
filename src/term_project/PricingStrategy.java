package term_project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by YeWenting on 2017/1/2.
 */
abstract public class PricingStrategy implements IPricingStrategy
{
    /* The data field */
    private HashSet<Integer> book = new HashSet<Integer>();
    private String ID = "", name = "";

    /* The constructor method */
    public PricingStrategy() {}

    public PricingStrategy(HashSet<Integer> book, String ID, String name)
    {
        this.book.addAll(book);
        this.ID = ID;
        this.name = name;
    }

    /* The control method */
    public void setBook(Set<Integer> list) { book.addAll(list); }
    public boolean containsBook(int type) { return book.contains(type); }
    public String getID() { return ID; }
    public String getName() { return name; }
    public String getBookTypes()
    {
        StringBuilder temp = new StringBuilder();

        if (book.size() > 0)
            for (int type : book)
                temp.append(ProductSpecification.idxToStr[type] + " ");
        else
            temp.append("无");

        return temp.toString();
    }

    abstract public double getSubTotal(SaleLineItem item);
    abstract public String getType();
    abstract public String getPara();
}
