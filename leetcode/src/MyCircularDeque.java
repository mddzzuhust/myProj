public class MyCircularDeque {
    private class DLinkListNode{
        int val;
        DLinkListNode prev, next;
        DLinkListNode(int val){
            this.val = val;
        }
    }

    private DLinkListNode head, tail;
    private int capacity;
    private int size;

    public MyCircularDeque(int k) {
        capacity = k;
        size = 0;
    }

    public boolean insertFront(int value) {
        if(size == capacity){
            return false;
        }
        DLinkListNode node = new DLinkListNode(value);
        if(size == 0){
            head = tail = node;
        }else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if(size == capacity){
            return false;
        }
        DLinkListNode node = new DLinkListNode(value);
        if(size == 0){
            head = tail = node;
        }else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if(size == 0){
            return false;
        }
        head = head.next;
        if(head != null){
            head.prev = null;
        }
        size--;
        return true;
    }

    public boolean deleteLast() {
        if(size == 0){
            return false;
        }
        tail = tail.prev;
        if(tail != null){
            tail.next = null;
        }
        size--;
        return true;
    }

    public int getFront() {
        if(size == 0){
            return -1;
        }
        return head.val;
    }

    public int getRear() {
        if(size == 0){
            return -1;
        }
        return tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
