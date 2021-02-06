package project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Booking implements Serializable {

    private int booking_id;
    private String booking_Start;
    private String booking_End;
    private Car objCar;
    private Customer objCustomer;
    private static ArrayList<Booking> booking_List;
    private static int numOfBooking = 0;

    public Booking() {
        booking_List = new ArrayList<>();
    }

    public Booking(String booking_Start, String booking_End, Car objCar, Customer objCustomer) {

        this.booking_Start = booking_Start;
        this.booking_End = booking_End;
        this.objCar = objCar;
        this.objCustomer = objCustomer;

        this.booking_id = numOfBooking;

    }

    public static ArrayList<Booking> getBooking_List() {
        return booking_List;
    }

    public static int getNumOfBooking() {
        return numOfBooking;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public void setBooking_Start(String booking_Start) {
        this.booking_Start = booking_Start;
    }

    public void setBooking_End(String booking_End) {
        this.booking_End = booking_End;
    }

    public void setObjCar(Car objCar) {
        this.objCar = objCar;
    }

    public void setObjCustomer(Customer objCustomer) {
        this.objCustomer = objCustomer;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public String getBooking_Start() {
        return booking_Start;
    }

    public String getBooking_End() {
        return booking_End;
    }

    public Car getObjCar() {
        return objCar;
    }

    public Customer getObjCustomer() {
        return objCustomer;
    }

    public static void addBooking(Booking obj) {
        if (Car.getCarList().contains(obj.getObjCar())) {
            Car.deleteCar(obj.getObjCar().getID());
        }
        booking_List.add(obj);
        numOfBooking++;
    }

   


    public static void deleteBooking(int booking_id) {

        booking_List.set(booking_id, new Booking(null, null, null, null));

    }

}
