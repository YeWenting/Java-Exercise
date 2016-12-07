package homework3;

/**
 * Created by YeWenting on 06/12/2016.
 */
public abstract class Employee
{
    private String firstName, lastName;
    private final String socialSecurityNumber;

    public Employee()
    {
        socialSecurityNumber = lastName = firstName = null;
    }

    public Employee(String fn, String ln, String ssn)
    {
        firstName = fn;
        lastName = ln;
        socialSecurityNumber = ssn;
    }

    public final void setFirstName(String fn) { firstName = fn; }
    public final void setLastName(String ln) { lastName = ln; }
    public final String getFirstName() { return firstName; }
    public final String getLastName() { return lastName; }
    public final String getSocialSecurityNumber() { return socialSecurityNumber; }

    public abstract int earning();

    @Override
    public String toString()
    {
        StringBuilder temp = new StringBuilder("");

        temp.append("First name: " + getFirstName());
        temp.append("\nLast name: " + getLastName());
        temp.append("\nSocial security number: " + getSocialSecurityNumber());
        temp.append("\n");

        return temp.toString();
    }

}
