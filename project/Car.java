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

    public static void deleteCar(int id) {
        carList.set(id, new Car(null,null,-1));
       
    }

}
