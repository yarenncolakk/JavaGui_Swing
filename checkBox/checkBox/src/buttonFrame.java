import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class buttonFrame extends JFrame implements ActionListener {
    Random rnd = new Random();
    private JButton btn1, btn2;
    public buttonFrame(){
        super("Button Pracrices...");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(500,700);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        btn1 = new JButton("My Tree");
        btn2 = new JButton("My House");

        //btn1.setIcon();

        //Icon image = new ImageIcon(getClass().getResource("Italy,Rome.jpg"));
        //Icon image2 = new ImageIcon(getClass().getResource("Italy,Capri.jpg"));

        Icon[] images = {
                new ImageIcon(getClass().getResource("Italy,Rome.jpeg")),
                new ImageIcon(getClass().getResource("Italy,Capri.jpeg")),
                new ImageIcon(getClass().getResource("France,Paris.jpeg")),
                new ImageIcon(getClass().getResource("Spain,Mallorca.jpeg"))
        };

        //btn1.setIcon(images[0]);
        //btn2.setIcon(images[1]);

        //btn1.setRolloverIcon(images[2]); //fotoğraf değişimi
        //btn2.setRolloverIcon(images[3]);

        //Random gelmesi için:
        btn1.setIcon(images[rnd.nextInt(images.length)]);
        btn2.setIcon(images[rnd.nextInt(images.length)]);

        btn1.setRolloverIcon(images[rnd.nextInt(images.length)]);
        btn2.setRolloverIcon(images[rnd.nextInt(images.length)]);

        btn1.addActionListener(this);
        btn2.addActionListener(this);

        add(btn1);
        add(btn2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new buttonFrame();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == btn1)
            JOptionPane.showMessageDialog(null, btn1.getText() + " is clicked", "Button Frame" ,JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, event.getActionCommand() + " is clicked ", "Button Frame", JOptionPane.INFORMATION_MESSAGE);

    }
}
