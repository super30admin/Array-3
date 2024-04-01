
// TC : O(n)
// SC : O(n)

package S30_Codes.Array_3;

class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int temp[] = new int[k];
        int tempIdx = 0;
        int startIdx = n-k;

        // Add last k elements to temp array
        while(startIdx < n){
            temp[tempIdx++] = nums[startIdx++];
        }

        // Shift other elements by k in original array
        startIdx = n-k-1;
        while(startIdx >= 0){
            nums[startIdx+k] = nums[startIdx--];
        }

        // transfer temp array to original array
        startIdx = 0;
        for(int num : temp){
            nums[startIdx++] = num;
        }
    }
}