public class RotatedArray {
//TC O(n)
    //SC O(1)
    //https://leetcode.com/problems/rotate-array/description/
    public static void main(String[] args) {
        int[] nums ={1,2,3,4,5,6,7};
        int k = 3;
       rotate(nums,k);
    }

    public static void rotate(int[] nums, int k) {
        if(nums==null|| nums.length==0) return;
        int n = nums.length;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
/*
reverse(nums,n-k,n);
        reverse(nums,0,n-k-1);
        reverse(nums,0,n-1);
* */

    }

    private static void reverse(int[] nums, int l, int r) {
        while(l<=r){
            swap(nums,l,r);
            l++;
            r--;
        }


    }

    private static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l]=nums[r];
        nums[r]=temp;
    }
    //TC - O(n) //SC - O(n)
    /*
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
         int n = nums.length;
        int[] res = new int[n];
        for (int i=0; i<n; i++) {
            int newIndex = (i + k) % n;
            res[newIndex] = nums[i];
        }

        for (int i=0; i<n; i++) {
            nums[i] = res[i];
        }
    }
*/
    //TC - O(n) //SC - O(n)
    /*
    public static void rotate(int[] nums, int k) {
        if(nums==null|| nums.length==0) return;
        int n = nums.length;
        int[] newNums = Arrays.copyOf(nums,n);
        Arrays.fill(nums,0);
        int count=0;
        for (int i = n-k; i < n ; i++) {
            nums[count]= newNums[i];
            count++;
        }
        for (int i = 0; i < n-k ; i++) {
            nums[count]= newNums[i];
            count++;
        }
        System.out.println(Arrays.toString(newNums));
    }*/
    //TC - O(n*k) //SC - O(1)
    /*
    public static void rotate(int[] nums, int k) {
        if(nums==null|| nums.length==0) return;
        int n = nums.length;
        for(int i = 0;i<k;i++) {
            int temp = nums[n - 1];
            nums[n - 1] = 0;
            for (int j = n - 1; j > 0; j--) {
                int temp2 = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp2;
            }
            nums[0] = temp;

        }

    }*/
}
