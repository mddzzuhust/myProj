package dataStructure;

class BinTree{
    private String str;
    private BinTree leftTree;
    private BinTree rightTree;
    public BinTree(String str){
        this.str = str;
    }

    public void setStr(String str){
        this.str = str;
    }

    public void setLeftTree(BinTree leftTree){
        this.leftTree = leftTree;
    }

    public void setRightTree(BinTree rightTree){
        this.rightTree = rightTree;
    }

    public String getStr(){
        return str;
    }

    public BinTree getLeftTree(){
        return leftTree;
    }

    public BinTree getRightTree(){
        return rightTree;
    }
}
public class Demo6_Tree {
    public static void main(String[] args) {
        BinTree rootTree = new BinTree("a");
        rootTree.setLeftTree(new BinTree("b"));
        rootTree.setRightTree(new BinTree("c"));

        BinTree midTree = null;
        midTree = rootTree.getLeftTree();
        midTree.setLeftTree(new BinTree("d"));
        midTree.setRightTree(new BinTree("e"));

        midTree = rootTree.getRightTree();
        midTree.setLeftTree(new BinTree("f"));
        midTree.setRightTree(new BinTree("g"));
    }
}