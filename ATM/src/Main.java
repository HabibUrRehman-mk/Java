class Circle {
    private int radius;
    public Circle() {
        radius = 7;
    }

    public Circle(int r) {
        radius = r;
    }

    public void setRadius(int r) {
        radius = r;
    }
    public int getRadius() {
        return radius;
    }
    public void display() {
        System.out.println("radius = " + radius);
    }

    public double CalculateCircumference() {
        double a = 3.14 * radius * radius;
        return a;
    }
}


public class Main {
    public static void main(String args[]) {
        Circle c1 = new Circle();
        c1.setRadius(5);
        System.out.println("Circumference of Circle 1 is: " + c1.CalculateCircumference());
        int r = c1.getRadius();
        Circle c2 = new Circle(r);
        c2.setRadius(50);
        System.out.println("Circumference of Circle 2 is: " + c2.CalculateCircumference());

    }
}




class Rectangle {

    private int length, width;

    public Rectangle() {
        length = 5;
        width = 2;
    }

    public Rectangle(int l, int w) {
        length = l;
        width = w;
    }

    public void setLength(int l)

    {
        length = l;
    }

    public void setWidth(int w)
    {
        width = w;
    }

    public int getLength()
    {
        return length;
    }
    public int getWidth()

    {
        return width;
    }

    public int area() {
        return (length * width);
    }
}

public class Main {

    public static void main(String args[]){
        Rectangle rect = new Rectangle();
        rect.setLength(5);
        rect.setWidth(10);
        System.out.println("Area of Rectangle is: " + rect.area());
                System.out.println("Width of Rectangle is: " + rect.getWidth());
    }
}



class point{
    private int x;
    private int y;
    public point (){
        x=0;
        y=0;
    }
    public point(int a,int b){
        x=a;
        y=b;
    }
    public void setx(int a){
        x=a;;
    }
    public void sety(int b){
        y=b;
    }
    public int getx(){
        return x;
    }
    public int gety(){
        return y;
    }
    public void display(){
        System.out.println("The value of x: "+x+"\nThe value of y: "+y);
    }
}
public class Main{
    public static void main(String args[]){
        point p1=new point(10,20);
        p1.display();
    }
}

























