//Problem 118 : Trapping Rain Water - Extra Space
//TC:O(N)
//SC:O(N)

/*Steps
    Bruteforce: TC:O(n^2) : Find minimum and maximum for each element, and then find difference between the minimum and current element height.

    Optimized:Using Extra Space - TC:O(N) | SC:O(2N)=>O(N)
        //1) Find max left for each index
        //2) Find max right for each index
        //3) Find Min of max left and max right for each index and then find the difference between height[i] and the min, that will be the answer how much water that index can store
        
            Eg:
            input [0,1,0,2,1,0,1,3,2,1,2,1]
            maxL  0 1 1 2 2 2 2 3 3 3 3 3      
            maxR  3 3 3 3 3 3 3 3 2 2 2 1     
  
min(maxL, maxR)   0 1 1 2 2 2 2 3 2 2 2 1
         result   0 0 1 0 1 2 1 0 0 1 0 0    
        
            input  4 2 0 3 2 5
            maxL   4 4 4 4 4 5
            maxR   5 5 5 5 5 5
                
   min(maxL, maxR) 4 4 4 4 4 5
         result    0 2 4 1 2 5 



*/

class Solution118 {
    public int trap(int[] height) {
        if(height==null || height.length==0) return 0;
        
        //1) Find max left for each index
        //2) Find max right for each index
        //3) Find Min of max left and max right for each index and then find the difference between height[i] and the min, that will be the answer how much water that index can store 
        
        //TC:O(N), SC:O(2N)=> O(N)
        int n = height.length;
        
         int[] maxLeft  = new int[n];
         int[] maxRight = new int[n];
         
         maxLeft[0] = height[0]; 
         //find max left for each index 
         for(int i=1;i<n;i++){
             maxLeft[i] = Math.max(maxLeft[i-1],height[i]);
         }
         
         maxRight[n-1] = height[n-1];
        //find max right for each index
         for(int i=n-2;i>=0;i--){
             maxRight[i] = Math.max(maxRight[i+1],height[i]);
         }
        
        //Calculating fown much water can be stored
        int result=0;
        int min = 0;
        for(int i=0;i<n;i++){
            min = Math.min(maxLeft[i],maxRight[i]);
            result += Math.abs(min-height[i]);
        }
        
        return result;
    }
}