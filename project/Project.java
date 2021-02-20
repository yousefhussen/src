package project;

import java.io.IOException;

public class Project {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
                     
      
         Booking b5 = new Booking();
         Customer c5 = new Customer();
         Car s5 = new Car();

        ReadAndWrite w1;
        w1 = new ReadAndWrite();
  //  w1.Read();
      Car c1 = new Car(" 2010" , " seat" , 1300);
      Car.addCar(c1);
      Car c2 = new Car(" 2015" , " mg" , 1500);
      Car.addCar(c2); 
      Customer c3=new Customer("Mohamed",18,1244);
      Customer.addcustomer(c3);
      Customer c4=new Customer("Salah",45,5455);
      Customer.addcustomer(c4);
      Booking b1=new Booking("10/5/2019","10/6/2019",c1,c3); 
      Booking.addBooking(b1);
      Booking b2=new Booking("1/1/2020","5/5/2020",c2,c4);

      Booking.addBooking(b2); 
       Car c7 = new Car(" 2020" , " toyota" , 1300);
      Car.addCar(c7);
   //   PayMethod q1 = new PayMethod(b2);
    //CustomerMenu c77=new CustomerMenu(c3);
//      AdminMenu s1 = new AdminMenu();

      
      
  StartUpMenu start = new StartUpMenu("Basha","7" , w1);
   
   
   

    }

}
