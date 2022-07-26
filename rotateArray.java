//TIme : O(n)
//Space : O(n)

class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0)
            return;
        int[] arr = new int[nums.length];
        int n = nums.length;
        k = k % n;
        int a = 0;
        for (int i = n - k; i < n; i++) {
            arr[a] = nums[i];
            a++;
        }
        int b = k;
        for (int j = 0; j < n - k; j++) {
            arr[b] = nums[j];
            b++;
        }

        for (int z = 0; z < n; z++) {
            nums[z] = arr[z];
        }
    }
}

// T : O(n)
// S : O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0)
            return;
        int[] arr = new int[nums.length];
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);

    }

    private void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}