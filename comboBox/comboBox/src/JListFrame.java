import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class JListFrame extends JFrame implements ListSelectionListener {

    private JList listColor;
    private String[] colors = {"pink","green","blue","orange","yellow"};
    //private Color[] myColors = {Color.green, Color.yellow, Color.red};
    public JListFrame()
    {
        setLayout(new FlowLayout());

        listColor = new JList(colors);
        listColor.setVisibleRowCount(3); //3 tanesi gözüksün kayan çubukla aşağı inelim.
        add(listColor); // önce listColor ekledik sonra kayan çubuk ekleyeceğiz.
        add(new JScrollPane(listColor)); //listColor a kayan çubuk ekledik

        //ListSelectionListener ekledik
        listColor.addListSelectionListener(this);


        setLocationRelativeTo(null);
        setVisible(true);
        setSize(300,300);
    }

    public static void main(String[] args) {
        new JListFrame();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (listColor.getSelectedIndex() == 0){
            getContentPane().setBackground(Color.pink); //arka plan değiştirmek için getContentPane
            setBackground(Color.pink); //yukarı kısım
        }
        else if (listColor.getSelectedIndex() == 1){
            getContentPane().setBackground(Color.green);
            setBackground(Color.green);
        }
        else if (listColor.getSelectedIndex() == 2){
            getContentPane().setBackground(Color.cyan);
            setBackground(Color.blue);
        }
        else if (listColor.getSelectedIndex() == 3){
            getContentPane().setBackground(Color.orange);
            setBackground(Color.orange);
        }
        else if (listColor.getSelectedIndex() == 4){
            getContentPane().setBackground(Color.yellow);
            setBackground(Color.yellow);
        }
    }

}

