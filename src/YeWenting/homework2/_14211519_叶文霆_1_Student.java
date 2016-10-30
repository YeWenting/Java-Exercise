package homework2;

/** Student.java (UTF-8)
 *
 * UPDATE:新增ScoreException, StudentNumberException.
 *
 * Student类中定义了三个惊静态常数用于处理无分数，
 * 分数的最大值和最小值的情况。
 * 在设置分数的方法中考虑了无意义的参数。
 * toString()方法中使用了高效的StringBuilder
 * 进行字符串的处理。
 * Created by YeWenting on 22/10/2016.
 */

class ScoreException extends Exception {}

class StudentNumberException extends Exception {}

public class _14211519_叶文霆_1_Student
{
    /* Special value setting */
    static public final int NO_MARK = -1;
    static public final int MAX_MARK = 100;
    static public final int MIN_MARK = 0;

    /* Student's info */
    private String studentNumber = null;
    private String studentName = null;
    private int markForMaths = NO_MARK;
    private int markForEnglish = NO_MARK;
    private int markForScience = NO_MARK;

    /* Construction of the class */
    public _14211519_叶文霆_1_Student(String number, String name)
            throws StudentNumberException
    {
        studentName = name;

        /* Check the student number format */
        if ('2' != number.charAt(0) || '0' != number.charAt(1) || 10 != number.length())
            throw new StudentNumberException();

        for (int i = 2; i < number.length() ; i++)
            if (!Character.isDigit(number.charAt(i)))
                throw new StudentNumberException();

        studentNumber = number;
    }

    /* Wrapper for get functions */
    public String getNumber() { return studentNumber; }
    public String getName(){ return studentName; }
    public int getMarkMaths(){ return markForMaths; }
    public int getMarkEnglish(){
        return markForEnglish;
    }
    public int getMarkScience(){
        return markForScience;
    }
    public double calculateAverage()
    {
        if (markForEnglish == NO_MARK || markForMaths == NO_MARK || markForScience == NO_MARK)
            return (double) NO_MARK;
        else
            return ((markForMaths + markForEnglish + markForScience) / 3.0D);
    }

    /* Wrapper for set functions */
    public void enterMarks(int markForMaths, int markForEnglish, int markForScience)
            throws ScoreException
    {
        if (markForMaths > MAX_MARK || markForMaths < MIN_MARK || markForMaths > MAX_MARK
                || markForMaths < MIN_MARK || markForMaths > MAX_MARK || markForMaths < MIN_MARK)
            throw new ScoreException();
        else
        {
            this.markForMaths = markForMaths;
            this.markForEnglish = markForEnglish;
            this.markForScience = markForScience;
        }
    }

    /* Override for toString method */
    public String toString()
    {
        // use StringBuilder to obtain higher efficiency
        StringBuilder temp = new StringBuilder("");
        temp.append("学号：" + studentNumber);
        temp.append("\n姓名：" + studentName);
        temp.append("\n数学成绩：" + markForMaths);
        temp.append("\n英语成绩：" + markForEnglish);
        temp.append("\n科学成绩：" + markForScience);
        temp.append("\n平均成绩：" + calculateAverage());
        return temp.toString();
    }
}