// Time Complexity : O(n) where n is the length of the array A
// Space Complexity : O(n) where n is the length of the array A
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class rotateArray_nSpace {
    public void rotate(int[] A, int k) {
        if (A.length <= 1 || k == 0) return;
        int n = A.length;
        int[] nums = new int[n];
        k = k % n;
        int j = k, l = 0;
        for (int i = 0; i < n; i++) {
            nums[(i + k) % n] = A[i];
        }
        System.arraycopy(nums, 0, A, 0, n);
        return;
    }
}