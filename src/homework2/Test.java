package homework2;

import java.io.*;

/**
 * Created by YeWenting on 28/11/2016.
 */


class Father {
    Father() {
        System.out.println("fa no");
    }

    Father(int x) {
        System.out.println("fa para");
    }
}

class Son extends Father{
    Son() {
        System.out.println("son no");
    }

    Son(int x) {
        System.out.println("son para");
    }
}

public class Test {
    static public void main(String[] args)
    {
        new Son(2);
        System.out.print(100*0.4);
    }
}
