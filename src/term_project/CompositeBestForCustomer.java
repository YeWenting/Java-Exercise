package term_project;

import java.util.HashSet;

/**
 * Created by YeWenting on 2017/1/2.
 */
public class CompositeBestForCustomer extends CompositeStrategy
{
    static final int MAX_TOTAL = 2014211519;

    /* The constructor method */
    public CompositeBestForCustomer(String list, HashSet<Integer> book, String ID, String name)
    {
        super(list, book, ID, name);
    }

    @Override
    public double getSubTotal(SaleLineItem item)
    {
        double best = MAX_TOTAL, temp;

        for (String name : strategies)
        {
            temp = PricingStrategyFactory.getInstance().getPricingStrategy(name).getSubTotal(item);
            best = best > temp ? temp: best;
        }
        return best;
    }

    @Override
    public String getType() { return "顾客最优策略"; }

}
