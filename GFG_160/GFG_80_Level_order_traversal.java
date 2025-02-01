package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/level-order-traversal/1
 *
 * # Level order traversal
 *
 *   Q. Given a root of a binary tree with n nodes, the task is to find its level order traversal.
 *      Level order traversal of a tree is breadth-first traversal for the tree.
 *    Ex.
 *      Input : root[] = [10, 20, 30, 40, 50]
 *                                              10
 *                                             /  \
 *                                           20    30
 *                                          /  \
 *                                        40    50
 *      Output: [[10], [20, 30], [40, 50]]
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GFG_80_Level_order_traversal {

    /// Structure
    private static class Node{
        int data;
        Node left;
        Node right;
        Node (int data){
            this.data = data;
        }
    }

    /// main Method
    public static void main(String[] args) {

        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        System.out.println(levelOrder(a));
    }
    static ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        // potd.code.hub
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            ans.add(new ArrayList<>());
            int n = q.size();
            for (int i = 0;i < n;i++){
                Node temp = q.poll();
                ans.getLast().add(temp.data);
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
        }

        return ans;
    }
}
