interface Ecofriendly{
    public void showEcoRating();
}


public class Main{
    public static void main(String[] args) {
        Vehicle c1=new Car();
        c1.start();
        System.out.println("The fair of car is "+c1.calculateFare(76.5));
        c1.stop();

        Bike b1 =new Bike();
        b1.start();
        System.out.println("The fair of bike is "+b1.calculateFare(76.5));
        b1.showEcoRating();
        b1.stop();

    }
}
