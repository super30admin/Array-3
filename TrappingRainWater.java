//Time Complexity = O(n)
//Space Complexity =O(n)
//Did you run it on leet code :yes


class Solution {
    public int trap(int[] height) {
      
        
         if(height == null || height.length == 0)
            return 0;
        
        int[] leftMax = new int[height.length] ;
        int[] rightMax = new int[height.length];
        leftMax[0] = 0;
        rightMax[height.length-1] = 0;
        int trappedWater = 0;
        for(int i = 1 ; i < height.length-1; i ++){
         
           leftMax[i] = Math.max(leftMax[i-1] , height[i-1]);
            
        }
        
        for(int i = height.length - 2; i>= 0; i--){
            
          rightMax[i] = Math.max(rightMax[i+1] , height[i+1]);
    
            if(Math.min(leftMax[i] , rightMax[i]) - height[i] > 0)
             trappedWater+= Math.min(leftMax[i] , rightMax[i]) - height[i];            
        }
        
       return trappedWater;
    }
}
















//Time Complexity : O(n)
//Space Complexity : O(1)
// Did it run on leetcode : yes

// the main idea behind the solution is the water trapped on the leftside is bound by left wall //and the water trapped on the right side is bound by the right wall. And one important catch is 
//whenever you have found the left which is bigger than the current building and there should be //atleast one buidling which should on anywhere on the right hand side which is greater than or //equal to the left building. 


class Solution {
    public int trap(int[] height) {
       if(height == null || height.length == 0)
            return 0;
       int lw = 0 ;
       int rw = 0 ;
       int l= 0;
       int r = height.length-1 ;
       int amount = 0 ;
       while(l <= r){
           //move on left and pointers whichever side has the small wall
           if(lw <= rw){
               //left wall greater than the current pointer we can add the trapped water
               if(lw >= height[l]){
                   amount+= lw - height[l];  
               }
               //shif the left wall to the left pointer
               else{
                   lw = height[l];
               }
               l++;
           }
           else{
               //right wall greater than the current pointer we can add the trapped water
               if(rw >= height[r]){
                   amount+=rw - height[r];
               }
                //shif the right wall to the right pointer
               else{
                   rw = height[r];
               }
               r--;
           }
           
       }
       return amount;
    }
}