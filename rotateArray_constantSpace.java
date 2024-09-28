// Time Complexity : O(n) where n is the length of the array A
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class rotateArray_constantSpace {
    public void rotate(int[] A, int k) {
        if (A.length <= 1 || k == 0) return;
        int n = A.length;
        k = k % n;
        reverse(A, 0, n-1);
        reverse(A, 0, k-1);
        reverse(A, k, n-1);
    }
    private void reverse(int[] A, int start, int end) {
        while (start < end) {
            swap(A, start, end);
            start++;
            end--;
        }
    }
    private void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}