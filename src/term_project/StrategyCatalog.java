package term_project;

import java.util.HashMap;

/**
 * Created by YeWenting on 2017/1/2.
 */
public class StrategyCatalog
{
    /* Strategy ID -> Strategy data field*/
    private HashMap<String, PricingStrategy> strategies = new HashMap<>();

    /* The constructor method */
    public StrategyCatalog() { }

    /* The control method */
    public PricingStrategy get(String ID) { return strategies.get(ID); }
    public PricingStrategy delete(String ID) { return strategies.remove(ID); }
    public PricingStrategy add(PricingStrategy strategy)
    {
        strategies.put(strategy.getID(), strategy);
        return strategy;
    }

    /* The book-discount answer method */
    public PricingStrategy getStrategyOfBook(int type)
    {
        for (PricingStrategy strategy : strategies.values())
        {
            if (strategy.containsBook(type)) return strategy;
        }
        return null;
    }
}
