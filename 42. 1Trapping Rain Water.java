class Solution {// time of O(2n)and space of O(n)
    public int trap(int[] height) {
        int n = height.length;
        //base case 
        if(height.length<= 2)
            return 0;
        //int[] leftmax = new int[n] ;
        int[] rightmax = new int[n];
        //leftmax[0] = height[0];
        rightmax[n-1] = height[n-1];
        for(int j= n-2; j>=0; j--){
            //leftmax[i] = Math.max(leftmax[i-1], height[i]);
            rightmax[j] = Math.max(rightmax[j+1],height[j]);
        }
        int result = 0;
        int leftmax =height[0];
        //Calculating result along with leftmax
        for(int i=1 ; i<n-1  ; i++){
            leftmax = Math.max(leftmax, height[i]);
            result += Math.min(rightmax[i],leftmax) - height[i];
        }
         return result;
        }
        
    }