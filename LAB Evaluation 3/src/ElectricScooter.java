public class ElectricScooter extends Vehicle implements Ecofriendly{
    @Override
    public void start(){
        System.out.println("Electric Scooter is started");
    }

    @Override
    public double calculateFare(double distance) {
        return distance*50;
    }

    @Override
    public void showEcoRating() {
        System.out.println("Electric Scooter has eco rating ......");
    }
}