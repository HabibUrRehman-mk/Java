class Adress{
    private int streetno;
    private int houseno;
    private String city;
    private int citycode;
    public Adress(int a,int b,String c,int d){
        streetno=a;
        houseno=b;
        city=c;
        citycode=d;
    }
    public int getHouseno() {
        return houseno;
    }
    public void setHouseno(int houseno) {
        this.houseno = houseno;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public int getCitycode() {
        return citycode;
    }
    public void setCitycode(int citycode) {
        this.citycode = citycode;
    }
    public int getStreetno() {
        return streetno;
    }
    public void setStreetno(int streetno) {
        this.streetno = streetno;
    }
}

class Person{
    private Adress a1;
    private String name;
    Person(String n, Adress a){
        name = n;
        a1 = a;
    }
    public void display(){
        System.out.println("Name "+name);
        System.out.println("His adress is Street#"+a1.getStreetno()+" house#"+a1.getHouseno()+" "+a1.getCity()+" "+a1.getCitycode());
    }
}

class Book{
    private String bookname;
    private String publisher;
    private Person author;
    Book(String a,String b,Person c){
        bookname=a;
        publisher=b;
        author=c;
    }
    public void bookdisplay(){
        System.out.println("The name of book is "+bookname+" published by "+publisher+" The details of author are");
        author.display();
    }
}

class Main{
    public static void main(String[] args) {
        Adress a1=new Adress(39,67,"Faisalabad",37700);
        Person p1=new Person("Areeb",a1);
        Book b1=new Book("OOP","Carvan Publisher",p1);
        b1.bookdisplay();
    }
}

















