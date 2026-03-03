//Approach :
// Reduce k with modulo to handle cases where k > n.
// Reverse the whole array, then reverse the first k elements and the remaining n-k elements.
// This effectively rotates the array to the right by k.

// Complexities:

// Time: O(n) 
// Space: O(1) 
class Solution
{
    public void Rotate(int[] nums, int k)
    {

        k = k % nums.Length;
        Reverse(nums, 0, nums.Length - 1);
        Reverse(nums, 0, k - 1);
        Reverse(nums, k, nums.Length - 1);
    }
    public void Reverse(int[] nums, int start, int end)
    {
        while (start < end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}




