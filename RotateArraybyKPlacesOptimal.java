//Time Complexity=O(n)
//Space Complexity=O(1)
public class RotateArraybyKPlacesOptimal {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        // if(n<k) return;
        k=k%n;
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
    }
    public void reverse(int[] nums,int start,int end){
        while(start<end){
            swap(nums,start,end);
            start++;end--;
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
