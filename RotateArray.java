// Time Complexity: O(n)

class RotateArray {

    // Space Complexity: O(n)
    public void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            arr[(i+k)%nums.length] = nums[i];
        }

        for(int i = 0; i < nums.length; i++){
            nums[i] = arr[i];
        }
    }

    // Space Complexity: O(1)
    public void rotateInPlace(int[] nums, int k){
        int n = nums.length;

        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);

    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
