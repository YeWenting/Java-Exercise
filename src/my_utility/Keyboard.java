package my_utility;

import java.io.InputStream;
import java.util.Scanner;
import java.util.InputMismatchException;

/** my_utility.Keyboard.java (UTF-8)
 *
 * A simple wrapper for the user-oriented text scanner using the
 * "java.util.Scanner" to implement, providing the exception-free
 * and safe method to the caller.
 *
 * Created by YeWenting on 24/10/2016.
 */
public class Keyboard
{
    static public int nextInt(InputStream input)
    {
        int x;

        while (true)
        {
            try
            {
                Scanner in = new Scanner(input);
                x = in.nextInt();
                break;
            }
            catch (InputMismatchException e)
            {
                System.out.println("请输入数字!");
            }
        }
        return x;
    }

    static public double nextDouble(InputStream input)
    {
        double x;

        while (true)
        {
            try
            {
                Scanner in = new Scanner(input);
                x = in.nextDouble();
                break;
            }
            catch (InputMismatchException e)
            {
                System.out.println("!");
            }
        }
        return x;
    }

    static public String nextString(InputStream input)
    {
        Scanner in = new Scanner(input);
        String s;

        s = in.nextLine();

        return s;
    }
}
