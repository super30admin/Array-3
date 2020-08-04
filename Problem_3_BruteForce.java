// Time complexity - O(nk)
// Space complexity - O(1)

// Brute force - move One element at a time

class Solution {
    public void rotate(int[] arr, int k) {
        int n = arr.length;
		k = k%n;
		int index = 0;
		while (k > 0) {
			int tmp = arr[n - k];
			for (int i = n - k; i > index; i--) {
				arr[i] = arr[i - 1];
			}

			arr[index++] = tmp;
			k--;
		}
    }
}
