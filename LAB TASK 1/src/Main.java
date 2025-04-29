class Time{
    int hours;
     int min;
     int sec;
     Time(){
         System.out.println("no tine is entered");
     }
     Time(int x,int y, int z) {
         hours = x;
         min = y;
         sec = z;

     }

     void display(){
         if (hours>24 ||min >60 ||sec>60){
             System.out.println("0:0:0");
         }
         else{
         System.out.println("current time is " +hours+ ":"+min+":"+sec);}
     }

}
public class Main {

    public static void main(String []args){
        Time t1=new Time(24,45,67);
        t1.display();
    }

}
