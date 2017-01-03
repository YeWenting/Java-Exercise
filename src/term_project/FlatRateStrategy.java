package term_project;

import java.util.ArrayList;

/**
 * Created by YeWenting on 2017/1/2.
 */
public class FlatRateStrategy extends PricingStrategy
{
    /* The data field */
    private double discountPerBook;

    /* The instructor method */
    public FlatRateStrategy(double discount, ArrayList<Integer> book)
    {
        super(book);
        discountPerBook = discount;
    }

    @Override
    public double getSubTotal(SaleLineItem item)
    {
        return item.getCopies() * item.getProdSpec().getPrice() - discountPerBook;
    }
}
