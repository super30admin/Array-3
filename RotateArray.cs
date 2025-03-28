// time complexity - O(n)
// space complexity - O(1)
public class Solution
{
    public void Rotate(int[] nums, int k)
    {
        int n = nums.Length;
        k %= n; // Handle cases where k > n
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    public void reverse(int[] nums, int start, int end)
    {
        while (start < end)
        {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}