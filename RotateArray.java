public class RotateArray {
    public void rotate(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return;
        }

        int n = nums.length;
        // to take care of this when k is larger than n. this will also work when k is regular
        k = k%n;
        // first reverse entire array
        reverse(nums, 0,n-1);
        // reverse first k elements (0-k-1)
        reverse(nums, 0,k-1);
        // reverse n-k elements (k-n-1)
        reverse(nums, k, n-1);
    }

    private void reverse(int[] nums, int l, int r){
        while(l<=r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
