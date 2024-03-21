import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BorderLayout1 extends JFrame {
    private JButton[] btn;
    private String[] text = {"NORTH", "SOUTH", "CENTER", "EAST", "WEST"};
    private String[] direction = {BorderLayout.NORTH, BorderLayout.SOUTH, BorderLayout.CENTER, BorderLayout.EAST, BorderLayout.WEST};
    private Icon[] icon = {
            new ImageIcon(getClass().getResource("west.png")),
            new ImageIcon(getClass().getResource("west.png")),
            new ImageIcon(getClass().getResource("west.png")),
            new ImageIcon(getClass().getResource("west.png")),
            new ImageIcon(getClass().getResource("west.png"))};


    public BorderLayout1()
    {
        btn = new JButton[5];

        Random rnd = new Random();

        for(int i = 0; i <btn.length; i++)
        {
            btn[i] = new JButton(text[i]);
            int rndNumber = rnd.nextInt(1,9);
            btn[i].setText(rndNumber + "! = " + factoriel(rndNumber));
            add(btn[i], direction[i]);
            btn[i].setIcon(icon[i]);
        }

        setTitle("Testing with BorderLayout");
        setSize(400,400);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public int factoriel(int number)
    {
        int result = 1;
        for(int i = 1; i <= number; i++)
        {
            result = result * i;
        }
          return result;
    }

    public static void main(String[] args)
    {
        new BorderLayout1();
    }
}
