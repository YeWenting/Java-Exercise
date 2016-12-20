package homework5;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * my_utility.Keyboard.java (UTF-8)
 * <p>
 * A simple wrapper for the user-oriented text scanner using the
 * "java.util.Scanner" to implement, providing the exception-free
 * and safe method to the caller.
 * <p>
 * Created by YeWenting on 24/10/2016.
 */
public class Keyboard {
    static public int nextInt(InputStream input) {
        int x;

        while (true) {
            try {
                Scanner in = new Scanner(input);
                x = in.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("请输入数字!");
            }
        }
        return x;
    }

    static public double nextDouble(InputStream input) {
        double x;

        while (true) {
            try {
                Scanner in = new Scanner(input);
                x = in.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("!");
            }
        }
        return x;
    }

    static public String nextString(InputStream input) {
        Scanner in = new Scanner(input);
        String s;

        s = in.nextLine();

        return s;
    }

    static public _14211519_叶文霆_5_Employee nextEmployee(InputStream input, int type)
    {
        /* read basic info */
        String first, last, SSN;
        System.out.println("First name:");
        first = Keyboard.nextString(input);
        System.out.println("Last name:");
        last = Keyboard.nextString(input);
        System.out.println("Social security number:");
        SSN = Keyboard.nextString(input);

        /* SSN = "0000" break */
        if (SSN.equals("0000"))
            return null;

        /* read advanced info */
        switch (type) {
            case 0:
                /* read salary employee info */
                int ws;
                System.out.println("Salary:");
                ws = Keyboard.nextInt(input);
                return new _14211519_叶文霆_5_SalaridEmployee(first, last, SSN, ws);

            case 1:
                /* read hourly employee info */
                int hour, wage;
                System.out.println("Wage:");
                wage = Keyboard.nextInt(input);
                System.out.println("Hour:");
                hour = Keyboard.nextInt(input);
                return new _14211519_叶文霆_5_HourlyEmployee(first, last, SSN, wage, hour);

            case 2:
                /* read commission employee info */
                int gs;
                double cr;
                System.out.println("Gross sales:");
                gs = Keyboard.nextInt(input);
                System.out.println("Commission rate:");
                cr = Keyboard.nextDouble(input);
                return new _14211519_叶文霆_5_CommisionEmployee(first, last, SSN, gs, cr);

            default:
                /* read base plus commission employee info */
                int gsBase, bs;
                double crBase;
                System.out.println("Gross sales:");
                gsBase = Keyboard.nextInt(input);
                System.out.println("Commission rate:");
                crBase = Keyboard.nextDouble(input);
                System.out.println("Base salary:");
                bs = Keyboard.nextInt(input);
                return new _14211519_叶文霆_5_BasePlusCommisionEmployee(first, last, SSN, gsBase, crBase, bs);

//            default:
//                return null;
        }
    }
}
