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
//         Customer_ID = numOfObjects;
//         Name="";
//         Age=0;
//         password=0;
//         numOfObjects++;
    }

    public Customer(String Name, int Age, int password) {
        //this.customer_list=customer_list;
      
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

    public static void editCustomer(int id) {
        Customer customerTemp = customer_list.get(id);
        System.out.println("===========================================");
        System.out.println("Customer Name : " + customerTemp.getName());
        System.out.println("Cuatomer Age : " + customerTemp.getAge());
        //  System.out.println("Customer password : " + customerTemp.getpassword());
        System.out.println("Customer password : " + "****");
        System.out.println("Would you like to change any of these items ?(yes/no)");
        Scanner input = new Scanner(System.in);
        String x = input.next();
        int temp = 0;
        while (x.equalsIgnoreCase("yes")) {
            System.out.println("enter the name of the item you would like to change ");
            String y = input.next();
            if (y.equalsIgnoreCase("name")) {
                System.out.println("Enter the new name");
                String newName = input.next();
                customerTemp.setName(newName);
            } else if (y.equalsIgnoreCase("age")) {
                System.out.println("Enter the new age");
                int newAge = input.nextInt();
                customerTemp.setAge(newAge);
            } else if (y.equalsIgnoreCase("password")) {
                System.out.println("Enter the old password");
                int h = input.nextInt();
                if (h == customerTemp.getpassword()) {
                    System.out.println("Enter the new password");
                    int newPassword = input.nextInt();
                    customerTemp.setPassword(newPassword);
                } else {
                    System.out.println("Calling the police !!");
                    temp = 1;
                    return;
                }
            }
            System.out.println("Customer Name : " + customerTemp.getName());
            System.out.println("Cuatomer Age : " + customerTemp.getAge());
            if (temp == 0) {
                System.out.println("Customer password : " + customerTemp.getpassword());
            } else {
                System.out.println(" ");
            }
            // System.out.println("Customer password : " + customerTemp.getpassword());
            System.out.println(" ");
            System.out.println("Would you like to change any of these items ?(yes/no)");
            x = input.next();
        }
    }

    public static void viewMemberList() {
        for (int i = 0; i < customer_list.size(); i++) {
            System.out.println("===========================================");
            System.out.println("Customer ID: " + i);
            System.out.println("===========================================");
            System.out.println("Customer Name : " + customer_list.get(i).getName());
            System.out.println("Cuatomer Age : " + customer_list.get(i).getAge());
            System.out.println("Customer password : " + customer_list.get(i).getpassword());

        }
    }

    public static void deleteCustomer(int customer_id) {
        customer_list.set(customer_id, new Customer(null,-1,-1));
    }

}
