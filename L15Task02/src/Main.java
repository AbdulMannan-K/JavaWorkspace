import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {


    public JFrame frame;
    JPanel panel = new JPanel();

    public static void main(String[] args) {
        Main m = new Main();
        m.frame.setVisible(true);
    }

    Main(){
        initializer();
    }

    public void initializer(){
        frame = new JFrame("Window");
        frame.setBounds(100,100,800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());


        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

        panel.setVisible(true);
        frame.getContentPane().add(panel);
        panel.setPreferredSize(new Dimension(400,300));
        GridLayout gl = new GridLayout(0,1);
        gl.setHgap(20);
        gl.setVgap(20);
        panel.setLayout(gl);
        panel.setBorder(new EmptyBorder(30,30,30,30));
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new FlowLayout());

        JTextField userName = new JTextField("Name");
        userName.setVisible(true);
        panel.add(userName);

        JTextField weight = new JTextField("Weight");
        weight.setVisible(true);
        panel.add(weight);

        JTextField price = new JTextField("Price");
        price.setVisible(true);
        panel.add(price);

        panel.add(subPanel);

        JButton add = new JButton("Add");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.add(new ArrayList<>(Arrays.asList(userName.getText(),weight.getText(),price.getText())));
            }
        });
        add.setVisible(true);
        subPanel.add(add);

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        cancel.setVisible(true);
        subPanel.add(cancel);

        JButton display = new JButton("Display");
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display display1 = new Display(data);
                display1.frame.setVisible(true);
            }
        });
        display.setVisible(true);
        subPanel.add(display);

    }

}