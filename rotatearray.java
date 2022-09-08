// tc: O(n)
// sc: O(1)


class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length==0) return;
        int n= nums.length;
        if(k>n){
            k=k%n;
        }
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
    }
    private void reverse(int[] nums,int i,int j){
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }        
    }
}
