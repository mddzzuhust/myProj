package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution699 {
    private class Node {
        int l, r, h, maxR;
        Node left, right;

        public Node(int l, int r, int h, int maxR) {
            this.l = l;
            this.r = r;
            this.h = h;
            this.maxR = maxR;
            this.left = null;
            this.right = null;
        }
    }

    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> res = new ArrayList<>();
        Node root = null;
        int maxH = 0;
        for (int[] position : positions) {
            int l = position[0];
            int r = position[0] + position[1];
            int e = position[1];
            int curH = query(root, l, r);
            root = insert(root, l, r, curH + e);
            maxH = Math.max(maxH, curH + e);
            res.add(maxH);
        }
        return res;
    }

    private Node insert(Node root, int l, int r, int h) {
        if (root == null) {
            return new Node(l, r, h, r);
        }
        if (l <= root.l) {
            root.left = insert(root.left, l, r, h);
        } else {
            root.right = insert(root.right, l, r, h);
        }
        root.maxR = Math.max(r, root.maxR);
        return root;
    }

    private int query(Node root, int l, int r) {
        if (root == null || l >= root.maxR)
            return 0;
        int curH = 0;
        if (!(r <= root.l || root.r <= l))
            curH = root.h;
        curH = Math.max(curH, query(root.left, l, r));
        if (r > root.l)
            curH = Math.max(curH, query(root.right, l, r));
        return curH;
    }
}
