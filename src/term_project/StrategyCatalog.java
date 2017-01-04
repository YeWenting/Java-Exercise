package term_project;

import java.util.HashMap;

/**
 * Created by YeWenting on 2017/1/2.
 */
public class StrategyCatalog
{
    /* The constant field */
    public static final String[] idxToStr = {"绝对值优惠策略", "百分比优惠策略", "顾客最优策略"};

    /* Strategy ID -> Strategy data field */
    private HashMap<String, PricingStrategy> strategies = new HashMap<>();

    /* The constructor method */
    public StrategyCatalog() { }

    /* The control method */
    public PricingStrategy get(String ID) { return strategies.get(ID); }

    public PricingStrategy remove(String ID) { return strategies.remove(ID); }

    public int size() { return strategies.size(); }

    public PricingStrategy add(PricingStrategy strategy)
    {
        strategies.put(strategy.getID(), strategy);
        return strategy;
    }

    public String[][] getAllData()
    {
        int i = 0;
        String[][] data = new String[strategies.size()][];

        for (PricingStrategy strategy : strategies.values()) {
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
    public PricingStrategy getStrategyOfBook(int type)
    {
        for (PricingStrategy strategy : strategies.values())
        {
            if (strategy.containsBook(type)) return strategy;
        }
        return new NoDiscountStrategy();
    }
}
