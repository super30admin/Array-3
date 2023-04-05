public class RotateKtimes {
    //TC=O(n) SC=O(1)
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(nums==null||nums.length==0)return;
        if(k>=n)k=k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);

    }

    private void reverse(int[] nums,int l,int r){
        while(l<r){
            swap(nums,l,r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums,int i,int j){
        if(i!=j){
            nums[i] = nums[i] + nums[j];
            nums[j] = nums[i] - nums[j];
            nums[i] = nums[i] - nums[j];
        }
    }
}
