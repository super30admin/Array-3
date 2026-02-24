//Reverse entire array: 7,6,5,4,3,2,1
//Revese till k elements: 5,6,7,4,3,2,1
//Reverse k to last elements: 5,6,7,1,2,3,4

//TC: O(2n)
//SC:O(1)
class Solution {
    public void rotate(int[] nums, int k) {
    
        int n=nums.length;
        if(k>n){
            k=k%n;
        }
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
        
    }


    private void reverse(int[] nums,int l, int r){
        while(l<=r){
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;

            l++;
            r--;
        }
    }
}
