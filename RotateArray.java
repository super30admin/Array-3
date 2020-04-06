// ===================== Approach-1 ==========================
/*
Time:O(N(K%N)), space: O(1)
Approach:
========
1. Save last element of array and push remaining elements 0..n-2 to right
2. Saved element is now stored in index 0
3. Same step has to be done k%n times to rotate array by k
*/
class Solution {
    public void rotate(int[] nums, int k) {
        if(k == 0 || nums == null || nums.length == 0) return; 
        k = k%nums.length;
        int n = nums.length;
        while(k != 0) {
            // store last element
            int curr = nums[n-1];
            //push remaining n-1 elements to right
            for(int i = n-1; i > 0; i--) {
                nums[i] = nums[i-1];
            }
            // add saved element to index 0
            nums[0] = curr;
            k--;
        }
    }
}

// ================= Approach-2 ==============================
/*
Time: O(N)
Space: O(1)
Approach:
1. Reverse entire array
2. Reverse first k and last k elements separately
3. This will give the rotated array by k
*/
class Solution {
    public void rotate(int[] nums, int k) {
        if(k == 0 || nums == null || nums.length == 0) return; 
        
        k = k%nums.length;
        //reverse entire array [7,6,5,4,3,2,1]
        reverse(nums, 0, nums.length - 1); 
        //reverse first k
        reverse(nums, 0, k-1);
        //reverse last k
        reverse(nums, k, nums.length - 1); 
    }
    
    //reverse array
    private void reverse(int[] nums, int start, int end) {
        while(start <= end) {
            int temp = nums[start]; 
            nums[start] = nums[end]; 
            nums[end] = temp; 
            end--;
            start++;
        }
        return; 
    }
}