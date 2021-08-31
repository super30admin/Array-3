//Time complexity: O(N), where N is the length of the nums array.
//Space complexity: O(1)

class Solution3 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n == 1 ) return;
        
        k = k%n;
        if(k==0 || k == nums.length) return;
        
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1); 
        reverse(nums, k, n-1);
    }
    
    public void reverse(int[] nums, int index1, int index2) {
        while(index1 < index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp; 
            index1++;
            index2--;
        }
    }
}