class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        if(height.length==0)
            return 0;
        int max = height[0];
        //left max
        for(int i=1;i<height.length-1;i++){
            left[i] = max;
            if(max<height[i]){
                max = height[i];
            }
        }
        
        //right max
        max = height[height.length-1];
        for(int i=height.length-1;i>0;i--){
            right[i] = max;
            if(max<height[i]){
                max = height[i];
            }
        }
        int sum = 0;
        for(int i=1;i<height.length-1;i++){
            int val = Math.min(left[i], right[i])-height[i];
            if(val<0) {
                val = 0;
            }
            sum = sum + val;
        }
        return sum;
    }
}

//Time complexity : O(N) where N is the length of height array
//Space complexity : O(N) extra space used by left and right arrays
