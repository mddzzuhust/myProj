package list;

class Node1 {
    private String str = null;
    private Node1 nextNode1 = null;

    public Node1(String str) {
        this.str = str;
    }

    public void add(Node1 nextNode1) {
        Node1 indexNode1 = this.nextNode1;
        while (true) {
            if (indexNode1.hasNext() == false) {
                break;
            }
            indexNode1 = indexNode1.getNextNode1();
        }
        indexNode1.setNextNode1(nextNode1);
    }


    public int getSize() {
        int size = 0;
        Node1 indexNode1 = this.nextNode1;
        while (true) {
            size++;
            if (indexNode1.hasNext() == false) {
                break;
            }
            indexNode1 = indexNode1.getNextNode1();
        }
        return size;
    }

    public void setNextNode1(Node1 nextNode1) {
        this.nextNode1 = nextNode1;
    }

    public Node1 getNextNode1() {
        return this.nextNode1;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public boolean hasNext() {
        if (nextNode1 != null) {
            return true;
        } else {
            return false;
        }
    }
}

public class Demo2_LinkedList {
    public static void main(String[] args) {
        String[] array = {"begin", "1", "2", "3", "4", "5"};
        Node1 rootNode1 = null;
        Node1 indexNode1 = null;
        boolean flag = true;
        for (String str : array) {
            if (flag) {
                rootNode1 = new Node1(str);
                indexNode1 = rootNode1;
                flag = false;
            } else {
                indexNode1.setNextNode1(new Node1(str));
                indexNode1 = indexNode1.getNextNode1();
            }
        }
        rootNode1.add(new Node1("添加元素"));
        indexNode1 = rootNode1;
        System.out.println(rootNode1.getSize());
        while (true) {
            System.out.println(indexNode1.getStr());
            if (indexNode1.hasNext() == false) {
                break;
            }
            indexNode1 = indexNode1.getNextNode1();
        }
    }
}