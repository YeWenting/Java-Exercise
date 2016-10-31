package homework1;

import java.util.Scanner;

import homework1.student.*;
import homework1.student_list.*;
import my_utility.Keyboard;

/** homework2.StudentListTest.java (UTF-8)
 *
 * 实现了用户交互类UserInterface，同样实现了用户输入
 * 无效时的处理和显示提示信息。
 *
 * Created by YeWenting on 22/10/2016.
 */
public class StudentListTest
{

    static public void main(String[] args)
    {
        UserInterface machine = new UserInterface();
        machine.run();
    }
}

class UserInterface
{
    /* The tested StudentList */
    _14211519_叶文霆_1_StudentList testStudentList = new _14211519_叶文霆_1_StudentList();

    /*************************************
     * Error-free read function
     *************************************/


    /*************************************
     * Wrapper for list test function
     *************************************/
    private void printAllStudent()
    {
        System.out.println("---目前有" + testStudentList.getTotal() + "个学生，信息为---:");
        for (int i = 0; i < testStudentList.getTotal(); i++)
            System.out.println(testStudentList.getItem(i));
    }

    private void deleteStudentByIndex()
    {
        int index;

        System.out.print("请输入要删除第几个学生：");
        index = Keyboard.getInt(System.in);
        if (!testStudentList.remove(index - 1)) System.out.println("对不起，没有对应的学生");
        else System.out.println("删除成功！");
    }

    private void deleteStudentByNumber()
    {
        String num;

        System.out.print("请输入学生学号：");
        num = Keyboard.nextString(System.in);
        if (!testStudentList.remove(num)) System.out.println("对不起，没有对应的学生");
        else System.out.println("删除成功！");

    }

    private void printStudentByIndex()
    {
        int index;
        _14211519_叶文霆_1_Student student;

        System.out.print("请输入学生位置：");
        index = Keyboard.getInt(System.in);

        student = testStudentList.getItem(index - 1);
        if (student == null) System.out.println("对不起，没有对应的学生");
        else System.out.println(student);
    }

    private void printStudentByNumber()
    {
        String num;
        _14211519_叶文霆_1_Student student;

        System.out.print("请输入学生学号：");
        num = Keyboard.nextString(System.in);

        student = testStudentList.getItem(num);
        if (student == null) System.out.println("对不起，没有对应的学生");
        else System.out.println(student);
    }

    /*************************************
     * User interface function
     *************************************/
    private void printWelcomeInfo()
    {
        System.out.println("菜单如下，请输入1~8代表您要执行的操作：");
        System.out.println("1. 增加1个学生	2. 根据学号删除学生     3.根据位置删除学生 ");
        System.out.println("4. 判断是否为空 	5. 根据位置返回学生     6.根据学号返回学生");
        System.out.println("7. 输出全部学生信息");
        System.out.println("8. 退出程序");
    }
    public void run()
    {
        Scanner in = new Scanner(System.in);
        int command;

        printWelcomeInfo();
        while(true)
        {
            System.out.print("请输入您的操作：");
            command = in.nextInt();
            switch (command)
            {
                case (1) :  testStudentList.add(StudentTest.createStudent());
                    printAllStudent();
                    break;
                case (2) :  deleteStudentByNumber();
                    printAllStudent();
                    break;
                case (3) :  deleteStudentByIndex();
                    printAllStudent();
                    break;
                case (4) :  if (testStudentList.isEmpty()) System.out.println("列表为空！");
                else System.out.println("列表非空！");
                    break;
                case (5) :  printStudentByIndex();
                    break;
                case (6) :  printStudentByNumber();
                    break;
                case (7) :  printAllStudent();
                    break;
                case (8) :  System.out.println("谢谢使用，再见:)");
                    return;
                default  :  System.out.println("请输入1~8之间的数字！");
                    break;
            }
        }
    }
}