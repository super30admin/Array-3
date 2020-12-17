package Dec16;

class RotateArray {
    public void rotate(int[] nums, int k) {
        
        /*
        Time complexity: O(n) + O(n) ~= O(n)
        Space complexity: No extra space used.
        Approach: 
        Rotate to right-
        Given array: 1,2,3,4,5,6,7,8,9
        k = 3
        1) Reverse the array.
            9,8,7,6,5,4,3,2,1
        2) Reverse the first k elements., i.e. elements from 0 to k-1 index.
            7,8,9,6,5,4,3,2,1
        3) Reverse the elements from index k to n-1.
            7,8,9,1,2,3,4,5,6.
            
        NOTE: 
        If reverse to left needs to be done:
        1) Reverse the array
        2) Reverse the first n-k elements, i.e.elements from 0 to n-k-1 index.
        3) Reverse the first k elements, i.e.elements from n-k to n-1 index.
        
        */
        
        // edge
        if (nums == null || nums.length == 0) {
            return; 
        }
        int n = nums.length;
        // Rotating an array of length 4 by 5 places is same as rotating the array by 1 place.
        if (k >= n) {
            k = k % n;
        }
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    
    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++; 
            r--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
