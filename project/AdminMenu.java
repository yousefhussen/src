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
public class AdminMenu extends JFrame implements ActionListener {

    JToggleButton ViewB = new JToggleButton("View");
    JToggleButton AddB = new JToggleButton("Add");
    JToggleButton DeleteB = new JToggleButton("Delete");
    JToggleButton CarB = new JToggleButton("Car");
    JToggleButton BookingB = new JToggleButton("Booking");
    JToggleButton CustomerB = new JToggleButton("Customer");
    JToggleButton EditB = new JToggleButton("Edit");
    JToggleButton Test = new JToggleButton("Yest");
    JComboBox ID = new JComboBox();
    JComboBox ID1 = new JComboBox();
    JComboBox ID2 = new JComboBox();
    JButton deletejoe = new JButton("Delete");
    Container c = getContentPane();
    private BufferedImage image;

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
        ButtonGroup group2 = new ButtonGroup();
        group2.add(BookingB);
        group2.add(CarB);
        group2.add(CustomerB);
        BookingB.setBounds(120, 0, 190, 40);
        CarB.setBounds(120 + 190, 0, 190, 40);
        CustomerB.setBounds(120 + 380, 0, 190, 40);
        BookingB.addActionListener(this);
        CarB.addActionListener(this);
        CustomerB.addActionListener(this);
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
        } else if (e.getSource().equals(CarB)) {
            defaultDrawings();
            CarIntialize();

        } else if (e.getSource().equals(CustomerB)) {
            defaultDrawings();
            CustomerIntialize();

        }

        if (e.getSource().equals(ID)) {
            defaultDrawings();
            BookingDrawings();

        } else if (e.getSource().equals(ID1)) {
            defaultDrawings();
            CarDrawings();

        } else if (e.getSource().equals(ID2)) {
            defaultDrawings();
            CustomerDrawings();

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
        c.add(CarB);
        c.add(CustomerB);
        c.revalidate();
        c.repaint();

    }

    public void BookingIntialize() {
        ID = new JComboBox();

        if (ViewB.isSelected()) {

            for (int i = 0; i < Booking.getBooking_List().size(); i++) {

                ID.addItem(Booking.getBooking_List().get(i).getBooking_id());
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

    public void CarIntialize() {
        ID1 = new JComboBox();

        if (ViewB.isSelected()) {

            for (int i = 0; i < Car.getCarList().size(); i++) {

                ID1.addItem(Car.getCarList().get(i).getID());
            }

            ID1.setBounds(160, 50, 100, 20);
            ID1.addActionListener(this);
            c.add(ID1);

        }
    }

    public void CustomerIntialize() {
        ID2 = new JComboBox();

        if (ViewB.isSelected()) {

            for (int i = 0; i < Car.getCarList().size(); i++) {

                ID2.addItem(Customer.getCustomer_list().get(i).getCustomer_ID());
            }

            ID2.setBounds(160, 50, 100, 20);
            ID2.addActionListener(this);
            c.add(ID2);

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

    public void CarDrawings() {
        ID1.setBounds(160, 50, 100, 20);
        ID1.addActionListener(this);
        c.add(ID1);
        Integer elid = (Integer) ID1.getSelectedItem();

        JLabel BName111 = new JLabel(Car.getCarList().get(elid).getMake());
        JLabel BName222 = new JLabel(" Car Brand : ");

        JLabel BName1111 = new JLabel(Car.getCarList().get(elid).getModel());
        JLabel BName2222 = new JLabel(" Car Model : ");

        Integer price = Car.getCarList().get(elid).getPrice();
        JLabel BName11111 = new JLabel(price.toString());
        JLabel BName22222 = new JLabel(" Car Price : ");

        BName111.setBounds(300, 140, 100, 20);
        BName222.setBounds(180, 140, 120, 20);

        BName1111.setBounds(300, 160, 100, 20);
        BName2222.setBounds(180, 160, 120, 20);

        BName11111.setBounds(300, 180, 100, 20);
        BName22222.setBounds(180, 180, 120, 20);

        c.add(BName111);
        c.add(BName222);
        c.add(BName1111);
        c.add(BName2222);
        c.add(BName11111);
        c.add(BName22222);

    }

    private void CustomerDrawings() {
        ID2.setBounds(160, 50, 100, 20);
        ID2.addActionListener(this);
        c.add(ID2);
        Integer elid = (Integer) ID2.getSelectedItem();

        JLabel BName111 = new JLabel(Customer.getCustomer_list().get(elid).getName());
        JLabel BName222 = new JLabel(" Customer Name : ");

        Integer Age = Customer.getCustomer_list().get(elid).getAge();
        JLabel BName1111 = new JLabel(Age.toString());
        JLabel BName2222 = new JLabel(" Customer Age : ");

        BName111.setBounds(300, 140, 100, 20);
        BName222.setBounds(180, 140, 120, 20);

        BName1111.setBounds(300, 160, 100, 20);
        BName2222.setBounds(180, 160, 120, 20);

        c.add(BName111);
        c.add(BName222);
        c.add(BName1111);
        c.add(BName2222);

    }

//     public void paintComponent(Graphics J) throws IOException
//     {
//         super.paintComponents(J);
//         image = ImageIO.read(new File("C:\\Users\\20101\\Downloads/sora.jpg")); 
//         J.drawImage(image, 0, 0, null);
//         
//     }
}
