public class Car extends Vehicle{
    @Override
    public void start(){
        System.out.println("Car is started");
    }

    @Override
    public double calculateFare(double distance) {
        return distance*50;
    }
}