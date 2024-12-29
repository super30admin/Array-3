// Time complexity = O(n)
// Space complexity = O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        // reverse the whole
        // reverse the first k elements
        // reverse the remaining elements.
        reverse(nums, 0, n-1); // 7,6,5,4,3,2,1
        reverse(nums,0, k-1);// 5,6,7,4,3,2,1
        reverse(nums, k, n-1);// 5,6,7,1,2,3,4        
    }
    
    private void reverse(int[] arr,int l, int r) {
        while(l<r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}