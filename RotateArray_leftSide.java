//rotate left
class Solution {
    public void rotate(int[] nums, int k) {
       if(nums == null || nums.length == 0) return;
        int n = nums.length;
        
        if(k>n) {
            k = k%n; //rotates to original array for every remainder 0
        }
        
        reverse(nums,0,n-1);
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
    }
    
    private void reverse(int[] nums,int firstIdx, int lastIdx){
        while(firstIdx < lastIdx){
            swap(nums,firstIdx,lastIdx);
            firstIdx++; lastIdx--;
        }
    }
    
    private void swap(int[] nums,int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/*
[1,2,3,4,5,6,7]
3
Output
[4,5,6,7,1,2,3]

Time complexity : O(n) + O(n-k)+ O(k) ==> Aysmtotically O(n)
Space complexity : O(1)
*/