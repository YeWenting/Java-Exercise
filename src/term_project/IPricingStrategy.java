package term_project;

/**
 * Created by YeWenting on 2017/1/2.
 */
public interface IPricingStrategy
{
    int FLATRATE = 0;
    int PERCENTAGE = 1;
    int COMPOSITE = 2;
    int NODISCOUNT = 3;

    double getSubTotal(SaleLineItem item);
}
