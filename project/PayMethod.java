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
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

public class PayMethod extends JFrame implements ActionListener {

    JButton Cash = new JButton("Cash");
    JButton Credit = new JButton("Credit");
    JButton floos = new JButton("Confirm");

    Booking objBooking;
    Container c = getContentPane();

    public PayMethod(Booking tmpbook) throws HeadlessException {
        this.objBooking = tmpbook;
        c.setLayout(null);
        setSize(600, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

            BName1.setBounds(300 - 100, 100 - 100, 100, 20);
            BName2.setBounds(180 - 100, 100 - 100, 120, 20);

            BName11.setBounds(300 - 100, 120 - 100, 100, 20);
            BName22.setBounds(180 - 100, 120 - 100, 120, 20);

            BName111.setBounds(300 - 100, 140 - 100, 100, 20);
            BName222.setBounds(180 - 100, 140 - 100, 120, 20);

            BName1111.setBounds(300 - 100, 160 - 100, 100, 20);
            BName2222.setBounds(180 - 100, 160 - 100, 120, 20);

            BName11111.setBounds(300 - 100, 180 - 100, 100, 20);
            BName22222.setBounds(180 - 100, 180 - 100, 120, 20);

            BNameS.setBounds(300 - 100, 200 - 100, 100, 20);
            BNameS.setFont(new Font("Serif", Font.PLAIN, 25));
            BNameS.setForeground(Color.red);
            BNameSS.setBounds(180 - 100, 200 - 100, 120, 20);

            JLabel Message = new JLabel("Please go to the nearest branch , Use your ID : " + BNameS.getText() + " To pay");
            Message.setBounds(180 - 100, 250 - 100, 350, 20);

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

        } else if (e.getSource().equals(Credit)) {
            c.removeAll();
            c.revalidate();
            c.repaint();
            c.setLayout(null);
            setSize(550, 250);
            setLocationRelativeTo(null);

            JLabel BName2 = new JLabel("Card Number : ");

            JLabel BName22 = new JLabel("Card Name : ");

            JLabel BName222 = new JLabel("Expiry Month : ");

            JLabel BName2222 = new JLabel("Expiry Year: ");

            JTextField EorAParameter1 = new JTextField();
            JTextField EorAParameter2 = new JTextField();
            JTextField EorAParameter3 = new JTextField();
            JTextField EorAParameter4 = new JTextField();

           

            MaskFormatter mask = null;
            try {
                mask = new MaskFormatter("#### #### #### ####");
                mask.setPlaceholderCharacter(' ');
            } catch (ParseException ee) {
                ee.printStackTrace();
            }

            JFormattedTextField field = new JFormattedTextField(mask);

            field.setBounds(300, 50, 150, 20);
            BName2.setBounds(180, 50, 120, 20);
            EorAParameter2.setBounds(300, 70, 100, 20);
            BName22.setBounds(180, 70, 120, 20);

            c.add(field);
            c.add(BName2);
            c.add(EorAParameter2);
            c.add(BName22);

        }
    }

}
