//TC-O(N) SC-O(1)
public class RotateArray {
    public void rotate(int[] nums, int k) {
        if(k==0){
            return;
        }
        if(nums.length==1){
            return;
        }

        k%=nums.length;
        swap(nums,0,nums.length-1);
        swap(nums,0,k-1);
        swap(nums,k,nums.length-1);

    }

    public void swap(int[] nums,int low, int high){
        while(low<=high){
            int temp= nums[low];
            nums[low]=nums[high];
            nums[high]=temp;
            low++;
            high--;
        }
    }

}
/*
//TC-O(N) SC-O(N)
  public void rotate(int[] nums, int k) {
        int length=nums.length;
        k=k%length;
        int[] resultArr= new int[length];
        for (int i = 0; i < k; i++) {
          resultArr[i] = nums[length - k + i];
         }
        for (int i = 0; i < length - k; i++) {
          resultArr[k + i] = nums[i];
        }
           int n=0;
        for(int i:resultArr){
           nums[n++]=i;
        }
    }


 */