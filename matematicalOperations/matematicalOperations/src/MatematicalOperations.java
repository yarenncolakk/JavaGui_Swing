import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MatematicalOperations extends JFrame implements ActionListener {
    private JTextField number1, number2, total;
    private JLabel lblOperations, lblEqual;
    private JButton btnCalculate;

    private String[] operators = {"+","-","x","/"};
    Random rnd = new Random();
    MatematicalOperations(){
        setLayout(null);

        setSize(380,180);
        getContentPane().setBackground(Color.pink);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        //number1
        number1 = new JTextField();
        number1.setBounds(20,10,80,50);
        number1.setFont(new Font("Dialog",Font.BOLD,20));
        number1.setForeground(Color.PINK);
        number1.setHorizontalAlignment(SwingConstants.CENTER); //yazı ortadan başlasın
        add(number1);

        //lblOperations
        lblOperations = new JLabel("?");
        lblOperations.setBounds(120,10,50,50);
        lblOperations.setFont(new Font("Dialog",Font.BOLD,15));
        add(lblOperations);

        //number2
        number2 = new JTextField();
        number2.setBounds(150,10,80,50);
        number2.setForeground(Color.PINK);
        number2.setFont(new Font("Dialog",Font.BOLD,20));
        number2.setHorizontalAlignment(SwingConstants.CENTER);
        add(number2);

        //lblEqual
        lblEqual = new JLabel("=");
        lblEqual.setBounds(250,10,50,50);
        lblEqual.setFont(new Font("Dialog",Font.BOLD,15));
        add(lblEqual);

        //total
        total = new JTextField();
        total.setBounds(280,10,80,50);
        total.setFont(new Font("Dialog",Font.BOLD,20));
        total.setForeground(Color.PINK);
        total.setHorizontalAlignment(SwingConstants.CENTER);
        total.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        total.setFocusable(false); //total değeriyle oynanamaz. üstüne basılıp değişiklik yapılamaz
        add(total);

        //btnCalculate
        btnCalculate = new JButton("Calculate!");
        btnCalculate.setFont(new Font("Dialog",Font.ITALIC,15));
        btnCalculate.setForeground(Color.PINK);
        btnCalculate.setBounds(20,70,340,60);
        btnCalculate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btnCalculate);

        btnCalculate.addActionListener(this);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MatematicalOperations();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            lblOperations.setText(operators[rnd.nextInt(operators.length)]);

            if(lblOperations.getText() == "+"){
                total.setText(String.valueOf(Integer.parseInt(number1.getText()) + Integer.parseInt(number2.getText())));
            }
            if(lblOperations.getText() == "-"){
                total.setText(String.valueOf(Integer.parseInt(number1.getText()) - Integer.parseInt(number2.getText())));
            }
            if(lblOperations.getText() == "x"){
                total.setText(String.valueOf(Integer.parseInt(number1.getText()) * Integer.parseInt(number2.getText())));
            }
            if(lblOperations.getText() == "/"){
                total.setText(String.valueOf(Integer.parseInt(number1.getText()) / Integer.parseInt(number2.getText())));
            }
        }catch(Exception exception){
            System.out.println("Error: " + exception);
            total.setText("Error");
        }
        
    }
}