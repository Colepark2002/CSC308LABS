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
 * @version 9/23/2022
 */
public class Main extends JFrame implements ActionListener {

    public static void main(String[] args) {
        Main win = new Main();
        win.setSize(500,500);
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * constructor
     * assembles the window used for our GUI
     */
    public Main()
    {
        super("Lab2");

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

        tabs.add(l1,"Page 1");
        tabs.add(l2, "Page 2");
        tabs.add(l3, "Page 3");
        tabs.add(l4, "Page 4");
        add(tabs);

        mb.setVisible(true);
        m1.setVisible(true);
        m2.setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Open"))
            JOptionPane.showMessageDialog(this, "You clicked open!");
        if (e.getActionCommand().equals("Save"))
            JOptionPane.showMessageDialog(this, "You clicked Save!");
        if (e.getActionCommand().equals("Quit"))
            JOptionPane.showMessageDialog(this, "You clicked Quit!");
    }
}
