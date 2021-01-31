package project;

import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import static java.lang.Integer.parseInt;
import javax.swing.*;

public class StartUpMenu extends JFrame implements ActionListener {

    private String adminName;
    private String Password;
    private JLabel user;
    private JLabel admin;
    private JLabel CustmoerOrAdmin;
    private JTextField tf1;
    private JLabel NA;
    private JTextField NameAdmin, DG;
    private JLabel PA, AG;
    private JPasswordField PassAdmin;
    private JLabel IDLogin;  
    private JTextField IDLoginEnter ;
    private ReadAndWrite file;
     

//    private JTextField tf2;
    private JButton b1, b2, b3, b4, b5 , b6;

    public StartUpMenu(String adminName, String Password ,ReadAndWrite file) {

        this.adminName = adminName;
        this.Password = Password;
         this.file =file;
        Container c = getContentPane();
        c.setLayout(null);

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Car Rental");
//        setLayout(new FlowLayout(FlowLayout.CENTER , 100 , 250));
        b1 = new JButton("Admin");
        b2 = new JButton("Customer");

        b1.setBounds(170, 260 / 2, 100, 40);
        b2.setBounds(290, 260 / 2, 100, 40);
        CustmoerOrAdmin = new JLabel("Are you a user or a Admin");
        CustmoerOrAdmin.setBounds(200, 115, 150, 15);

        c.add(CustmoerOrAdmin);

        c.add(b1);
        c.add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setVisible(true);

    }

    StartUpMenu() {

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(b1)) {

            getContentPane().removeAll();
            getContentPane().repaint();

            Container b = getContentPane();
            b.setLayout(null);
            setTitle("Log In Admin");
            b6 = new JButton("Sign In");

            NA = new JLabel("username: ");
            PA = new JLabel("password: ");
            PassAdmin = new JPasswordField();
            NameAdmin = new JTextField();
            NA.setBounds(200, 50, 100, 100);
            PA.setBounds(200, 100, 100, 100);
            NameAdmin.setBounds(280, 90, 90, 25);
            PassAdmin.setBounds(280, 140, 90, 25);
            b6.setBounds(225, 200, 100, 40);
            b6.addActionListener(this);

            b.add(NA);
            b.add(NameAdmin);
            b.add(PA);
            b.add(PassAdmin);
            b.add(b6);

        } else if (e.getSource().equals(b2)) {

            getContentPane().removeAll();
            getContentPane().repaint();
            Container b = getContentPane();
            b.setLayout(null);
            setTitle("Log In Customer");
            b3 = new JButton("Sign In");
            b4 = new JButton("Sign Up");
            JLabel IDLogin = new JLabel("ID: ");
            NA = new JLabel("Username: ");
            PA = new JLabel("Password: ");
            PassAdmin = new JPasswordField();
            NameAdmin = new JTextField();
            IDLoginEnter = new JTextField();
            b4.setBounds(225, 250, 100, 40);
            b4.addActionListener(this);
            NA.setBounds(200, 50, 100, 100);
            PA.setBounds(200, 100, 100, 100);
           
            NameAdmin.setBounds(280, 90, 90, 25);
            PassAdmin.setBounds(280, 140, 90, 25); 
            IDLogin.setBounds(200, 10, 100, 100);
            IDLoginEnter.setBounds(280, 50, 90, 25);
            b3.setBounds(225, 200, 100, 40);
            b3.addActionListener(this);
            b.add(NA);
            b.add(NameAdmin);
            b.add(PA);
            b.add(PassAdmin);
            b.add(b3);
            b.add(b4);
            b.add(IDLogin);
            b.add(IDLoginEnter);

        } else if (e.getSource().equals(b3)) {
            try
            {
                int SH= Integer.parseInt(IDLoginEnter.getText());
                
                Customer temp = Customer.getCustomer_list().get(SH); 
                if (temp.getName().equals(NameAdmin.getText())&&temp.getpassword()==(Integer.parseInt(PassAdmin.getText())))
            {
              
                  
                getContentPane().removeAll();
                getContentPane().repaint();

                Container bb = getContentPane();
                bb.setLayout(null);
                dispose();
                CustomerMenu c77=new CustomerMenu(temp ,  this.file);
               

            } else {

                JOptionPane.showMessageDialog(null, "username or password wrong ", "Incorrect Parameters", JOptionPane.PLAIN_MESSAGE);

            }
            }
            catch(Exception ee){
                    
                     JOptionPane.showMessageDialog(null, "A customer with this ID Doesn't exist ", "Incorrect Parameters", JOptionPane.PLAIN_MESSAGE);
            }
            
            
          
        } else if (e.getSource().equals(b4)) {
            getContentPane().removeAll();
            getContentPane().repaint();

            Container b = getContentPane();
            b.setLayout(null);
            setTitle("Sign Up Customer");
            NA = new JLabel("username: ");
            PA = new JLabel("password: ");
            AG = new JLabel("Age: ");
            b5 = new JButton("Create Account");
            DG = new JTextField();
            PassAdmin = new JPasswordField();
            NameAdmin = new JTextField();
            NA.setBounds(200, 50, 100, 100);
            PA.setBounds(200, 100, 100, 100);
            AG.setBounds(200, 150, 100, 100);
            DG.setBounds(280, 190, 40, 25);
            NameAdmin.setBounds(280, 90, 90, 25);
            PassAdmin.setBounds(280, 140, 90, 25);
            b3.setBounds(225, 200, 100, 40);
            b3.addActionListener(this);
            b5.setBounds(225, 250, 150, 60);
            b5.addActionListener(this);
            b.add(NA);
            b.add(NameAdmin);
            b.add(PA);
            b.add(PassAdmin);
            b.add(AG);
            b.add(DG);
            b.add(b5);

        } else if (e.getSource().equals(b5)) {
            if (DG.getText().equals("") || PassAdmin.getText().equals("") || NameAdmin.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Don't leave a field empty", "Incorrect Parameters", JOptionPane.PLAIN_MESSAGE);

            } else {
                Integer habd = parseInt(DG.getText());
                Integer habd2 = parseInt(PassAdmin.getText());
                Customer newCustomer = new Customer(NameAdmin.getText(), habd, habd2);
                Customer.addcustomer(newCustomer);
                JOptionPane.showMessageDialog(null, "Signed successfully,your ID is  " + newCustomer.getCustomer_ID(), "Incorrect Parameters", JOptionPane.PLAIN_MESSAGE);
                dispose();
                CustomerMenu c3 = new CustomerMenu(newCustomer , this.file);

            }

        }
        else if (e.getSource().equals(b6)) {
            if (PassAdmin.getText().equals(Password)&& NameAdmin.getText().equals(adminName)) {
                
               
                dispose();
                 AdminMenu s1 = new AdminMenu(this.file);

            }else{
                 JOptionPane.showMessageDialog(null, "username or password wrong ", "Incorrect Parameters", JOptionPane.PLAIN_MESSAGE);
            }

        }

    }
}
