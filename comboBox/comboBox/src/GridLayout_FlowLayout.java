import javax.swing.*;
import java.awt.*;

public class GridLayout_FlowLayout extends JFrame {

    private JButton[] btn;
    private String[] text = {"one","two","three","four","five","six"};

    private JTextField text1;
    private JPanel pnl1;
    public GridLayout_FlowLayout()
    {
        setLayout(new GridLayout(2,3));
        btn = new JButton[6];

        text1 = new JTextField();

        pnl1 = new JPanel();

        for(int i = 0; i < btn.length; i++)
        {
            btn[i] = new JButton(text[i]);
            pnl1.add(btn[i]);
        }

        add(pnl1);

        setTitle("Testing with Grid&FlowLayout");
        setSize(300,300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GridLayout_FlowLayout();
    }
}
