package term_project;

/**
 * Created by YeWenting on 2017/1/2.
 */
public class NoDiscountStrategy extends PricingStrategy
{
    @Override
    public double getSubTotal(SaleLineItem item)
    {
        return item.getCopies() * item.getProdSpec().getPrice();
    }
}
