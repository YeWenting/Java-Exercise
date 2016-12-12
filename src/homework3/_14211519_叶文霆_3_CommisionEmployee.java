package homework3;

/**
 * Created by YeWenting on 06/12/2016.
 */
public class _14211519_叶文霆_3_CommisionEmployee extends _14211519_叶文霆_3_Employee
{
    private int grossSales;
    private double commissionRate;

    public _14211519_叶文霆_3_CommisionEmployee() { grossSales = 0; commissionRate = 0.0; }
    public _14211519_叶文霆_3_CommisionEmployee(String fn, String ln, String ssn, int gs, double cr)
    {
        super(fn, ln, ssn);
        grossSales = gs;
        commissionRate = cr;
    }

    public final void setGrossSales(int gs) { grossSales = gs; }
    public final void setCommissionRate(int cr) { commissionRate = cr; }
    public final int getGrossSales() { return grossSales; }
    public final double getCommissionRate() { return commissionRate; }

    public int earning() { return (int)(grossSales * commissionRate); }

    @Override
    public String toString()
    {
        StringBuilder temp = new StringBuilder("");

        temp.append("This is a commission employee:\n");
        temp.append(super.toString());
        temp.append("Gross sales: " + grossSales);
        temp.append("\nCommission rate: " + commissionRate);
        temp.append("\nEarning: " + earning());
        temp.append("\n");

        return temp.toString();
    }

}
