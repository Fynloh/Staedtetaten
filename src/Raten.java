//   Marienschule Bielefeld
//    Einfache Benutzeroberflaeche fuer das Staedteraten.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import javax.swing.event.*;

public class Raten extends JFrame implements ActionListener
{   
     public JTextField zeile;
     private JTextField jTextField1 = new JTextField("");
     ImageIcon icon = new ImageIcon( "bielefeld.jpg" );
     JLabel l1 = new JLabel( icon );
     private SolveTree meinSolveTree = new SolveTree();
     private KnopfControl meinKnopfControl = new KnopfControl (this, meinSolveTree);
     private final String startzeile = "Denken Sie sich eine Stadt aus. Weiter mit <Weiter>.";
    

    public Raten()
    {
    // Frame-Initialisierung
      super("Staedteraten");
      this.getContentPane().setBackground(Color.yellow);
      this.getContentPane().setLayout(new FlowLayout());

      // Panel f�r die Eingabemaske
      JPanel Eingabe = new JPanel();
      Eingabe.setLayout (new GridLayout (2,1));
      Eingabe.add (new Label("Dialogfeld fuer das Staedteraten"));
      zeile = new JTextField (45);
      zeile.setText (startzeile);
      Eingabe.add (zeile);
      this.getContentPane().add (Eingabe);
        
        
      //Panel f�r die Kn�pfe
      JPanel Knoepfe = new JPanel ();
      Knoepfe.setLayout (new GridLayout (4,1));
      JButton button1 = new JButton("Weiter");  
      button1.addActionListener(this);
      Knoepfe.add(button1);
      JButton button2 = new JButton("Ja");
      button2.addActionListener(this);
      Knoepfe. add(button2);
      JButton button3 = new JButton("Nein");
      button3.addActionListener(this);
      Knoepfe. add(button3);
      JButton button4 = new JButton("Ende");
      button4.addActionListener(this);
      Knoepfe.add(button4);
      this.getContentPane().add (Knoepfe);
      int frameWidth = 900;
      int frameHeight = 700;
      setSize(frameWidth, frameHeight);
      Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
      int x = (d.width - getSize().width) / 2;
      int y = (d.height - getSize().height) / 2;
      setLocation(x, y);
      Container cp = getContentPane();
      setVisible(true);
      
      cp.setLayout(null);
      
      Eingabe.setBounds(180, 150, 500, 81);
      Knoepfe.setBounds(680, 150, 90, 81);
      
      l1.setBounds(200, 250, 450, 400);
      l1.setText("");
      l1.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
      cp.add(l1);
      l1.setVisible(true);

      jTextField1.setBackground(Color.yellow);
      jTextField1.setFont(new Font("MS Sans Serif", Font.PLAIN, 24));
      jTextField1.setText("                        Staedteraten");
      jTextField1.setBounds(180, 30, 500, 81);
      jTextField1.setEditable(false);
      cp.add(jTextField1);

   }

    public void actionPerformed(ActionEvent event)
    { 
      String cmd = event.getActionCommand();
      meinKnopfControl.automat (cmd);
    } 
    
    public static void main(String[] args)
    {
        Raten wnd = new Raten();
        wnd.setSize(900,700);
        wnd.setVisible(true);
        wnd.setResizable(true);
    }
}