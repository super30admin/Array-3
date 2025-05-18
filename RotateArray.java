class RotateArray {
    public void rotate(int[] nums, int k) {
        int i=0; 
        int j = nums.length-1;
        rotate(nums, i, j); //O(n)
        k = k%nums.length;
        rotate(nums, 0, k-1); //O(k)
        rotate(nums, k, nums.length -1); //O(n-k)
    }

    private void rotate(int[] nums, int i, int j){
        while(i<j){ // O(n)
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}

/*
 * Time Complexity => O(n) + O(n-k) + O(k) = O(2n) => O(n)
 * Space Complexity: O(1)
 */