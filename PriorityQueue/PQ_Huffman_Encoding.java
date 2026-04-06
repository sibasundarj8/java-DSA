package PriorityQueue;/*
 *
 * https://www.geeksforgeeks.org/problems/huffman-encoding3345/1
 *
 * # Huffman Encoding
 *
 *   Q. Given a string s of distinct characters and their corresponding frequency f[ ] i.e. character s[i] has f[i] frequency.
 *      You need to build the Huffman tree and return all the huffman codes in preorder traversal of the tree.
 *
 *      Note: While merging if two nodes have the same value, then the node which occurs at first will be taken on the left of
 *            Binary Tree and the other one to the right, otherwise Node with less value will be taken on the left of the subtree
 *            and other one to the right.
 *    Ex.
 *      Input : s = "abcdef", f[] = {5, 9, 12, 13, 16, 45}
 *      Output: [0, 100, 101, 1100, 1101, 111]
 *      Explanation:
 *                                  [100]
 *                                 /     \
 *                          [f ,45]      [55]
 *                                        /   \
 *                                     [25]   [30]
 *                                    /   \    /   \
 *                             [c,12]   [d,13] [14] [e,16]
 *                                                /   \
 *                                            [a,5]  [b,9]
 *              HuffmanCodes will be:
 *                  f : 0
 *                  c : 100
 *                  d : 101
 *                  a : 1100
 *                  b : 1101
 *                  e : 111
 *
 *  Constraints:
 *          1 ≤ s.size() = f.size() ≤ 26
 */

import java.util.*;

public class PQ_Huffman_Encoding {

    ///  main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("S: ");
        String s = sc.next();

        int n = s.length();
        int[] frq = new int[n];

        System.out.print("frequencies: ");
        for (int i = 0; i < n; i++) {
            frq[i] = sc.nextInt();
        }

        System.out.println("preorder of huff-man tree: ");
        System.out.println(huffmanCodes(s, frq));
    }

    /// Solution
    static ArrayList<String> huffmanCodes(String s, int[] f) {
        // potd.code.hub
        int n = s.length();
        ArrayList<String> result = new ArrayList<>();

        if (n == 1) {
            result.add("0");
            return result;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> (a.freq == b.freq) ? a.time - b.time : a.freq - b.freq);

        for (int i = 0; i < n; i++) {
            Node node = new Node(f[i], i);
            pq.offer(node);
        }

        while (pq.size() > 1) {
            Node node1 = pq.poll();
            Node node2 = pq.poll();

            int freq = node1.freq + node2.freq;
            int time = Math.min(node1.time, node2.time);
            Node newNode = new Node(freq, time);

            newNode.left = node1;
            newNode.right = node2;

            pq.offer(newNode);
        }

        preOrder(pq.poll(), new StringBuilder(), result);

        return result;
    }

    private static void preOrder(Node root, StringBuilder sb, ArrayList<String> res) {
        // base case
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
            return;
        }

        // recursive work with backtracking
        sb.append('0');
        preOrder(root.left, sb, res);
        sb.deleteCharAt(sb.length() - 1);

        sb.append('1');
        preOrder(root.right, sb, res);
        sb.deleteCharAt(sb.length() - 1);
    }

    private static class Node {
        int freq;
        int time;
        Node left, right;

        public Node(int freq, int time) {
            this.freq = freq;
            this.time = time;
        }
    }
}
