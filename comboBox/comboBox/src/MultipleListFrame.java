import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MultipleListFrame extends JFrame implements ListSelectionListener,ActionListener {
    private JList colorList, copyList;
    private String[] colors = {"green","blue","black","red","orange"};
    private JButton btn;

    public MultipleListFrame()
    {
        setLayout(new FlowLayout());
        colorList = new JList<>(colors);
        colorList.setVisibleRowCount(3);
        add(colorList);
        add(new JScrollPane(colorList));

        btn = new JButton("Copy>>");
        add(btn);
        btn.addActionListener(this);

        copyList = new JList<>();
        copyList.setVisibleRowCount(3);
        copyList.setFixedCellHeight(15);
        copyList.setFixedCellWidth(60);
        add(copyList);
        add(new JScrollPane(copyList));


        setTitle("Test with MultipleList");
        setSize(300,200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MultipleListFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
}
