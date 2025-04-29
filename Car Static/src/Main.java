abstract class Car{
abstract public void start();
public void stop(){
    System.out.println("car is stopped");
}

}

class Corolla extends Car{
    @Override
    public void start(){
        System.out.println("Corolla is started");
    }
}

class Mehran extends Car{
    @Override
    public void start(){
        System.out.println("Mehran is started");
    }
}

class Main{
    public static void main(String[] args) {
        Car c1=new Corolla();
        c1.start();
        c1.stop();

        Car m1=new Mehran();
        m1.start();
        m1.stop();
    }
}
