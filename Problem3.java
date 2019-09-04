public class rotateArray {
    // Time : O(n) Space : O(1)
    // 1.find gcd of n and k and divide array into gcd sets and each set length will be n/gcd;
    // 2.now next element in each set will be i+k . Swap first element of set with next element . Do this for all elements in set and 
    // 3.repeat step 2 for all sets . Now array will be rotated.
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        if(nums.length <= 1 || k == 0){
            return;
        }
        int noOfSets = gcd (nums.length , k);
        for (int i = 0; i < noOfSets; i++) {
            int j = i;
            int count = nums.length / noOfSets - 1;
            for (int m = 0; m < count; m++) {
                j = (j + k) % nums.length;
                swap(nums, j, i);
            }
        }
    }


    private static int gcd (int n1, int n2){
        if(n1 % n2 == 0) return n2;
        else return gcd(n2, n1 % n2);
    }

    private static void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    // Time : O(n) Space : O(1)
    // reverse entire array, then reverse first k elements and then reverse remaining n-k elements.

    public static void rotate2(int[] nums, int k) {
        k = k%nums.length;
        if(nums.length == 1 || k == nums.length) return;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public static void reverse(int[] nums,int l,int r){
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
    //Time : O(n) Space : O(n)
    // store all elements into a secondary array . Start from n-k position and replace elements accordingly.
    public void rotate3(int[] nums, int k) {
        if(k>nums.length) k = (k - nums.length)%nums.length;
        int[] result = new int[nums.length];
        for(int i = 0;i<nums.length;i++)
            result[i] = nums[i];
        int j = 0;
        for(int i = nums.length-k;i<nums.length;i++){
            nums[j] = result[i];
            j++;
        }
        int i = 0;
        while(j<nums.length){
            nums[j] = result[i];
            i++;
            j++;
        }
    }
    //Time : O(n*k) Space : O(1)
    // start from last element and keep swapping i and i-1 indexed elements till start of array . Do this k times.
    public void rotate4(int[] nums, int k) {
        while(k>0){
            for(int i = nums.length-1;i>0;i--){
                swap(nums,i,i-1);
            }
            k--;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12};
        int k = 3;
        rotate(nums,k);
    }
}
