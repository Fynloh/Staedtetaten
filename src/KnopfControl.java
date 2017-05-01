import javax.swing.JOptionPane;

class KnopfControl
{
   private final int startZ = 0, ratenZ = 1, erweitern1Z = 2,
                      erweitern2Z = 3,erweitern3Z = 4, neuStartZ = 5,  
                      erweitern4Z = 6, erweitern5Z = 7, erweitern6Z = 8;
  
  private int aktuellerZustand = startZ;
  
  private Raten meinRaten;
  private SolveTree meinSolveTree;
  private String alteStadt, neueStadt, frage;
  private final String startzeile = "Denken Sie sich eine Stadt aus. Weiter mit <Weiter>.";
     
  // Konstruktor sorgt dafuer, dass die Moeglichkeiten der
  // Klassen Raten und SolveTree in KnopfControl bekannt sind.
  
  KnopfControl (Raten paraRaten, SolveTree paraSolveTree)
  {
	meinSolveTree = paraSolveTree;
    meinRaten = paraRaten;
  }

  void automat (String cmd)
  {
    switch (aktuellerZustand) 
    {    
        case startZ:  bearbeiteStart (cmd);
        break;
        case ratenZ:  bearbeiteRaten (cmd);
        break;
        case neuStartZ:  neuStart (cmd);
        break;
        case erweitern1Z:  bearbeiteErweitern1 (cmd);
        break;
        case erweitern2Z:  bearbeiteErweitern2 (cmd);
        break;
        case erweitern4Z:  bearbeiteErweitern4 (cmd);
        break;
        case erweitern5Z:  bearbeiteErweitern5 (cmd);
        break;
        case erweitern6Z:  bearbeiteErweitern6 (cmd);
        break;
        case erweitern3Z:  bearbeiteErweitern3 (cmd);
        break;
    }
    
     if (cmd.equals ("Tiefe"))
    { 
    	System.out.println("Depth");
        JOptionPane.showMessageDialog (meinRaten, "Die Tiefe des Baums beträgt: "+ meinSolveTree.getDepth (meinSolveTree.getTree ()));
    }
  } 
    
  void bearbeiteStart (String cmd)
  {     
        if (cmd.equals("Ende")) 
        { 
          meinRaten.setVisible(false);
          meinRaten.dispose();
          System.exit(0);
        }
    else if (cmd.equals ("Weiter"))
         {
             String info = meinSolveTree.getRoot();
             meinRaten.zeile.setText (info);
             aktuellerZustand = ratenZ;
         }
  }   
  
  
  void bearbeiteRaten (String cmd)
  {    
    if (cmd.equals ("Nein"))
    {    
       if (!meinSolveTree.isLeaf())
       {
          meinSolveTree.downLeft ();
          String info = meinSolveTree.getRoot();
          if (!meinSolveTree.isLeaf ())
             meinRaten.zeile.setText (info);
          else
             meinRaten.zeile.setText ("Heisst die Stadt "+info+"?");
       }
       else
       {
         alteStadt = meinSolveTree.getRoot();
         meinRaten.zeile.setText ("Schade. Ich habe falsch geraten. Weiter mit <Weiter>.");
         aktuellerZustand = erweitern1Z;
       }  
    }
    else if (cmd.equals ("Ja"))
    {
      if (!meinSolveTree.isLeaf ())
      {
          meinSolveTree.downRight ();
          String info = meinSolveTree.getRoot();
          if (!meinSolveTree.isLeaf ())
            meinRaten.zeile.setText (info);
          else
            meinRaten.zeile.setText ("Heisst die Stadt "+info+"?");
      }   
      else
      {
         meinRaten.zeile.setText ("Juhu. Ich habe richtig geraten. Weiter mit <Weiter>.");
         aktuellerZustand = neuStartZ;
      }
    }
    else if (cmd.equals ("Ende"))
    { 
          meinRaten.setVisible(false);
          meinRaten.dispose();
          System.exit(0);
      }
    else if (cmd.equals ("Tiefe"))
    { 
    	System.out.println("Depth");
        JOptionPane.showMessageDialog (meinRaten, "Die Tiefe des Baums beträgt: "+ meinSolveTree.getDepth (meinSolveTree.getTree ()));
    }

  } 
  
  void neuStart (String cmd)
  {        
    if (cmd.equals ("Weiter"))
      {            
        meinSolveTree.reset();
        meinRaten.zeile.setText (startzeile);
        aktuellerZustand = startZ;
      }
     else if (cmd.equals ("Ende"))
    { 
          meinRaten.setVisible(false);
          meinRaten.dispose();
          System.exit(0);

    }
  } 

  void bearbeiteErweitern1 (String cmd)
  { 
    if (cmd.equals ("Weiter"))
    {           
        meinRaten.zeile.setText ("Wie heisst die richtige Stadt? <Weiter>.");
        aktuellerZustand = erweitern2Z;
      }
  } 
  
  void bearbeiteErweitern2 (String cmd)
  { 
    if (cmd.equals ("Weiter"))
      {           
          meinRaten.zeile.setText ("");
          aktuellerZustand = erweitern3Z;
      }
  }
  
  void bearbeiteErweitern3 (String cmd)
  { 
    if (cmd.equals ("Weiter"))
    {           
      neueStadt = meinRaten.zeile.getText ();
        meinRaten.zeile.setText ("Formulieren Sie eine Ja-Nein Frage um "+neueStadt+" und "+ alteStadt+" zu unterscheiden!");
        aktuellerZustand = erweitern4Z;
      }
  } 
  
  
  void bearbeiteErweitern4 (String cmd)
  { 
    if (cmd.equals ("Weiter"))
      {           
          meinRaten.zeile.setText ("");
          aktuellerZustand = erweitern5Z;
      }
  }

  void bearbeiteErweitern5 (String cmd)
  { 
    if (cmd.equals ("Weiter"))
    {           
        frage = meinRaten.zeile.getText ();
        meinRaten.zeile.setText ("Wie muss die Frage fuer " + neueStadt+"  beantwortet werden?");
        aktuellerZustand = erweitern6Z;
      }
  } 
  
  void bearbeiteErweitern6 (String cmd)
  { 
    if (cmd.equals ("Ja"))
    {           
      meinSolveTree.expand (frage, alteStadt, neueStadt);
      meinRaten.zeile.setText ("Jetzt kann ich es. Weiter mir <Weiter>"); 
      aktuellerZustand = neuStartZ;
      } 
      else if (cmd.equals ("Nein"))
    {           
      meinSolveTree.expand (frage, neueStadt, alteStadt);
      meinRaten.zeile.setText ("Jetzt kann ich es. Weiter mir <Weiter>");
      aktuellerZustand = neuStartZ;
    }
    meinRaten.showCityCount(meinSolveTree.countLeaves(meinSolveTree.getTree()));
  }       
}