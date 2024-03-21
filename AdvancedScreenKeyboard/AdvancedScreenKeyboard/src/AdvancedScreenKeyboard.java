import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdvancedScreenKeyboard extends JFrame {
    private String[] uppercase = {"\"","1","2","3","4","5","6","7","8","9","0","*","-","Del",
                                  "Tab","Q","W","E","R","T","Y","U","I","O","P","Ğ","Ü","Enter",
                                  "Caps","A","S","D","F","G","H","J","K","L","Ş","İ",","," ",
                                  "Shift","<","Z","X","C","V","B","N","M","Ö","Ç",".","⬆","Shift",
                                  "fn","control","option","command"," "," ","Space"," "," ","command",
                                  "option","⬅","⬇ ","➡",};
    private String[] lowercase = {"\"","1","2","3","4","5","6","7","8","9","0","*","-","Del",
                                  "Tab","q","w","e","r","t","y","u","ı","o","p","ğ","ü","Enter",
                                  "Caps","a","s","d","f","g","h","j","k","l","ş","i",","," ",
                                  "Shift","<","z","x","c","v","b","n","m","ö","ç",".","⬆","Shift",
                                  "fn","control","option","command"," "," ","Space"," "," ","command",
                                  "option","⬅","⬇ ","➡",};

    private JButton[] btn;
    private JTextField txt;
    private JPanel pnl1;
    private boolean isCaps = false;
    private boolean isShift = false;
    public AdvancedScreenKeyboard(){

        setLayout(new BorderLayout());
        btn = new JButton[70];

        txt = new JTextField();
        txt.setFont(new Font("Dialog",Font.PLAIN,20));

        pnl1 = new JPanel();
        pnl1.setLayout(new GridLayout(5,14));

        for(int i = 0; i < btn.length; i++) //index
        {
            btn[i] = new JButton(uppercase[i]);

            int finalI = i;

            btn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String pressed = btn[finalI].getText(); //basılan tuşu pressed olsun.
                    if(pressed.equals("Del"))
                    {
                        try {
                            txt.setText(txt.getText(0,txt.getText().length()-1));//0.indexten başlayarak al son indexi azalt
                        }catch(Exception exception){
                            System.out.println(exception);
                        }
                    }
                    else if(pressed.equals("Tab"))
                    {
                        txt.setText(txt.getText() + "    ");
                    }
                    else if(pressed.equals("Space"))
                    {
                        txt.setText(txt.getText() + " ");
                    }
                    else if(pressed.equals("Enter"))
                    {
                        JOptionPane.showMessageDialog(null,"Enter is clicked...");
                    }
                    else if(pressed.equals("Caps") || pressed.equals("CAPS"))
                    {
                       isCaps = !isCaps; //true ise false, false ise true yapar.
                        updateKeyboardLayout();
                    }
                    else if(pressed.equals("Shift") || pressed.equals("SHIFT"))
                    {
                        isShift = !isShift;
                        updateKeyboardLayout();
                    }
                        else{
                            if(isCaps) { //true olup olmadığını kontrol eder
                                txt.setText(txt.getText() + uppercase[finalI]);
                            }
                            else if(isShift){
                                txt.setText(txt.getText() + uppercase[finalI]);
                                
                                isShift = !isShift;
                                updateKeyboardLayout();

                            }
                            else{
                                txt.setText(txt.getText() + lowercase[finalI]);
                            }


                    }

                }
            });

            pnl1.add(btn[i]);
        }

        updateKeyboardLayout();

        add(txt, BorderLayout.NORTH);
        add(pnl1, BorderLayout.CENTER);


        setTitle("Advanced Screen Keyboard");
        setSize(1200,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void updateKeyboardLayout(){
        if (isCaps) {
            btn[28].setText("CAPS");
        } else {
            btn[28].setText("Caps");
        }
       if (isShift) {
           btn[42].setText("SHIFT");
           btn[55].setText("SHIFT");
       }
       else {
           btn[42].setText("Shift");
           btn[55].setText("Shift");
       }
    }

    public static void main(String[] args) {
        new AdvancedScreenKeyboard();
    }
}
