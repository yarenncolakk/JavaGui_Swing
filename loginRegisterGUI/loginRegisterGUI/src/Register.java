import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Register extends JFrame {
    Register(){
        super("Register");
        setLayout(null);
        setSize(430,550);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addComponents();
    }
    private void addComponents(){

        //register name label
        JLabel lblRegName = new JLabel("Name:");
        lblRegName.setBounds(60,150,150,40);
        lblRegName.setFont(new Font("Dialog", Font.PLAIN,20));
        add(lblRegName);

        //register name text
        JTextField txtRegName = new JTextField();
        txtRegName.setBounds(160,155,200,30);
        txtRegName.setFont(new Font("Dialog",Font.PLAIN,18));
        add(txtRegName);

        //register surname label
        JLabel lblRegSname = new JLabel("Surname:");
        lblRegSname.setBounds(60,195,150,40);
        lblRegSname.setFont(new Font("Dialog",Font.PLAIN,20));
        add(lblRegSname);

        //register surname text
        JTextField txtRegSname = new JTextField();
        txtRegSname.setBounds(160,200,200,30);
        txtRegSname.setFont(new Font("Dialog",Font.PLAIN,18));
        add(txtRegSname);

        //register username label
        JLabel lblRegUsername = new JLabel("Username:");
        lblRegUsername.setBounds(60,240,150,40);
        lblRegUsername.setFont(new Font("Dialog", Font.PLAIN,20));
        add(lblRegUsername);

        //register username text
        JTextField txtRegUsername = new JTextField();
        txtRegUsername.setBounds(160,245,200,30);
        txtRegUsername.setFont(new Font("Dialog",Font.PLAIN,18));
        add(txtRegUsername);

        //register password label
        JLabel lblRegPassword = new JLabel("Password:");
        lblRegPassword.setBounds(60,285,150,40);
        lblRegPassword.setFont(new Font("Dialog", Font.PLAIN,20));
        add(lblRegPassword);

        //password text
        JPasswordField txtRegPassword = new JPasswordField();
        txtRegPassword.setBounds(160,290,200,30);
        txtRegPassword.setFont(new Font("Dialog", Font.PLAIN,18));
        add(txtRegPassword);

        //register pink label
        JLabel lblreg = new JLabel("Register");
        lblreg.setForeground(Color.PINK);
        lblreg.setBounds(130,5,250,200);
        lblreg.setFont(new Font("Snell Roundhand",Font.BOLD ,40));
        add(lblreg);

        //register button
        JButton btnRegister = new JButton("Register");
        btnRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRegister.setBounds(280,360,80,35);
        add(btnRegister);

        //register button action
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtRegName.getText().isEmpty() ||
                txtRegSname.getText().isEmpty() ||
                txtRegUsername.getText().isEmpty()||
                String.valueOf(txtRegPassword.getPassword()).isEmpty()){
                    JOptionPane.showMessageDialog(null,
                            "No field can be left blank on the registration. Please fill the blank fields!");
                }else{
                    Login login = new Login(); //kayıt olduktan sonra login sayfası açıldı.
                    login.username = txtRegUsername.getText(); //register username, login username eşitlendi.
                    login.password = String.valueOf(txtRegPassword.getPassword());
                    JOptionPane.showMessageDialog(null,"You successfully registered!");
                    setVisible(false); // kayıt olunduktan sonra register sayfası kapansın. sadece login sayfası kalsın.
                }
            }
        });

        //login label
        JLabel lblRegLogin = new JLabel("You have an account? Login here!");
        lblRegLogin.setForeground(Color.PINK);
        lblRegLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblRegLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new Login().setVisible(true);
            }
        });
        lblRegLogin.setBounds(85,420,270,50);
        lblRegLogin.setFont(new Font("Dialog",Font.ITALIC | Font.BOLD,14));
        add(lblRegLogin);




    }

}
