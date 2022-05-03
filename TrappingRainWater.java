//Time Complexity : O(n)
//Space Complexity : O(1)
public class TrappingRainWater {	
	/**Approach: Two Pointers**/
	public int trap(int[] height) {
        if(height==null || height.length==0) return 0;        
        int res=0;
        int l=0; int r=height.length-1;
        int lw=0; int rw=0;        
        while(l <= r){
            //Decide which side to process
            if(lw <= rw){
                if(height[l] < lw)
                    res += lw - height[l];
                else
                    lw = height[l];
                l++;
            }else{
                if(height[r] < rw)
                    res += rw - height[r];
                else
                    rw = height[r];
                r--;
            }
        }
        return res;
    }	
	
	// Driver code to test above
	public static void main (String[] args) {
		TrappingRainWater ob= new TrappingRainWater();
		int[] height= {0,1,0,2,1,0,1,3,2,1,2,1};
		
		System.out.println("Total water units trapped: "+ ob.trap(height));
		
	}
}
