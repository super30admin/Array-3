class Solution {
    public void rotate(int[] nums, int k) {
        // helper(nums, k);
        helperOptimized(nums, k);
    }

    private void helper(int[] nums, int k) {
        if (k == 0 || k % nums.length == 0 || nums.length == 1) {
            return;
        }
        int rotations = k % nums.length;
        int[] ans = new int[nums.length];

        for (int i = 0, r = (rotations); i < rotations; i++, r--) {
            ans[i] = nums[nums.length - r];
        }

        for (int i = 0; i < nums.length - rotations; i++) {
            ans[i + rotations] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }
        ans = null;
    }

    private void helperOptimized(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        this.reverse(nums, 0, n - 1);
        this.reverse(nums, 0, k - 1);
        this.reverse(nums, k, n - 1);

    }

    private void reverse(int[] nums, int first, int last) {
        while (first < last) {
            int temp = nums[first];
            nums[first] = nums[last];
            nums[last] = temp;
            first++;
            last--;
        }
    }
}