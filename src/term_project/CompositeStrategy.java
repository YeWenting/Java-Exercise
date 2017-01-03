package term_project;

import java.util.ArrayList;

/**
 * Created by YeWenting on 2017/1/2.
 */
abstract public class CompositeStrategy extends PricingStrategy
{
    /* The data field */
    protected ArrayList<String> strategies = new ArrayList<String>();

    /* The constructor method */
    public CompositeStrategy() {}
    public CompositeStrategy(String list, ArrayList<Integer> book)
    {
        super(book);
        String[] lists = list.split("\\|");
        for (String strategyName : lists)
            strategies.add(strategyName);
    }

    /* The controller method */
    public void add(String name) { strategies.add(name); }

    @Override
    public abstract double getSubTotal(SaleLineItem item);
}
