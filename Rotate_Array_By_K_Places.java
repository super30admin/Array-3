/**
    Time: O(n)
    Space: O(1)
**/
class Solution {
    public void rotate(int[] nums, int k) {
        
        if(k == 0)
            return;
        
        int n = nums.length;
        
        /* if k = 18 then we just need to take care of remaining reminder part*/
        k = k % n;
        
        /*reverse the whole arrray if k > 1 */
        reverse(nums, 0, n-1);
        
        /* reverse the part till k */
        reverse(nums, 0, k-1);
        
        /* reverse the last part from k */
        reverse(nums, k, n-1);
        
    }
    
    private void reverse(int[] nums, int start, int end)
    {
        while(start < end)
        {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    private void swap(int[] nums, int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}



/* BruteForce:  shift last element to first for k times
   Time: O(n^2)
   Space: O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        
        while(k > 0)
        {
            int temp = nums[n-1];
            int i = n-1;
            while(i != 0)
            {
                nums[i] = nums[i-1];
                i--;
            }
            nums[0] = temp;
            k--;
        }
        
        
    }
}*/
