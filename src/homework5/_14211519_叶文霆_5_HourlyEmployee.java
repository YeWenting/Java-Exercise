package homework5;

/**
 * Created by YeWenting on 06/12/2016.
 */
public class _14211519_叶文霆_5_HourlyEmployee extends _14211519_叶文霆_5_Employee
{
    private int wage, hours;

    public _14211519_叶文霆_5_HourlyEmployee() { wage = hours = 0; }
    public _14211519_叶文霆_5_HourlyEmployee(String fn, String ln, String ssn, int wa, int ho)
    {
        super(fn, ln, ssn);
        wage = wa; hours = ho;
    }

    public final void setHours(int ho) { hours = ho; }
    public final void setwage(int wa) { wage = wa; }
    public final int getWage() { return wage; }
    public final int getHours() { return hours; }

    public int earning()
    {
        return wage * hours;
    }

    @Override
    public String toString()
    {
        StringBuilder temp = new StringBuilder("");

        temp.append("This is a hourly employee:\n");
        temp.append(super.toString());
        temp.append("Wage: " + wage);
        temp.append("\nHours: " + hours);
        temp.append("\nEarning: " + earning());
        temp.append("\n");

        return temp.toString();
    }
}
