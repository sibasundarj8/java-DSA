package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1
 *
 * # Pair Sum in BST
 *
 *   Q. Given a Binary Search Tree(BST) and a target. Check whether there's a pair of Nodes in the BST
 *      with value summing up to the target.
 *    Ex.
 *      Input : root = [7, 3, 8, 2, 4, N, 9]
 *                     target = 12
 *                  7
 *                 / \
 *                3  (8)
 *               / \   \
 *              2  (4)  9
 *      Output: True
 *      Explanation: In the binary tree above, there are two nodes (8 and 4) that add up to 12.
 */
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GFG_91_Pair_Sum_in_BST {

    /// Structure
    private static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
        }
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
        // print tree
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
            System.out.println("Level Order: \n" + s);
        }
    }

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter level Order of the tree: ");
        String levelOrder = sc.nextLine();

        Node root = Node.createList(levelOrder);
        root.print();

        System.out.println("Target: ");
        int target = sc.nextInt();

        System.out.println(findTarget(root, target));
    }

    /// Solution
    static boolean findTarget(Node root, int target) {
        // potd.code.hub
        HashSet<Integer> set = new HashSet<>();

        return find(root, target, set);
    }
    private static boolean find(Node root, int target, HashSet<Integer> set){
        // base case
        if (root == null) return false;
        // self work
        if (set.contains(target - root.data)) return true;
        set.add(root.data);
        // recursive work
        return find(root.left, target, set) || find(root.right, target, set);
    }
}
