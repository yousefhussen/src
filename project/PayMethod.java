/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class PayMethod extends JFrame implements ActionListener {

    JButton Cash = new JButton("Cash");
    JButton Credit = new JButton("Credit");
    JButton floos = new JButton("Confirm");
    JButton pay = new JButton("Pay");
    JFormattedTextField field = new JFormattedTextField();
    JFormattedTextField field1 = new JFormattedTextField();
    JFormattedTextField field2 = new JFormattedTextField();
    JFormattedTextField field3 = new JFormattedTextField();
    JTextField field0 = new JTextField();

    Booking objBooking;

    Container c = getContentPane();

    public PayMethod(Booking tmpbook) throws HeadlessException {
        this.objBooking = tmpbook;

        c.setLayout(null);
        setSize(600, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("PaymentMethod");
        JLabel WhichMethod = new JLabel("Which Method will be used to pay  : ");
        WhichMethod.setBounds(175, 50, 210, 20);
        Cash.setBounds(160, 70, 110, 20);
        Credit.setBounds(270, 70, 110, 20);
        c.add(WhichMethod);
        c.add(Cash);
        c.add(Credit);
        Cash.addActionListener(this);
        Credit.addActionListener(this);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(Cash)) {

            c.removeAll();
            c.revalidate();
            c.repaint();
            c.setLayout(null);
            setSize(550, 250);
            setLocationRelativeTo(null);

            JLabel BName1 = new JLabel(objBooking.getBooking_End());
            JLabel BName2 = new JLabel("Booking End Date : ");

            JLabel BName11 = new JLabel(objBooking.getBooking_Start());
            JLabel BName22 = new JLabel("Booking Start Date : ");

            JLabel BName111 = new JLabel(objBooking.getObjCar().getMake());
            JLabel BName222 = new JLabel("Booking Car Brand : ");

            JLabel BName1111 = new JLabel(objBooking.getObjCar().getModel());
            JLabel BName2222 = new JLabel("Booking Car Model : ");

            Integer price = objBooking.getObjCar().getPrice();
            JLabel BName11111 = new JLabel(price.toString());
            JLabel BName22222 = new JLabel("Booking Car Price : ");

            Integer temp = objBooking.getBooking_id();
            JLabel BNameS = new JLabel(temp.toString());
            JLabel BNameSS = new JLabel("Booking ID : ");

            BName1.setBounds(200, 0, 100, 20);
            BName2.setBounds(80, 0, 120, 20);

            BName11.setBounds(200, 20, 100, 20);
            BName22.setBounds(80, 20, 120, 20);

            BName111.setBounds(200, 40, 100, 20);
            BName222.setBounds(80, 40, 120, 20);

            BName1111.setBounds(200, 60, 100, 20);
            BName2222.setBounds(80, 60, 120, 20);

            BName11111.setBounds(200, 80, 100, 20);
            BName22222.setBounds(80, 80, 120, 20);

            BNameS.setBounds(200, 100, 100, 20);
            BNameS.setFont(new Font("Serif", Font.PLAIN, 25));
            BNameS.setForeground(Color.red);
            BNameSS.setBounds(80, 100, 120, 20);

            JLabel Message = new JLabel("Please go to the nearest branch , Use your ID : " + BNameS.getText() + " To pay");
            Message.setBounds(80, 150, 350, 20);

            c.add(Message);

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
            c.add(BNameS);
            c.add(BNameSS);
            Booking.addBooking(objBooking);
            JOptionPane.showMessageDialog(null, "Added Successfully", "Success", JOptionPane.PLAIN_MESSAGE);

        } else if (e.getSource().equals(Credit)) {
            c.removeAll();
            c.revalidate();
            c.repaint();
            c.setLayout(null);
            setSize(600, 250);
            setLocationRelativeTo(null);

            JLabel BName2 = new JLabel("Card Number : ");

            JLabel BName22 = new JLabel("Card Name     : ");

            JLabel BName222 = new JLabel("Expiry Month  : ");

            JLabel BName2222 = new JLabel("Expiry Year: ");
            JLabel BName22222 = new JLabel("cvc/cvv: ");

            MaskFormatter mask = null;
            try {
                mask = new MaskFormatter("#### #### #### ####");
                mask.setPlaceholderCharacter(' ');
            } catch (ParseException ee) {
                ee.printStackTrace();
            }
            field = new JFormattedTextField(mask);

            MaskFormatter mask1 = null;
            try {
                mask1 = new MaskFormatter("##");
                mask1.setPlaceholderCharacter(' ');
            } catch (ParseException ee) {
                ee.printStackTrace();
            }
            field1 = new JFormattedTextField(mask1);

            field2 = new JFormattedTextField(mask1);
            MaskFormatter mask2 = null;
            try {
                mask2 = new MaskFormatter("###");
                mask2.setPlaceholderCharacter(' ');
            } catch (ParseException ee) {
                ee.printStackTrace();
            }
            field3 = new JFormattedTextField(mask2);

            field.setBounds(300, 50, 150, 20);
            BName2.setBounds(180, 50, 120, 20);
            field0.setBounds(300, 70, 100, 20);
            BName22.setBounds(180, 70, 120, 20);
            field1.setBounds(300, 90, 30, 20);
            BName222.setBounds(180, 90, 150, 20);
            field2.setBounds(410, 90, 30, 20);
            BName2222.setBounds(332, 90, 150, 20);
            field3.setBounds(510, 90, 30, 20);
            BName22222.setBounds(450, 90, 150, 20);
            pay.setBounds(300, 130, 150, 50);

            c.add(field);
            c.add(BName2);
            c.add(field0);
            c.add(BName22);
            c.add(field1);
            c.add(BName222);
            c.add(field2);
            c.add(BName2222);
            c.add(field3);
            c.add(BName22222);
            c.add(pay);
            pay.addActionListener(this);

        } else if (e.getSource().equals(pay)) {
            if (field.getText().charAt(0) == ' ' || field.getText().charAt(field.getText().length() - 1) == ' ') {
                JOptionPane.showMessageDialog(null, "Don't Leave any field empty !", "a7a", JOptionPane.PLAIN_MESSAGE);
            } else if (field1.getText().charAt(0) == ' ' || field1.getText().charAt(field1.getText().length() - 1) == ' ') {
                JOptionPane.showMessageDialog(null, "Don't Leave any field empty !", "a7a", JOptionPane.PLAIN_MESSAGE);
            } else if (field2.getText().charAt(0) == ' ' || field2.getText().charAt(field2.getText().length() - 1) == ' ') {
                JOptionPane.showMessageDialog(null, "Don't Leave any field empty !", "a7a", JOptionPane.PLAIN_MESSAGE);
            } else if (field3.getText().charAt(0) == ' ' || field3.getText().charAt(field3.getText().length() - 1) == ' ') {
                JOptionPane.showMessageDialog(null, "Don't Leave any field empty !", "a7a", JOptionPane.PLAIN_MESSAGE);
            } else {
                Booking.addBooking(objBooking);
                JOptionPane.showMessageDialog(null, "Success !", "gad3", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "Added Successfully", "Success", JOptionPane.PLAIN_MESSAGE);
                dispose();

            }
        }
    }

}
