import javax.swing.*;
import java.util.Arrays;
import java.util.Random;

public class Animals extends JFrame {
    Animals(){
        char[] vowel = {'a', 'e', 'i', 'o', 'u'};
        char[] consonat = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};

        Random rnd = new Random();

        int number = Integer.parseInt(JOptionPane.showInputDialog("How many animals do you want?")); //String değeri(JOption pane) int çevirdik.
        int letter = Integer.parseInt(JOptionPane.showInputDialog("How many letters do you want the animals names?"));
        String[] newNames = new String[number]; // yeni oluşan isimleri tutar
        String name = ""; //isim oluşturur

        try {
            for (int i = 0; i < number; i++){
                for (int j = 0; j < letter; j++){
                    if (j % 2 == 0){ // 1 sesli 1 sessiz harfli olması için
                        name += (consonat[rnd.nextInt(consonat.length)]);
                    }
                    else {
                        name += (vowel[rnd.nextInt(vowel.length)]);
                    }
                }
                newNames[i] = (name); //newName dizisinin elemanlarını name olarak tuttu.
                name = ""; //isim sıfırlandı
            }
        }catch (Exception exception){
            System.out.println("logged : " + exception);
        }
        finally {
            { // bu blok her türlü çalışır.
                System.out.println("These are your animals");
                //JOptionPane.showMessageDialog(null,"These are your animals");
            }
        }
        JOptionPane.showMessageDialog(null,"Names of animals: " + Arrays.toString(newNames));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Animals();
    }
}
