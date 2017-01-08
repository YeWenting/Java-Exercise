package homework7;

import java.util.HashSet;

/**
 * Created by YeWenting on 2017/1/2.
 */
public class _14211519_叶文霆_7_FlatRateStrategy extends _14211519_叶文霆_7_PricingStrategy
{
    /* The data field */
    private double discountPerBook;

    /* The instructor method */
    public _14211519_叶文霆_7_FlatRateStrategy(double discount, HashSet<Integer> book, String ID, String name)
    {
        super(book, ID, name);
        discountPerBook = discount;
    }

    @Override
    public double getSubTotal(_14211519_叶文霆_7_SaleLineItem item)
    {
        return item.getCopies() * (item.getProdSpec().getPrice() - discountPerBook);
    }

    @Override
    public String getType() { return "绝对值优惠策略"; }

    @Override
    public String getPara() { return String.valueOf(discountPerBook); }
}
