class Solution {
    public int trap(int[] height) {
        
        int i = 1; 
        int k  = 1;
        int total = 0;
        if (height == null || height.length <= 1) return  0;
        int x = 0 ;
        for(x = 0 ; x < height.length ; x ++ ) {
            if(height[x] > 0) break;
        }
        int startIndex = x;
        int  endIndex = 0;
        int nh = height[x];
        for(i = x; i < height.length-1 ; i ++ ) 
        {
           endIndex = getNextEndIndex(startIndex , height[startIndex]  ,  height ,  endIndex ); 
           int cnt = ( height[endIndex ] < height[startIndex]) ? height[endIndex ] : height[startIndex];
          for(int k1 = endIndex -1  ; k1 > startIndex ; k1 --  )
          {
              total = total + ( cnt - height[k1]) ; 
            
         }   
          i  =  endIndex ;  
          startIndex = endIndex;
       }
        return total;
    }
    
    int getNextEndIndex (int i, int nh ,int[] height , int endIndex) {
        boolean found = false;
        int  k = -1 ;
        while(!found) {
             k = getNextHeightIndex (i,nh, height, endIndex) ; 
             if(k > 0 ){
                 found = true;
                break;
             }else{
                 nh = nh - 1;
             }
        }
         return k ;
    }
    
    int getNextHeightIndex(int i, int nh ,int[] height , int endIndex) {
         for(int k = i+1 ; k < height.length ; k ++ ) {
            if (height[k] >= nh) {
                endIndex = k;
                
                return endIndex;
            }
         }
        
          return -1;
          // return  getNextHeight(int i, int nh ,int[] height , int endIndex);
       //   getNextHeight(int i, int s ,int[] height , int endIndex)
    }
}
