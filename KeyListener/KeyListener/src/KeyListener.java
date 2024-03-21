import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

//bir harfe basıldığında text areadaki yazı değişsin:

public class KeyListener extends JFrame implements java.awt.event.KeyListener {

    private JTextArea textArea;
    private JLabel lbl;

    public KeyListener() {
        //setLayout(new FlowLayout());
        //setLayout(new BorderLayout()); //bunu eklemeden de componentlerde kullanabiliriz.
        textArea = new JTextArea(12, 15);
        add(textArea, BorderLayout.CENTER);

        textArea.addKeyListener(this);

        lbl = new JLabel("Deneme...");
        add(lbl, BorderLayout.NORTH);

        setTitle("Testing with KeyListener");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new KeyListener();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        lbl.setText(String.valueOf(e.getKeyChar())); //tıklanan her harfi label textine eşitler.

//        //key code
//        if(e.getKeyCode() == 65)
//        {
//            lbl.setText("a");
//        }
//        else if(e.getKeyCode() == 66)
//        {
//            lbl.setText("b");
//        }

//        //key char
//        if(e.getKeyChar() == 'a')
//        {
//            lbl.setText("a");
//        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}




