// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We will swap each elements with the kth next element, and this with the next kth element
// We will repeat this until we have swapped n elements 
// We might encounter cycles, these cases can be handled by keeping the initial index in variable
// And checking later and moving on to the next element.
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int count = 0;
        for(int i = 0; count < n; i++){
            int cur = i;
            int prev = nums[i];
            do{
                int next = (cur + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                cur = next;
                count++;
            }while(i != cur);
        }
        
    }
}