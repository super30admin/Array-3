//TC: O(n)
//SC: O(1)
//approach: reverse entire array, then reverse two array partitions, from 0 to k-1, and k to n-1 separately

public class RotateArrayByKPlaces {

    public void rotate(int[] nums, int k) {
        if(nums.length==1 || k==0) return;

        k = k%nums.length;
        reverseArray(nums, 0, nums.length-1);
        reverseArray(nums, 0, k-1);
        reverseArray(nums, k, nums.length-1);
    }

    private void reverseArray(int[] nums, int startIndex, int endIndex){
        while(startIndex<endIndex){
            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}
