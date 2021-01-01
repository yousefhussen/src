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

//    private JTextField tf2;
    private JButton b1, b2, b3, b4, b5;

    public StartUpMenu(String adminName, String Password) {

        this.adminName = adminName;
        this.Password = Password;
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

    public void LogIn() {

        Scanner input = new Scanner(System.in);

        System.out.println("Customer Or Admin ? (c/a)");
        String cora = input.next();
        if (cora.equalsIgnoreCase("c")) {
            UserLogin();

        } else if (cora.equalsIgnoreCase("a")) {

            System.out.println("Enter the Admin name, please");
            String x = input.next();
            if (x.equals(adminName)) {
                System.out.println("Enter the password, please");
                String z = input.next();
                if (z.equals(Password)) {
                    System.out.println("edit or delete or add or view");
                    z = input.next();
                    if (z.equals("edit")) {
                        String repeat = "yes";
                        while (repeat.equalsIgnoreCase("yes")) {
                            Booking.viewBookingList();
                            System.out.println("Change Cars/Customers/Bookings");
                            String xx = input.next();

                            if (xx.equalsIgnoreCase("Car")) {

                                Car.viewCarlist();
                                System.out.println("===========================================");
                                //   System.out.println("The list of Cars is from 0 to " + (Car.getNumOfObjects() - 1));
                                System.out.println("Write down the id of the car that you would like to change");
                                int h = input.nextInt();

                                Car.editCar(h);
                                Car.viewCarlist();

                            } else if (xx.equalsIgnoreCase("booking")) {
                                System.out.println("===========================================");
                                System.out.println("The list of bookings is from 0 to " + (Booking.getNumOfBooking() - 1));
                                System.out.println("Write down the id of the booking that you would like to change");
                                int h = input.nextInt();
                                Booking.editBookingList(h);
                            } else if (xx.equalsIgnoreCase("Customer")) {
                                Customer.viewMemberList();
                                System.out.println("===========================================");
                                System.out.println("The list of Customers is from 0 to " + (Customer.getNumOfObjects() - 1));
                                System.out.println("Write down the id of the customer that you would like to change");
                                int h = input.nextInt();
                                Customer.editCustomer(h);
                            }

                            System.out.println("would you like to change anything else? (yes/no)");
                            repeat = input.next();
                        }

                    } else if (z.equalsIgnoreCase("add")) {
                        System.out.println("add booking/car/customer");
                        String xx = input.next();
                        if (xx.equalsIgnoreCase("booking")) {
                            System.out.println("Enter the start date of rent contract");

                            String booking_Start = input.next();
                            System.out.println("Enter the end date of rent contract");
                            String booking_End = input.next();
                            Car.viewCarlist();
                            System.out.println("Enter the id of the wanted car");
                            Car willbeaddedCar = Car.getCarList().get(input.nextInt());
                            Customer.viewMemberList();
                            System.out.println("Enter the id of the Customer");
                            Customer willbeaddedCustomer = Customer.getCustomer_list().get(input.nextInt());
                            Booking bb = new Booking(booking_Start, booking_End, willbeaddedCar, willbeaddedCustomer);
                            Booking.addBooking(bb);

                        } else if (xx.equalsIgnoreCase("car")) {
                            System.out.println("Enter the Model of the car");
                            String model = input.next();
                            System.out.println("enter the make of the car");
                            String make = input.next();
                            System.out.println("enter the price of the car");
                            int price = input.nextInt();
                            Car bb = new Car(model, make, price);
                            Car.addCar(bb);
                        } else if (xx.equalsIgnoreCase("Customer")) {
                            System.out.println("Enter the name of the customer");
                            String name = input.next();
                            System.out.println("enter the password of the customer");
                            int password = input.nextInt();
                            System.out.println("enter the age of the Customer");
                            int age = input.nextInt();
                            Customer bb = new Customer(name, age, password);
                            Customer.addcustomer(bb);
                        }
                    } else if (z.equalsIgnoreCase("delete")) {
                        System.out.println("delete booking/car/customer");
                        String xx = input.next();
                        if (xx.equalsIgnoreCase("booking")) {
                            System.out.println("enter the id of the booking you want to delete");
                            int xy = input.nextInt();
                            Booking.getBooking_List().remove(xy);

                        } else if (xx.equalsIgnoreCase("car")) {
                            System.out.println("enter the id of the Car you want to delete");
                            int xy = input.nextInt();
                            System.out.println("Deleting.....");
                            Car.getCarList().remove(xy);
                            System.out.println("Deleted succefully");

                        } else if (xx.equalsIgnoreCase("Customer")) {
                            System.out.println("enter the id of the Customer you want to delete");
                            int xy = input.nextInt();
                            Customer.getCustomer_list().remove(xy);
                            System.out.println("Deleted succefully");

                        }
                    } else if (z.equalsIgnoreCase("view")) {
                        System.out.println("view list of ... booking/car/customer");
                        String xx = input.next();
                        if (xx.equalsIgnoreCase("booking")) {

                            Booking.viewBookingList();

                        } else if (xx.equalsIgnoreCase("car")) {
                            Car.viewCarlist();

                        } else if (xx.equalsIgnoreCase("Customer")) {
                            Customer.viewMemberList();

                        }
                    }
                } else {
                    System.out.println("Password is incorrrect, please try again");
                    LogIn();
                }
            } else {
                System.out.println("Username is incorrect, Please try again");
                LogIn();
            }

        }

    }

    private void UserLogin() {
        System.out.println("edit or delete or add");
        Scanner input = new Scanner(System.in);
        String eda = input.next();
        if (eda.equalsIgnoreCase("edit")) {
            System.out.println("===========================================");
            System.out.println("Write down the id of the booking that you would like to change");
            int h = input.nextInt();
            System.out.println("Checking if you are the user for Booking with id:  " + h);
            System.out.println("Enter the user name, please");
            String x = input.next();
            if (x.equals(Booking.getBooking_List().get(h).getObjCustomer().getName())) {
                System.out.println("Enter you password , please ");
                int z = input.nextInt();
                if (z == Booking.getBooking_List().get(h).getObjCustomer().getpassword()) {
                    Booking.editBookingListUser(h);
                } else {
                    System.out.println("Password is incorrrect, please try again");
                    UserLogin();
                }
            } else {
                System.out.println("Username is incorrect, Please try again");
                UserLogin();
            }
        } else if (eda.equalsIgnoreCase("add")) {
            System.out.println("is It your First time Here? (yes/no)");
            if (input.next().equalsIgnoreCase("yes")) {
                System.out.println("Enter the name of the customer");
                String name = input.next();
                System.out.println("enter the password of the customer");
                int password = input.nextInt();
                System.out.println("enter the age of the customer");
                int age = input.nextInt();
                Customer bb = new Customer(name, age, password);
                Customer.addcustomer(bb);
                System.out.println("Your Id Is " + bb.getCustomer_ID() + " PLease remember it");

            }

            System.out.println("Enter the start date of rent contract");
            String booking_Start = input.next();
            System.out.println("Enter the end date of rent contract");
            String booking_End = input.next();
            Car.viewCarlist();
            System.out.println("Enter the id of the wanted car");
            Car willbeaddedCar = Car.getCarList().get(input.nextInt());

            System.out.println("Enter your id ");
            Customer willbeaddedCustomer = Customer.getCustomer_list().get(input.nextInt());
            System.out.println("Enter Your Password , " + willbeaddedCustomer.getName());
            if (input.nextInt() == (willbeaddedCustomer.getpassword())) {
                System.out.println("Logged In Succesfully");
                Booking bb = new Booking(booking_Start, booking_End, willbeaddedCar, willbeaddedCustomer);
                Booking.addBooking(bb);
            } else {
                System.out.println("Password incorrect Exiting...");
            }

        } else if (eda.equalsIgnoreCase("delete")) {
            System.out.println("===========================================");
            System.out.println("Write down the id of the booking that you would like to delete");
            int h = input.nextInt();
            System.out.println("Checking if you are the user for Booking with id:  " + h);
            System.out.println("Enter the user name, please");
            String x = input.next();
            if (x.equals(Booking.getBooking_List().get(h).getObjCustomer().getName())) {
                System.out.println("Enter you password , please ");
                int z = input.nextInt();
                if (z == Booking.getBooking_List().get(h).getObjCustomer().getpassword()) {
                    System.out.println("Deleting.....");
                    Booking.getBooking_List().remove(h);
                    System.out.println("Deleted succefully");
                } else {
                    System.out.println("Password is incorrrect, please try again");
                    UserLogin();
                }
            } else {
                System.out.println("Username is incorrect, Please try again");
                UserLogin();
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(b1)) {

            getContentPane().removeAll();
            getContentPane().repaint();

            Container b = getContentPane();
            b.setLayout(null);
            setTitle("Log In Admin");
            b3 = new JButton("Sign In");

            NA = new JLabel("username: ");
            PA = new JLabel("password: ");
            PassAdmin = new JPasswordField();
            NameAdmin = new JTextField();
            NA.setBounds(200, 50, 100, 100);
            PA.setBounds(200, 100, 100, 100);
            NameAdmin.setBounds(280, 90, 90, 25);
            PassAdmin.setBounds(280, 140, 90, 25);
            b3.setBounds(225, 200, 100, 40);
            b3.addActionListener(this);

            b.add(NA);
            b.add(NameAdmin);
            b.add(PA);
            b.add(PassAdmin);
            b.add(b3);

        } else if (e.getSource().equals(b2)) {

            getContentPane().removeAll();
            getContentPane().repaint();
            Container b = getContentPane();
            b.setLayout(null);
            setTitle("Log In Customer");
            b3 = new JButton("Sign In");
            b4 = new JButton("Sign Up");
            NA = new JLabel("username: ");
            PA = new JLabel("password: ");
            PassAdmin = new JPasswordField();
            NameAdmin = new JTextField();
            b4.setBounds(225, 250, 100, 40);
            b4.addActionListener(this);
            NA.setBounds(200, 50, 100, 100);
            PA.setBounds(200, 100, 100, 100);
            NameAdmin.setBounds(280, 90, 90, 25);
            PassAdmin.setBounds(280, 140, 90, 25);
            b3.setBounds(225, 200, 100, 40);
            b3.addActionListener(this);
            b.add(NA);
            b.add(NameAdmin);
            b.add(PA);
            b.add(PassAdmin);
            b.add(b3);
            b.add(b4);

        } else if (e.getSource().equals(b3)) {
            if (NameAdmin.getText().equals(adminName) && PassAdmin.getText().equals(Password)) {

                getContentPane().removeAll();
                getContentPane().repaint();

                Container bb = getContentPane();
                bb.setLayout(null);
                dispose();
                AdminMenu Admin = new AdminMenu();

            } else {

                JOptionPane.showMessageDialog(null, "Username or Password is Incorrect ", "Incorrect Parameters", JOptionPane.PLAIN_MESSAGE);

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
                JOptionPane.showMessageDialog(null, "Signed successfully,your ID is  "+ newCustomer.getCustomer_ID(), "Incorrect Parameters", JOptionPane.PLAIN_MESSAGE);
                dispose();
                CustomerMenu c3=new CustomerMenu(newCustomer);
                
                

            }

        }

    }
}
