//import javax.swing.*;
//import java.awt.*;
//
//class Main{
//    public static void main(String[] args) {
//        JFrame mainframe=new JFrame("Main");
//        mainframe.setSize(500,500);
//        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        mainframe.setLayout(new BorderLayout());
//        JPanel customerpanel =new JPanel(new FlowLayout());
//        JButton addcustomer =new JButton("Add customer");
//        JLabel name=new JLabel("Name");
//        name.setFont(new Font("Arial",Font.BOLD,14));
//        JTextField namefield=new JTextField(20);
//        String namefieldtext;
//        namefieldtext=namefield.getText();
//
//        String[] gender ={"Male","Female"};
//        JComboBox <String> genderbox=new JComboBox<>(gender);
//        genderbox.getSelectedItem();
//        customerpanel.add(name);
//        customerpanel.add(namefield);
//        customerpanel.add(genderbox);
//        customerpanel.add(addcustomer);
//        addcustomer.addActionListener(e -> {
//            System.out.println(namefield.getText()+genderbox.getSelectedItem()+"customer is added");
//        });
//
//        mainframe.add(customerpanel, BorderLayout.NORTH);
//
//        mainframe.setVisible(true);
//    }
//}


import java.io.*;

//class Student{
//    String name;
//    String address;
//    Student(){
//        System.out.println("Object created");
//    }
//    Student(String n,String a){
//        this.name=n;
//        this.address=a;
//    }
//    public void display(){
//        System.out.println("Name of student is "+this.name+" and address is "+this.address);
//    }
//}
//class Teacher extends Student{
//    Teacher(){
//        super();
//    }
//}
//
class Main{
    public static void main(String[] args)  {
//        Student s1 =new Student("Hammad","Sahiwal");
//        Student s2=new Student("Muzamil","Jhang");
//        s2.display();
        String filename="example.txt";
       try (BufferedWriter writer =new BufferedWriter(new FileWriter(filename,true))){
           writer.newLine();
           writer.write("/n hello");
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    try(BufferedReader reader =new BufferedReader(new FileReader(filename))) {
        String line=reader.readLine();
        System.out.println(line);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    }
}