/*
Way1
Brute force keep shifting elements one step right k times Here time complexity is O(nk) and space complexity is O(1)

Way2
Place original value at i into i+k% array of length position of a new array . Here time complexity O(n) but space complexity is O(n)

Executed on leetcode

Approach:
For rotate right:
Step1: reverse entire array           --O(n) by swapping the first and last and then moving inward from both the ends of array till the entire array is reversed.
Step1 : reverse first half 0 to k-1    --O(k)
Step2: reverse second half k to n      --- O(n-k)

*/

class Solution {
    public void rotate(int[] nums, int k) {
      if(nums == null || nums.length ==0) return;
        int n = nums.length;
        
      if(k > n){ k = k%n; }  //for every remainder 0 rotation gives out original 
        
      reverse(nums,0,n-1);
      reverse(nums,0,k-1);
      reverse(nums,k,n-1);  
    }
    
    private void reverse(int[] nums, int firstIdx,int lastIdx){
        while(firstIdx < lastIdx){
            swap(nums,firstIdx,lastIdx);
            firstIdx++; lastIdx--;
        }
    }
    
    private void swap(int[] nums,int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}



/*
Time complexity : O(n) +O(k) +O(n-k) = O(2n)  Hence asymototically O(n)
Space complexity: O(1)
*/