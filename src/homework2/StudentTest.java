package homework2;

/** homework2.StudentTest.java (UTF-8)
 *
 * studentTest类实现了能够正确处理用户非法输出的用户交互界面，
 * 当用户输入数据不符合格式要求时将会抛弃错误数据，并给出相应提
 * 示信息。
 * 使用String.split()来处理逗号。
 *
 * Created by YeWenting on 16/10/2016.
 */

public class StudentTest
{
    static public _14211519_叶文霆_1_Student createStudent()
    {
        String name, id, marks;
        int maths, english, science;
        _14211519_叶文霆_1_Student testStudent;

        while (true)
        {
            try
            {
                System.out.print("请输入学生学号：");
                id = Keyboard.nextString(System.in);
                System.out.print("请输入学生姓名：");
                name = Keyboard.nextString(System.in);
                System.out.print("请输入学生三门课成绩（数学,英语,科学）：");
                marks = Keyboard.nextString(System.in);

                String[] score = marks.split(",");
                maths = Integer.parseInt(score[0]);
                english = Integer.parseInt(score[1]);
                science = Integer.parseInt(score[2]);

                testStudent = new _14211519_叶文霆_1_Student(id, name);
                testStudent.enterMarks(maths, english, science);
                break;
            }

            catch (NumberFormatException e)
            {
                System.out.println("请输入数字！");
            }
            catch (ScoreException e)
            {
                System.out.println("成绩数据有误，请重新输入！");
            }
            catch (StudentNumberException e)
            {
                System.out.println("学号格式不正确，请重新输入！");
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("请输入3个数字，并用半角逗号隔开！");
            }
        }
        return testStudent;
    }
    static public void main(String[] args)
    {
        _14211519_叶文霆_1_Student testStudent = createStudent();
        System.out.println(testStudent);
    }
}
