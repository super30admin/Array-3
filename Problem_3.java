//Time Complexity:O(n)
//Space Complexity:O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        reverse(nums, 0,n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    private void reverse(int[] nums, int a, int b){
        while(a<b){
            swap(nums, a, b);
            a++;
            b--;
        }
    }
    private void swap(int[] nums, int i , int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}