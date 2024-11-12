package GFG;

import java.util.ArrayList;
import java.util.Scanner;

public class POTD_Linked_List_Matrix {
    static class Node{
        int data;
        Node right, down;
        Node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dimension: ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][]arr = new int[r][c];

        System.out.println("Enter elements: ");
        for (int i = 0;i < r;i++){
            for (int j = 0;j < c;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        printList(construct(arr));
    }
    static Node construct(int[][]arr) {
        // potd.code.hub
        int r = arr.length;
        int c = arr[0].length;
        ArrayList<ArrayList<Node>>ans = new ArrayList<>();

        for (int i = 0;i < r;i++){
            ans.add(new ArrayList<>());
            for (int j = 0;j < c;j++){
                ans.get(i).add(new Node(arr[i][j]));
            }
        }
        for (int i = 0;i < r;i++){
            for (int j = 0;j < c;j++){
                if (j < c-1) ans.get(i).get(j).right = ans.get(i).get(j+1);
                if (i < r-1) ans.get(i).get(j).down = ans.get(i+1).get(j);
            }
        }

        return ans.get(0).get(0);
    }
    static void printList(Node head){
        Node temp = head;
        Node curr = temp;
        while(temp != null){
            while (curr != null){
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
            temp = temp.down;
            curr = temp;
            System.out.println();
        }
    }
}