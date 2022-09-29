package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Lab 2
 * Creates a window with a specified menubar and sub menubar with specified menu items split into quarters each labeled
 * with our names and colored using label backgrounds.
 *
 * @author Cole Park
 * @author Van  Park
 * @author Jacob Shapero
 * @author Lauren Allen
 * @author Bret Craig
 * @version 9/28/2022
 */
public class App extends JFrame implements ActionListener {
    JTextField T1;
    JTextField T2;
    JTextField T3;
    JTextField calcText;
    int num1;
    int num2;
    char operator;
    boolean isFirst = true;
    boolean haveSecond = false;



    public static void main(String[] args) {
        App win = new App();
        win.setSize(500,500);
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * constructor
     * assembles the window used for our GUI
     */
    public App()
    {

        super("Lab3");

        JMenuBar mb = new JMenuBar();

        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("About");

        JMenuItem item1 = new JMenuItem("Open");
        JMenuItem item2 = new JMenuItem("Save");
        JMenuItem item3 = new JMenuItem("Quit");

        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);

        m1.add(item1);
        m1.add(item2);
        m1.add(item3);

        mb.add(m1);
        mb.add(m2);
        setJMenuBar(mb);

        JTabbedPane tabs = new JTabbedPane();

        JLabel l1 = new JLabel("Cole Park");
        JLabel l2 = new JLabel("Lauren Allen");
        JLabel l3 = new JLabel("Van Park");
        JLabel l4 = new JLabel("Jacob Shapero");

        l1.setBackground(Color.PINK);
        l2.setBackground(Color.GREEN);
        l3.setBackground(Color.CYAN);
        l4.setBackground(Color.BLACK);
        l4.setForeground(Color.WHITE);
        l1.setHorizontalAlignment(JLabel.CENTER);
        l2.setHorizontalAlignment(JLabel.CENTER);
        l3.setHorizontalAlignment(JLabel.CENTER);
        l4.setHorizontalAlignment(JLabel.CENTER);

        l1.setOpaque(true);
        l2.setOpaque(true);
        l3.setOpaque(true);
        l4.setOpaque(true);

        GridLayout grid = new GridLayout(2,2);
        JPanel box = new JPanel();
        box.setLayout(grid);
        JButton b1 = new JButton("Click Here");
        T1 = new JTextField("I can write here");
        T2 = new JTextField("And Here...");
        T3 = new JTextField("Or here!");
        box.add(T1);
        box.add(T2);
        box.add(b1);
        box.add(T3);
        b1.addActionListener(this);

        //Calculator Setup
        BorderLayout border = new BorderLayout();
        JPanel calcPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        GridLayout calcGrid = new GridLayout(4,4);
        buttonPanel.setLayout(calcGrid);
        calcPanel.setLayout(border);
        JButton[] calcButtons = new JButton[16];
        for (int i = 0; i < 10; i++)
        {
            calcButtons[i] = new JButton(i+"");
            buttonPanel.add(calcButtons[i]);
            calcButtons[i].addActionListener(this);
        }
        calcButtons[10] = new JButton("+");
        calcButtons[11] = new JButton("-");
        calcButtons[12] = new JButton("*");
        calcButtons[13] = new JButton("/");
        calcButtons[14] = new JButton("=");
        calcButtons[15] = new JButton("clear");
        buttonPanel.add(calcButtons[10]);
        buttonPanel.add(calcButtons[11]);
        buttonPanel.add(calcButtons[12]);
        buttonPanel.add(calcButtons[13]);
        buttonPanel.add(calcButtons[14]);
        buttonPanel.add(calcButtons[15]);
        calcButtons[10].addActionListener(this);
        calcButtons[11].addActionListener(this);
        calcButtons[12].addActionListener(this);
        calcButtons[13].addActionListener(this);
        calcButtons[14].addActionListener(this);
        calcButtons[15].addActionListener(this);
        calcText = new JTextField();
        calcPanel.add(calcText, BorderLayout.NORTH);
        calcPanel.add(buttonPanel, BorderLayout.CENTER);



        tabs.add(box,"Page 1");
        tabs.add(calcPanel, "Calculator");
        tabs.add(l3, "Page 3");
        tabs.add(l4, "Page 4");
        add(tabs);

        mb.setVisible(true);
        m1.setVisible(true);
        m2.setVisible(true);

    }

    /**
     * actionPerformed
     * @param e
     * responds to action events accordingly based on buttons selected
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Open"))
            JOptionPane.showMessageDialog(this, "You clicked open!");
        else if (e.getActionCommand().equals("Save"))
            JOptionPane.showMessageDialog(this, "You clicked Save!");
        else if (e.getActionCommand().equals("Quit"))
            JOptionPane.showMessageDialog(this, "You clicked Quit!");
        else if (e.getActionCommand().equals("Click Here"))
            T3.setText((T1.getText() + " " + T2.getText()));
        else if (e.getActionCommand().equals("clear"))
        {
            calcText.setText("");
            num1 = 0;
            num2 = 0;
            haveSecond = false;
            isFirst = true;
        }
        else if (isInt(e.getActionCommand()))
            calcText.setText((calcText.getText() + e.getActionCommand()));
        else
        {
            if(isFirst)
            {
                num1 = Integer.parseInt(calcText.getText());
                isFirst = false;
            }
            else {
                num2 = Integer.parseInt(calcText.getText());
                haveSecond = true;
            }

            calcText.setText("");
            if (!e.getActionCommand().equals("="))
            {
                if(!haveSecond)
                {
                    operator = e.getActionCommand().charAt(0);
                }
                else
                {
                    calculate();
                    operator = e.getActionCommand().charAt(0);
                }

            }
            else
            {
                calculate();
            }
        }

    }

    private void calculate()
    {
        int result;
        switch(operator)
        {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                result = 0;
                break;
        }
        num1 = 0;
        num2 = 0;
        calcText.setText(result + "");
        haveSecond = false;
        isFirst = true;
    }

    private boolean isInt(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

}
