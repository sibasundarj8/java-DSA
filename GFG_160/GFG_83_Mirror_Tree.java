package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/mirror-tree/1
 *
 * # Mirror Tree
 *
 *   Q. Given a binary tree, convert the binary tree to its Mirror tree.
 *
 *      Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children of all
 *      non-leaf nodes interchanged.
 *    Ex.
 *      Input : root[] = [1, 2, 3, N, N, 4]
 *      Output: [1, 3, 2, N, 4]
 *      Explanation:                1    |    1
 *                                 / \   |   / \
 *                                2   3  |  3   2
 *                                   /   |   \
 *                                  4    |    4
 *
 *          In the inverted tree, every non-leaf node has its left and right child interchanged.
 */

import java.util.LinkedList;
import java.util.Queue;

public class GFG_83_Mirror_Tree {

    /// Structure
    private static class Node{
        int data;
        Node left;
        Node right;
        Node (int data){
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
        Node[]arr = {new Node(1),
                     new Node(2),
                     new Node(3),
                     new Node(4)};
        arr[0].left = arr[1];
        arr[0].right = arr[2];
        arr[2].left = arr[3];
        arr[0].print();

        mirror(arr[0]);
        arr[0].print();
    }

    /// Solution
    static void mirror(Node node) {
        // potd.code.hub
        if (node == null) return;
        mirror(node.left);
        mirror(node.right);
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
