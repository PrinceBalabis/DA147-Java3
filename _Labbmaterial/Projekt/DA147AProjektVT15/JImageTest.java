package project;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/*
Programmet visar hur man skapar ett JImage-objekt vilket placeras i en container (här JFrame). JImage-objektet visar en bild. Denna bild skalas om så att hela bilden syns i komponenten. Alla proportioner behålls.

Tredje raden i main-metoden läser in en bild från hårddisken. Ändra till en bild som finns på din hårddisk. Bildformatet ska var jpg, gif eller png.

Fjärde raden i main-metoden skapar ett JImage-objekt. Det första argumentet till konstruktorn är den inlästa bilden och det andra argumentet avgör det sätt som bilden visas på. Bilden kan visas på tre sätt:
* JImage.SCALE - bilden skalas om så att hela bilden syns. Proportionerna i bilden behålls.
* JImage.FIT - Bilden skalas om till JImage-komponentens storlek
* JImage.NORMAL - Bilden visas i normal storlek

För att visa en bild behöver du alltså:
1. Skapa ett ImageIcon-objekt där du anger filens namn + fullständig sökväg som argument
2. Skapa ett JImage-objekt med ImageIcon-objektet i punkt 1 som input. Du bör även ange på vilket sätt bilden ska visas (se ovan)

Nödvändiga filer för kompilering:
* JImageTest.java
* JImage.java
Båda filerna ska placeras i paketet projekt.

Testkörning:
Starta programmet med JImageTest. När ett fönster innehållande en bild visar sig så ändra storlek på fönstret. Du ser då hur bildens storlek förändras.

Ett JImage-objekt kan placeras i en Container på samma sätt som andra grafiska komponenter.
*/

public class JImageTest extends JPanel {
    private ImageIcon imageIcon = new ImageIcon("C:/bilder/gubbe.jpg");
    private JImage image = new JImage(imageIcon, JImage.NORMAL);
    private JLabel lblState = new JLabel("state = NORMAL");
    private int state = JImage.NORMAL;
    
    public JImageTest() {
        JButton btnChange = new JButton("Ändra bildvisning");
        setPreferredSize( new Dimension(500,300) );
        setLayout(new BorderLayout());
        image.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        btnChange.addActionListener(new AL());
        add(lblState, BorderLayout.NORTH);
        add(image,BorderLayout.CENTER);
        add(btnChange,BorderLayout.SOUTH);
    }
    
    private class AL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            switch( state ) {
                case JImage.NORMAL : 
                    state = JImage.FIT;
                    lblState.setText("state = FIT");
                    break;
                case JImage.FIT :
                    state = JImage.SCALE;
                    lblState.setText("state = SCALE");
                    break;
                case JImage.SCALE :
                    state = JImage.NORMAL;
                    lblState.setText("state = NORMAL");
                    break;
            }
            image.setState( state );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame(); 
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JImageTest());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
