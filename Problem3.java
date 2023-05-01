//Time -> O(n)
//Space -> O(1)

class Problem3 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(nums == null || nums.length == 0)
            return; 
        if(k >= n){
            k = k%n;
        }

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    private void reverse(int[] nums, int i, int j){
        while(i <= j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    private void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j]; 
        arr[j] = temp;
    }
}