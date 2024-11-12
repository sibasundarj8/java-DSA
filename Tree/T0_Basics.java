package Tree;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }
}
public class T0_Basics {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(3);
        TreeNode a11 = new TreeNode(4);
        TreeNode a12 = new TreeNode(5);
        TreeNode a21 = new TreeNode(6);
        TreeNode a22 = new TreeNode(7);

        a.left = a1;
        a.right = a2;
        a1.left = a11;
        a1.right = a12;
        a2.left = a21;
        a2.right = a22;

        printTree(a);
    }
    static void printTree(TreeNode root){
        if(root == null) return;
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
