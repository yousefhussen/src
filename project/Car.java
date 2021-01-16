package project;

import java.io.Serializable;
import java.util.*;

public class Car implements Serializable {


    private int ID;
    private String model;
    private String make;
    private int price;
    private static int numOfObjects = 0;
    private static ArrayList<Car> carList;

    public Car(String model, String make, int price) {
        this.ID = numOfObjects;
        this.model = model;
        this.make = make;
        this.price = price;

    }

    public Car() {
        carList = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public int getPrice() {
        return price;
    }

    public static ArrayList<Car> getCarList() {
        return carList;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setPrice(int price) {
        this.price = price;

    }

    public void setCarList(ArrayList<Car> carList) {
        Car.carList = carList;
    }

    public static void addCar(Car obj) {
        
        carList.add(obj);
        numOfObjects++;
    }

    public static void editCar(int id) {
        String choice = "yes";
        while (choice.equals("yes")) {
            Car carTemp = carList.get(id);

            System.out.println("===========================================");
            System.out.println("Car model : " + carTemp.getModel());
            System.out.println("Car price per hour : " + carTemp.getPrice());
            System.out.println("Car make : " + carTemp.getMake());

            System.out.println("What do u want to edit ? ");
            System.out.println("If u want to edit car model type \"make\", if u want to edit car price type \"price\" , if u want to edit car model type \"model\" ");

            Scanner sc = new Scanner(System.in);

            String input = sc.next();

            if (input.equalsIgnoreCase("make")) {
                System.out.println("Enter the brand which u want to replace with " + carTemp.getMake());
                String newMake = sc.next();
                carTemp.setMake(newMake);
            }
            if (input.equalsIgnoreCase("price")) {
                System.out.println("Enter the new price ");
                int newPrice = sc.nextInt();
                carTemp.setPrice(newPrice);
            }
            if (input.equalsIgnoreCase("model")) {
                System.out.println("Enter the new model ");
                String newModel = sc.next();
                carTemp.setModel(newModel);
            }

            System.out.println("Do u want to change anything else?");

            choice = sc.next();

        }

    }
    
     public static void editCarUser(int id) {
        String choice = "yes";
        while (choice.equals("yes")) {
            Car carTemp = carList.get(id);

            System.out.println("===========================================");
            System.out.println("Car model : " + carTemp.getModel());
            System.out.println("Car price per hour : " + carTemp.getPrice());
            System.out.println("Car make : " + carTemp.getMake());

            System.out.println("What do u want to edit ? ");
            System.out.println("If u want to edit car model type \"make\", if u want to edit car model type \"model\" ");

            Scanner sc = new Scanner(System.in);

            String input = sc.next();

            if (input.equalsIgnoreCase("make")) {
                System.out.println("Enter the brand which u want to replace with " + carTemp.getMake());
                String newMake = sc.next();
                carTemp.setMake(newMake);
            }
           
            if (input.equalsIgnoreCase("model")) {
                System.out.println("Enter the new model ");
                String newModel = sc.next();
                carTemp.setModel(newModel);
            }

            System.out.println("Do u want to change anything else?");

            choice = sc.next();

        }

    }

    public static void viewCarlist() {

        for (int i = 0; i < carList.size(); i++) {
            System.out.println("===========================================");
            System.out.println("Car ID: " + i);
            System.out.println("===========================================");
            System.out.println("Car model : " + carList.get(i).getModel());
            System.out.println("Car make : " + carList.get(i).getMake());
            System.out.println("Car price : " + carList.get(i).getPrice());
        }
    }

    public static void deleteCar(int id) {
        carList.set(id, new Car(null,null,-1));
       
    }

}
