//T.C O(n)
//S.C O(1)
//Did the code run in LeetCode: yes

//Look at the expected solution and understand the pattern, we can reverse the entire array and then reverse
// first k elements and next n-k elements
class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverse(nums,0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums,k, n-1);
    }
    private void reverse(int[] arr, int l, int r){
        while(l<r){
            swap(arr,l,r);
            l++;
            r--;
        }
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]= temp;
    }
}