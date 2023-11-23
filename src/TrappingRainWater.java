// Time Complexity:  O(n)
// Space Complexity: O(n)

class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int water=0;
        int left[]=new int[n];
        int right[]=new int[n];
        left[0]=height[0];
        right[n-1]=height[n-1];
        for(int i=1;i<n;i++){
            left[i]=Math.max(left[i-1],height[i]);
            right[n-i-1]=Math.max(right[n-i],height[n-i-1]);
        }
        for(int i=0;i<n;i++){
            water+=Math.min(left[i],right[i])-height[i];
        }
        return water;
    }
}





// ******************** Another Solution ********************
//
// // Time Complexity:  O(n)
// // Space Complexity: O(1)
//
//
// class Solution 
// {
//     public int trap(int[] height) 
//     {
//         int start = 0 ;
//         int end = height.length-1 ;
//         int water = 0 ;
//         int max1 = start ;
//         int max2 = end ;
        
//         while(start<end)
//         {
//             if(height[start]<height[end])
//             {
//                 start++ ; 
//                 if(height[max1]<height[start])
//                     max1 = start ;
//                 else
//                     water+=height[max1]-height[start];  
//             }    
//             else
//             {
//                 end-- ;   
//                 if(height[max2]<height[end])
//                     max2 = end ;
//                 else
//                     water+=height[max2]-height[end];
//             }
//         }
//         return water;
//     }
// }
