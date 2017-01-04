package term_project;

import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.ObjectExpression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
    public PricingStrategy getPricingStrategy(String ID) { return catalog.get(ID); }

    /* The factory pattern method */
    public PricingStrategy createPricingStrategy(int type, Object paras, HashSet<Integer> booktype, String ID, String name)
        throws Exception
    {
        /* Check the strategy exists */
        if (catalog.get(ID) != null)
            throw new Exception("已存在相同编号的策略！");

        /* Check if the book type has been bound */
        for (int i : booktype)
            if (catalog.getStrategyOfBook(i) != null )
                throw new Exception(ProductSpecification.idxToStr[i] + "已被绑定！");

        /* Create the strategy */
        PricingStrategy temp = null;
        switch (type)
        {
            case IPricingStrategy.FLATRATE:
                temp = catalog.add(new FlatRateStrategy(Double.parseDouble(paras.toString()), booktype, ID, name));
                break;

            case IPricingStrategy.PERCENTAGE:
                temp = catalog.add(new PercentageStrategy(Integer.parseInt(paras.toString()), booktype, ID, name));
                break;

            case IPricingStrategy.COMPOSITE:
                temp = catalog.add(new CompositeBestForCustomer(paras.toString(), booktype, ID, name));
                break;

            case IPricingStrategy.NODISCOUNT:
                temp = catalog.add(new NoDiscountStrategy());
                break;

            default:
                return null;
        }
        if (temp == null) throw new Exception("参数无效！");
        return temp;
    }
}

//class FactoryTest
//{
//    static public void main(String[] args)
//    {
//        PricingStrategyFactory factory = PricingStrategyFactory.getInstance();
//        factory.createPricingStrategy(IPricingStrategy.PERCENTAGE,20, new ArrayList<Integer>(), "1", "plan1");
//        factory.createPricingStrategy(IPricingStrategy.FLATRATE, 20, new ArrayList<Integer>(ProductSpecification.HEALTHCARE_BOOK), "2", "paln");
//
//        ArrayList <Integer> list  = new ArrayList<Integer>();
//        list.add(ProductSpecification.COMIC_BOOK);
//
//        PricingStrategy temp = PricingStrategyFactory.getInstance().createPricingStrategy(IPricingStrategy.COMPOSITE, "plan3", "plan1|plan2", list);
//        SaleLineItem item = new SaleLineItem(10, new ProductSpecification("123", 20, "sb", ProductSpecification.COMIC_BOOK), factory.getStrategyOfBook(ProductSpecification.COMIC_BOOK));
//        SaleLineItem item2 = new SaleLineItem(10, new ProductSpecification("123", 30, "sb2", ProductSpecification.HEALTHCARE_BOOK), factory.getStrategyOfBook(ProductSpecification.HEALTHCARE_BOOK));
//
//        Sale mySale = new Sale();
//        mySale.add(item);
//        mySale.add(item2);
//        System.out.println(mySale.getTotal());
//    }
//}
