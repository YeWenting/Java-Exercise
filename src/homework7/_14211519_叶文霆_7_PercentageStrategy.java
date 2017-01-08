package homework7;

import java.util.HashSet;

/**
 * Created by YeWenting on 2017/1/2.
 */
public class _14211519_叶文霆_7_PercentageStrategy extends _14211519_叶文霆_7_PricingStrategy
{
    /* The data field */
    private int discountPercent = 0;

    /* The instructor method */
    public _14211519_叶文霆_7_PercentageStrategy(int discount, HashSet<Integer> book, String ID, String name)
    {
        super(book, ID, name);
        discountPercent = discount;
    }

    @Override
    public double getSubTotal(_14211519_叶文霆_7_SaleLineItem item)
    {
        return item.getCopies() * item.getProdSpec().getPrice() * (100 - discountPercent) / 100;
    }

    @Override
    public String getType() { return "百分比优惠策略"; }

    @Override
    public String getPara() { return String.valueOf(discountPercent); }
}