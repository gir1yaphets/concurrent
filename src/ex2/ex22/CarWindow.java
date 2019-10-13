package ex2.ex22;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CarWindow extends JFrame {

    CarWorld display;
    JButton addLeft;
    JButton addRight;

    public CarWindow() {

        Container c = getContentPane();

        c.setLayout(new BorderLayout());
        display = new CarWorld();


        c.add("Center", display);
        addLeft = new JButton("Add Left");
        addRight = new JButton("Add Right");

        addLeft.addActionListener(new ActionListener() {
                                      public void actionPerformed(ActionEvent e) {
                                          display.addCar(Car.REDCAR);
                                      }
                                  }
        );

        addRight.addActionListener(new ActionListener() {
                                       public void actionPerformed(ActionEvent e) {
                                           display.addCar(Car.BLUECAR);
                                       }
                                   }
        );


        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.add(addLeft);
        p1.add(addRight);
        c.add("South", p1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
