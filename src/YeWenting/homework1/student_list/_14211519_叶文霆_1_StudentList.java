package homework1.student_list;

import homework1.student.*;

import java.util.ArrayList;

/** StudentList.java (UTF-8)
 *
 *  使用基于数组的 ArrayList 适配器实现StudentList类，
 *  保证了快速的随机访问的同时，也支持高效的add()操作和
 *  扩容操作。
 *  使用list.size()来代替了total成员变量。
 *  最大学生数设为100.
 * Created by YeWenting on 16/10/2016.
 */

public class _14211519_叶文霆_1_StudentList
{
    /* Data member variables */
    private ArrayList<_14211519_叶文霆_1_Student> list = new ArrayList<_14211519_叶文霆_1_Student>();
    private int maxStudentNum = 100;

    /* Constructor method */
    public _14211519_叶文霆_1_StudentList() { }
    public _14211519_叶文霆_1_StudentList(int length) { maxStudentNum = length; }

    /*************************************
     * Wrapper for get methods
     *************************************/
    public int getTotal() { return list.size(); }

    public boolean isEmpty() { if (list.size() == 0) return true; return false; }

    public _14211519_叶文霆_1_Student getItem(int no)
    {
        if (no < 0 || no >= list.size()) return null;
        return list.get(no);
    }

    public _14211519_叶文霆_1_Student getItem(String number)
    {
        int index = find(number);

        if (index < 0) return null;
        return list.get(index);
    }

    /*************************************
     * Wrapper for array operation methods
     *************************************/
    public boolean add(_14211519_叶文霆_1_Student stu)
    {
        if (list.size() >= maxStudentNum) return false;
        list.add(stu);
        return true;
    }

    public boolean remove(int no)
    {
        if (no < 0 || no >= list.size()) return false;
        list.remove(no);
        return true;
    }

    public boolean remove(String number) {
        int index = find(number);

        if (index < 0) return false;
        list.remove(index);
        return true;
    }

    public int find(String number)
    {
        for (int i = 0; i < list.size(); i++)
            if (list.get(i).getNumber().equals(number))
                return i;
        return -1;
    }


}
