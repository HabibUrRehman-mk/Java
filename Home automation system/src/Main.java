import javax.swing.*;
import java.awt.*;


public class Main{
    public static void main(String[] args) {
        JFrame mainframe=new JFrame("Home automation system");
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setSize(400,300);
        mainframe.setLayout(new GridLayout(3,1,10,10));

        JPanel lightpanel=new JPanel();
        JLabel lightlabel=new JLabel("Lights");
        JButton lighONtbutton =new JButton("ON");
        JButton lightOFFbutton=new JButton("OFF");
        lightpanel.add(lightlabel);
        lightpanel.add(lighONtbutton);
        lightpanel.add(lightOFFbutton);

        JPanel fanpanel=new JPanel();
        JLabel fanlabel=new JLabel("Fans");
        JButton fanONbutton =new JButton("ON");
        JButton fanOFFbutton=new JButton("OFF");
        fanpanel.add(fanlabel);
        fanpanel.add(fanONbutton);
        fanpanel.add(fanOFFbutton);

        JPanel acpanel=new JPanel();
        JLabel aclabel=new JLabel("AC Temperature");
        JSlider acslider=new JSlider(18, 30,22);
        JLabel tempdisplay=new JLabel("22 C");
        acslider.setMajorTickSpacing(2);
        acslider.setPaintTicks(true);
        acslider.setPaintLabels(true);
        acpanel.add(aclabel);
        acpanel.add(acslider);
        acpanel.add(tempdisplay);

        lighONtbutton.addActionListener(e->JOptionPane.showMessageDialog(mainframe,"Light turned ON"));
        lightOFFbutton.addActionListener(e->JOptionPane.showMessageDialog(mainframe,"Light turned OFF"));

        fanONbutton.addActionListener(e->JOptionPane.showMessageDialog(mainframe,"Fan turned ON"));
        fanOFFbutton.addActionListener(e->JOptionPane.showMessageDialog(mainframe,"Fan turned OFF"));
        
        acslider.addChangeListener(e->tempdisplay.setText(acslider.getValue()+" C"));

        mainframe.add(lightpanel);
        mainframe.add(fanpanel);
        mainframe.add(acpanel);
        mainframe.setVisible(true);
    }
}