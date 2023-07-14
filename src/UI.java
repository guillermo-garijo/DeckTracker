import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class UI implements Observer {
    private JPanel display;
    private JTable deckData;
    private static final Vector<String> columns = new Vector<>(Arrays.asList("Name", "Copies"));
    private DefaultTableModel model;

    public UI() {

    }

    public void start(){
        JFrame frame = new JFrame("App");
        frame.setContentPane(display);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        model = new DefaultTableModel(new Vector(), columns);
        deckData.setModel(model);
        deckData.getColumnModel().getColumn(1).setMaxWidth(20);
    }


    @Override
    public void update(Observable observable, Object o) {
        //DefaultTableModel model = new DefaultTableModel((Vector<Vector<String>>)o, columns);
        //deckData.setModel(model);
        model.setDataVector((Vector<Vector<String>>)o, columns);
        deckData.getColumnModel().getColumn(1).setMaxWidth(20);
        deckData.getColumnModel().getColumn(0).setMaxWidth(150);

    }
}
