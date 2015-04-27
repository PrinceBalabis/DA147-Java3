package project;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class JColor extends JPanel {
  private JSlider red = new JSlider(0,255,128),
                  green = new JSlider(0,255,128),
                  blue = new JSlider(0,255,128);

  public JColor() {
    this.setLayout(new GridLayout(1,3,20,20));
    ChangeListener cl = new CL();
    red.addChangeListener(cl);
    green.addChangeListener(cl);
    blue.addChangeListener(cl);
    red.setBackground(Color.red);
    green.setBackground(Color.green);
    blue.setBackground(Color.blue);
    setBackground(new Color(red.getValue(),green.getValue(),blue.getValue()));
    add(red);
    add(blue);
    add(green);
  }
  
  public Insets getInsets() {
      return(new Insets(20,20,20,20));
  }
  
  public int getRed() {
      return red.getValue();
  }

  public int getGreen() {
      return green.getValue();
  }

  public int getBlue() {
      return blue.getValue();
  }

  private class CL implements ChangeListener {
    public void stateChanged(ChangeEvent e) {
      Color color = new Color(red.getValue(), green.getValue(), blue.getValue());
      setBackground(color);
    }
  }

}
