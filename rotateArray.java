// Time Complexity : O(n)
// Space Complexity :O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums==null || nums.length==0 || k==0) return;
        k=k%nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        
    }
    
    private void reverse(int[] array, int l, int r){
         while(l<r && r<array.length && l<array.length){
            int temp=array[l];
            array[l++] = array[r];
            array[r--] = temp;   
        }
        
    }
}