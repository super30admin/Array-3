public class Water{
  public int calculate( int[] heights)
  {
  
    int water = 0;
    int lMax =Integer.MIN_VALUE;
    int rMax=Integer.MIN_VALUE;
    
    int l = 0 ;
    int r = heights.length-1;
    
    while (l<r)
    {
       
      lMax = Math.max( lMax , heights[l]);
      
      rMax = Math.max(rMax , heights[r]);
      
      if (lMax < rMax)
      {
         water += lMax-height[l];
         ++l;
      }
      else
      {
         water += rMax-height[r];
        --r;
      }
      
      
    
    }
  
  return water
  }
  

}
