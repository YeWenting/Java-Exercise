package term_project;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by YeWenting on 2017/1/2.
 */
abstract public class CompositeStrategy extends PricingStrategy
{
    /* The data field */
    protected ArrayList<String> strategies = new ArrayList<String>();

    /* The constructor method */
    public CompositeStrategy() {}
    public CompositeStrategy(String list, HashSet<Integer> book, String ID, String name)
    {
        super(book, ID, name);
        String[] lists = list.split("\\|");
        for (String strategyName : lists)
            strategies.add(strategyName);
    }

    /* The controller method */
    public void add(String name) { strategies.add(name); }

    @Override
    public abstract double getSubTotal(SaleLineItem item);
}
