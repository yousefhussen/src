/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author 20101
 */
public class AdminMenu extends JFrame implements ActionListener {

    JToggleButton ViewB = new JToggleButton("View");
    JToggleButton AddB = new JToggleButton("Add");
    JToggleButton DeleteB = new JToggleButton("Delete");
    JToggleButton EditB = new JToggleButton("Edit");
    JToggleButton Test = new JToggleButton("Yest");
    Container c = getContentPane();

    public AdminMenu() throws HeadlessException {

        c.setLayout(null);

        setSize(700, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Menu - Admin");
        ButtonGroup group = new ButtonGroup();

        ViewB.setBounds(0, 0, 120, 80);
        AddB.setBounds(0, 80, 120, 80);
        DeleteB.setBounds(0, 160, 120, 80);
        EditB.setBounds(0, 240, 120, 80);
        group.add(ViewB);
        group.add(AddB);
        group.add(DeleteB);
        group.add(EditB);
        ViewB.addActionListener(this);
        AddB.addActionListener(this);
        DeleteB.addActionListener(this);
        EditB.addActionListener(this);
        c.add(ViewB);
        c.add(AddB);
        c.add(DeleteB);
        c.add(EditB);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(ViewB)) {
            
            //default drawings
            c.removeAll();
            c.repaint();
            ButtonGroup group = new ButtonGroup();
            ViewB.setBounds(0, 0, 120, 80);
            AddB.setBounds(0, 80, 120, 80);
            DeleteB.setBounds(0, 160, 120, 80);
            EditB.setBounds(0, 240, 120, 80);
            group.add(ViewB);
            group.add(AddB);
            group.add(DeleteB);
            group.add(EditB);
            ViewB.addActionListener(this);
            AddB.addActionListener(this);
            DeleteB.addActionListener(this);
            EditB.addActionListener(this);
            c.add(ViewB);
            c.add(AddB);
            c.add(DeleteB);
            c.add(EditB);
            //
            
            

        }

    }

}
