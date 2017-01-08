package homework7;

/**
 * Created by YeWenting on 2017/1/2.
 */
public class _14211519_叶文霆_7_SaleLineItem
{
    /* The data field */
    private int copies = 0;
    private _14211519_叶文霆_7_ProductSpecification prodSpec = null;
    private _14211519_叶文霆_7_PricingStrategy strategy = null;

    /* The constructor method */
    public _14211519_叶文霆_7_SaleLineItem(int copies, _14211519_叶文霆_7_ProductSpecification prodSpec, _14211519_叶文霆_7_PricingStrategy strategy)
    {
        this.copies = copies;
        this.prodSpec = prodSpec;
        this.strategy = strategy;
    }

    /* The getter method*/
    public int getCopies() { return copies; }
    public _14211519_叶文霆_7_ProductSpecification getProdSpec() { return prodSpec; }
    public double getSubTotal() { return strategy.getSubTotal(this); }
}
