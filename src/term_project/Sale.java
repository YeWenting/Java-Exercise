package term_project;

import java.util.ArrayList;

/**
 * Created by YeWenting on 2017/1/3.
 */
public class Sale implements Subject
{
    /* The data field */
    private ArrayList<SaleLineItem> items = new ArrayList<>();

    /* The observer pattern */
    ArrayList<Observer> observers = new ArrayList<>();

    /* The constructor method */
    public Sale() {}

    /* The shopping method */
    public SaleLineItem add(SaleLineItem item)
    {
        items.add(item);
        notifyObservers();
        return item;
    }

    public double getTotal()
    {
        double temp = 0;
        for (SaleLineItem item : items)
            temp += item.getSubTotal();
        return temp;
    }

    public String[][] getCartInfo()
    {
        String[][] temp = new String[items.size()][];

        for (int i = 0; i < items.size(); i++)
        {
            SaleLineItem item = items.get(i);
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
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
