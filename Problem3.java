//Time Complexity: O(n); where n is the length of nums array
//Space Complexity: O(1)
//Code run successfully on LeetCode.

public class Problem3 {

    public void rotate(int[] nums, int k) {
        
        if(nums == null|| nums.length ==0|| k ==0)
            return;
        
        int n = nums.length;
        k = k %n;
        
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1); 
    }
    
    private void reverse(int[] nums, int low, int high)
    {
        int temp = 0;
        while(low < high)
        {
           temp = nums[low];
           nums[low] = nums[high];
           nums[high] = temp;
           low++;
           high--;
        }
    }
}
