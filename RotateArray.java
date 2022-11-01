// Time Complexity : O(N)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
reverse arrays, from kth ptr reverse again
* */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        reverse(0,nums.length-1,nums);
        reverse(0,k-1,nums);
        reverse(k,nums.length-1,nums);
    }

    private void reverse(int ptr1,int ptr2,int[] nums){
        int p1=ptr1,p2=ptr2;
        while(p1<p2){
            swap(p1,p2,nums);
            p1++;
            p2--;
        }
    }

    private void swap(int p1,int p2,int[] nums){
        int temp=nums[p1];
        nums[p1]=nums[p2];
        nums[p2]=temp;
    }
}