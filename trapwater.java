class Solution 
  //TC:o(n)SC: o(1)
  
    public int trap(int[] height) {
        int low=0;
        int high=1;
        int water=0;
        int currwater=0;
        
        //forward
        while(high<height.length){
            if( height[high]<height[low] ){
                currwater+=height[low]-height[high];
                }
            else{//trap water 
                water+=currwater;
                currwater=0;
                low=high;  
            }
            high++;
        }
            int peak=low;
            low=height.length-1;
            high=low-1;
            currwater=0;
        //backward
            while(high>=peak){
                if( height[high]<height[low] ){
                currwater+=height[low]-height[high];
                }
            else{
                water+=currwater;
                currwater=0;
                low=high;
                
            }
                high--;
                
            }
            
        
        
        return water;
        
        
        
    }
}
