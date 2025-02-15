package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1
 *
 * # Lowest Common Ancestor in a BST
 *
 *   Q. Serialization is to store a tree in an array so that it can be later restored and
 *      deserialization is reading tree back from the array. Complete the functions
 *
 *      • serialize() : stores the tree into an array a and returns the array.
 *      • deSerialize() : deserializes the array to the tree and returns the root of the tree.
 *
 *      Note: Multiple nodes can have the same data and the node values are always positive
 *            integers. Your code will be correct if the tree returned by
 *            deSerialize(serialize(input_tree)) is same as the input tree. Driver code will
 *            print the in-order traversal of the tree returned by deSerialize(serialize(input_tree)).
 *    Ex.
 *      Input : root = [1, 2, 3]
 *                               1
 *                              / \
 *                             2   3
 *      Output: [2, 1, 3]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GFG_94_Serialize_and_deserialize_a_binary_tree {

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
        Node root = Node.createList("1 2 3");

        ArrayList<Integer> arr = serialize(root);
        System.out.println(arr);

        System.out.println("Inorder: ");
        Node ans = deSerialize(arr);
        inOrder(ans);
    }
    static void inOrder(Node root){
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    /// Solution
    // Function to serialize a tree and return a list containing nodes of tree.
    static ArrayList<Integer> serialize(Node root) {
        // potd.code.hub
        StringBuilder s = new StringBuilder();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
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
        while (s.length() != 0 && !Character.isDigit(s.charAt(s.length()-1))) {
            s.deleteCharAt(s.length() - 1);
        }

        ArrayList<Integer>list = new ArrayList<>();
        Arrays.stream(s.toString().split(" ")).forEach(x -> list.add(x.equals("N") ? -1 : Integer.parseInt(x)));

        return list;
    }

    // Function to deserialize a list and construct the tree.
    static Node deSerialize(ArrayList<Integer> arr) {
        // potd.code.hub
        if (arr.isEmpty() || arr.get(0) == -1) return null;
        Node root = new Node(arr.get(0));
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int n = arr.size(), i = 1;
        while (!q.isEmpty() && i < n){
            Node temp = q.remove();
            // left
            if (arr.get(i) != -1){
                temp.left = new Node(arr.get(i));
                q.add(temp.left);
            }
            i++;
            // right
            if (i >= n) break;
            if (arr.get(i) != -1){
                temp.right = new Node(arr.get(i));
                q.add(temp.right);
            }
            i++;
        }
        return root;
    }
}
