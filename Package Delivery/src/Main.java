class Package{
    String sname;
    String sadress;
    String rname;
    String radress;
    double weight;
    Package(String sn,String sa,String rn,String ra,double w){
        this.sname=sn;
        this.sadress=sa;
        this.rname=rn;
        this.radress=ra;
        this.weight=w;
        if(w<=0){
            System.out.println("invalid weight");
        }
    }

    public double calculateCost(){
       return weight*110;
    }
    public void display(){
        System.out.println("The delivery Details are\nSender Name:"+sname+"\nSender Adress: "+sadress+"\nWeight: "+weight+"kg\n");
        System.out.println("Receiver name: "+rname+"\nReceiver Adress:"+radress+"\nDelivery charges:Rs "+calculateCost());
    }
}

class TwoDayPackage extends Package{

    TwoDayPackage(String sn, String sa, String rn, String ra, double w) {
        super(sn, sa, rn, ra, w);
    }
    @Override
    public double calculateCost(){
        return weight*150;
    }

}
class OvernightPackage extends Package{

    OvernightPackage(String sn, String sa, String rn, String ra, double w) {
        super(sn, sa, rn, ra, w);
    }
    @Override
    public double calculateCost(){
        return weight*200;
    }

}


public class Main{
    public static void main(String[] args) {
        Package p1=new TwoDayPackage("Habib","Faisalabad","Muzammil","Jhang",0.5);
        p1.display();
    }
}




















