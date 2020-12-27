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
     JToggleButton CarB = new JToggleButton("Car");
    JToggleButton BookingB = new JToggleButton("Booking");
    JToggleButton CustomerB = new JToggleButton("Customer");
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
        if (e.getSource().equals(ViewB)||e.getSource().equals(AddB)||e.getSource().equals(DeleteB)||e.getSource().equals(EditB) ) {
            
            //default drawings
            defaultDrawings();
            //
        }
        else if (e.getSource().equals(BookingB))
        {
             System.out.println("edit or delete or add or view");
            Bookingdrwaings();
        }
        else if(e.getSource().equals(CarB))
        {
            
        }
        else if(e.getSource().equals(CustomerB))
        {
            
        }


    }
    
    public void defaultDrawings ()
    {
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
            ButtonGroup group2 = new ButtonGroup();
            group2.add(BookingB);
            group2.add(CarB);
            group2.add(CustomerB);
            BookingB.setBounds(120, 0, 190, 40);
            CarB.setBounds(120+190, 0, 190, 40);
            CustomerB.setBounds(120+380, 0, 190, 40);
            BookingB.addActionListener(this);
            CarB.addActionListener(this);
            CustomerB.addActionListener(this);
            c.add(BookingB);
            c.add(CarB);
            c.add(CustomerB);
            
    }
    
    public void Bookingdrwaings()
    {
        if(ViewB.isSelected())
        {
             System.out.println("edit or delete or add or view");
            Integer[] ids=new Integer [Booking.getBooking_List().size()];
            for(int i = 0; i<Booking.getBooking_List().size();i++)
            {
                ids[i]=Booking.getBooking_List().get(i).getBooking_id();
                 System.out.println(ids[i]);
            }
            JComboBox ID = new JComboBox(ids);
            ID.setBounds(160, 50, 100, 20);
            c.add(ID);
            
        }
    }

}
