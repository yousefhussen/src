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

        this.booking_id = numOfBooking;
        this.booking_Start = booking_Start;
        this.booking_End = booking_End;
        this.objCar = objCar;
        this.objCustomer = objCustomer;

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

        booking_List.add(obj);
        numOfBooking++;
    }

    public static void viewBookingList() {
        for (int i = 0; i < booking_List.size(); i++) {
            System.out.println("===========================================");
            System.out.println("Booking ID: " + i);
            System.out.println("===========================================");
            System.out.println("The ID is " + booking_List.get(i).getBooking_id());
            System.out.println("Booking Start from " + booking_List.get(i).getBooking_Start());
            System.out.println("Booking End at " + booking_List.get(i).getBooking_End());
            System.out.println("Customer Name " + booking_List.get(i).objCustomer.getName());
            System.out.println("Customer Age " + booking_List.get(i).objCustomer.getAge());
            System.out.println("The Car deltails " + booking_List.get(i).objCar.getMake());
            System.out.println("The Car deltails " + booking_List.get(i).objCar.getModel());
            System.out.println("The Car deltails " + booking_List.get(i).objCar.getPrice());
        }
    }

    public static void viewBookingDetails(int id) {
        Booking bookingTemp = booking_List.get(id);
        System.out.println("Booking " + id);
        System.out.println("===========================================");
        System.out.println("The ID is " + bookingTemp.getBooking_id());
        System.out.println("Booking Start from " + bookingTemp.getBooking_Start());
        System.out.println("Booking End at " + bookingTemp.getBooking_End());
        System.out.println("Customer Name " + booking_List.get(id).objCustomer.getName());
        System.out.println("Customer Age " + booking_List.get(id).objCustomer.getAge());
        System.out.println("The Car deltails " + bookingTemp.objCar.getMake());
        System.out.println("The Car deltails " + bookingTemp.objCar.getModel());
        System.out.println("The Car deltails " + bookingTemp.objCar.getPrice());
    }

    public static void editBookingList(int id) {

        Booking bookingTemp = booking_List.get(id);
        Car settercar = Car.getCarList().get(id);
        Customer settercustomer = Customer.getCustomer_list().get(id);
        viewBookingDetails(id);
        System.out.println("Would you like to change any of these items ?(yes/no)");
        Scanner input = new Scanner(System.in);
        String x = input.next();
        while (x.equalsIgnoreCase("yes")) {
            System.out.println("Type car/Customer if you would like to change in it");
            String y = input.next();
            if (y.equalsIgnoreCase("car")) {
                Car.editCar(id);
                bookingTemp.objCar = settercar;

            } else if (y.equalsIgnoreCase("customer")) {
                Customer.editCustomer(id);
                bookingTemp.objCustomer = settercustomer;
            } else {
                System.out.println("Wrong input");
                return;
            }
            System.out.println(" ");
            System.out.println("Do you want to continue or exit?");
            String z = input.next();
            if (z.equalsIgnoreCase("continue")) {
            } else if (z.equalsIgnoreCase("exit")) {
                return;
            }

        }

    }
    // coco
       public static void editBookingListUser(int id) {

        Booking bookingTemp = booking_List.get(id);
        Car settercar = Car.getCarList().get(id);
        Customer settercustomer = Customer.getCustomer_list().get(id);
        viewBookingDetails(id);
        System.out.println("Would you like to change any of these items ?(yes/no)");
        Scanner input = new Scanner(System.in);
        String x = input.next();
        while (x.equalsIgnoreCase("yes")) {
            System.out.println("Type car/Customer if you would like to change in it");
            String y = input.next();
            if (y.equalsIgnoreCase("car")) {
                Car.editCarUser(id);
                bookingTemp.objCar = settercar;

            } else if (y.equalsIgnoreCase("customer")) {
                Customer.editCustomer(id);
                bookingTemp.objCustomer = settercustomer;
            } else {
                System.out.println("Wrong input");
                return;
            }
            System.out.println(" ");
            System.out.println("Do you want to continue or exit?");
            String z = input.next();
            if (z.equalsIgnoreCase("continue")) {
            } else if (z.equalsIgnoreCase("exit")) {
                return;
            }

        }

    }

    public static void deleteBooking(int booking_id) {
        booking_List.remove(booking_id);
        numOfBooking--;
    }

}
