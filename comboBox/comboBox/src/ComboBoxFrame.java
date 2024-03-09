import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ComboBoxFrame extends JFrame implements ItemListener {
    private JComboBox<String> combo;
    private String[] images = {"Seçiniz","çiçek1.jpeg","çiçek2.jpeg","çiçek3.jpeg","çiçek4.jpeg"};

    private Icon[] iconImg = {new ImageIcon(getClass().getResource("çiçek1.jpeg")),
            new ImageIcon(getClass().getResource("çiçek2.jpeg")),
            new ImageIcon(getClass().getResource("çiçek3.jpeg")),
            new ImageIcon(getClass().getResource("çiçek4.jpeg"))};

    private JLabel lbl;


    public ComboBoxFrame(){
        super("Testing with JCombobox");
        setLayout(new FlowLayout());

        combo = new JComboBox<>(images);
        add(combo);
        combo.addItemListener(this);

        lbl = new JLabel("deneme");
        add(lbl);

        setVisible(true);
        setSize(350,400);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        new ComboBoxFrame();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (combo.getSelectedIndex() == 0){
            lbl.setText("");
            lbl.setIcon(null);
        }
        else if(combo.getSelectedIndex() == 1){
            lbl.setText("Flowers");
            lbl.setIcon(iconImg[0]);
        }
        else if (combo.getSelectedIndex() == 2){
            lbl.setText("Lily");
            lbl.setIcon(iconImg[1]);
        }
        else if (combo.getSelectedIndex() == 3){
            lbl.setText("Tulip");
            lbl.setIcon(iconImg[2]);
        }
        else{
            lbl.setText("Flowers");
            lbl.setIcon(iconImg[3]);
        }

        //JOptionPane.showMessageDialog(null,"Selected...");
    }
}
