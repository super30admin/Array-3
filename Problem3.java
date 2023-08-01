package Array3;

/**
 * Initially we reverse the entire array.Then reverse first k elements. Finally
 * reverse elements from k+1 to the end.
 * 
 * Time Complexity : O(n)- where n is the length of the arr
 * 
 * Space Complexity : O(1)
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
public class Problem3 {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        if(k==0)
            return;
        reverse(nums,0, nums.length-1);

        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }

    void reverse(int[] nums, int start, int end){
        while(start<=end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
