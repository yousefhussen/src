package project;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class CustomerMenu extends JFrame implements ActionListener {

    Customer speed;
    JToggleButton ViewB = new JToggleButton("View");
    JToggleButton AddB = new JToggleButton("Add");
    JToggleButton DeleteB = new JToggleButton("Delete");

    JToggleButton BookingB = new JToggleButton("Booking");

    JToggleButton EditB = new JToggleButton("Edit");
    JToggleButton Test = new JToggleButton("Yest");
    JComboBox ID = new JComboBox();
    JComboBox ID1 = new JComboBox();

    JButton deletejoe = new JButton("Delete");
    JButton addjoe = new JButton("Add");
    JButton editjoe = new JButton("Edit");

    JTextField tf1, tf2;
    JLabel lb1, lb2, lb3, make, model, price, make1, model1, price1;
    JComboBox addComboBoxCar;
    Container c = getContentPane();
    JTextField EorAParameter1 = new JTextField();
    JTextField EorAParameter2 = new JTextField();
    JTextField EorAParameter3 = new JTextField();
    JComboBox EorAParameter4 = new JComboBox();
    JComboBox EorAParameter5 = new JComboBox();
    ReadAndWrite file;
    private BufferedImage image;

    public CustomerMenu(Customer speed2, ReadAndWrite ffile) throws HeadlessException {

        c.setLayout(null);
        speed = speed2;
        setSize(700, 360);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
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
        addjoe.addActionListener(this);
        deletejoe.addActionListener(this);
        editjoe.addActionListener(this);
        c.add(ViewB);
        c.add(AddB);
        c.add(DeleteB);
        c.add(EditB);
        ButtonGroup group2 = new ButtonGroup();
        group2.add(BookingB);

        BookingB.setBounds(120, 0, 565, 40);

        BookingB.addActionListener(this);
        this.file = ffile;
      addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                handleClosing();
            }
        });
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
        } else if (e.getSource().equals(ID)) {
            defaultDrawings();
            BookingDrawings();

        } else if (e.getSource().equals(ID1)) {

            defaultDrawings();
            if (AddB.isSelected()) {
                BookingIntialize();

                CarDrawings();
            } else if (EditB.isSelected()) {
                BookingDrawings();

                CarDrawings();
            } else {
                CarDrawings();
            }

        } else if (e.getSource().equals(deletejoe)) {

            Booking.deleteBooking((int) ID.getSelectedItem());
            defaultDrawings();
            BookingIntialize();
            JOptionPane.showMessageDialog(null, "Deleted Successfully", "Success", JOptionPane.PLAIN_MESSAGE);

        } else if (e.getSource().equals(addjoe)) {

            if (BookingB.isSelected()) {
                if (EorAParameter1.getText().isEmpty() || EorAParameter2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill the start and end date ", "Empty Parameters", JOptionPane.PLAIN_MESSAGE);
                } else if (ID1.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(null, "Choose a car ", "Empty Parameters", JOptionPane.PLAIN_MESSAGE);
                } else {
                    Booking Tempp = new Booking(EorAParameter1.getText(), EorAParameter2.getText(), Car.getCarList().get((Integer) ID1.getSelectedItem()), speed);

                    PayMethod q1 = new PayMethod(Tempp);
                    defaultDrawings();
                    BookingIntialize();

                }

            }
        } else if (e.getSource().equals(editjoe)) {
            if (BookingB.isSelected()) {
                if (EorAParameter1.getText().isEmpty() || EorAParameter2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill the start and end date ", "Empty Parameters", JOptionPane.PLAIN_MESSAGE);
                } else if (ID1.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(null, "Choose a car ", "Empty Parameters", JOptionPane.PLAIN_MESSAGE);
                } else {
                    Booking Temp = Booking.getBooking_List().get((Integer) (ID.getSelectedItem()));
                    Temp.setBooking_End(EorAParameter1.getText());
                    Temp.setBooking_Start(EorAParameter2.getText());
                    Temp.setObjCar(Car.getCarList().get((Integer) ID1.getSelectedItem()));
                    Temp.setObjCustomer(speed);
                    defaultDrawings();
                    BookingIntialize();
                    JOptionPane.showMessageDialog(null, "Edited Successfully", "Success", JOptionPane.PLAIN_MESSAGE);
                }

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
                if (speed.getCustomer_ID() == Booking.getBooking_List().get(i).getObjCustomer().getCustomer_ID()) {
                    if (Booking.getBooking_List().get(i).getBooking_Start() != null) {
                        ID.addItem(Booking.getBooking_List().get(i).getBooking_id());
                    }
                }
            }

            ID.setBounds(160, 50, 100, 20);
            ID.addActionListener(this);
            c.add(ID);

        } else if (AddB.isSelected()) {

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

            addjoe.setBounds(200, 250, 100, 20);
            c.add(addjoe);
        } else if (DeleteB.isSelected()) {

            for (int i = 0; i < Booking.getBooking_List().size(); i++) {
                if (speed.getCustomer_ID() == Booking.getBooking_List().get(i).getObjCustomer().getCustomer_ID()) {
                    if (Booking.getBooking_List().get(i).getBooking_Start() != null) {

                        ID.addItem(Booking.getBooking_List().get(i).getBooking_id());
                    }
                }
            }

            if (!ID.isShowing()) {
                ID.setBounds(160, 50, 100, 20);

                ID.addActionListener(this);
                deletejoe.setBounds(200, 250, 100, 20);

                c.add(deletejoe);
                c.add(ID);
            }

        } else if (EditB.isSelected()) {
            //add combo box for bookings

            for (int i = 0; i < Booking.getBooking_List().size(); i++) {
                if (speed.getCustomer_ID() == Booking.getBooking_List().get(i).getObjCustomer().getCustomer_ID()) {
                    if (Booking.getBooking_List().get(i).getBooking_Start() != null) {

                        ID.addItem(Booking.getBooking_List().get(i).getBooking_id());
                    }
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
            Object tmpelid = Booking.getBooking_List().get(elid).getObjCar().getID();
            System.out.println(tmpelid);

            ID1.setBounds(300, 140, 100, 20);

            c.add(ID1);
            JLabel combolabel = new JLabel("Choose a car : ");
            combolabel.setBounds(180, 140, 100, 20);
            c.add(combolabel);

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

}
