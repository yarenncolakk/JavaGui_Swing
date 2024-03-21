import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicScreenKeyboard extends JFrame {

    private JButton[] btn;
    private JPanel pnl1;
    private JTextField text1;
    private String[] text = {"one","two","three","four","five","six","seven","eight","nine"};
    public BasicScreenKeyboard()
    {
        setLayout(new GridLayout(2,3));
        btn = new JButton[9];

        text1 = new JTextField();

        pnl1 = new JPanel();

        for(int i = 0; i < btn.length; i++) //index
        {
            btn[i] = new JButton(text[i]);

            //int finalI = i+1; //değerler rakam olarak gelir
            int finalI = i; //actionListener da kullanabilmek için.

            btn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //text1.setText(text1.getText() + " " + finalI); // rakamlar gelir
                    text1.setText(text1.getText() + " " + text[finalI]);
                }
            });
            pnl1.add(btn[i]);

        }

        add(text1);
        add(pnl1);


        setTitle("Basic Screen Keyboard");
        setSize(300,300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new BasicScreenKeyboard();
    }
}

