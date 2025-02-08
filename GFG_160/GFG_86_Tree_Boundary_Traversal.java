package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
 *
 * # Tree Boundary Traversal
 *
 *   Q. Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following
 *      order:
 *
 *          1) Left Boundary: This includes all the nodes on the path from the root to the leftmost
 *             leaf node. You must prefer the left child over the right child when traversing. Do
 *             not include leaf nodes in this section.
 *
 *          2) Leaf Nodes: All leaf nodes, in left-to-right order, that are not part of the left
 *             or right boundary.
 *
 *          3) Reverse Right Boundary: This includes all the nodes on the path from the rightmost
 *             leaf node to the root, traversed in reverse order. You must prefer the right child
 *             over the left child when traversing. Do not include the root in this section if it
 *             was already included in the left boundary.
 *
 *      Note: If the root doesn't have a left subtree or right subtree, then the root itself is the
 *            left or right boundary.
 *    Ex.
 *      Input : root[] = [1, 2, N, 4, 9, 6, 5, N, 3, N, N, N, N 7, 8]
 *      Output: [1, 2, 4, 6, 5, 7, 8]
 *      Explanation:
 *                          (1)
 *                          /
 *                        (2)
 *                        / \
 *                      (4)  9
 *                      / \   \
 *                    (6) (5)  3
 *                            / \
 *                          (7) (8)
 *              As the root doesn't have a right subtree, the right boundary is not included in
 *              the traversal.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GFG_86_Tree_Boundary_Traversal {

    /// Structure
    private static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
        }
        void print(){
            Queue<Node> q = new LinkedList<>();
            StringBuilder s = new StringBuilder();
            q.offer(this);
            while (!q.isEmpty()){
                Node temp = q.poll();
                if (temp == null){
                    s.append("N ");
                    continue;
                }
                s.append(temp.data).append(" ");
                q.add(temp.left);
                q.add(temp.right);
            }
            while (!s.isEmpty() && !Character.isDigit(s.charAt(s.length()-1))){
                s.deleteCharAt(s.length()-1);
            }
            System.out.println(s);
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node[] node = {new Node(1),
                       new Node(2),
                       new Node(4),
                       new Node(9),
                       new Node(6),
                       new Node(5),
                       new Node(3),
                       new Node(7),
                       new Node(8)};
        node[0].left = node[1];

        node[1].left = node[2];
        node[1].right = node[3];

        node[2].left = node[4];
        node[2].right = node[5];

        node[3].right = node[6];

        node[6].left = node[7];
        node[6].right = node[8];

        node[0].print();
        System.out.println(boundaryTraversal(node[0]));
    }

    /// Solution
    static ArrayList<Integer> boundaryTraversal(Node node) {
        // potd.code.hub
        ArrayList<Integer> ans = new ArrayList<>();
        if (node != null) ans.add(node.data);
        left(node.left, ans);
        leaf(node.left, ans);
        leaf(node.right, ans);
        right(node.right, ans);

        return ans;
    }
    private static void left(Node root, ArrayList<Integer> ans){
        if (root == null || (root.left == null && root.right == null)) return;
        ans.add(root.data);
        if (root.left == null) left(root.right, ans);
        else left(root.left, ans);
    }
    private static void leaf(Node root, ArrayList<Integer> ans){
        if (root == null) return;
        leaf(root.left, ans);
        if (root.left == null && root.right == null) ans.add(root.data);
        leaf(root.right, ans);
    }
    private static void right(Node root, ArrayList<Integer> ans){
        if (root == null || (root.left == null && root.right == null)) return;
        if (root.right == null) right(root.left, ans);
        else right(root.right, ans);
        ans.add(root.data);
    }
}
