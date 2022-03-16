trapping rain water
//Time complexity : O(N)
//Space complexity: O(1)

class Solution {
    public int trap(int[] height) {
      int leftMax[] = new int[height.length];
        int rightMax[] = new int[height.length];
        
        Arrays.fill(leftMax, 0);
        Arrays.fill(rightMax, 0);
        
        // calculate leftMax for ith position without i
        for(int i=1; i<height.length-1; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
        }
        
        // calculate rightmax for ith position without i
        for(int i = height.length-2; i>0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
        }
        
        int sum = 0;
        // sum for all the positive value as if there is a negative value then it means at that place water cannot be stored
        for(int i=0; i<height.length; i++) {
            sum += Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        
        return sum;
    //}   
    }
}

H-Index
//Time complexity : O(N)
//Space complexity: O(N)

class Solution {
    public int hIndex(int[] citations) {
      int[] counts = new int[citations.length + 2];
      for (int i = citations.length - 1; i >= 0; i--)  
            counts[Math.min(citations[i], citations.length)]++;
             int h;
            for (h = citations.length; h > 0; h--) {
            counts[h] += counts[h + 1];
            if (counts[h] >= h)  break;
        }
        return h;
    }
}


Rotate array
//Time complexity :O(N)
//Space complexity :O(1)
public void rotate(int[] nums, int k) {
     
    if (k >nums.length){
        k = k%nums.length;
     }
    int end = nums.length;
    
    nums = reverse(nums,0,end-k-1);
    nums = reverse(nums,end-k,end-1);
    nums = reverse(nums,0,end-1);
 }
    
    private int[] reverse(int[] nums, int start, int end){
       
       while(start<end){
       int temp = nums[start];
       nums[start] = nums[end];
       nums[end] = temp;
       start++; end--;
       }
       return nums;
    }
