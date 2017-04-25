import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 03.02.2012 - version 1.1 vom 4.2.2013
  * @Kirsten Marczyk - version
  */

public class StaedteRaten extends JFrame
{
  private JTextArea jTextArea1 = new JTextArea("");
  private JButton jButton1 = new JButton();
  ImageIcon icon = new ImageIcon( "bielefeld.jpg" );
  JLabel l1 = new JLabel( icon );

   public StaedteRaten()
    {
    }

  public StaedteRaten(String title)
  {
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 900;
    int frameHeight = 700;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    Container cp = getContentPane();
    cp.setLayout(null);
    this.getContentPane().setBackground(Color.yellow);

    jButton1.setBounds(310, 65, 217, 81);
    jButton1.setFont(new Font("MS Sans Serif", Font.PLAIN, 24));
    jButton1.setText("Staedteraten");
    jButton1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    l1.setBounds(200, 250, 450, 400);
    l1.setText("");
    l1.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
    cp.add(l1);
    // Bild sichtbar oder unsichtbar machen
    l1.setVisible(true);
    // Ende Komponenten

    //Hintergrund des Buttons �ndern
    jButton1.setBackground(Color.green);
    
    jTextArea1.setBackground(Color.green);
    jTextArea1.setFont(new Font("MS Sans Serif", Font.PLAIN, 18));
    jTextArea1.setText("Dieses Programm behauptet, dass es Staedte raten kann!\nProbieren Sie es aus ;)\nZum Starten bitte den Button 'Staedteraten' druecken!\nViel Spass!");
    jTextArea1.setBounds(195, 170, 455, 98);
    jTextArea1.setEditable(false);
    cp.add(jTextArea1);

    setResizable(true);
    setVisible(true);
  }

  public void jButton1_ActionPerformed(ActionEvent evt)
  {
    // hier wird ein neues Fenster aufgerufen
    new Raten();
  }


  public static void main(String[] args)
  {
    new StaedteRaten("Staedteraten");
  }
}
