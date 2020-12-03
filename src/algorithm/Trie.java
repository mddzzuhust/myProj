package algorithm;


public class Trie{
    private Node root;

    public Trie(){
        root = new Node(' ');
    }

    public void insert(String word){
        if(search(word) == true) return;

        Node current = root;
        for(int i = 0; i < word.length(); i++){
            Node child = current.subNode(word.charAt(i));
            if(child != null){
                current = child;
            } else {
                current.childList.add(new Node(word.charAt(i)));
                current = current.subNode(word.charAt(i));
            }
            current.count++;
        }
        current.isEnd = true;
    }


    /**
     *怎么判断单词是否存在？
     *被判断的单词的字母与根节点下的子节点的字母进行比较，直到匹配到两者最后一个字母相同，并且最后一个节点的isEnd标记为true
     */
    public boolean search(String word){
        Node current = root;

        for(int i = 0; i < word.length(); i++){
            if(current.subNode(word.charAt(i)) == null)
                return false;
            else
                current = current.subNode(word.charAt(i));
        }
        if (current.isEnd == true) return true;
        else return false;
    }

    public void deleteWord(String word){
        if(search(word) == false) return;

        Node current = root;
        for(char c : word.toCharArray()) {
            Node child = current.subNode(c);
            if(child.count == 1) {
                current.childList.remove(child);
                return;
            } else {
                child.count--;
                current = child;
            }
        }
        current.isEnd = false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        //trie.insert("ball");
        trie.insert("balls");
        trie.deleteWord("balls");
        trie.insert("sense");

        // testing deletion
        System.out.println(trie.search("balls"));
        System.out.println(trie.search("ba"));
        trie.deleteWord("balls");
        System.out.println(trie.search("balls"));
        System.out.println(trie.search("ball"));
    }
}