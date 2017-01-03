package term_project;

/**
 * Created by YeWenting on 2017/1/2.
 */
public class SaleLineItem
{
    /* The data field */
    private int copies = 0;
    private ProductSpecification prodSpec = null;
    private PricingStrategy strategy = null;

    /* The constructor method */
    public SaleLineItem(int copies, ProductSpecification prodSpec, PricingStrategy strategy)
    {
        this.copies = copies;
        this.prodSpec = prodSpec;
        this.strategy = strategy;
    }

    /* The getter method*/
    public int getCopies() { return copies; }
    public ProductSpecification getProdSpec() { return prodSpec; }
    public double getSubTotal() { return strategy.getSubTotal(this); }
}
