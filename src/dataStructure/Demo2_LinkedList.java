package dataStructure;

class Node {
    private String str = null;
    private Node nextNode = null;

    public Node(String str) {
        this.str = str;
    }

    public void add(Node nextNode) {
        Node indexNode = this.nextNode;
        while (true) {
            if (indexNode.hasNext() == false) {
                break;
            }
            indexNode = indexNode.getNextNode();
        }
        indexNode.setNextNode(nextNode);
    }


    public int getSize() {
        int size = 0;
        Node indexNode = this.nextNode;
        while (true) {
            size++;
            if (indexNode.hasNext() == false) {
                break;
            }
            indexNode = indexNode.getNextNode();
        }
        return size;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getNextNode() {
        return this.nextNode;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public boolean hasNext() {
        if (nextNode != null) {
            return true;
        } else {
            return false;
        }
    }
}

public class Demo2_LinkedList {
    public static void main(String[] args) {
        String[] array = {"begin", "1", "2", "3", "4", "5"};
        Node rootNode = null;
        Node indexNode = null;
        boolean flag = true;
        for (String str : array) {
            if (flag) {
                rootNode = new Node(str);
                indexNode = rootNode;
                flag = false;
            } else {
                indexNode.setNextNode(new Node(str));
                indexNode = indexNode.getNextNode();
            }
        }
        rootNode.add(new Node("添加元素"));
        indexNode = rootNode;
        System.out.println(rootNode.getSize());
        while (true) {
            System.out.println(indexNode.getStr());
            if (indexNode.hasNext() == false) {
                break;
            }
            indexNode = indexNode.getNextNode();
        }
    }
}