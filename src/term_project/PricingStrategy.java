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

    /* The constructor method */
    public PricingStrategy() {}
    public PricingStrategy(ArrayList<Integer> book)
    {
        this.book.addAll(book);
    }

    /* The control method */
    public void setBook(Set<Integer> list) { book.addAll(list); }
    public boolean containsBook(int type) { return book.contains(type); }

    abstract public double getSubTotal(SaleLineItem item);
}
