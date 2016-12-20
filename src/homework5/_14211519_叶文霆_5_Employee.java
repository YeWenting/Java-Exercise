package homework5;

/**
 * Created by YeWenting on 06/12/2016.
 */
public abstract class _14211519_叶文霆_5_Employee
{
    private String firstName, lastName;
    private final String socialSecurityNumber;

    public _14211519_叶文霆_5_Employee()
    {
        socialSecurityNumber = lastName = firstName = null;
    }

    public _14211519_叶文霆_5_Employee(String fn, String ln, String ssn)
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

    /* Abstract method */
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
