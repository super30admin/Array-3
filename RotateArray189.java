class Solution {
//     Obs1: k > nums.length ==> k = k % nums.length
//     Approach1: O(kn) O(1) temp = arr[kth], now move remaining elemnts forward, a[0]= temp
//     Approach2: O(n)  O(1) result[] and inserting elements in its correct position
//     Approach3: O(n)  O(1) Reversing the array, then first k elements and then remaining elements
    
    // Approach3:    
    // Time Complexity: O(n)
    // Space Complexity:O(1)

    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return;
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    public void reverse(int[] arr, int start, int end){
        int temp;
        while(start < end){
            temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }
}