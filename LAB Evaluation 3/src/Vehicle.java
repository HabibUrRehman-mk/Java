public abstract class Vehicle{

    abstract void start();
    abstract public double calculateFare(double distance);
    public void stop(){
        System.out.println("Vehicle stopped");
    }
}
