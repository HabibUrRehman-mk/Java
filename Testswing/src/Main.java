import javax.swing.*;

class Frame extends JFrame{
    public JFrame mainframe;
    public Frame(){
//        method 1
//        setTitle("main page");
//        setLayout(null);
//        setSize(500,500);
//        setVisible(true);

//        method 2 making frame
        JFrame mainframe=new JFrame("Main Page");
        mainframe.setLayout(null);
        mainframe.setSize(700,700);
        mainframe.setVisible(true);

        //button making and adding
        JButton b1=new JButton("Click me");
        b1.setBounds(250,600,150,50);
        mainframe.add(b1);
    }
}
public class Main  {
    public static void main(String[] args) {
        Frame f1=new Frame();
    }

}