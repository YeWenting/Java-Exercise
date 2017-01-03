package term_project;

import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.ObjectExpression;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by YeWenting on 2017/1/2.
 */

public class PricingStrategyFactory
{
    /* The data field */
    private static PricingStrategyFactory instance;
    private StrategyCatalog catalog;

    /* The private constructor */
    private PricingStrategyFactory() { catalog = new StrategyCatalog(); }

    /* The instance getter wrapper */
    static public PricingStrategyFactory getInstance()
    {
        if (null == instance)
            instance = new PricingStrategyFactory();
         return instance;
    }

    /* The catalog access wrapper */
    public PricingStrategy getStrategyOfBook(int type) { return catalog.getStrategyOfBook(type); }
    public PricingStrategy getPricingStrategy(String name) { return catalog.get(name); }

    /* The factory pattern method */
    public PricingStrategy createPricingStrategy(int type, String name, Object paras, ArrayList<Integer> booktype)
    {
        switch (type)
        {
            case IPricingStrategy.FLATRATE:
                return catalog.add(name, new FlatRateStrategy(Double.parseDouble(paras.toString()), booktype));

            case IPricingStrategy.PERCENTAGE:
                return catalog.add(name, new PercentageStrategy(Integer.parseInt(paras.toString()), booktype));

            case IPricingStrategy.COMPOSITE:
                {
                return catalog.add(name, new CompositeBestForCustomer(paras.toString(), booktype));
            }
            case IPricingStrategy.NODISCOUNT:
                return catalog.add(name, new NoDiscountStrategy());

            default:
                return null;
        }
    }
}

class FactoryTest
{
    static public void main(String[] args)
    {
        PricingStrategyFactory factory = PricingStrategyFactory.getInstance();
        factory.createPricingStrategy(IPricingStrategy.PERCENTAGE, "plan1", 20, new ArrayList<Integer>());
        factory.createPricingStrategy(IPricingStrategy.FLATRATE, "plan2", 20, new ArrayList<Integer>(ProductSpecification.HEALTHCARE_BOOK));

        ArrayList <Integer> list  = new ArrayList<Integer>();
        list.add(ProductSpecification.COMIC_BOOK);

        PricingStrategy temp = PricingStrategyFactory.getInstance().createPricingStrategy(IPricingStrategy.COMPOSITE, "plan3", "plan1|plan2", list);
        SaleLineItem item = new SaleLineItem(10, new ProductSpecification("123", 20, "sb", ProductSpecification.COMIC_BOOK), factory.getStrategyOfBook(ProductSpecification.COMIC_BOOK));
        SaleLineItem item2 = new SaleLineItem(10, new ProductSpecification("123", 30, "sb2", ProductSpecification.HEALTHCARE_BOOK), factory.getStrategyOfBook(ProductSpecification.HEALTHCARE_BOOK));

        Sale mySale = new Sale();
        mySale.add(item);
        mySale.add(item2);
        System.out.println(mySale.getTotal());
    }
}
