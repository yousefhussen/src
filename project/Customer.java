/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer implements Serializable {

    private String Name;
    private int Age;
    private int Customer_ID;
    private static ArrayList<Customer> customer_list;
    private int password;
    private static int numOfObjects = 0;

    public Customer() {
        customer_list = new ArrayList<>();

    }

    public Customer(String Name, int Age, int password) {
      
        this.Customer_ID = numOfObjects;
        this.Name = Name;
        this.Age = Age;
        this.password = password;
      
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void setCustomer_ID(int Customer_ID) {
        this.Customer_ID = Customer_ID;
    }

    public static void setCustomer_list(ArrayList<Customer> customer_list) {
        Customer.customer_list = customer_list;
    }

    public static void setNumOfObjects(int numOfObjects) {
        Customer.numOfObjects = numOfObjects;
    }

    public int getpassword() {
        return password;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }

    public int getCustomer_ID() {
        return Customer_ID;
    }

    public static ArrayList<Customer> getCustomer_list() {
        return customer_list;
    }

    public static int getNumOfObjects() {
        return numOfObjects;
    }

    public static void addcustomer(Customer obj) {
        customer_list.add(obj); 
        numOfObjects++;
          
    }

    public static void deleteCustomer(int customer_id) {
        customer_list.set(customer_id, new Customer(null,-1,-1));
    }

}
