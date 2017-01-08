package homework7;

import java.util.ArrayList;

/**
 * Created by YeWenting on 2017/1/3.
 */
public class _14211519_叶文霆_7_Sale implements _14211519_叶文霆_7_Subject
{
    /* The data field */
    private ArrayList<_14211519_叶文霆_7_SaleLineItem> items = new ArrayList<>();

    /* The observer pattern */
    ArrayList<_14211519_叶文霆_7_Observer> observers = new ArrayList<>();

    /* The constructor method */
    public _14211519_叶文霆_7_Sale() {}

    /* The shopping method */
    public _14211519_叶文霆_7_SaleLineItem add(_14211519_叶文霆_7_SaleLineItem item)
    {
        items.add(item);
        notifyObservers();
        return item;
    }

    public double getTotal()
    {
        double temp = 0;
        for (_14211519_叶文霆_7_SaleLineItem item : items)
            temp += item.getSubTotal();
        return temp;
    }

    public String[][] getCartInfo()
    {
        String[][] temp = new String[items.size()][];

        for (int i = 0; i < items.size(); i++)
        {
            _14211519_叶文霆_7_SaleLineItem item = items.get(i);
            double oldPrice = item.getCopies() * item.getProdSpec().getPrice();
            double discount = oldPrice - item.getSubTotal();

            temp[i] = new String[]{
                items.get(i).getProdSpec().getTitle(),
                String.valueOf(items.get(i).getCopies()),
                String.valueOf(oldPrice),
                String.valueOf(discount)
            };
        }

        return temp;
    }

    /* The Subject method */
    @Override
    public void registerObserver(_14211519_叶文霆_7_Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(_14211519_叶文霆_7_Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (_14211519_叶文霆_7_Observer observer : observers) {
            observer.update(this);
        }
    }
}
