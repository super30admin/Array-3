class Solution {
    public int trap(int[] height) {
        
        int left =0 , right = height.length-1;
        int total = 0, mL= height[left], mR= height[right];
        while(left<right)
        {int leftVal = height[left];
         int rightVal = height[right];
         
         if(leftVal<rightVal)
         {
             left++;
             mL= Math.max(mL, height[left]);
             total+= mL-height[left];
         }
         else
         {
             
             right--;
             mR= Math.max(mR, height[right]);
             total+= mR-height[right];
             
         }
            
            
        }
        
        return total;
        
        
        
    }
}