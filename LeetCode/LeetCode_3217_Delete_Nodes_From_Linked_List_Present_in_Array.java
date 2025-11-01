package LeetCode;/*
 *
 * https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/
 *
 * # 3217. Delete Nodes From Linked List Present in Array
 *
 *   Q. You are given an array of integers nums and the head of a linked list. Return the head of the modified linked
 *      list after removing all nodes from the linked list that have a value that exists in nums.
 *   Ex.
 *      Input : nums = [1], head = [1,2,1,2,1,2]
 *      Output: [2,2,2]
 *      Explanation: 2 ->  -> 2 -> 2
 *                   Remove the nodes with value 1.
 *
 *  Constraints:
 *      1 <= nums.length <= 10⁵
 *      1 <= nums[i] <= 10⁵
 *      All elements in nums are unique.
 *      The number of nodes in the given list is in the range [1, 10⁵].
 *      1 <= Node.val <= 10⁵
 *      The input is generated such that there is at least one node in the linked list that has a value not present in nums.
 */

import java.util.HashSet;

public class LeetCode_3217_Delete_Nodes_From_Linked_List_Present_in_Array {

    /// Structure
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /// Main Method
    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                                new ListNode(2,
                                        new ListNode(1,
                                                new ListNode(2,
                                                        new ListNode(1,
                                                                new ListNode(2))))));
        int[] nums = {1};

        ListNode modified = modifiedList(nums, head);

        System.out.println("Modified list is: ");
        ListNode temp = modified;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /// Solution
    static ListNode modifiedList(int[] nums, ListNode head) {
        ListNode prev = new ListNode(-1);
        prev.next = head;
        head = prev;

        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);

        ListNode temp = head.next;
        while (temp != null) {

            // skipping the elements.
            while (temp != null && set.contains(temp.val)) {
                temp = temp.next;
            }

            prev.next = temp;
            prev = temp;

            if (temp == null) break;

            temp = temp.next;
        }

        return head.next;
    }
}
