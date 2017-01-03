package term_project;

/**
 * Created by YeWenting on 2017/1/3.
 */

public interface Subject
{
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}
