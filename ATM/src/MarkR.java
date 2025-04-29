class Marks {
    private int mark1;
    private int mark2;
    private int mark3;
    Marks(){
        mark1=mark2=mark3=0;
    }
    public void setmark(int a,int b,int c){
        mark1=a;
        mark2=b;
        mark3=c;
    }
    public void germark(){
        System.out.println("The marks are \nMark 1: "+mark1+"\nMark 2: "+mark2+"\nMark 3: "+mark3);
    }
    public void avaragemark(){
        System.out.println("The average of marks is "+(mark1+mark2+mark3)/3);
    }
}
public class MarkR{
    public static void main(String args[]){
        Marks muzammil=new Marks();
        muzammil.setmark(12,13,14);
        muzammil.germark();
        muzammil.avaragemark();
    }
}
