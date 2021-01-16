package project;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ReadAndWrite{

    private Car objCar;
    private Customer objCustomer;
    private Booking objBooking;
    private StartUpMenu objStart;

    public void Write() throws IOException, ClassNotFoundException {
        String filename = "data1.bin";
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (int i = 0; i < Booking.getBooking_List().size(); i++) {
                os.writeObject(Booking.getBooking_List().get(i));
            }
        }

        String filename2 = "Car.bin";
        try (ObjectOutputStream os2 = new ObjectOutputStream(new FileOutputStream(filename2))) {
            for (int i = 0; i < Car.getCarList().size(); i++) {
                os2.writeObject(Car.getCarList().get(i));
            }
        }

        String filename3 = "Customer.bin";
        try (ObjectOutputStream os3 = new ObjectOutputStream(new FileOutputStream(filename3))) {
            for (int i = 0; i < Customer.getCustomer_list().size(); i++) {
                os3.writeObject(Customer.getCustomer_list().get(i));
            }
        }

    }

    public void Read() throws IOException, ClassNotFoundException, EOFException {

        ObjectInputStream is = new ObjectInputStream(new FileInputStream("data1.bin"));

        Booking.getBooking_List().clear();

        try {

            while (true) {

                objBooking = (Booking) is.readObject();
                Booking.addBooking(objBooking);
            }
        } catch (EOFException e) {

        }
        is.close();

        ObjectInputStream is2 = new ObjectInputStream(new FileInputStream("Car.bin"));

        try {
            Car.getCarList().clear();

            while (true) {

                objCar = (Car) is2.readObject();
                Car.addCar(objCar);
            }

        } catch (EOFException e) {

        }

        is2.close();

        ObjectInputStream is3 = new ObjectInputStream(new FileInputStream("Customer.bin"));

        Customer.getCustomer_list().clear();

        try {
            while (true) {

                objCustomer = (Customer) is3.readObject();
                Customer.addcustomer(objCustomer);
            }

        } catch (EOFException e) {

        }

        is3.close();

    }

}
