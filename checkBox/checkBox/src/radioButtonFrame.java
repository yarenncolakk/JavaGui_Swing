import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class radioButtonFrame extends JFrame implements ItemListener {
    private JRadioButton rbtn1, rbtn2;
    private ButtonGroup grp;
    private JTextField text1;
    public radioButtonFrame()
        {
            setLayout(new FlowLayout());

            rbtn1 = new JRadioButton("Female");
            rbtn2 = new JRadioButton("Male");
            text1 = new JTextField(12);

            rbtn1.addItemListener(this);
            rbtn2.addItemListener(this);

            grp = new ButtonGroup();
            grp.add(rbtn1);
            grp.add(rbtn2);

            add(rbtn1);
            add(rbtn2);
            add(text1);

            setTitle("Testing with RadioButton");
            setVisible(true);
            setSize(200, 150);
            setLocationRelativeTo(null);

        }

    public static void main(String[] args) {
        new radioButtonFrame();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if (rbtn1.isSelected())
            text1.setText(rbtn1.getText());
        else text1.setText(rbtn2.getText());
    }
}
