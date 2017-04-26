class SolveTree
{
    private BinaryTree<String> start = new BinaryTree<String>();
    //wurzel
    private BinaryTree<String> meinBaum = new BinaryTree<String>("Am Rhein?");
  
  SolveTree ()
  {         //knoten
        BinaryTree<String> rechts = new BinaryTree<String>("Am Oberrhein?");
        BinaryTree<String> links  = new BinaryTree<String>("Linksrheinisch?");
        BinaryTree<String> linksRe  = new BinaryTree<String>("Gibt es dort eine Rennstrecke?");
        BinaryTree<String> linksReLi  = new BinaryTree<String>("Aachen");
        BinaryTree<String> linksReRe  = new BinaryTree<String>("Spa");
        BinaryTree<String> linksLi  = new BinaryTree<String>("An der Weser?");
        BinaryTree<String> linksLiLi = new BinaryTree<String> ("Aktuelle Hauptstadt von Deutschland?");
        BinaryTree<String> linksLiLiLi = new BinaryTree<String> ("Im Ruhrgebiet?");
        BinaryTree<String> linksLiLiRe = new BinaryTree<String> ("Berlin");
        BinaryTree<String> linksLiLiLiRe = new BinaryTree<String> ("Dortmund");
        BinaryTree<String> linksLiLiLiLi = new BinaryTree<String> ("Landeshauptstadt von Niedersachsen?");
        BinaryTree<String> linksLiLiLiLiRe = new BinaryTree<String> ("Hannover");
        BinaryTree<String> linksLiLiLiLiLi = new BinaryTree<String> ("Minden");
        BinaryTree<String> linksLiRe = new BinaryTree<String> ("Minden");
        BinaryTree<String> rechtsLi = new BinaryTree<String> ("Ehemalige Hauptstadt Deutschlands?");
        BinaryTree<String> rechtsLiLi = new BinaryTree<String> ("Koeln");
        BinaryTree<String> rechtsLiRe = new BinaryTree<String> ("Bonn");
        BinaryTree<String> rechtsRe = new BinaryTree<String> ("Basel");
        
        
       
        linksLiLiLiLi.setLeftTree(linksLiLiLiLiLi);
        linksLiLiLiLi.setRightTree(linksLiLiLiLiRe);
        linksLiLiLi.setLeftTree(linksLiLiLiLi);
        linksLiLiLi.setRightTree(linksLiLiLiRe);
        linksLiLi.setRightTree(linksLiLiRe);
        linksLiLi.setLeftTree(linksLiLiLi);
        linksRe.setRightTree(linksReRe);
        linksRe.setLeftTree(linksReLi);
        linksLi.setLeftTree (linksLiLi);
        linksLi.setRightTree (linksLiRe);
        links.setLeftTree (linksLi);
        links.setRightTree(linksRe);
        rechts.setLeftTree (rechtsLi);
        rechts.setRightTree(rechtsRe);
        rechtsLi.setRightTree(rechtsLiRe);
        rechtsLi.setLeftTree(rechtsLiLi);
        meinBaum.setRightTree (rechts);
        meinBaum.setLeftTree (links);
        start = meinBaum;

  }
    // neue wurzel
     public void reset ()
    {
      meinBaum = start;
    }
  
    public void downLeft()
    {
      meinBaum = meinBaum.getLeftTree();
    }
  
    public void downRight()
    {
      meinBaum = meinBaum.getRightTree();
    }
  
    public boolean isLeaf ()
    {
      BinaryTree<String> links = meinBaum.getLeftTree();
      BinaryTree<String> rechts = meinBaum.getRightTree();
      return  (links.getContent()==null && rechts.getContent()==null);
    }
  
  public String getRoot ()
  {
      return meinBaum.getContent();
  }
  
  public void expand (String frage, String linkeStadt, String rechteStadt) 
  {
      meinBaum.setContent (frage);
      BinaryTree<String> links = new BinaryTree<String> (linkeStadt);
      BinaryTree<String> rechts = new BinaryTree<String> (rechteStadt);
      meinBaum.setLeftTree (links);
      meinBaum.setRightTree (rechts);
  }
}






