class RotateArrayByKPlaces {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        if(n==0)
            return;

        if(k>n)
            k=k%n;

        reverseArray(nums,0, n-k-1);
        reverseArray(nums, n-k, n-1);
        reverseArray(nums,0,n-1);

    }

    public void reverseArray(int[] arr, int l, int r){
        while(r>l){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
