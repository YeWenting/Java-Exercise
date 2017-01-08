package homework7;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by YeWenting on 2017/1/2.
 */
abstract public class _14211519_叶文霆_7_CompositeStrategy extends _14211519_叶文霆_7_PricingStrategy
{
    /* The data field */
    protected ArrayList<String> strategies = new ArrayList<String>();

    /* The constructor method */
    public _14211519_叶文霆_7_CompositeStrategy() {}
    public _14211519_叶文霆_7_CompositeStrategy(String[] list, HashSet<Integer> book, String ID, String name)
    {
        super(book, ID, name);
        for (String strategyName : list)
            strategies.add(strategyName);
    }

    /* The controller method */
    public void add(String name) { strategies.add(name); }

    @Override
    public String getPara() { return String.join(",", strategies); }

}
