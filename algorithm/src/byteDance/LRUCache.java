package byteDance;

import java.util.HashMap;

class Node {
    Node pre;
    Node next;
    int key;
    int value;

    Node(int k, int val) {
        key = k;
        value = val;
    }
}

public class LRUCache {
    HashMap<Integer, Node> hm;
    Node head, tail;
    int size;

    public LRUCache(int capacity) {
        hm = new HashMap<Integer, Node>();
        head = new Node(-1, -1);
        tail = new Node(0, 0);
        size = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (hm.containsKey(key)) {
            Node p = hm.get(key);
            putToHead(p);
            return p.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (hm.containsKey(key)) {
            Node p = hm.get(key);
            p.value = value;
            hm.put(key, p);
            putToHead(p);
        } else if (hm.size() < size) {
            Node p = new Node(key, value);
            putToHead(p);
            hm.put(key, p);
        } else {
            Node p = new Node(key, value);
            putToHead(p);
            hm.put(key, p);
            int tmpkey = removeEnd();
            hm.remove(tmpkey);
        }
    }

    private int removeEnd() {
        Node p = tail.pre;
        tail.pre.pre.next = tail;
        tail.pre = p.pre;
        p.pre = null;
        p.next = null;
        return p.key;
    }

    private void putToHead(Node p) {
        if (p.next != null && p.pre != null) {
            p.pre.next = p.next;
            p.next.pre = p.pre;
        }
        p.pre = head;
        p.next = head.next;
        head.next.pre = p;
        head.next = p;
    }
}
