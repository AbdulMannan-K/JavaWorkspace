import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Display {

    public JFrame frame;

    Display(ArrayList<ArrayList<String>> data){
        initialize(data);
    }

    public void initialize(ArrayList<ArrayList<String>> data){
        frame = new JFrame("Table");
        frame.setBounds(100,100,800,600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());



        JPanel panel = new JPanel();

        frame.getContentPane().add(panel);

        JTable table = new JTable(new DefaultTableModel(new Object[]{"Inventry Name","Weight","Price"},0));
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        table.setBounds(100,100,500,500);
        for (ArrayList<String> datum : data) {
            model.addRow(new Object[]{datum.get(0), datum.get(1), datum.get(2)});
        }


        JScrollPane pane = new JScrollPane(table);

        panel.add(pane);
    }


}

