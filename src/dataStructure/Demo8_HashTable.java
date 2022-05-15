package dataStructure;

class HashTable_linked{
    private Node[] values;
    private int j;
    public HashTable_linked(){
        this.values = new Node[16];
    }
    public HashTable_linked(int length){
        this.values = new Node[length];
    }
    public void insert(int key,String value){
        this.j = hashCode(key);
        if(this.values[j]==null){
            this.values[j]=new Node(value);
        }else {
            this.values[j].add(new Node(value));
        }
    }
    public Object search(int key){
        this.j = hashCode(key);
        if(this.values[this.j]!=null){
            return this.values[this.j];
        }else {
            return null;
        }
    }
    private int hashCode(int key){
        return key%this.values.length;
    }
}
public class Demo8_HashTable {
    public static void main(String[] args) {
        HashTable_linked hashTable = new HashTable_linked(10);
        hashTable.insert(11,"你好");
        hashTable.insert(39,"世界");
        hashTable.insert(22,"权利的游戏");
// hashTable.insert(211,"努力奋斗");
// hashTable.insert(211,"努力奋斗+1");
        Node node = (Node)hashTable.search(211);
        System.out.println(node.getStr());
        System.out.println(node.getStr());
        System.out.println(node.getNextNode().getStr());
        System.out.println(node.getNextNode().getNextNode().getStr());
    }
}