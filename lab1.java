package com.company;
import javax.swing.*;
import java.awt.*;


/**
 * Creates a window with a specified menubar and sub menubar with specified menu items split into quarters each labeled
 * with our names and colored using label backgrounds.
 *
 * Authors: Cole Park, Van  Park, Jacob Shapero, Lauren Allen.
 *
 */

public class Main extends JFrame{


    public static void main(String[] args) {
        Main win = new Main();
        win.setSize(500,500);
        win.setVisible(true);
    }

    public Main()
    {
        // creates JFrame
        super("Lab1");

        //creates menu bar
        JMenuBar mb = new JMenuBar();

        // creates menus
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("About");

        // creates menu items
        JMenuItem item1 = new JMenuItem("Load a Roster");
        JMenuItem item2 = new JMenuItem("Add Attendance");
        JMenuItem item3 = new JMenuItem("Save");
        JMenuItem item4 = new JMenuItem("Plot Data");

        // adds menu items to menu
        m1.add(item1);
        m1.add(item2);
        m1.add(item3);
        m1.add(item4);

        // adds menus to the menubar
        mb.add(m1);
        mb.add(m2);
        setJMenuBar(mb);

        // creates and adds grid layout and creates and adds labels
        GridLayout g = new GridLayout(2,2);
        setLayout(g);
        JLabel l1 = new JLabel("Cole Park");
        JLabel l2 = new JLabel("Lauren Allen");
        JLabel l3 = new JLabel("Van Park");
        JLabel l4 = new JLabel("Jacob Shapero");
        l1.setBackground(Color.PINK);
        l2.setBackground(Color.GREEN);
        l3.setBackground(Color.CYAN);
        l4.setBackground(Color.BLACK);
        l4.setForeground(Color.WHITE);
        l1.setOpaque(true);
        l2.setOpaque(true);
        l3.setOpaque(true);
        l4.setOpaque(true);
        add(l1);
        add(l2);
        add(l3);
        add(l4);

        // sets menubar and menus to visible
        mb.setVisible(true);
        m1.setVisible(true);
        m2.setVisible(true);
    }
}
