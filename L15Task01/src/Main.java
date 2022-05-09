import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public JFrame frame;
    JPanel panel = new JPanel();

    public static void main(String[] args) {
        Main m = new Main();
        m.frame.setVisible(true);
    }

    Main(){
        initialize();
    }

    public void initialize(){
        frame = new JFrame("Window");
        frame.setBounds(100,100,800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        panel.setVisible(true);
        frame.getContentPane().add(panel);
        panel.setPreferredSize(new Dimension(400,300));
        GridLayout gl = new GridLayout(0,1);
        gl.setHgap(20);
        gl.setVgap(20);
        panel.setLayout(gl);
        panel.setBorder(new EmptyBorder(30,30,30,30));

        JTextField userName = new JTextField("Name");
        userName.setVisible(true);
        panel.add(userName);

        JTextField FatherName = new JTextField("Father Name");
        FatherName.setVisible(true);
        panel.add(FatherName);

        String[] gen = {"Male","Female"};
        JComboBox<String>gender = new JComboBox<String>(gen);
        gender.setVisible(true);
        panel.add(gender);

        JPasswordField pass = new JPasswordField();
        pass.setVisible(true);
        panel.add(pass);

        JButton btn = new JButton("Submit");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,userName.getText()+" Fathers Name : " + FatherName.getText()+" Gender is : " + gender.getSelectedItem().toString());
            }
        });
        btn.setVisible(true);
        panel.add(btn);

    }

}
