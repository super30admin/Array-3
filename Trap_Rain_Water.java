/** Optimized solution using two arrays to calculate leftMax and rightMax seperately 
    Time: O(n)
    Space: O(n)
*/
class Solution {
    
    public int trap(int[] height) {
        
        int result = 0;
        int n = height.length;
        int[] leftArray = new int[n];
        int[] rightArray = new int[n];
        
        int leftMax = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
        {
            leftMax = Math.max(leftMax, height[i]);
            leftArray[i] = leftMax;
        }
        
        int rightMax = Integer.MIN_VALUE;
        for(int j=n-1; j>0; j--)
        {
            rightMax = Math.max(rightMax, height[j]);
            rightArray[j] = rightMax;
        }
        
        for(int k=0; k<n; k++)
        {
            result += (Math.min(leftArray[k], rightArray[k]) - height[k]);
        }
        
        return result;
    }
}


/** BruteForce Approach: calculate the how much water every single building can hold,
    at every point calculate leftMax & rightMax 
    take minimum of them and subtract the height of the building 
    Time: O(n^2)
    Space: O(1)


class Solution {
    
    public int trap(int[] height) {
        
        int result = 0;
        int leftMax = 0, rightMax= 0;
        
        for(int i=0; i<height.length; i++)
        {

            leftMax = height[i];
            
            // Calculate leftMax for i
            for(int l=0; l<i; l++)
            {
                leftMax = Math.max(leftMax, height[l]);
            }
            
            rightMax = height[i];
            
            //Calculate rightMax for i 
            for(int r=i+1; r < height.length; r++)
            {
                rightMax = Math.max(rightMax, height[r]);
            }
            
            result += (Math.min(leftMax, rightMax)) - height[i];
            System.out.println(result);
        }
        
        return result;
        
    }
    
}
**/



/*class Solution {
    
    //time complexity: o(n)
    //space : o(1)
    public int trap(int[] height) {
        
        int max_left = 0;
        int max_right = 0;
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        
        while(left <= right)
        {
            if(height[left] < height[right])
            {
                if(height[left] >= max_left)
                    max_left = height[left];
                else
                    result += max_left - height[left];
                left++;
            }else
            {
                if(height[right] >= max_right)
                    max_right = height[right];
                else
                    result += max_right - height[right];
                right--;
            }
            
        }
        
        return result;
    }
}*/
