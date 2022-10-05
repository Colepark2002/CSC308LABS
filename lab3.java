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
 * @version 9/26/2022
 */
public class App extends JFrame implements ActionListener {
    JTextField T1;
    JTextField T2;
    JTextField T3;
    JTextField calcText;



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

        GridLayout calcGrid = new GridLayout(4,3);
        JPanel calcPanel = new JPanel();
        calcPanel.setLayout(calcGrid);
        JButton calcB1 = new JButton("1");
        JButton calcB2 = new JButton("2");
        JButton calcB3 = new JButton("3");
        JButton calcB4 = new JButton("4");
        JButton calcB5 = new JButton("5");
        JButton calcB6 = new JButton("6");
        JButton calcB7 = new JButton("7");
        JButton calcB8 = new JButton("8");
        JButton calcB9 = new JButton("9");
        calcText = new JTextField();
        calcPanel.add(calcText);
        calcPanel.add(calcB1);
        calcPanel.add(calcB2);
        calcPanel.add(calcB3);
        calcPanel.add(calcB4);
        calcPanel.add(calcB5);
        calcPanel.add(calcB6);
        calcPanel.add(calcB7);
        calcPanel.add(calcB8);
        calcPanel.add(calcB9);
        calcB1.addActionListener(this);
        calcB2.addActionListener(this);
        calcB3.addActionListener(this);
        calcB4.addActionListener(this);
        calcB5.addActionListener(this);
        calcB6.addActionListener(this);
        calcB7.addActionListener(this);
        calcB8.addActionListener(this);
        calcB9.addActionListener(this);


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
        else if (!e.getActionCommand().equals("Ok"))
            calcText.setText((calcText.getText() + e.getActionCommand()));

    }

}
