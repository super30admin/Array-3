// Time Complexity : O(n), where n is the size of the input array (exactly O(2n))
// Space Complexity :O(1), no extra space used
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

//Three liner approach of your code in plain English
//1. If k is greater than n, then recalculate k = k%n (as, the output for  n=9 and k=11, is equal to the ouput of n=9 and k=2 )
//2. Then do the follwing three steps
        //1. reverse the entire array (0, n-1)
        //2. reverse the first k elements (0, k-1)
        //3. reverse the remaining n-k elements (k, n-1)
//3. NOTE: the above will roate the array to its "right" by k, So to rotate the array to its "left" by k, it is same just above with 
            //few changes
            //1. reverse the entire array (0, n-1)
            //2. reverse the first n-k elements (0, n-k-1)
            //3. reverse the remaining k elements (n-k, n-1)

// Your code here along with comments explaining your approach

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        //k is greater than nums.length
        if(k > n){
            k = k%n;
        }
        //edge case
        if(k==0) return;
        //reverse the entire nums array
        reverse(nums, 0, n-1);
        //reverse the first k elements
        reverse(nums, 0, k-1);
        //reverse the remaining n-k elements
        reverse(nums, k, n-1);
    }
    //helper function to reverse the array starting and ending by the specified indexes
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            //swap the elements at the start and the end index
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    //helper function for reverse function to swap 2 elemets one by one
    private void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}