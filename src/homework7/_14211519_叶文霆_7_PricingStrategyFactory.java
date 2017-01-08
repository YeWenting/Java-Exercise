package homework7;

import java.util.HashSet;

/**
 * Created by YeWenting on 2017/1/2.
 */

public class _14211519_叶文霆_7_PricingStrategyFactory
{
    /* The data field */
    private static _14211519_叶文霆_7_PricingStrategyFactory instance;
    private _14211519_叶文霆_7_StrategyCatalog catalog;

    /* The private constructor */
    private _14211519_叶文霆_7_PricingStrategyFactory() { catalog = new _14211519_叶文霆_7_StrategyCatalog(); }

    /* The instance getter wrapper */
    static public _14211519_叶文霆_7_PricingStrategyFactory getInstance()
    {
        if (null == instance)
            instance = new _14211519_叶文霆_7_PricingStrategyFactory();
         return instance;
    }

    /* The catalog access wrapper */
    public _14211519_叶文霆_7_PricingStrategy getStrategyOfBook(int type) { return catalog.getStrategyOfBook(type); }
    public _14211519_叶文霆_7_PricingStrategy getPricingStrategy(String ID) { return catalog.get(ID); }
    public _14211519_叶文霆_7_PricingStrategy removePricingStrategy(String ID) { return catalog.remove(ID); }
    public String[][] getAllStratetiesInfo() { return catalog.getAllData(); }

    /* The factory pattern method */
    public _14211519_叶文霆_7_PricingStrategy createPricingStrategy(int type, Object paras, HashSet<Integer> booktype, String ID, String name)
        throws Exception
    {
        /* Check the strategy exists */
        if (catalog.get(ID) != null)
            throw new Exception("已存在相同编号的策略！");

        /* Check if the book type has been bound */
        for (int i : booktype)
            if (!catalog.getStrategyOfBook(i).getType().equals("无优惠"))
                throw new Exception(_14211519_叶文霆_7_ProductSpecification.idxToStr[i] + "已被绑定！");

        /* Create the strategy */
        _14211519_叶文霆_7_PricingStrategy temp = null;
        switch (type)
        {
            case _14211519_叶文霆_7_IPricingStrategy.FLATRATE:
                temp = catalog.add(new _14211519_叶文霆_7_FlatRateStrategy(Double.parseDouble(paras.toString()), booktype, ID, name));
                break;

            case _14211519_叶文霆_7_IPricingStrategy.PERCENTAGE:
                temp = catalog.add(new _14211519_叶文霆_7_PercentageStrategy(Integer.parseInt(paras.toString()), booktype, ID, name));
                break;

            case _14211519_叶文霆_7_IPricingStrategy.COMPOSITE:
                // Check Validity
                String[] list = paras.toString().split("\\|");
                for (String strategyID : list)
                    if (catalog.get(strategyID) == null) throw new Exception("输入的简单策略编号无效！");
                temp = catalog.add(new _14211519_叶文霆_7_CompositeBestForCustomer(list, booktype, ID, name));
                break;

            case _14211519_叶文霆_7_IPricingStrategy.NODISCOUNT:
                temp = catalog.add(new _14211519_叶文霆_7_NoDiscountStrategy());
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
