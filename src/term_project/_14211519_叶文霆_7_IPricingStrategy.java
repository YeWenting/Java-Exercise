package term_project;

/**
 * Created by YeWenting on 2017/1/2.
 */
public interface _14211519_叶文霆_7_IPricingStrategy
{
    int FLATRATE = 0;
    int PERCENTAGE = 1;
    int COMPOSITE = 2;
    int NODISCOUNT = 3;

    double getSubTotal(_14211519_叶文霆_7_SaleLineItem item);
}
