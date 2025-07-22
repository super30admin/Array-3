class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int totalwater = 0;
        int leftmax = 0;
        int rightmax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftmax) {
                    leftmax = height[left];
                } else {
                    // No, the leftMax wall is taller than the current wall.
                    // This means water can be trapped here.
                    // The amount is the difference between the water level (leftMax) and the ground
                    // (height[left]).
                    totalwater += leftmax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightmax) {

                    rightmax = height[right];
                } else {
                    // No, the rightMax wall is taller. Water is trapped.
                    totalwater += rightmax - height[right];
                }
                // Move the right pointer inward.
                right--;
            }
        }
        return totalwater;
    }
}

//
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return;
        }
        int n = nums.length;
        k = k % n;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

//
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }
}