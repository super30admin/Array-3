// TC => O(n)
// SC => O(1)
public class Solution
{
    public void Rotate(int[] nums, int k)
    {
        if (nums == null || nums.Length == 0 || k == 0)
        {
            return;
        }

        int n = nums.Length;
        k = k % n;
        Reverse(nums, 0, n - 1);
        Reverse(nums, 0, k - 1);
        Reverse(nums, k, n - 1);
    }

    public void Reverse(int[] nums, int start, int end)
    {
        int i = start;
        int j = end;

        while (i < j)
        {
            Swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void Swap(int[] nums, int start, int end)
    {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}