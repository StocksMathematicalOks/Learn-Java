// 1619. Mean of Array After Removing Some Elements:
import java.util.Arrays;
import java.util.Stack;
class Solution {
    public double trimMean(int[] arr) {
        double sum = 0;
        double median;
        ArrayList<Integer> ArrayL = new ArrayList<Integer>();
        Arrays.sort(arr);
        double percent = 0.05*arr.length;
        for(int i=0; i<arr.length; i++){
            ArrayL.add(arr[i]);
        }
        for(int i=0; i<percent; i++){
            ArrayL.remove(0);
        }
        for(int i=0; i<percent; i++){
            ArrayL.remove(ArrayL.size()-1);
        }
        for(int i=0; i<ArrayL.size(); i++){
            sum += ArrayL.get(i);
        }
        return sum/ArrayL.size();
    }
}

// Reverse a String:
import java.util.Arrays;
import java.util.stream.Collectors;
class Solution {
    public void reverseString(String[] s) {
        char store = '\0';
        int Length = s.length();
        int FinalLength = (Length%/2==0):Length/2:(Length-1)/2;
        for( int i=0; i < FinalLength; i++ ) {
            store = s.charAt(i);
            s[i] = s[Length - 1 - i];
            s[Length - 1 - i] = store;
        }
        System.out.println(s.toString());
    }
}

// Divide Two Integers (Java):
class Solution {
    public int divide(int dividend, int divisor) {
        double Divisor = Math.pow(divisor, -1);
        double result = Divisor*dividend;
        int Result = (int)result;
        return Result;
    }
}


//Remove Nth Node From End of List. (LeetCode):
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.util.LinkedList;
class Solution {
    public int length(ListNode node){
        if(node == null){
            return 0;
        }
        else{
            return 1 + this.length(node.next);
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int l = length(head); int i = 0;
        ListNode current = head; ListNode previous = head;
        if(l==1){
            return null;
        }
        if ( n == l ){
            return head.next;
        }
        while (current.next != null){
            if ( ( ++i == l - n ) && ( current.next.next != null ) )
                current.next = current.next.next; // A ListNode will always carries the values following it (Or Preceeding it), because it
                //contains links/references to those next or previous nodes, therefore eliminating the task of iteration.
            previous = current;
            current = current.next;

        }
        if((current.next == null) && ( n == 1 )){
            previous.next = null;
        }
        return head;
    }
}

//Linked List Methods/Classes (LeetCode):
//Linked List Length:
    public int length(ListNode node){
        if(node == null){
            return 0;
        }
        else{
            return 1 + this.length(node.next);
        }
    }
//Linked List Last Element:
    public ListNode LastNode(ListNode node){
        ListNode tmp = new ListNode();
        while(node.next != null){
            tmp = node.next;
            node.next = tmp.next;
            }
        return tmp;
        }
//Linked List First Element:
    //Keep Original Linked List:
    public ListNode FirstNode1(ListNode node){
        List Node tmp = node;
        tmp.next = null;
        return tmp;
    }
    //Unlink First Node from Original Linked List:
    public ListNode FirstNode2(ListNode node){
        node.next = null;
        return node;
    }

//Linked List Middle Element:
public ListNode Length(ListNode node){
    if(node == null){
        return 0;
    }
    else{
        return 1 + this.Length(node.next);
    }
}
public ListNode MiddleElement(ListNode node){
    int i=0;
    int middle = Math.round(Length(node)/2);
    while(node != null){
        if(++i = middle){
            tmp = node.next;
        }
    }
    while(tmp != null){

    }
}

//Invert A Binary Tree (LeetCode):
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root != null){
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = right;
            root.right = left;
            //The Double Recursion is Required due to the fact that there are two branches to each tree and sub-tree.   
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }


//Depth of Furthest Left and Furthest Right Nodes of a Binary Tree:
    public int length_right(TreeNode node){
        if(node == null){
            return 0;
        }
        else{
            return 1 + this.length_right(node.right);
        }
    }
    public int length_left(TreeNode node){
        if(node == null){
            return 0;
        }
        else{
            return 1 + this.length_left(node.left);
        }
    }

//Maximum Depth of a Binary Tree (LeetCode):
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int length(TreeNode node){
        if (node == null){
            return 0;
        }
        else{
            return 1 + Math.max(length(node.left), length(node.right));
        }
    }
    public boolean isBalanced(TreeNode root) {
        if( root == null ){
            return true;
        }
        int Right = length(root.right);
        int Left = length(root.left);
        if( Math.abs(Right-Left) <=1 && isBalanced(root.left)
            && isBalanced(root.right) ){
            return true;
        }
        else{
            return false;
        }
    }
}


//Majority Element (LeetCode):
import java.util.HashMap;
import java.util.Map.Entry;
class Solution {
    public int majorityElement(int[] nums) {
        int val = 0;
        HashMap<Integer, Integer> new_map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if(new_map.containsKey(nums[i])){
                new_map.put(nums[i], new_map.get(nums[i])+1);
            }
            else{
                new_map.put(nums[i], 1);
            }
        }
         for(Entry<Integer, Integer> entry: new_map.entrySet()){
            if( entry.getValue() > nums.length/2){
                val = entry.getKey();
            }
        }
        return val;
    }
}

//Binary Search Iterative (LeetCode Binary Search):

class Solution {
    public int search(int[] nums, int target) {
    if( nums.length == 0) return -1;
    int low = 0;
    int high = nums.length-1;
    while( high >= low ){
        int middle = low  + (high - low)/2;
    if ( target == nums[middle] ) {
        return middle;
    } else if ( target < nums[middle] ) {
        high = middle-1;
    } else if( target > nums[middle] ) {
        low = middle+1;
        }
    }
    return -1;
    }
}


// Maximum Average SubArray 1 (LeetCode):
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int j=0;
        double CurrentSum=0;
        double Maximum = Double.valueOf(Integer.MIN_VALUE);
        for(int i=0; i<nums.length; i++){
            CurrentSum += Double.valueOf(nums[i]);
            if(i-j == k-1){
                Maximum = Math.max(Maximum, CurrentSum/k);
                CurrentSum -= nums[j];
                j++;
            }
        }
        System.out.println(CurrentSum);
        return Maximum;
    }
}
// Time Complexity: O(n), Space Complexity: O(1).

class InsertionSort {
    public void Sort(int[] data){
        int incrementer = 0;
        int Length = data.length-1;
        for(int i=0; i < Length; i++){
            incrementer = i;
            while( data[i] > data[i+1] ){
                data[i] = data[i]+data[Length-i];
                data[Length-i] = data[i]-data[Length-i];
                data[i] = data[i]-data[Length-i];
                incrementer--;
            }
        }
    }
}
