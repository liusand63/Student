package com.liusand.leetcode;
//面试题 02.06. 回文链表
/*
    编写一个函数，检查输入的链表是否是回文的。
 */


import java.util.ArrayList;
import java.util.List;

public class IsPalindrome {

}

//递归
class Solution {
    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }
 //双指针
 class Solution1 {
     public boolean isPalindrome(ListNode head) {
         List<Integer> vals = new ArrayList<Integer>();
         ListNode currentNode = head;
         while (currentNode != null) {
             vals.add(currentNode.val);
             currentNode = currentNode.next;
         }
         int front = 0;
         int back = vals.size() - 1;
         while (front < back) {
             if (!vals.get(front).equals(vals.get(back))) {
                 return false;
             }
             front++;
             back--;
         }
         return true;
     }
 }
