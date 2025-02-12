package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/find-k-th-smallest-element-in-bst/1
 *
 * # k-th Smallest in BST
 *
 *   Q. Given a BST and an integer k, the task is to find the kth smallest element in the BST. If there
 *      is no kth smallest element present then return -1.
 *    Ex.
 *      Input : root = [20, 8, 22, 4, 12, N, N, N, N, 10, 14]
 *              k = 3
 *                        20
 *                       /  \
 *                      8   22
 *                     / \
 *                    4  12
 *                      /  \
 *                     10  14
 *      Output: 10
 *      Explanation: 10 is the 3rd smallest element in the BST.
 */
import java.util.Scanner;

public class GFG_90_k_th_Smallest_in_BST {

    /// Structure
    private static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("size of level order Array: ");
        int n = sc.nextInt();

        Node[]arr = new Node[n];

        System.out.println("Enter level order traversal: ");
        for (int i = 0;i < n;i++){
            String s = sc.next();
            if (Character.isDigit(s.charAt(0))){
                arr[i] = new Node(Integer.parseInt(s));
            }
        }

        for (int i = 0;2*i < n ;i++){
            if (arr[i] != null){
                int l = 2 * i + 1;
                int r = 2 * i + 2;
                if (l < n) arr[i].left = arr[l];
                if (r < n) arr[i].right = arr[r];
            }
        }

        System.out.println("K: ");
        int k = sc.nextInt();

        System.out.println(kthSmallest(arr[0], k));
    }

    /// Solution
    static int kthSmallest(Node root, int k) {
        // potd.code.hub
        int[]ans = {0};
        find(root, new int[]{k}, ans);

        return ans[0] == 0 ? -1 : ans[0];
    }
    private static void find(Node root, int[]k, int[]ans){
        if (root == null) return;
        find(root.left, k, ans);
        k[0]--;
        if (k[0] == 0) ans[0] = root.data;
        find(root.right, k, ans);
    }
}
