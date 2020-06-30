
//Exercise1
public class Exercise1 {

    public static void main(String[] args) {
        int a = 500;    //Create a int variable and set it to 500
        short b = 10;   //Create a short variable and set it to 10
        byte c = 30;    //Create a byte variable and set it to 30

        //Create a variable of type long, and make it equal to 70000 plus
        // 15 times the int value then plus the short plus the byte variables
        long d = 70_000 + 15 * a + b + c;
        System.out.println(d);
    }
}


//Exercise2

public class Exercise2 {
    public static void main(String[] args) {
        //Convert a given number of pounds to kilograms
        float pound = 100f;   //Create a variable to store the 100 pounds
        float kilogram;
        //Calculate the number of Kilograms for the number 100 pounds and store in a variable.
        kilogram= (float) (2.205 * pound);
        //Print out the result.
        System.out.println(kilogram);
    }
}


//Exercise3
public class Exercise3 {
    public static void main(String[] args) {

        double a = 20;   //Create a double variable with the value 20
        double b = 80;   //Create a second variable of type double with the value 80

        //Add both numbers up and multiply by 25
        //Print the total of #3
        System.out.println((a + b)*25);


        //Use the remainder operator to figure out the remainder from the sum of #3 divided by 40.
        double remainder;
        remainder   = (a + b) * 25 % 40;

        //Write an "if" statement that displays a message
        // "Total was over the limit” if the remaining total (#4) is equal to 20 or less.
        if (remainder <= 20 ){
            System.out.println("Total was over the limit");
        }        
    }
}



//exercise4;
import com.sun.org.apache.bcel.internal.generic.SWITCH;
import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter one Uppercase Alphabet Character");
        char myChar = input.next().charAt(0);         //Create a char variable for switch statement

        switch(myChar){
            case 'A':
                System.out.println("Apple");
                break;
            case 'B':
                System.out.println("Banana");
                break;
            case 'C':
                System.out.println("Cherries");
                break;
            case 'D':
                System.out.println("Dragon");
                break;
            case 'E':
                System.out.println("Fruit");
                break;
            default:
                System.out.println("ElderBerry");
                break;
        }
    }
}



//Exercise5
import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);
        int start;
        int end;
        System.out.println("Enter a start number");
        start = input.nextInt();
        System.out.println("Enter an end number");
        end = input.nextInt();
        int start1 = start;

//list all the numbers
        if (start > end){
            System.out.println("Your start number is larger than the end number");
        }
        else if(start == end){
                System.out.println("0");
            }
        else{
            do { start++;
                System.out.println(start);
            }
            while (start < end-1);
        }

// Sum of numbers  using while loop 
        if (start1 > end){
            System.out.println("Your start number is larger than the end number");
        }
        else if(start1 == end){
            System.out.println("0");
        }
        else{
            int i = 0;
            do {
                start1++;
                i = i+start1;
            }
            while (start1 < end-1);
            System.out.println("sum: " + i);
        }
    }
}



//EmployDemo exercise
public class EmployDemo{
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.setName("Kelly");
        employee1.setCompany("Flexon");
        employee1.setLocation("San Francisco");

        String name = employee1.getName();
        String company = employee1.getCompany();
        String location = employee1.getLocation();
        employee1.sayHello();
        System.out.println("This is "+ name + "'s profile " + "at "+company+ " in "+ location);
        
    }
}


class Employee{
    String name;
    String company;
    String location;

    public void sayHello() {
        System.out.println("Hi, this is "+ this.name);
    }
    public String getName(){
        return name;
    }

    public String getCompany() {
        return company;
    }
    public String getLocation() {
        return location;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }
}










