// O(n) time: single pass
// O(1) space

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length; // in case k > length, just take remainder
        
        int count = 0; // count how many numbers have been moved
        for (int start = 0; count < nums.length; start++){
            int currentIdx = start;
            int currentVal = nums[start];
            do{
                int nextIdx = (currentIdx + k) % nums.length;
                int nextVal = nums[nextIdx]; // temporary variable
                nums[nextIdx] = currentVal;
                currentIdx = nextIdx;
                currentVal = nextVal;
                count++; // increment
            } while (start != currentIdx); // until we return back to original start
        }
    }
}