package term_project;

import java.util.HashMap;

/**
 * Created by YeWenting on 2017/1/2.
 */
public class StrategyCatalog
{
    /* The data field */
    private HashMap<String, PricingStrategy> strategies = new HashMap<String, PricingStrategy>();

    /* The constructor method */
    public StrategyCatalog() { }

    /* The control method */
    public PricingStrategy get(String name) { return strategies.get(name); }
    public PricingStrategy delete(String name) { return strategies.remove(name); }
    public PricingStrategy add(String name, PricingStrategy strategy)
    {
        strategies.put(name, strategy);
        return strategy;
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
