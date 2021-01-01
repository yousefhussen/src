/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.ImageIO;

/**
 *
 * @author 20101
 */
public class CustomerMenu extends JFrame implements ActionListener {
    Customer speed;
    JToggleButton ViewB = new JToggleButton("View");
    JToggleButton AddB = new JToggleButton("Add");
    JToggleButton DeleteB = new JToggleButton("Delete");
   
    JToggleButton BookingB = new JToggleButton("Booking");
  
    JToggleButton EditB = new JToggleButton("Edit");
    JToggleButton Test = new JToggleButton("Yest");
    JComboBox ID = new JComboBox();
   
    JButton deletejoe = new JButton("Cancel");
    Container c = getContentPane();
    private BufferedImage image;

    public CustomerMenu(Customer speed2) throws HeadlessException {

        c.setLayout(null);
        speed=speed2;
        setSize(700, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Menu ");
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
      
        BookingB.setBounds(120, 0, 565, 40);
      
        BookingB.addActionListener(this);
        
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(ViewB) || e.getSource().equals(AddB) || e.getSource().equals(DeleteB) || e.getSource().equals(EditB)) {

            //default drawings
            defaultDrawings();
            //
        } else if (e.getSource().equals(BookingB)) {
            defaultDrawings();
            BookingIntialize();
     


        }

        if (e.getSource().equals(ID)) {
            defaultDrawings();
            BookingDrawings();

        
        }

        if (e.getSource().equals(deletejoe)) {
            if (BookingB.isSelected()) {
                Booking.deleteBooking((int)ID.getSelectedItem());
                defaultDrawings();
                BookingIntialize();
                
                
            }
        }

    }

    public void defaultDrawings() {

        c.removeAll();
        c.add(ViewB);
        c.add(AddB);
        c.add(DeleteB);
        c.add(EditB);
        c.add(BookingB);
       
        c.revalidate();
        c.repaint();

    }

    public void BookingIntialize() {
        ID = new JComboBox();
        

        if (ViewB.isSelected()) {

            for (int i = 0; i < Booking.getBooking_List().size(); i++) {
                if(speed==Booking.getBooking_List().get(i).getObjCustomer())
                {
                 ID.addItem(Booking.getBooking_List().get(i).getBooking_id());
                }
            }

            ID.setBounds(160, 50, 100, 20);
            ID.addActionListener(this);
            c.add(ID);

        } else if (DeleteB.isSelected()) {

            for (int i = 0; i < Booking.getBooking_List().size(); i++) {

                ID.addItem(Booking.getBooking_List().get(i).getBooking_id());
            }

            ID.setBounds(160, 50, 100, 20);
            ID.addActionListener(this);
            deletejoe.setBounds(200, 250, 100, 20);
            deletejoe.addActionListener(this);
            c.add(deletejoe);
            c.add(ID);

        }
    }

   

   

    public void BookingDrawings() {
        ID.setBounds(160, 50, 100, 20);
        ID.addActionListener(this);
        c.add(ID);
        Integer elid = (Integer) ID.getSelectedItem();
        JLabel BName1 = new JLabel(Booking.getBooking_List().get(elid).getBooking_End());
        JLabel BName2 = new JLabel("Booking End Date : ");

        JLabel BName11 = new JLabel(Booking.getBooking_List().get(elid).getBooking_Start());
        JLabel BName22 = new JLabel("Booking Start Date : ");

        JLabel BName111 = new JLabel(Booking.getBooking_List().get(elid).getObjCar().getMake());
        JLabel BName222 = new JLabel("Booking Car Brand : ");

        JLabel BName1111 = new JLabel(Booking.getBooking_List().get(elid).getObjCar().getModel());
        JLabel BName2222 = new JLabel("Booking Car Model : ");

        Integer price = Booking.getBooking_List().get(elid).getObjCar().getPrice();
        JLabel BName11111 = new JLabel(price.toString());
        JLabel BName22222 = new JLabel("Booking Car Price : ");

        BName1.setBounds(300, 100, 100, 20);
        BName2.setBounds(180, 100, 120, 20);

        BName11.setBounds(300, 120, 100, 20);
        BName22.setBounds(180, 120, 120, 20);

        BName111.setBounds(300, 140, 100, 20);
        BName222.setBounds(180, 140, 120, 20);

        BName1111.setBounds(300, 160, 100, 20);
        BName2222.setBounds(180, 160, 120, 20);

        BName11111.setBounds(300, 180, 100, 20);
        BName22222.setBounds(180, 180, 120, 20);

        c.add(BName11);
        c.add(BName22);
        c.add(BName1);
        c.add(BName2);
        c.add(BName111);
        c.add(BName222);
        c.add(BName1111);
        c.add(BName2222);
        c.add(BName11111);
        c.add(BName22222);
        if (DeleteB.isSelected()) {
            deletejoe.setBounds(200, 250, 100, 20);
            deletejoe.addActionListener(this);
            c.add(deletejoe);
        }

    }

    

    
//     public void paintComponent(Graphics J) throws IOException
//     {
//         super.paintComponents(J);
//         image = ImageIO.read(new File("C:\\Users\\20101\\Downloads/sora.jpg")); 
//         J.drawImage(image, 0, 0, null);
//         
//     }
}