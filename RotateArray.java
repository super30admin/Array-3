// the solution is as follows. If the array has n elements and you want to rotate it k places, reverse the first n-k elements of the array. Also reverse the rest of the k elements of the array. Now, reverse the entire new array. For example consider the input  1,2,3,4,5,6,7,8,9  and let k=2. Reversing the first n-k and the rest of the k elements , we have 7,6,5,4,3,2,1 9,8. Now reverse the entire array and we have 8,9,1,2,3,4,5,6,7 which is the final answer. Make sure to take k = k%n for cases whhen k is greater than n.
//Time O(n)
//Space O(1)
class Solution {
    public void rotate(int[] nums, int k) {
  
       if(nums==null || nums.length==0)
           return;
      int n = nums.length;
      k=k%n;
      
      reverse(nums,0,n-1-k);
      reverse(nums,n-k,n-1);
      reverse(nums,0,n-1);
        
        
    }
    
    private void reverse(int [] nums , int start, int end)
    {   int temp;
        while(start<end)
        {
            temp= nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}