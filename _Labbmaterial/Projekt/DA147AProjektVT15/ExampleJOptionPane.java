package project;
import javax.swing.*;
import java.awt.*;

public class ExampleJOptionPane {
    public static void main(String[] args)  {
        JColor jcolor = new JColor();
        jcolor.setPreferredSize(new Dimension(200, 100));
        if(JOptionPane.showConfirmDialog(null, jcolor, "En färgväljare-dialog", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION) {
            // Här kan man avläsa olika värden i panelen som visas 
            System.out.println("Röd=" + jcolor.getRed() + 
                    ", Grön="+jcolor.getGreen() + 
                    ", Blå=" + jcolor.getBlue());
        }
    }
}

