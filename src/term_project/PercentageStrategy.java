package term_project;

import java.util.ArrayList;

/**
 * Created by YeWenting on 2017/1/2.
 */
public class PercentageStrategy extends PricingStrategy
{
    /* The data field */
    private int discountPercent = 0;

    /* The instructor method */
    public PercentageStrategy(int discount, ArrayList<Integer> book)
    {
        super(book);
        discountPercent = discount;
    }

    @Override
    public double getSubTotal(SaleLineItem item)
    {
        return item.getCopies() * item.getProdSpec().getPrice() * (100 - discountPercent) / 100;
    }
}