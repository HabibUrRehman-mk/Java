public class Bike extends Vehicle implements Ecofriendly{
    @Override
    public void start(){
        System.out.println("Bike is started");
    }

    @Override
    public double calculateFare(double distance) {
        return distance*40;
    }

    @Override
    public void showEcoRating() {
        System.out.println("Bike has Eco rating .....");
    }
}