import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class Login extends JFrame {
    Login(){
        super("Login");
        setLayout(null); //konum null olursa yerlerini kendimiz belirleriz.
        setSize(430,550); //çerçevenin
        setLocationRelativeTo(null); //uygulamanın ekranın ortasında çalışmasını sağlar.
        setVisible(true);
        setResizable(false); //yeniden boyutlanabilmesini kapatırsak girdiğimiz ölçülerde sabit kalır.
        setDefaultCloseOperation(EXIT_ON_CLOSE); //çarpı tuşuna basıldığında uygulama tamamen kapanır.

        addComponents();
    }
    String username;
    String password;
    private void addComponents(){

        //profile image
        JLabel lblImg = new JLabel(loadImage("src/profile.png")); //copy path
        lblImg.setBounds(135,50,170,170);
        add(lblImg);

        //username label
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(60,250,150,40); //label konum ve sınırlar tanımlanır.
        lblUsername.setFont(new Font("Dialog", Font.PLAIN,20));
        add(lblUsername);

        //username text
        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(160,255,200,30);
        txtUsername.setFont(new Font("Dialog", Font.PLAIN,18));
        add(txtUsername);

        //password label
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(60,295,150,40);
        lblPassword.setFont(new Font("Dialog", Font.PLAIN,20));
        add(lblPassword);

        //password text
        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(160,300,200,30);
        txtPassword.setFont(new Font("Dialog", Font.PLAIN,20));
        add(txtPassword);

        //forgot password label
        JLabel lblForgotPass = new JLabel("Forgot password?");
        lblForgotPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblForgotPass.setForeground(Color.PINK);
        lblForgotPass.setBounds(255,325,200,30);
        lblForgotPass.setFont(new Font("Dialog", Font.PLAIN,13));

        //forgot password test
        lblForgotPass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String mail = JOptionPane.showInputDialog("Please enter your e-mail!");
                if(!mail.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Check your e-mail!");
                }
            }
        });
        add(lblForgotPass);

        //login button
        JButton btnLogin = new JButton("Login");
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogin.setBounds(280,360,80,35);
        add(btnLogin);

        //login test
        btnLogin.addActionListener(new ActionListener() { //dışarıdan implement etmedik.
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtUsername.getText().equals(username) && // == operatörü yerine equals kullanılır.
                   String.valueOf(txtPassword.getPassword()).equals(password)) //getPassword metodu string ifadeye dönüştürülmeli.
                    //String.valueOf un içine yazılan her şey string olur.
                {
                    JOptionPane.showMessageDialog(null,"Successfully logged in!");
                }
                if(!txtUsername.getText().equals(username) &&
                        !String.valueOf(txtPassword.getPassword()).equals(password)){
                    if(txtUsername.getText().isEmpty() &&
                            String.valueOf(txtPassword.getPassword()).isEmpty()){
                        JOptionPane.showMessageDialog(null,"Username or password cannot be empty!");
                    }else {
                        JOptionPane.showMessageDialog(null, "There is no such as account. Please create an account!");
                    }
                }
                if(!txtUsername.getText().equals(username) && //username yanlışsa ve password doğruysa
                        String.valueOf(txtPassword.getPassword()).equals(password))
                {
                    JOptionPane.showMessageDialog(null,"Username is incorrect!");
                }
                if(!String.valueOf(txtPassword.getPassword()).equals(password) && //password yanlışsa ve username doğruysa
                        txtUsername.getText().equals(username))
                {
                    JOptionPane.showMessageDialog(null,"Password is incorrect!");
                }
            }
        });

        //register label
        JLabel lblRegister = new JLabel("Not a user? Create an account here!");
        lblRegister.setForeground(Color.PINK); //yazıyı mavi yapmak için.
        lblRegister.setCursor(new Cursor(Cursor.HAND_CURSOR)); //üstüne gelince "el" imleci gelir.
        lblRegister.setBounds(80,420,270,50);
        lblRegister.setFont(new Font("Dialog",Font.ITALIC | Font.BOLD,14));
        //lblRegister.setVerticalTextPosition(SwingConstants.BOTTOM);
        //lblRegister.setHorizontalTextPosition(SwingConstants.CENTER);
        add(lblRegister);

        //register here
        lblRegister.addMouseListener(new MouseAdapter() { //mouse ile üzerine basıldığında
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new Register().setVisible(true);
            }
        });
    }

    //profile image
    private ImageIcon loadImage(String resourcePath){
        try {
            BufferedImage img = ImageIO.read(new File(resourcePath));
            return new ImageIcon(img);
        }catch (Exception exception){
            System.out.println("Logged: " + exception);
            return null;
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() { new Login();}
        });
    }
}
