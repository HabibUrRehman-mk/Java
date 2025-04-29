class HotDog{
    int Idnum;
    int simplecount;
    int shamicount;
    int zingercount;
    HotDog(int a){
        if (int a ==1){
            simplecount++;
        }
        else if (int a==2){
            shamicount++;
        }
        else if (int a==3){
            zingercount++;
        }
        else{
            System.out.println("invalid id");
        }
    }
    public int getShamicount() {
        return shamicount;
    }

    public int getSimplecount() {

        return simplecount;
    }

    public int getZingercount() {

        return zingercount;
    }
}

public class HotDogR {
    public static void main(String[] args) {
        HotDog h1=new HotDog(1);
        HotDog h2=new HotDog(1);
        HotDog h3=new HotDog(2);
        HotDog h4=new HotDog(2);
        HotDog h5=new HotDog(3);
        h1.zingercount();
        h1.shamicount();
        h1.simplecount();
    }
}

