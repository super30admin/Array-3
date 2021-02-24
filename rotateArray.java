class Solution {
    public void rotate(int[] nums, int k) {
     
        int n = nums.length;
        if(nums == null || nums.length == 0)
            return;
        
        if(k > n)
            k = k%n;
        
        //initally reverse the whole array
        reverse(nums,0,n-1);
        //reverse the first k elements
        reverse(nums,0,k-1);
        //reverse the elements from k+1 elements till the end of the array
        reverse(nums,k,n-1);
    }
    
    private void reverse(int[] nums,int l, int r){
        while(l<=r){
            swap(nums,l,r);
            l++;
            r--;
        }
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

//Time Complexity: O(nk)
//Space Complexity: O(1)
