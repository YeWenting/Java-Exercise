package homework3;

import java.util.ArrayList;
import java.util.Random;
import my_utility.Keyboard;

/**
 * Created by YeWenting on 07/12/2016.
 */
public class EmployeeTest
{
    static public final int EMPLOYEE_NUM = 3;
    static public final int SALARY = 0, HOURLY = 1, COMMISION = 2, BASEPLUS = 3;

    static public void main(String[] args)
    {
        Random rand = new Random();
        ArrayList<_14211519_叶文霆_3_Employee> employees = new ArrayList<_14211519_叶文霆_3_Employee>();

        for (int i = 0; i < EMPLOYEE_NUM; i++)
        {
            int type = rand.nextInt() % 4;

            /* print welcome message */
            switch (type)
            {
                case 0  :   System.out.println("Generated a salaried employee!");
                            break;
                case 1  :   System.out.println("Generated a hourly employee!");
                            break;
                case 2  :   System.out.println("Generated a commission employee!");
                            break;
                default :   System.out.println("Generated a base plus commission employee!");
                            break;
            }

            /* read basic info */
            String first, last, SSN;
            System.out.println("First name:");
            first = Keyboard.nextString(System.in);
            System.out.println("Last name:");
            last = Keyboard.nextString(System.in);
            System.out.println("Social security number:");
            SSN = Keyboard.nextString(System.in);

            /* read advanced info */
            switch (type)
            {
                case 0  :
                    /* read salary employee info */
                    int ws;
                    System.out.println("Salary:");
                    ws = Keyboard.nextInt(System.in);
                    employees.add(new _14211519_叶文霆_3_SalaridEmployee(first, last, SSN, ws));
                    break;

                case 1  :
                    /* read hourly employee info */
                    int hour, wage;
                    System.out.println("Wage:");
                    wage = Keyboard.nextInt(System.in);
                    System.out.println("Hour:");
                    hour = Keyboard.nextInt(System.in);
                    employees.add(new _14211519_叶文霆_3_HourlyEmployee(first, last, SSN, wage, hour));
                    break;

                case 2  :
                    /* read commission employee info */
                    int gs;
                    double cr;
                    System.out.println("Gross sales:");
                    gs = Keyboard.nextInt(System.in);
                    System.out.println("Commission rate:");
                    cr = Keyboard.nextDouble(System.in);
                    employees.add(new _14211519_叶文霆_3_CommisionEmployee(first, last, SSN, gs, cr));
                    break;

                default :
                    /* read base plus commission employee info */
                    int gsBase, bs;
                    double crBase;
                    System.out.println("Gross sales:");
                    gsBase = Keyboard.nextInt(System.in);
                    System.out.println("Commission rate:");
                    crBase = Keyboard.nextDouble(System.in);
                    System.out.println("Base salary:");
                    bs = Keyboard.nextInt(System.in);
                    employees.add(new _14211519_叶文霆_3_BasePlusCommisionEmployee(first, last, SSN, gsBase, crBase, bs));
                    break;
            }
        }
        /* print the employees info */
        for (int j = 0; j < employees.size(); j++)
            System.out.println(employees.get(j));
    }
}
