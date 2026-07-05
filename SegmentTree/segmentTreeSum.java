import java.util.*;
class Node {
    int start, end, sum;
    Node left, right;
    Node(int s, int e) {
        start = s;
        end = e;
    }
}
class SegmentTree {
    Node root;
    SegmentTree(int[] arr) {
        root = build(arr, 0, arr.length - 1);
    }
    Node build(int[] arr, int s, int e) {
        Node node = new Node(s, e);
        if(s==e){
            node.sum = arr[s];
            return node;
        }
        int mid = (s + e) / 2;
        node.left = build(arr, s, mid);
        node.right = build(arr, mid + 1, e);
        node.sum = node.left.sum + node.right.sum;
        return node;
    }
    int query(Node node, int l, int r) {
        if (node.end < l || node.start > r)
            return 0;
        if (l <= node.start && node.end <= r)
            return node.sum;
        return query(node.left, l, r) + query(node.right, l, r);
    }
    void update(Node node, int idx, int val) {
        if (node.start == node.end) {
            node.sum = val;
            return;
        }
        int mid = (node.start + node.end) / 2;
        if (idx <= mid)
            update(node.left, idx, val);
        else
            update(node.right, idx, val);
        node.sum = node.left.sum + node.right.sum;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] arr = {1,3,-7,0,12,-2,0};
        SegmentTree st = new SegmentTree(arr);
        System.out.println(st.query(st.root,1,3));
        st.update(st.root,2,10);
        System.out.println(st.query(st.root,1,3));
    }
}