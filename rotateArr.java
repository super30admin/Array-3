// O(n)
class Solution {
    public void rotate(int[] nums, int k) {
        int n= nums.length;
        if(k>=n) k= k%n;             //
        System.out.println(k);
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k, n-1);
    }
    
    private void reverse(int []nums, int start, int end){
        int i=start;
        int j=end;
        while(i<j){
            int temp= nums[i];
            nums[i]= nums[j];
            nums[j]= temp;
            i++;
            j--;
        }
    }
}
