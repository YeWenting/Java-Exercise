package term_project;

import java.util.HashSet;

/**
 * Created by YeWenting on 2017/1/2.
 */
public class PercentageStrategy extends PricingStrategy
{
    /* The data field */
    private int discountPercent = 0;

    /* The instructor method */
    public PercentageStrategy(int discount, HashSet<Integer> book, String ID, String name)
    {
        super(book, ID, name);
        discountPercent = discount;
    }

    @Override
    public double getSubTotal(SaleLineItem item)
    {
        return item.getCopies() * item.getProdSpec().getPrice() * (100 - discountPercent) / 100;
    }
}