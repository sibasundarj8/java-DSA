package Tree;/*
[medium]
problem link - https://practice.geeksforgeeks.org/problems/remove-bst-keys-outside-given-range/1
*/
public class T15_Remove_bst_keys_outside_given_Range { 

    /// Solution
    static Node removekeys(Node cur, int l, int r) {
        // base case
        if (cur == null) return null;
        
        // recursive work
        Node left = removekeys(cur.left, l, r);
        Node right = removekeys(cur.right, l, r);
        
        // self work
        cur.left = left;
        cur.right = right;
        
        if(cur.data < l) return cur.right;
        if(cur.data > r) return cur.left;
        
        return cur;
    }
}
