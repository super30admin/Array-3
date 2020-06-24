//time o(n)
//space o(1)

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length ==0)
            return;
        int n = nums.length;
        if(k>n)
        {
            k = k%n;
        }
        //reverse the array
        reverse(nums, 0, n-1);
        // for rotating towards right, reverse first k elements and then n-k elements
        reverse(nums, 0, k-1);
        //reverse n-k elements now
        reverse(nums, k, n-1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
        
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    } 
    
}