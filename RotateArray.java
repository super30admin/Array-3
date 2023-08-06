public class RotateArray {
    //Time Complexity: O(N)
    //Space complexity: O(1)
    public void rotate(int[] nums, int k) {
        k = k% nums.length;
        //rotate array
        nums = reverse(0, nums.length - 1, nums);

        //rotate first half
        nums = reverse(0, k - 1, nums);
        //rotate second halp
        nums = reverse(k, nums.length - 1, nums);

    }
    private int[] reverse(int start, int end , int[] nums){
        while(start< end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

        return nums;
    }
}
