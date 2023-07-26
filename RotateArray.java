// Time Complexity :O(n) where n is the number of elements in the nums array
// Space Complexity :O(1) as no auxiliary space is used
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

public class RotateArray {
    public void rotate(int[] nums, int k) {

        if(nums == null || nums.length < 1 || k == 0){
            return;
        }

        int length = nums.length;
        k = k % length;

        //reverse the entire array first
        reverse(nums, 0, length-1);
        //then reverse the first k elements
        reverse(nums, 0, k-1);
        //reverse the n-k elements
        reverse(nums, k, length-1);

    }

    private void reverse(int[] arr, int start, int end){
        if(start < 0 || start >= arr.length || end < 0 || end >= arr.length ){
            return;
        }
        while(start < end && start < arr.length && end >=0){
            swap(arr, start,end);
            start++; end--;
        }
    }

    private void swap(int[] arr, int i, int j){
        if(arr[i] != arr[j]){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
