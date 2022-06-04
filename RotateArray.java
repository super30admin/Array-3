//TC = O(N)
//SC = O(1)

/*
 * Since we need to make K shifts, last k elements are reversed,
 * then first n - k elements are reversed.
 * then the whole array is reversed.
 */

public class RotateArray {
    
    public static void rotate(int[] nums, int k)
    {
        if(nums == null || nums.length == 0) return;

        int n = nums.length;
        k = k%n;

        reverse(nums,n-k,n-1);
        reverse(nums,0,n-k-1);
        reverse(nums,0,n-1);
    }

    public static void reverse(int nums[],int l,int r)
    {
        while(l<=r)
        {
            int temp = nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
    }

    public static void main(String args[])
    {
        int[] nums = {1,2,3,4,5,6,7};

        rotate(nums, 3);
        for(int i: nums)
        {
            System.out.print(i+" ");
        }
    }
}
