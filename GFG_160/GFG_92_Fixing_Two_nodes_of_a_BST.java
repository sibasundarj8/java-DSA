package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/fixed-two-nodes-of-a-bst/1
 *
 * # Fixing Two nodes of a BST
 *
 *   Q. Given the root of a Binary search tree(BST), where exactly two nodes were swapped by
 *      mistake. Your task is to fix (or correct) the BST by swapping them back. Do not change
 *      the structure of the tree.
 *
 *      Note: It is guaranteed that the given input will form BST, except for 2 nodes that will
 *            be wrong. All changes must be reflected in the original linked list.
 *    Ex 1:
 *      Input : root = [10, 5, 8, 2, 20]
 *      Output: 1
 *                  10
 *                 /  \
 *                5   (8)
 *               / \
 *              2  (20)
 *      Explanation: The nodes 20 and 8 were swapped.
 *
 *    Ex 2:
 *      Input : root = [93, 61, 87, 9]
 *      Output: 1
 *                 (93)
 *                 /  \
 *                61  (87)
 *               /
 *              9
 *      Explanation: The nodes 93 and 87 were swapped.
 */

import java.util.LinkedList;
import java.util.Queue;

public class GFG_92_Fixing_Two_nodes_of_a_BST {

    /// Structure
    private static class Node{
        int data;
        Node left, right;
        Node(int data) {this.data = data;}
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
        // print in-order traversal
        void printInOrder(){
            print(this);
        }
        private void print(Node root){
            if (root == null) return;
            print(root.left);
            System.out.print(root.data + " ");
            print(root.right);
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node root1 = Node.createList("10 5 8 2 20");
        Node root2 = Node.createList("93 61 87 9");

        System.out.print("before fixing: ");
        root1.printInOrder();
        correctBST(root1);
        System.out.print("\nafter fixing:  ");
        root1.printInOrder();
        System.out.println();

        System.out.print("before fixing: ");
        root2.printInOrder();
        correctBST(root2);
        System.out.print("\nafter fixing:  ");
        root2.printInOrder();
        System.out.println();
    }

    /// Solution
    static void correctBST(Node root) {
        // potd.code.hub
        Node[]bag = new Node[2];
        correct(root, bag, new Node[]{new Node(Integer.MIN_VALUE)});

        int temp = bag[0].data;
        bag[0].data = bag[1].data;
        bag[1].data = temp;
    }
    private static void correct(Node root, Node[]temp, Node[]prev){
        if (root == null) return;
        correct(root.left, temp, prev);
        if (prev[0].data > root.data){
            if (temp[0] == null)temp[0] = prev[0];
            temp[1] = root;
        }
        prev[0] = root;
        correct(root.right, temp, prev);
    }
}
