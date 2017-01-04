package term_project;

import java.util.ArrayList;

/**
 * Created by YeWenting on 2017/1/3.
 */
public class Sale
{
    /* The data field */
    private ArrayList<SaleLineItem> items = new ArrayList<>();

    /* The constructor method */
    public Sale() {}

    /* The shopping method */
    public SaleLineItem add(SaleLineItem item)
    {
        items.add(item);
        return item;
    }

    public double getTotal()
    {
        double temp = 0;
        for (SaleLineItem item : items)
            temp += item.getSubTotal();
        return temp;
    }
}
