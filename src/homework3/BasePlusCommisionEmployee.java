package homework3;

/**
 * Created by YeWenting on 06/12/2016.
 */
public class BasePlusCommisionEmployee extends CommisionEmployee
{
    private int baseSalary;
    
    public BasePlusCommisionEmployee() { baseSalary = 0; }
    public BasePlusCommisionEmployee(String fn, String ln, String ssn, int gs, double cr, int bs)
    {
        super(fn, ln, ssn, gs, cr);
        baseSalary = bs;
    }

    public final void setbaseSalary(int bs) { baseSalary = bs; }
    public final int getbaseSalary() { return baseSalary; }

    public int earning() { return super.earning() + baseSalary; }

    @Override
    public String toString()
    {
        StringBuilder temp = new StringBuilder("");

        temp.append("This is a base plus commission employee:");
        temp.append("\nFirst name: " + getFirstName());
        temp.append("\nLast name: " + getLastName());
        temp.append("\nSocial security number: " + getSocialSecurityNumber());
        temp.append("\nGross sales: " + getGrossSales());
        temp.append("\nCommission rate: " + getCommissionRate());
        temp.append("\nBase plus salary: " + baseSalary);
        temp.append("\nEarning: " + earning());
        temp.append("\n");

        return temp.toString();
    }
}
