import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class MouseTrackerFrame extends JFrame implements MouseMotionListener {

    private JPanel pnl;
    private JLabel lbl;

    public MouseTrackerFrame()
    {
        pnl = new JPanel();
        lbl = new JLabel("deneme");

        pnl.setBackground(Color.pink);
        pnl.addMouseMotionListener(this);

        add(pnl, BorderLayout.CENTER);
        add(lbl, BorderLayout.NORTH);

        setTitle("Testing with MouseTracker");
        setSize(300,300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MouseTrackerFrame();

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Dragged...");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("Mouse Moved...");

        //mouse hareket ettikçe koordinatlar yazsın.
        lbl.setText("Coordinate: (" + e.getX() + "," + e.getY() + ")");

        //mouse hareket ettikçe random renkler gelsin
        Random rnd = new Random();
        Color[] myColor = {Color.yellow, Color.pink, Color.red, Color.orange, Color.cyan, Color.black, Color.green};
        pnl.setBackground(myColor[rnd.nextInt(myColor.length)]);

    }
}
