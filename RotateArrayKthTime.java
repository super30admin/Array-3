// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach

// 1. reverse the entire array
// 2. reverse the 0 to k-1 elements
// 3. reverse the k to n-1 elements
//Note : make sure to set k = k%n if k > n  // if k>n then  element will be at same postions as they were in  k%n step for example if elments are [1,2] and k =3 then step 1 [2,1] step 2 [1,2] step 3 [2,1] same as on 3%2 = 1 step
        
*/


class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length == 1) return;
        int n = nums.length;
     
        if(k>n) k = k%n; // if k>n then  element will be at same postions as they were in  k%n step for example if elments are [1,2] and k =3 then step 1 [2,1] step 2 [1,2] step 3 [2,1] same as on 3%2 = 1 step
        
        reverseArray(nums,0,n-1);
        reverseArray(nums,0,k-1);
        reverseArray(nums,k,n-1);
        
        
    }
    
    private void reverseArray(int[] nums, int p1 , int p2)
    {
        while(p1<p2)
        {
            int temp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = temp;
            
            p1++;
            p2--;
        }
    }
}