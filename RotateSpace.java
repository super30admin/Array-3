// time complexity o(n)
// space complexity o(n)

public class RotateSpace {

    public void rotate(int[] nums, int k) {

        if (nums.length == 0 || k < 1)
            return;
        if (k >= nums.length)
            k = k % nums.length;
        int[] tempAr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {

            if (i < k) {
                tempAr[i] = nums[nums.length - k + i];
            } else {
                tempAr[i] = nums[i - k];
            }
        }

        for (int i = 0; i < tempAr.length; i++) {
            nums[i] = tempAr[i];
        }
    }

}
