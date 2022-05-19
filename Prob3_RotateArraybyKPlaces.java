//TC : O(n) + O(K) + O(n-k) ===== O(n) // reverse whole array IN O(N), then doing reverese on k and n-k elements so total is O(N) only

//SC : O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0)    return;
        
        if(k >= nums.length){
            k = k % nums.length;
        }
        reverseArray(nums, 0, nums.length - 1 ); // reverse nums array 
        //Reverse 0 to k-1 and k to nums.length
        reverseArray(nums, 0, k-1);
        
        reverseArray(nums, k, nums.length - 1);
        
    }
    public void swap(int[] nums, int i, int j){
        int data = nums[i];
        nums[i] = nums[j];
        nums[j] = data;
    }
    
    public void reverseArray(int[] nums, int i, int j){
        while(i < j){
            swap(nums, i, j);
            i++; 
            j--;
        }
    }
}