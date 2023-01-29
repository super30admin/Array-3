
public class RotateArray {
	 // TIme O(N)
	 //Space O(N)
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] temp = new int[len];

        for(int i=0;i<len;i++){
            temp[(i+k)%len] = nums[i];
        }
        for(int i=0;i<len;i++){
            nums[i] = temp[i];
        }
    }

    // Time O(N)
    //Space O(1)
    public void rotateWithNoExtraSpace(int[] nums, int k) {
       if(k>nums.length)
        {
            k = k % nums.length;
        }
       reverse(nums,0,nums.length-1);
       reverse(nums,0,k-1);
       reverse(nums,k,nums.length-1);

    }
    private void reverse(int[] nums ,int startIdx,int endIdx){
        while(startIdx <= endIdx){
            int temp = nums[startIdx];
            nums[startIdx] = nums[endIdx];
            nums[endIdx] = temp;
            startIdx++;
            endIdx--;
        } 
    }
    
}
