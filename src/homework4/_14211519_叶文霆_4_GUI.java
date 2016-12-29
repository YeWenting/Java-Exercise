package homework4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Created by YeWenting on 28/12/2016.
 */

public class _14211519_叶文霆_4_GUI extends JFrame
{
    /* Windows size constant*/
    private static final int INPUT_WIDTH = 320;
    private static final int INPUT_HEIGHT = 300;
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 400;
    private static final int CONFIRM_WIDTH = 200;
    private static final int CONFIRM_HEIGHT = 100;

    /* Employees data & method */
    ArrayList<_14211519_叶文霆_4_Employee> employees;

    private double getAverWage()
    {
        if (0 == employees.size()) return 0;

        double tot = 0;

        for (_14211519_叶文霆_4_Employee emp : employees)
            tot += emp.getEarning();

        return tot / employees.size();
    }

    /* Information input dialog class */
    class BasePlusCommisionEmpDialog extends JDialog
    {
        public BasePlusCommisionEmpDialog(JFrame f)
        {
            super(f, true);
            initUI();
        }

        private void initUI()
        {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(7, 2));

            panel.add(new JLabel("First name: "));
            JTextField firstNameField = new JTextField();
            panel.add(firstNameField);

            panel.add(new JLabel("Last name: "));
            JTextField lastNameField = new JTextField();
            panel.add(lastNameField);

            panel.add(new JLabel("Social security num: "));
            JTextField secNumField = new JTextField();
            panel.add(secNumField);

            panel.add(new JLabel("Base salary: "));
            JTextField baseSalaryField = new JTextField();
            panel.add(baseSalaryField);

            panel.add(new JLabel("Gross sales: "));
            JTextField salesField = new JTextField();
            panel.add(salesField);

            panel.add(new JLabel("Commission rate: "));
            JTextField rateField = new JTextField();
            panel.add(rateField);

            // Add "submit" button
            JButton bSubmit= new JButton("submit");
            bSubmit.addActionListener((event) ->
            {
                try
                {
                    // Make sure security number is no empty
                    if (secNumField.getText().equals(""))
                        throw new IllegalArgumentException();

                    employees.add(new _14211519_叶文霆_4_BasePlusCommisionEmployee(
                            firstNameField.getText(),
                            lastNameField.getText(),
                            secNumField.getText(),
                            Integer.parseInt(salesField.getText()),
                            Integer.parseInt(rateField.getText()),
                            Integer.parseInt(baseSalaryField.getText())
                    ));
                }
                catch (Exception e)
                {
                    ErrorLog log = new ErrorLog();
                    log.setVisible(true);
                }
                finally
                {
                    this.dispose();
                }
            });
            panel.add(bSubmit);

            // Add "cancel" button
            JButton bCancel = new JButton("Cancel");
            bCancel.addActionListener ((event) ->
            {
                this.dispose();
            });
            panel.add(bCancel);

            // Add panel and resize
            this.add(panel);
            this.pack();

            // Misc
            setTitle ("Create Commision Employee");
            setDefaultCloseOperation (DISPOSE_ON_CLOSE);
            setLocationRelativeTo (getParent ());
            setSize(INPUT_WIDTH, INPUT_HEIGHT);
        }
    }

    private class CommisionEmpDialog extends JDialog
    {
        public CommisionEmpDialog(JFrame f)
        {
            super(f, true);
            initUI();
        }

        private void initUI()
        {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(6, 2));

            panel.add(new JLabel("First name: "));
            JTextField firstNameField = new JTextField();
            panel.add(firstNameField);

            panel.add(new JLabel("Last name: "));
            JTextField lastNameField = new JTextField();
            panel.add(lastNameField);

            panel.add(new JLabel("Social security num: "));
            JTextField secNumField = new JTextField();
            panel.add(secNumField);

            panel.add(new JLabel("Gross sales: "));
            JTextField salesField = new JTextField();
            panel.add(salesField);

            panel.add(new JLabel("Commission rate: "));
            JTextField rateField = new JTextField();
            panel.add(rateField);

            // Add "submit" button
            JButton bSubmit= new JButton("submit");
            bSubmit.addActionListener((event) ->
            {
                try
                {
                    // Make sure security number is no empty
                    if (secNumField.getText().equals(""))
                        throw new IllegalArgumentException();

                    employees.add(new _14211519_叶文霆_4_CommisionEmployee(
                            firstNameField.getText(),
                            lastNameField.getText(),
                            secNumField.getText(),
                            Integer.parseInt(salesField.getText()),
                            Double.parseDouble(rateField.getText())
                            ));
                }
                catch (Exception e)
                {
                    ErrorLog log = new ErrorLog();
                    log.setVisible(true);
                }
                finally
                {
                    this.dispose();
                }
            });
            panel.add(bSubmit);

            // Add "cancel" button
            JButton bCancel = new JButton("Cancel");
            bCancel.addActionListener ((event) ->
            {
                this.dispose();
            });
            panel.add(bCancel);

            // Add panel and resize
            this.add(panel);
            this.pack();

            // Misc
            setTitle ("Create Commision Employee");
            setDefaultCloseOperation (DISPOSE_ON_CLOSE);
            setLocationRelativeTo (getParent ());
            setSize(INPUT_WIDTH, INPUT_HEIGHT);
        }
    }

    class ErrorLog extends JDialog
    {
        public ErrorLog()
        {
            super();
            initUI();
        }

        private void initUI ()
        {
            // Show error info
            this.add(new JLabel("Invalid input! Please try again", JLabel.CENTER));
            this.pack();

            // Misc
            setTitle ("Error!");
            setDefaultCloseOperation (DISPOSE_ON_CLOSE);
            setLocationRelativeTo (getParent());
            setSize(CONFIRM_WIDTH, CONFIRM_HEIGHT);
        }
    }

    class AverEarningDialog extends JDialog
    {
        public AverEarningDialog()
        {
            super();
            initUI();
        }

        private void initUI()
        {
            // Show info
            this.add(new JLabel("Average Earning: " + getAverWage(), JLabel.CENTER));
            this.pack();

            // Misc
            setTitle ("Average Earning");
            setDefaultCloseOperation (DISPOSE_ON_CLOSE);
            setLocationRelativeTo (getParent());
            setSize(CONFIRM_WIDTH, CONFIRM_HEIGHT);
        }
    }

    public _14211519_叶文霆_4_GUI()
    {
        employees = new ArrayList<_14211519_叶文霆_4_Employee>();
        initUI();
    }

    private void initUI()
    {
        // Show the menu bar
        initMenu();

        // Show the content
        this.add(new JLabel ("Swing GUI - 员工信息的录入和查询", JLabel.CENTER));

        // Misc
        setTitle ("员工信息的录入和查询");
        setSize (FRAME_WIDTH, FRAME_HEIGHT);
        setLocationRelativeTo (null);
        setDefaultCloseOperation (EXIT_ON_CLOSE);
    }

    private void initMenu()
    {
        // Create menu 1-1
        JMenuItem mBPCEmp = new JMenuItem("BasePlusCommisionEmployee");
        mBPCEmp.addActionListener((e) ->
        {
            BasePlusCommisionEmpDialog dialog = new BasePlusCommisionEmpDialog(this);
            dialog.setVisible(true);
        });

        // Create menu 1-2
        JMenuItem mCEmp = new JMenuItem("CommisionEmployee");
        mCEmp.addActionListener((e) ->
        {
            CommisionEmpDialog dialog = new CommisionEmpDialog(this);
            dialog.setVisible(true);
        });

        // Create menu 2-1
        JMenuItem mAverSearch = new JMenuItem("AverageEarningSearch");
        mAverSearch.addActionListener((e) ->
        {
            AverEarningDialog dialog = new AverEarningDialog();
            dialog.setVisible(true);
        });

        // Create menu 1
        JMenu mEmpInfoInput = new JMenu("EmployeeInfoInput");
        mEmpInfoInput.add(mBPCEmp);
        mEmpInfoInput.add(mCEmp);

        // Create menu 2
        JMenu mSearch = new JMenu("Search");
        mSearch.add(mAverSearch);

        // Create and show menu bar
        JMenuBar mMain = new JMenuBar();
        mMain.add(mEmpInfoInput);
        mMain.add(mSearch);
        this.setJMenuBar(mMain);
    }

    private void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == )
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            _14211519_叶文霆_4_GUI gui = new _14211519_叶文霆_4_GUI();
            gui.setVisible(true);
        });
    }

}
