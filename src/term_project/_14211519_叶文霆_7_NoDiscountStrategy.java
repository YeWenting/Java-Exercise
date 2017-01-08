package term_project;

/**
 * Created by YeWenting on 2017/1/2.
 */
public class _14211519_叶文霆_7_NoDiscountStrategy extends _14211519_叶文霆_7_PricingStrategy
{
    @Override
    public double getSubTotal(_14211519_叶文霆_7_SaleLineItem item)
    {
        return item.getCopies() * item.getProdSpec().getPrice();
    }

    @Override
    public String getType() { return "无优惠"; }

    @Override
    public String getPara() { return "null"; }
}
