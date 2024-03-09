import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class checkBoxFrame extends JFrame implements ItemListener{
    private JCheckBox check1, check2;
    private JTextField text1;
    public checkBoxFrame(){
        setLayout(new FlowLayout());

        check1 = new JCheckBox("Bold");
        check2 = new JCheckBox("Italic");

        text1 = new JTextField("Advance Java Programming");

        add(check1);
        add(check2);
        add(text1);

        check1.addItemListener(this);
        check2.addItemListener(this);

        setTitle("Testing with CheckBox");
        setVisible(true);
        setSize(300,150);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new checkBoxFrame();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(check1.isSelected()){
            Font font = null;
            font = new Font("Serif",Font.BOLD,13);
            text1.setFont(font);
        }
         if(check2.isSelected()){
            Font font = null;
            font = new Font("Serif",Font.ITALIC,13);
            text1.setFont(font);
        }
        if(check1.isSelected() && check2.isSelected()){
            Font font = null;
            font = new Font("Serif",Font.BOLD | Font.ITALIC,13);
            text1.setFont(font);
        }
        if(!check1.isSelected() && !check2.isSelected()){
            Font font = null;
            font = new Font("Dialog",Font.PLAIN,13);
            text1.setFont(font);
        }


    }
}
