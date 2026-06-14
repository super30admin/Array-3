//Time Complexity: O(n)
//Space Complexity: O(1)
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverse(nums,0, n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }

    public void reverse (int[] temp, int l, int r) {
        while (l < r) {
            int tmp = temp[l];
            temp[l] = temp[r];
            temp[r] = tmp;
            l++;
            r--;
        }
    }
}
