public class RotateArrayByKPlaces {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(nums==null || n<0) return;
        if(k>=n) k = k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }

    private void reverse(int[] nums, int left, int right){
        while(left<=right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// TC - O(n)
// SC - O(1)
