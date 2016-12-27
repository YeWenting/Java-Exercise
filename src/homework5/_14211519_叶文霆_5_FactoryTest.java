package homework5;

/**
 * Created by YeWenting on 20/12/2016.
 */
public class _14211519_叶文霆_5_FactoryTest
{
    static public void main(String args[])
    {
        UserInterface service = new UserInterface();
        service.run();
    }
}


class UserInterface
{
    /* Data field */
    private _14211519_叶文霆_5_Factory testFactory;

    /* Construction method */
    public UserInterface(){ testFactory = new _14211519_叶文霆_5_Factory(); }

    /* Client serving method */
    private void printWelcomeInfo()
    {
        System.out.println("Please input your command:");
        System.out.println("1. find   2. update   3. delete  4. print");
        System.out.println("5. exit");
    }

    private void findAction()
    {
        /* read the empSecNum */
        System.out.println("Please input the social security number");
        String empSecNum = Keyboard.nextString(System.in);

        _14211519_叶文霆_5_Employee emp =  testFactory.getEmployee(empSecNum);


        if (emp == null)
            System.out.println("No such employee!\n");
        else
            System.out.println(emp);
    }

    private void updateAction()
    {
        /* read the empSecNum */
        System.out.println("Please input the social security number");
        String empSecNum = Keyboard.nextString(System.in);

        if (testFactory.getEmployee(empSecNum) == null)
        {
            System.out.println("invalid security number!\n");
            return;
        }

        /* read the updated info */
        int type;
        do
        {
            System.out.println("0->salaried emp 1->hourly emp 2->commission emp 3->base plus commission emp");
            System.out.println("What's new employee type:");
            type = Keyboard.nextInt(System.in);
        } while (type < 0 || type > 3);

        _14211519_叶文霆_5_Employee emp = Keyboard.nextEmployee(System.in, type);
        testFactory.updateEmployee(empSecNum, emp);
        System.out.println("Updated successfully!\n");
    }

    private void deleteAction()
    {
        /* read the empSecNum */
        System.out.println("Please input the social security number");
        String empSecNum = Keyboard.nextString(System.in);

        _14211519_叶文霆_5_Employee emp =  testFactory.deleteEmployee(empSecNum);

        if (emp == null)
            System.out.println("No such employee!\n");
        else
        {
            System.out.println("Delete successfully!\n");
        }

    }

    private void printAction()
    {
        testFactory.printAllEmployees();
    }

    public void run()
    {
        testFactory.initEmployees();
        System.out.println("Welcome to Employees Database designed by Ywt.");

        // running loop
        while (true)
        {
            printWelcomeInfo();
            int command = Keyboard.nextInt(System.in);
            boolean exitKey = false;

            switch (command)
            {
                case (1):
                    findAction();
                    break;
                case (2):
                    updateAction();
                    break;
                case (3):
                    deleteAction();
                    break;
                case (4):
                    printAction();
                    break;
                case (5):
                    exitKey = true;
                    break;
                default:
                    System.out.println("Invalid command!");
            }
            if (exitKey) break;
        }

        System.out.println("Thank you:)");
    }
}