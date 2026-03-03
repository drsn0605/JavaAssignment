package myPractice;

class Car1 {
    String color = "Red";
    int speed = 120;

    void displayInfo() {
        System.out.println("Car color: " + color);
        System.out.println("Car speed: " + speed);
    }
}

public class CreateObject {
    public static void main(String[] args) {
        Car1 myCar = new Car1();
        myCar.displayInfo();
    }
}
