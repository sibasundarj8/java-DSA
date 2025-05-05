package Tree;/*
 * https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
 *
 * # Left View of Binary Tree
 *
 *   Q. You are given the root of a binary tree. Your task is to return the left view of the binary
 *      tree. The left view of a binary tree is the set of nodes visible when the tree is viewed
 *      from the left side.
 *
 *      If the tree is empty, return an empty list.
 *   Ex.
 *      Input : root[] = [1, 2, 3, N, N, 4, N, N, 5, N, N]
 *                                     (1)
 *                                    /   \
 *                                  (2)   (3)
 *                                        /
 *                                      (4)
 *                                        \
 *                                        (5)
 *      Output: [1, 2, 4, 5]
 *      Explanation: From the left side of the tree, the nodes 1, 2, 4, and 5 are visible.
 *                                    >(1)<
 *                                    /   \
 *                                 >(2)<  (3)
 *                                        /
 *                                     >(4)<
 *                                        \
 *                                       >(5)<
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tree_Left_View_of_Binary_Tree {

    /// Structure
    private static class Node {
        int data;
        Node left;
        Node right;
        Node (int data){
            this.data = data;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node[] nodes = {new Node(1),
                        new Node(2),
                        new Node(3),
                        new Node(4),
                        new Node(5)};

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[2].left = nodes[3];

        nodes[3].right = nodes[4];

        System.out.println("""
                        (1)
                       /   \\
                     (2)   (3)
                           /
                         (4)
                           \\
                           (5)
                """);
        System.out.println("Left View : " + leftView(nodes[0]));
    }

    /// Solution
    static ArrayList<Integer> leftView(Node root) {
        // potd.code.hub
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if (root != null) q.add(root);

        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0;i < size;i++){
                Node node = q.poll();
                if (i == 0) ans.add(node.data);
                if (node.left != null)q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }

        return ans;
    }
}
