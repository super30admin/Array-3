/* time - O(kn) space - O(1)
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        if nums is None or len(nums) == 0:
            return
        
        n = len(nums)
        
        if k > n:
            k = k % n
        
        for i in range(k):
            previous = nums[n-1]
            
            for i in range(n):
                temp = nums[i]
                nums[i] = previous
                previous = temp


class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return;
        
        int n = nums.length;
        if (k > n)
            k = k % n;
        
        for (int i=0; i<k; i++){
            int previous = nums[n-1];
            for (int j=0; j<n; j++){
                int temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
}

*/
// one more approach where we can take empty array and place elements starting from k to n-1 first and then elements starting from 0 to k-1
// time would be O(n) but space is O(n)

/*
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        if nums is None or len(nums) == 0:
            return
        
        n = len(nums)
        if k > n:
            k = k % n
        self.reverse(nums, 0, n-1)
        self.reverse(nums, 0, k-1)
        self.reverse(nums, k, n-1)
    
    def reverse(self, nums, l, r):
        while l < r:
            self.swap(nums, l, r)
            l += 1
            r -= 1
            
    def swap(self, nums, i, j):
        temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
*/

// Time - O(n)
// Space - O(1)
// Logic - first reversed entired array and then reversed 0 to k elements and from k elements to n-1 separately
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return;
        
        int n = nums.length;
        if (k > n)
            k = k % n;
        
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    
    private void reverse(int[] nums, int l, int r){
        while (l < r){
            swap(nums, l, r);
            l++;
            r--;
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}