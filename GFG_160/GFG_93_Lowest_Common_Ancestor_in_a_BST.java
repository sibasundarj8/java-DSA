package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1
 *
 * # Lowest Common Ancestor in a BST
 *
 *   Q. Given a Binary Search Tree (with all values unique) and two nodes n1 and n2 (n1 != n2).
 *      You may assume that both nodes exist in the tree. Find the Lowest Common Ancestor (LCA)
 *      of the given two nodes in the BST.
 *
 *      LCA between two nodes n1 and n2 is defined as the lowest node that has both n1 and n2 as
 *      descendants (where we allow a node to be a descendant of itself).
 *    Ex.
 *      Input : root = [20, 8, 22, 4, 12, N, N, N, N, 10, 14]
 *              n1 = 8, n2 = 14
 *                                  20
 *                                 /  \
 *                                8    22
 *                               / \
 *                              4   12
 *                                 /  \
 *                                10   14
 *      Output: 8
 *      Explanation: 8 is the closest node to both 8 and 14, which is also an ancestor of both
 *                   the nodes.
 */
import java.util.LinkedList;
import java.util.Queue;

public class GFG_93_Lowest_Common_Ancestor_in_a_BST {

    /// Structure
    private static class Node{
        int data;
        Node left, right;
        Node(int data){this.data = data;}
        // creating tree from level order
        static Node createList(String levelOrder){
            if (levelOrder.isEmpty() || levelOrder.equals("N")) return null;
            String[] s = levelOrder.split(" ");
            int n = s.length;
            Queue<Node> q = new LinkedList<>();
            Node root = new Node(Integer.parseInt(s[0]));
            q.add(root);
            // starting from 2nd element
            int i = 1;
            while (i < n && !q.isEmpty()){
                Node temp, curr = q.poll();
                // left child
                if (Character.isDigit(s[i].charAt(0))){
                    temp = new Node(Integer.parseInt(s[i]));
                    curr.left = temp;
                    q.add(temp);
                }
                i++;
                // right child
                if (i >= n) break;
                if (Character.isDigit(s[i].charAt(0))){
                    temp = new Node(Integer.parseInt(s[i]));
                    curr.right = temp;
                    q.add(temp);
                }
                i++;
            }
            return root;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node root = Node.createList("20 8 22 4 12 N N N N 10 14");
        Node n1 = new Node(8), n2 = new Node(14);
        System.out.println(LCA(root, n1, n2).data);
    }

    /// Solution
    static Node LCA(Node root, Node n1, Node n2) {
        // potd.code.hub
        Node temp = root;
        while (temp != null){
            if (n1.data < temp.data && n2.data < temp.data) 
                temp = temp.left;
            else if (temp.data < n1.data && temp.data < n2.data)
                temp = temp.right;
            else break;
        }
        return temp;
    }
}
