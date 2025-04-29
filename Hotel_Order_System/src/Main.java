import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main{
    public static void main(String[] args) {
        JFrame mainframe=new JFrame("Resturant ordering system");
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainframe.setSize(400,300);
        mainframe.setLayout(new BorderLayout());

        JLabel title=new JLabel("Welcome to Our Resturant",JLabel.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,18));
        mainframe.add(title,BorderLayout.NORTH);
        JButton calculatecost =new JButton("Calculate cost");

        JPanel centrepanel=new JPanel(new GridLayout(2,2,10,10));
        JLabel itemLabel=new JLabel("Select items");
        JComboBox<String> itembox =new JComboBox<>(new String[]{"Burger - Rs: 250","Pizza- Rs: 450","Pasta - Rs:550"});
        JLabel quantitylabel=new JLabel("Enter Quantity");
        JTextField quantityfield=new JTextField();

        centrepanel.add(itemLabel);
        centrepanel.add(itembox);
        centrepanel.add(quantitylabel);
        centrepanel.add(quantityfield);
        mainframe.add(centrepanel,BorderLayout.CENTER);

        JPanel southpanel=new JPanel(new FlowLayout());
        JLabel totallabel=new JLabel("Total cost: Rs 0");
        southpanel.add(calculatecost);
        southpanel.add(totallabel);
        mainframe.add(southpanel,BorderLayout.SOUTH);



        calculatecost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String selecteditem=(String) itembox.getSelectedItem();
                    int quantity = Integer.parseInt(quantityfield.getText());
                    int price=0;

                    if(selecteditem.contains("Burger")){
                        price=250;
                    }
                    else if(selecteditem.contains("Pizza")){
                        price=450;
                    }
                    else if(selecteditem.contains("Pasta")){
                        price=550;
                    }
                    int totalCost=price*quantity;
                    totallabel.setText("Total Cost: Rs "+totalCost);
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number for quantity.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });
        mainframe.setVisible(true);

    }
}