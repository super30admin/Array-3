//Time Complexity:O(n)
//Space Complexity:O(n)
//Approach- FIrst step is to reverse the entire array. Then the part before the kth element in the array is reversed and then the part after that is also reversed. This would give me the rotated array.
//This solution was executed successfully and got accepted in leetcode.
class Solution {
    public void rotate(int[] nums, int k) {
        if(k==0){
            return;
        }
        if(nums.length==1){
            return;
        }
        k%=nums.length;
        swap(nums,0,nums.length-1);
        swap(nums,0,k-1);
        swap(nums,k,nums.length-1);
    }
    public void swap(int[] nums,int low, int high){
        while(low<=high){
            int temp= nums[low];
            nums[low]=nums[high];
            nums[high]=temp;
            low++;
            high--;
        }
    }
}