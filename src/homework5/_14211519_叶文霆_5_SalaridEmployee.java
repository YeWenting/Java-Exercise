package homework5;

/**
 * Created by YeWenting on 06/12/2016.
 */
public class _14211519_叶文霆_5_SalaridEmployee extends _14211519_叶文霆_5_Employee
{
    private int weeklySalary;

    public _14211519_叶文霆_5_SalaridEmployee() { weeklySalary = 0; }
    public _14211519_叶文霆_5_SalaridEmployee(String fn, String ln, String ssn, int ws)
    {
        super(fn, ln, ssn);
        weeklySalary = ws;
    }

    public final void setWeeklySalary(int ws) { weeklySalary = ws; }
    public final int getWeeklySalary() { return weeklySalary; }

    public int earning()
    {
        return weeklySalary * 4;
    }

    @Override
    public String toString()
    {
        StringBuilder temp = new StringBuilder("");

        temp.append("This is a salaried employee:\n");
        temp.append(super.toString());
        temp.append("Salary: " + weeklySalary);
        temp.append("\nEarning: " + earning());
        temp.append("\n");

        return temp.toString();
    }
}
