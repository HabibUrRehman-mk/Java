class Distance{
    int feet;
    int inches;
    public Distance(){
        feet=0;
        inches=0;
    }
    public Distance(int a,int b){
        feet=a;
        inches=b;
    }
    public void setfeet(int a){
        feet=a;
    }
    public void setinches(int b){
        inches=b;
    }
    public void getfeet(){
        System.out.println("the value of feet is "+ feet);
    }
    public void getinches(){
        System.out.println("the value of inches is "+ inches);
    }
    public Distance adder(Distance a){
        Distance newd=new Distance(feet+a.feet,inches+a.inches);
//        b.feet=feet+a.feet;
//        b.inches=inches+a.inches;
        return newd;
    }
    public void show(){
        System.out.println("The value of feet is "+feet+" and inches is "+inches);
    }
}
public class Main{
    public static void main(String[] args) {
        Distance d1=new Distance(20,10);
        Distance d2=new Distance(10,20);
        Distance d3=new Distance();
        d3=d2.adder(d1);
        d3.show();

    }
}