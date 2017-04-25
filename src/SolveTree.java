class SolveTree
{
    private BinaryTree<String> start = new BinaryTree<String>();
    //wurzel
    private BinaryTree<String> meinBaum = new BinaryTree<String>("Am Rhein?");
  
  SolveTree ()
  {         //knoten
        BinaryTree<String> rechts = new BinaryTree<String>("Am Oberrhein?");
        BinaryTree<String> links  = new BinaryTree<String>("Linksrheinisch?");
        BinaryTree<String> linksRe  = new BinaryTree<String>("Aachen");
        BinaryTree<String> linksLi  = new BinaryTree<String>("An der Weser?");
        BinaryTree<String> linksLiLi = new BinaryTree<String> ("Hannover");
        BinaryTree<String> linksLiRe = new BinaryTree<String> ("Minden");
        BinaryTree<String> rechtsLi = new BinaryTree<String> ("Koeln");
        BinaryTree<String> rechtsRe = new BinaryTree<String> ("Basel");
        
        linksLi.setLeftTree (linksLiLi);
        linksLi.setRightTree (linksLiRe);
        links.setLeftTree (linksLi);
        links.setRightTree(linksRe);
        rechts.setLeftTree (rechtsLi);
        rechts.setRightTree(rechtsRe);
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






