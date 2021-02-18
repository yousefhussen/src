/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.NumberFormatter;

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
    JButton addjoe = new JButton("Add");
    JButton editjoe = new JButton("Edit");
    JTextField EorAParameter1 = new JTextField();
    JTextField EorAParameter2 = new JTextField();
    JTextField EorAParameter3 = new JTextField();
    JPasswordField EorAParameter6 = new JPasswordField();
    JComboBox EorAParameter4 = new JComboBox();
    JComboBox EorAParameter5 = new JComboBox();
    ReadAndWrite file;

    Container c = getContentPane();
    private BufferedImage image;

    public AdminMenu(ReadAndWrite ffile) throws HeadlessException {

        c.setLayout(null);

        setSize(700, 360);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Menu - Admin");
        setResizable(false);
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
        deletejoe.addActionListener(this);
        addjoe.addActionListener(this);
        editjoe.addActionListener(this);
        this.file = ffile;
       addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                handleClosing();
            }
        });

//       
        setVisible(true);

    }
    
     private void handleClosing() {

        int answer = showWarningMessage();

        switch (answer) {
            case JOptionPane.YES_OPTION:
                
                
                StartUpMenu start = new StartUpMenu("Basha", "7", file);
                 dispose();
                break;

            case JOptionPane.NO_OPTION:
                try {
                    file.Write();
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(CustomerMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                 dispose();
                break;

            case JOptionPane.CANCEL_OPTION:

                break;
        }

       

    }
    
      private int showWarningMessage() {
        String[] buttonLabels = new String[]{"Main menu", "Exit to desktop", "Cancel"};
        String defaultOption = buttonLabels[0];
        Icon icon = null;

        return JOptionPane.showOptionDialog(this,
                "Save and Exit to Desktop.\n"
                + "Or back to main menu?",
                "Warning",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE,
                icon,
                buttonLabels,
                defaultOption);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(ViewB) || e.getSource().equals(AddB) || e.getSource().equals(DeleteB) || e.getSource().equals(EditB)) {

            defaultDrawings();

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
            if (AddB.isSelected()) {
                BookingIntialize();
                CustomerDrawings();
                CarDrawings();
            } else if (EditB.isSelected() && BookingB.isSelected()) {
                BookingDrawings();
                CustomerDrawings();
                CarDrawings();
            } else if (EditB.isSelected() && CarB.isSelected()) {

                CarIntialize();
            } else {
                CarDrawings();
            }

        } else if (e.getSource().equals(ID2)) {
            defaultDrawings();
            if (AddB.isSelected()) {
                BookingIntialize();
                CarDrawings();
                CustomerDrawings();
            } else if (EditB.isSelected() && BookingB.isSelected()) {
                BookingDrawings();
                CarDrawings();
                CustomerDrawings();
            } else if (EditB.isSelected() && CustomerB.isSelected()) {

                CustomerIntialize();
            } else {
                CustomerDrawings();
            }

        }

        if (e.getSource().equals(deletejoe)) {
            if (BookingB.isSelected()) {

                Booking.deleteBooking((int) ID.getSelectedItem());
                defaultDrawings();
                BookingIntialize();

            } else if (CarB.isSelected()) {
                Car.deleteCar((int) ID1.getSelectedItem());
                defaultDrawings();
                CarIntialize();

            } else if (CustomerB.isSelected()) {
                Customer.deleteCustomer((int) ID2.getSelectedItem());
                defaultDrawings();
                CustomerIntialize();

            }
        } else if (e.getSource().equals(addjoe)) {
            if (BookingB.isSelected()) {
                if (EorAParameter1.getText().isEmpty() || EorAParameter2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill the start and end date ", "Empty Parameters", JOptionPane.PLAIN_MESSAGE);
                } else if (ID1.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(null, "Choose a car ", "Empty Parameters", JOptionPane.PLAIN_MESSAGE);
                } else if (ID2.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(null, "Choose a Customer ", "Empty Parameters", JOptionPane.PLAIN_MESSAGE);
                } else {
                    Booking.addBooking(new Booking(EorAParameter1.getText(), EorAParameter2.getText(), Car.getCarList().get((Integer) ID1.getSelectedItem()), Customer.getCustomer_list().get((Integer) ID2.getSelectedItem())));
                    defaultDrawings();
                    BookingIntialize();
                    JOptionPane.showMessageDialog(null, "Added Successfully", "Success", JOptionPane.PLAIN_MESSAGE);
                }

            } else if (CarB.isSelected()) {
                try {
                    Integer.parseInt(EorAParameter3.getText());
                    
                if (EorAParameter1.getText().isEmpty() || EorAParameter2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill the Brand and the Model  ", "Empty Parameters", JOptionPane.PLAIN_MESSAGE);
                } else if (EorAParameter3.getText().isEmpty() || (parseInt(EorAParameter3.getText())) <= 0) {
                    JOptionPane.showMessageDialog(null, "Enter a valid price ", "Empty Parameters", JOptionPane.PLAIN_MESSAGE);
                } else {
                    Car.addCar(new Car(EorAParameter2.getText(), EorAParameter1.getText(), parseInt(EorAParameter3.getText())));
                    defaultDrawings();
                    CarIntialize();
                    JOptionPane.showMessageDialog(null, "Added Successfully", "Success", JOptionPane.PLAIN_MESSAGE);
                }
                    
                    
                } catch (NumberFormatException eeee) {
                     JOptionPane.showMessageDialog(null, "Enter a valid price ", "Empty Parameters", JOptionPane.PLAIN_MESSAGE);
                }


            } else if (CustomerB.isSelected()) {
                 try {
                    //Integer.parseInt(EorAParameter6.getText());
                    
                if (EorAParameter1.getText().isEmpty() || EorAParameter2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill the Name And The Age  ", "Empty Parameters", JOptionPane.PLAIN_MESSAGE);
                } else if (EorAParameter6.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter a valid password ", "Empty Parameters", JOptionPane.PLAIN_MESSAGE);
                } else {
                    Customer.addcustomer(new Customer(EorAParameter1.getText(), (parseInt(EorAParameter2.getText())), (parseInt(EorAParameter6.getText()))));
                    defaultDrawings();
                    CustomerIntialize();
                    EorAParameter6.setText("");
                    JOptionPane.showMessageDialog(null, "Added Successfully", "Success", JOptionPane.PLAIN_MESSAGE);
                }
                 } catch (NumberFormatException eeee) {
                    JOptionPane.showMessageDialog(null, "Enter a valid password " + EorAParameter6.getText(), "Empty Parameters", JOptionPane.PLAIN_MESSAGE);
                }

            }
        } else if (e.getSource().equals(editjoe)) {
            if (BookingB.isSelected()) {
                if (EorAParameter1.getText().isEmpty() || EorAParameter2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill the start and end date ", "Empty Parameters", JOptionPane.PLAIN_MESSAGE);
                } else if (ID2.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(null, "Choose a Customer ", "Empty Parameters", JOptionPane.PLAIN_MESSAGE);
                } else {
                    Booking Temp = Booking.getBooking_List().get((Integer) (ID.getSelectedItem()));
                    Temp.setBooking_End(EorAParameter1.getText());
                    Temp.setBooking_Start(EorAParameter2.getText());
                    if (ID1.getSelectedIndex() == -1) {
                        Temp.setObjCar(Booking.getBooking_List().get((Integer)ID.getSelectedItem()).getObjCar());
                    } else {
                         Temp.setObjCar(Car.getCarList().get((Integer) ID1.getSelectedItem()));
                    }
                   
                    Temp.setObjCustomer(Customer.getCustomer_list().get((Integer) ID2.getSelectedItem()));
                    defaultDrawings();
                    BookingIntialize();
                    JOptionPane.showMessageDialog(null, "Edited Successfully", "Success", JOptionPane.PLAIN_MESSAGE);
                }

            } else if (CarB.isSelected()) {
                if (EorAParameter1.getText().isEmpty() || EorAParameter2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill the Brand and the Model  ", "Empty Parameters", JOptionPane.PLAIN_MESSAGE);
                } else if ((parseInt(EorAParameter3.getText())) <= 0 || EorAParameter3.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter a valid price ", "Empty Parameters", JOptionPane.PLAIN_MESSAGE);
                } else {
                    Car Temp = Car.getCarList().get((Integer) (ID1.getSelectedItem()));
                    Temp.setMake(EorAParameter1.getText());
                    Temp.setModel(EorAParameter2.getText());
                    Temp.setPrice(parseInt(EorAParameter3.getText()));
                    defaultDrawings();
                    CarIntialize();
                    JOptionPane.showMessageDialog(null, "Edited Successfully", "Success", JOptionPane.PLAIN_MESSAGE);
                }

            } else if (CustomerB.isSelected()) {
                if (EorAParameter1.getText().isEmpty() || EorAParameter2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill the Name And The Age  ", "Empty Parameters", JOptionPane.PLAIN_MESSAGE);
                } else {
                    Customer Temp = Customer.getCustomer_list().get((Integer) ID2.getSelectedItem());
                    Temp.setName(EorAParameter1.getText());
                    Temp.setAge(parseInt(EorAParameter2.getText()));
                    defaultDrawings();
                    CustomerIntialize();
                    JOptionPane.showMessageDialog(null, "Edited Successfully", "Success", JOptionPane.PLAIN_MESSAGE);
                }

            }
        }

    }

    public void defaultDrawings() {

        c.removeAll();
        EorAParameter1.setText("");
        EorAParameter2.setText("");
        EorAParameter3.setText("");
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
                if (Booking.getBooking_List().get(i).getBooking_Start() != null) {

                    ID.addItem(Booking.getBooking_List().get(i).getBooking_id());
                }

            }

            ID.setBounds(160, 50, 100, 20);
            ID.addActionListener(this);
            c.add(ID);

        } else if (DeleteB.isSelected()) {

            for (int i = 0; i < Booking.getBooking_List().size(); i++) {

                if (Booking.getBooking_List().get(i).getBooking_Start() != null) {

                    ID.addItem(Booking.getBooking_List().get(i).getBooking_id());
                }
            }

            if (!ID.isShowing()) {
                System.out.println((int) ID.getSelectedItem());
                ID.setBounds(160, 50, 100, 20);

                ID.addActionListener(this);
                deletejoe.setBounds(200, 250, 100, 20);

                c.add(deletejoe);
                c.add(ID);
            }

        } else if (AddB.isSelected()) {

            //show the start and end date and their text fields
            JLabel BName2 = new JLabel("Booking End Date : ");

            JLabel BName22 = new JLabel("Booking Start Date : ");

            EorAParameter1.setBounds(300, 100, 100, 20);
            BName2.setBounds(180, 100, 120, 20);
            EorAParameter2.setBounds(300, 120, 100, 20);
            BName22.setBounds(180, 120, 120, 20);

            c.add(EorAParameter1);
            c.add(BName2);
            c.add(EorAParameter2);
            c.add(BName22);
            //show the combobox for the list of cars and it's lapbel
            Object tmpelid = ID1.getSelectedItem();
            ID1 = new JComboBox();
            for (int i = 0; i < Car.getCarList().size(); i++) {
                if (Car.getCarList().get(i).getMake() != null) {
                    ID1.addItem(Car.getCarList().get(i).getID());
                }
            }
            ID1.setSelectedItem(tmpelid);
            ID1.setBounds(300, 140, 100, 20);
            ID1.addActionListener(this);
            c.add(ID1);
            JLabel combolabel = new JLabel("Choose a car : ");
            combolabel.setBounds(180, 140, 100, 20);
            c.add(combolabel);
            //show the combobox for the list of Customers and it's label
            Object tmpelid1 = ID2.getSelectedItem();
            ID2 = new JComboBox();
            for (int i = 0; i < Customer.getCustomer_list().size(); i++) {
                if (Customer.getCustomer_list().get(i).getName() != null) {
                    ID2.addItem(Customer.getCustomer_list().get(i).getCustomer_ID());
                }
            }
            ID2.setSelectedItem(tmpelid1);
            ID2.setBounds(540, 140, 100, 20);
            ID2.addActionListener(this);
            c.add(ID2);
            JLabel combolabel1 = new JLabel("Choose a Customer : ");
            combolabel1.setBounds(410, 140, 150, 20);
            c.add(combolabel1);

            addjoe.setBounds(200, 250, 100, 20);
            c.add(addjoe);

        } else if (EditB.isSelected()) {
            //add combo box for bookings

            for (int i = 0; i < Booking.getBooking_List().size(); i++) {
                if (Booking.getBooking_List().get(i).getBooking_Start() != null) {

                    ID.addItem(Booking.getBooking_List().get(i).getBooking_id());
                }

            }

            ID.setBounds(160, 50, 100, 20);
            ID.addActionListener(this);
            c.add(ID);
            ID1 = new JComboBox();
            for (int i = 0; i < Car.getCarList().size(); i++) {
                if (Car.getCarList().get(i).getMake() != null) {
                    ID1.addItem(Car.getCarList().get(i).getID());
                }
            }
            ID1.addActionListener(this);
            ID2 = new JComboBox();
            for (int i = 0; i < Customer.getCustomer_list().size(); i++) {
                if (Customer.getCustomer_list().get(i).getName() != null) {
                    ID2.addItem(Customer.getCustomer_list().get(i).getCustomer_ID());
                }
            }
            ID2.addActionListener(this);

        }
    }

    public void CarIntialize() {

        if (ViewB.isSelected()) {
            ID1 = new JComboBox();

            for (int i = 0; i < Car.getCarList().size(); i++) {
                if (Car.getCarList().get(i).getMake() != null) {
                    ID1.addItem(Car.getCarList().get(i).getID());
                }
            }

            ID1.setBounds(160, 50, 100, 20);
            ID1.addActionListener(this);
            c.add(ID1);

        } else if (DeleteB.isSelected()) {
            ID1 = new JComboBox();

            for (int i = 0; i < Car.getCarList().size(); i++) {
                if (Car.getCarList().get(i).getMake() != null) {
                    ID1.addItem(Car.getCarList().get(i).getID());
                }
            }

            ID1.setBounds(160, 50, 100, 20);
            ID1.addActionListener(this);
            deletejoe.setBounds(200, 250, 100, 20);

            c.add(deletejoe);
            c.add(ID1);

        } else if (AddB.isSelected()) {
            ID1 = new JComboBox();
            JLabel BName2 = new JLabel("Car Brand : ");

            JLabel BName22 = new JLabel("Car Model : ");
            JLabel BName222 = new JLabel("Car Price : ");

            EorAParameter1.setBounds(300, 100, 100, 20);
            BName2.setBounds(180, 100, 120, 20);
            EorAParameter2.setBounds(300, 120, 100, 20);
            BName22.setBounds(180, 120, 120, 20);
            EorAParameter3.setBounds(300, 140, 100, 20);
            BName222.setBounds(180, 140, 120, 20);

            c.add(EorAParameter1);
            c.add(BName2);
            c.add(EorAParameter2);
            c.add(BName22);
            c.add(EorAParameter3);
            c.add(BName222);
            addjoe.setBounds(200, 250, 100, 20);

            c.add(addjoe);
        } else if (EditB.isSelected()) {
            Object tmpelid = 0;
            if (ID1.getSelectedIndex() != -1) {
                tmpelid = ID1.getSelectedItem();
            }

            ID1 = new JComboBox();
            for (int i = 0; i < Car.getCarList().size(); i++) {
                if (Car.getCarList().get(i).getMake() != null) {
                    ID1.addItem(Car.getCarList().get(i).getID());
                }
            }
            ID1.setSelectedItem(tmpelid);
            ID1.setBounds(160, 50, 100, 20);
            ID1.addActionListener(this);
            c.add(ID1);
            JLabel BName2 = new JLabel("Car Brand : ");

            JLabel BName22 = new JLabel("Car Model : ");
            JLabel BName222 = new JLabel("Car Price : ");

            EorAParameter1.setBounds(300, 100, 100, 20);

            BName2.setBounds(180, 100, 120, 20);
            EorAParameter2.setBounds(300, 120, 100, 20);

            BName22.setBounds(180, 120, 120, 20);
            EorAParameter3.setBounds(300, 140, 100, 20);

            BName222.setBounds(180, 140, 120, 20);
            try {
                EorAParameter1.setText(Car.getCarList().get((Integer) ID1.getSelectedItem()).getMake());
                EorAParameter2.setText(Car.getCarList().get((Integer) ID1.getSelectedItem()).getModel());
                Integer price = Car.getCarList().get((Integer) ID1.getSelectedItem()).getPrice();
                EorAParameter3.setText(price.toString());
            } catch (Exception e) {

            }

            c.add(EorAParameter1);
            c.add(BName2);
            c.add(EorAParameter2);
            c.add(BName22);
            c.add(EorAParameter3);
            c.add(BName222);
            editjoe.setBounds(200, 250, 100, 20);

            c.add(editjoe);
        }
    }

    public void CustomerIntialize() {

        if (ViewB.isSelected()) {
            ID2 = new JComboBox();

            for (int i = 0; i < Customer.getCustomer_list().size(); i++) {
                if (Customer.getCustomer_list().get(i).getName() != null) {
                    ID2.addItem(Customer.getCustomer_list().get(i).getCustomer_ID());
                }
            }

            ID2.setBounds(160, 50, 100, 20);
            ID2.addActionListener(this);
            c.add(ID2);

        } else if (DeleteB.isSelected()) {
            ID2 = new JComboBox();

            for (int i = 0; i < Customer.getCustomer_list().size(); i++) {
                if (Customer.getCustomer_list().get(i).getName() != null) {
                    ID2.addItem(Customer.getCustomer_list().get(i).getCustomer_ID());
                }
            }

            ID2.setBounds(160, 50, 100, 20);
            ID2.addActionListener(this);
            deletejoe.setBounds(200, 250, 100, 20);

            c.add(deletejoe);
            c.add(ID2);

        } else if (AddB.isSelected()) {
            JLabel BName2 = new JLabel("Customer Name : ");

            JLabel BName22 = new JLabel("Customer Age : ");
            JLabel BName222 = new JLabel("Customer Password : ");

            EorAParameter1.setBounds(320, 100, 100, 20);
            BName2.setBounds(180, 100, 130, 20);
            EorAParameter2.setBounds(320, 120, 100, 20);
            BName22.setBounds(180, 120, 130, 20);
            EorAParameter6.setBounds(320, 140, 100, 20);
            BName222.setBounds(180, 140, 130, 20);

            c.add(EorAParameter1);
            c.add(BName2);
            c.add(EorAParameter2);
            c.add(BName22);
            c.add(EorAParameter6);
            c.add(BName222);
            addjoe.setBounds(200, 250, 100, 20);

            c.add(addjoe);
        } else if (EditB.isSelected()) {
            Object tmpelid = 0;
            if (ID2.getSelectedIndex() != -1) {
                tmpelid = ID2.getSelectedItem();
            }

            ID2 = new JComboBox();
            for (int i = 0; i < Customer.getCustomer_list().size(); i++) {
                if (Customer.getCustomer_list().get(i).getName() != null) {
                    ID2.addItem(Customer.getCustomer_list().get(i).getCustomer_ID());
                }
            }
            ID2.setSelectedItem(tmpelid);
            ID2.setBounds(160, 50, 100, 20);
            ID2.addActionListener(this);
            c.add(ID2);
            JLabel BName2 = new JLabel("Customer Name : ");

            JLabel BName22 = new JLabel("Customer Age : ");

            EorAParameter1.setBounds(300, 100, 100, 20);
            EorAParameter1.setText(Customer.getCustomer_list().get((Integer) ID2.getSelectedItem()).getName());
            BName2.setBounds(180, 100, 120, 20);
            EorAParameter2.setBounds(300, 120, 100, 20);
            Integer AGE = Customer.getCustomer_list().get((Integer) ID2.getSelectedItem()).getAge();
            EorAParameter2.setText(AGE.toString());
            BName22.setBounds(180, 120, 120, 20);

            c.add(EorAParameter1);
            c.add(BName2);
            c.add(EorAParameter2);
            c.add(BName22);

            editjoe.setBounds(200, 250, 100, 20);

            c.add(editjoe);
        }
    }

    public void BookingDrawings() {

        if (DeleteB.isSelected() || ViewB.isSelected()) {
            ID.setBounds(160, 50, 100, 20);

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

                c.add(deletejoe);
            }
        } else if (AddB.isSelected()) {

            JLabel BName2 = new JLabel("Booking End Date : ");

            JLabel BName22 = new JLabel("Booking Start Date : ");

            JLabel BName222 = new JLabel("Booking Car Brand : ");

            JLabel BName2222 = new JLabel("Booking Car Model : ");

            JLabel BName22222 = new JLabel("Booking Car Price : ");

            EorAParameter1.setBounds(300, 100, 100, 20);
            BName2.setBounds(180, 100, 120, 20);

            EorAParameter2.setBounds(300, 120, 100, 20);
            BName22.setBounds(180, 120, 120, 20);

            BName222.setBounds(180, 140, 120, 20);

            BName2222.setBounds(180, 160, 120, 20);

            BName22222.setBounds(180, 180, 120, 20);

            c.add(EorAParameter2);
            c.add(BName22);
            c.add(EorAParameter1);
            c.add(BName2);
            c.add(BName222);
            c.add(BName2222);
            c.add(BName22222);
        } else if (EditB.isSelected()) {
            ID.setBounds(160, 50, 100, 20);

            c.add(ID);
            Integer elid = (Integer) ID.getSelectedItem();
            //show the start and end date and their text fields
            JLabel BName2 = new JLabel("Booking End Date : ");

            JLabel BName22 = new JLabel("Booking Start Date : ");

            EorAParameter1.setBounds(300, 100, 100, 20);
            BName2.setBounds(180, 100, 120, 20);
            EorAParameter2.setBounds(300, 120, 100, 20);
            BName22.setBounds(180, 120, 120, 20);
            EorAParameter1.setText(Booking.getBooking_List().get(elid).getBooking_End());
            EorAParameter2.setText(Booking.getBooking_List().get(elid).getBooking_Start());

            c.add(EorAParameter1);
            c.add(BName2);
            c.add(EorAParameter2);
            c.add(BName22);
            //show the combobox for the list of cars and it's lapbel
            Object tmpelid = Booking.getBooking_List().get(elid).getObjCar().getID();
            System.out.println(tmpelid);

           

            ID1.setBounds(300, 140, 100, 20);

            c.add(ID1);
            JLabel combolabel = new JLabel("Choose a car : ");
            combolabel.setBounds(180, 140, 100, 20);
            c.add(combolabel);
            //show the combobox for the list of Customers and it's label
            Object tmpelid1 = Booking.getBooking_List().get(elid).getObjCustomer().getCustomer_ID();

           

            ID2.setBounds(540, 140, 100, 20);

            c.add(ID2);
            JLabel combolabel1 = new JLabel("Choose a Customer : ");
            combolabel1.setBounds(410, 140, 150, 20);
            c.add(combolabel1);

            editjoe.setBounds(200, 250, 100, 20);
            c.add(editjoe);

        }

    }

    public void CarDrawings() {
        if (DeleteB.isSelected() || ViewB.isSelected()) {
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
            if (DeleteB.isSelected()) {
                deletejoe.setBounds(200, 250, 100, 20);

                c.add(deletejoe);
            }
        } else if (AddB.isSelected() || EditB.isSelected()) {
            ID1.setBounds(300, 140, 100, 20);

            c.add(ID1);
            if (ID1.getSelectedIndex() == -1) {
                ID1.setSelectedIndex(0);
            }
            Integer elid = (Integer) ID1.getSelectedItem();

            JLabel ShowParameter1 = new JLabel(Car.getCarList().get(elid).getMake());
            JLabel ShowParameter2 = new JLabel(" Car Brand : ");

            JLabel ShowParameter11 = new JLabel(Car.getCarList().get(elid).getModel());
            JLabel ShowParameter22 = new JLabel(" Car Model : ");

            Integer price = Car.getCarList().get(elid).getPrice();
            JLabel ShowParameter111 = new JLabel(price.toString());
            JLabel ShowParameter222 = new JLabel(" Car Price : ");

            ShowParameter1.setBounds(300, 160, 100, 20);
            ShowParameter2.setBounds(180, 160, 120, 20);

            ShowParameter11.setBounds(300, 180, 100, 20);
            ShowParameter22.setBounds(180, 180, 120, 20);

            ShowParameter111.setBounds(300, 200, 100, 20);
            ShowParameter222.setBounds(180, 200, 120, 20);

            c.add(ShowParameter1);
            c.add(ShowParameter2);
            c.add(ShowParameter11);
            c.add(ShowParameter22);
            c.add(ShowParameter111);
            c.add(ShowParameter222);

        }

    }

    private void CustomerDrawings() {
        if (DeleteB.isSelected() || ViewB.isSelected()) {
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
            if (DeleteB.isSelected()) {
                deletejoe.setBounds(200, 250, 100, 20);

                c.add(deletejoe);
            }
        } else if (AddB.isSelected() || EditB.isSelected()) {
            ID2.setBounds(540, 140, 100, 20);
            ID2.addActionListener(this);
            c.add(ID2);
            if (ID2.getSelectedIndex() == -1) {
                ID2.setSelectedIndex(0);
            }
            Integer elid = (Integer) ID2.getSelectedItem();

            JLabel ShowParameter3 = new JLabel(Customer.getCustomer_list().get(elid).getName());
            JLabel ShowParameter4 = new JLabel(" Customer Name : ");

            Integer Age = Customer.getCustomer_list().get(elid).getAge();
            JLabel ShowParameter33 = new JLabel(Age.toString());
            JLabel ShowParameter44 = new JLabel(" Customer Age : ");

            ShowParameter3.setBounds(540, 160, 100, 20);
            ShowParameter4.setBounds(410, 160, 120, 20);

            ShowParameter33.setBounds(540, 180, 100, 20);
            ShowParameter44.setBounds(410, 180, 120, 20);

            c.add(ShowParameter3);
            c.add(ShowParameter4);
            c.add(ShowParameter33);
            c.add(ShowParameter44);

        }

    }

}
