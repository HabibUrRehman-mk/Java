import javax.swing.*;

public class Main{


    public static void main(String[] args) {
        JFrame mainframe=new JFrame("Test");
        mainframe.setSize(1000,800);
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JTextField textarea=new JTextField();
        textarea.setText("hello");
        JButton showbutton=new JButton();

        mainframe.add(showbutton);
        mainframe.add(textarea);
        mainframe.setVisible(true);
    }
}