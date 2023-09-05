import java.util.Arrays;

public class Problem189 {
//TC=0(n)
//SC=O(1)
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        if(nums==null || n==0)
            return;
        if(k>n)
            k=k%n;
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] nums,int left, int right){
        while(left<=right){
            swap(nums,left,right);
            left++;
            right--;
        }

    }

    private void swap(int[] nums, int idx1, int idx2){
        int temp = nums[idx1];
        nums[idx1]=nums[idx2];
        nums[idx2]=temp;
    }

    public static void main(String[] args) {
        Problem189 problem=new Problem189();
        problem.rotate(new int[]{1,2,3,4,5,6,7},3);
    }
}
