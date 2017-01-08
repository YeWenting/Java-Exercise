package term_project;

import java.util.HashMap;

/**
 * Created by YeWenting on 2017/1/2.
 */
public class _14211519_叶文霆_7_StrategyCatalog
{
    /* The constant field */
    public static final String[] idxToStr = {"绝对值优惠策略", "百分比优惠策略", "顾客最优策略"};

    /* Strategy ID -> Strategy data field */
    private HashMap<String, _14211519_叶文霆_7_PricingStrategy> strategies = new HashMap<>();

    /* The constructor method */
    public _14211519_叶文霆_7_StrategyCatalog() { }

    /* The control method */
    public _14211519_叶文霆_7_PricingStrategy get(String ID) { return strategies.get(ID); }

    public _14211519_叶文霆_7_PricingStrategy remove(String ID) { return strategies.remove(ID); }

    public int size() { return strategies.size(); }

    public _14211519_叶文霆_7_PricingStrategy add(_14211519_叶文霆_7_PricingStrategy strategy)
    {
        strategies.put(strategy.getID(), strategy);
        return strategy;
    }

    public String[][] getAllData()
    {
        int i = 0;
        String[][] data = new String[strategies.size()][];

        for (_14211519_叶文霆_7_PricingStrategy strategy : strategies.values()) {
            data[i] = new String[]{
                    strategy.getID(),
                    strategy.getName(),
                    strategy.getType(),
                    strategy.getBookTypes(),
                    strategy.getPara()
            };
            i++;
        }

        return data;
    }

    /* The book-discount answer method */
    public _14211519_叶文霆_7_PricingStrategy getStrategyOfBook(int type)
    {
        for (_14211519_叶文霆_7_PricingStrategy strategy : strategies.values())
        {
            if (strategy.containsBook(type)) return strategy;
        }
        return new _14211519_叶文霆_7_NoDiscountStrategy();
    }
}
