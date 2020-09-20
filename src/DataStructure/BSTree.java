package DataStructure;

public class BSTree<T extends Comparable<T>> {
    private BSTNode<T> mRoot;

    public class BSTNode<T extends Comparable<T>> {
        T key;
        BSTNode<T> left;
        BSTNode<T> right;
        BSTNode<T> parent;

        public BSTNode(T key, BSTNode<T> parent, BSTNode<T> left, BSTNode<T> right) {
            this.key = key;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public T getKey() {
            return key;
        }

        public String toString() {
            return "key:" + key;
        }
    }

    public BSTree() {
        mRoot = null;
    }

    private void preOrder(BSTNode<T> tree) {
        if (tree != null) {
            System.out.print(tree.key + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder() {
        preOrder(mRoot);
    }

    public void inOrder(BSTNode<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.print(tree.key + " ");
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(mRoot);
    }

    private void postOrder(BSTNode<T> tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.key + " ");
        }
    }

    public void postOrder() {
        postOrder(mRoot);
    }

    private BSTNode<T> search(BSTNode<T> x, T key) {
        if (x == null)
            return x;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return search(x.left, key);
        else if (cmp > 0)
            return search(x.right, key);
        else
            return x;
    }

    public BSTNode<T> search(T key) {
        return search(mRoot, key);
    }

    private BSTNode<T> iterativeSearch(BSTNode<T> x, T key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);

            if (cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else
                return x;
        }
        return x;
    }

    public BSTNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }

    private BSTNode<T> minimum(BSTNode<T> tree) {
        if (tree == null)
            return null;
        while (tree.left != null)
            tree = tree.left;
        return tree;
    }

    public T minimum() {
        BSTNode<T> p = minimum(mRoot);
        if (p != null)
            return p.key;
        return null;
    }

    private BSTNode<T> maximum(BSTNode<T> tree) {
        if (tree == null)
            return null;

        while (tree.right != null)
            tree = tree.right;
        return tree;
    }

    public T maximum() {
        BSTNode<T> p = maximum(mRoot);
        if (p != null)
            return p.key;
        return null;
    }

    public BSTNode<T> successor(BSTNode<T> x){
        if(x.right!=null)
            return minimum(x.right);

        BSTNode<T> y = x.parent;
        while ((y!=null)&&(x==y.right)){
            x = y;
            y = y.parent;
        }
        return y;
    }

    public BSTNode<T> predecessor(BSTNode<T> x){
        if(x.left!=null)
            return maximum(x.left);

        BSTNode<T> y = x.parent;
        while ((y!=null)&&(x==y.left)){
            x = y;
            y = y.parent;
        }
        return y;
    }

    private void insert(BSTree<T> bst,BSTNode<T> z){
        int cmp;
        BSTNode<T> y = null;
        BSTNode<T> x = bst.mRoot;

        while (x!=null){
            y = x;
            cmp = z.key.compareTo(x.key);
            if(cmp<0)
                x = x.left;
            else
                x = x.right;
        }

        z.parent = y;
        if(y==null)
            bst.mRoot = z;
        else {
            cmp = z.key.compareTo(y.key);
            if(cmp<0)
                y.left = z;
            else
                y.right = z;
        }
    }

    public void insert(T key){
        BSTNode<T> z = new BSTNode<T>(key,null,null,null);

        if(z!=null)
            insert(this,z);
    }

    private BSTNode<T> remove(BSTree<T> bst,BSTNode<T> z){
        BSTNode<T> x = null;
        BSTNode<T> y = null;

        if((z.left==null)||(z.right==null))
            y = z;
        else
            y = successor(z);

        if(y.left!=null)
            x = y.left;
        else
            x = y.right;

        if(x!=null)
            x.parent = y.parent;

        if(y.parent==null)
            bst.mRoot = x;
        else if(y == y.parent.left)
            y.parent.right = x;
        else
            y.parent.right = x;

        if(y!=z)
            z.key = y.key;

        return y;
    }

    public void remove(T key){
        BSTNode<T> z,node;
        if((z=search(mRoot,key))!=null)
            if((node=remove(this,z))!=null)
                node = null;
    }

    private void destroy(BSTNode<T> tree){
        if(tree==null)
            return;
        if(tree.left!=null)
            destroy(tree.left);
        if(tree.right!=null)
            destroy(tree.right);

        tree=null;
    }

    public void clear(){
        destroy(mRoot);
        mRoot = null;
    }

    private void print(BSTNode<T> tree,T key,int direction){
        if(tree!=null){
            if(direction==0)
                System.out.printf("%2d is root\n",tree.key);
            else
                System.out.printf("%2d is %d's %6s child\n",
                        tree.key,key,direction==1?"right":"left");

            print(tree.left,tree.key,-1);
            print(tree.right,tree.key,1);
        }
    }

    public void print(){
        if(mRoot!=null)
            print(mRoot,mRoot.key,0);
    }
}
