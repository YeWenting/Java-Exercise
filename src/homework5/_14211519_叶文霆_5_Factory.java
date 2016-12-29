package homework5;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by YeWenting on 20/12/2016.
 */
public class _14211519_叶文霆_5_Factory
{
    /* Initialized number of employees */
    static private final int INIT_NUM = 10;

    /* Employees map */
    private HashMap <String, _14211519_叶文霆_5_Employee> employees;

    /* Construction method */
    public _14211519_叶文霆_5_Factory() { employees = new HashMap <String, _14211519_叶文霆_5_Employee>(); }

    /* Initialized method */
    public void initEmployees()
    {
        Random rand = new Random();

        for (int i = 0; i < INIT_NUM; i++)
        {
            int type = rand.nextInt(4);

            /* print message */
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

            _14211519_叶文霆_5_Employee emp = _14211519_叶文霆_5_Keyboard.nextEmployee(System.in, type);
            if (emp != null)
                this.addEmployee(emp);
            else
            {
                System.out.println("The initialing process is ended.\n");
                return;
            }
        }
    }

    /* Wrapper for control method */
    public _14211519_叶文霆_5_Employee getEmployee(String empSecNum) { return employees.get(empSecNum); }

    public _14211519_叶文霆_5_Employee deleteEmployee(String empSecNum) { return employees.remove(empSecNum); }

    public _14211519_叶文霆_5_Employee addEmployee(_14211519_叶文霆_5_Employee stu)
    {
        if (employees.get(stu.getSocialSecurityNumber()) != null)
            return null;
        else
            return employees.put(stu.getSocialSecurityNumber(), stu);
    }

    public _14211519_叶文霆_5_Employee updateEmployee(String empSecNum, _14211519_叶文霆_5_Employee stu)
    {
        if (employees.get(empSecNum) != null)
            return employees.put(empSecNum, stu);
        else
            return null;
    }

    public void printAllEmployees()
    {
        for (_14211519_叶文霆_5_Employee emp : employees.values())
            System.out.println(emp);
    }
}