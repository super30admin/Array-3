package codes;

public class TrappingRainWater {
    public  static int trap(int[] height) {
    	/**
    	 * 1 water above a paarticular index is the max(left and right index) around the index - the height of the index itself.
    	 * t-O(n^2)
    	 * s-O(1)
    	 */
    	  
        int ans=0;
        
        for(int i=0;i<height.length;i++){
            int left=0, right=0;
            int j=i;
            while(j>=0){
                left=Math.max(left,height[j]);
                j--;
            }
            
            j=i;
            
            while(j<height.length){
                right=Math.max(right,height[j]);
                j++;
            }
            
            ans+=Math.min(left, right)-height[i];
 
        }
        
        
        return ans;
    }
    
    
 public int trap2(int[] height) {
	 
	 /**
	  * Instead of calculating the left and right max we can calculate and store the values of the same in array.
	  *  t-O(n)
	  *s-O(n) 
	  */
        
        if (height.length==0|| height == null) return 0;
            
            
        int ans=0;
        
        int [] maxLeft= new int [height.length];
        int [] maxRight= new int [height.length];
        
        maxLeft[0]=height[0];
        for(int i=1;i<height.length;i++){
            maxLeft[i]=Math.max(height[i],maxLeft[i-1]);
        }
        
        maxRight[height.length-1]=height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            maxRight[i]=Math.max(height[i],maxRight[i+1]);
        }
        
        
        for(int i=0;i<height.length;i++){
            ans+=Math.min(maxLeft[i],maxRight[i])-height[i];
        }
        
        return ans;
        
        
    }
    
    public static void main(String[] args) {
//		int [] arr= {0,1,0,2,1,0,1,3,2,1,2,1};
		int [] arr1= {4,2,0,3,2,5};
		int result=trap(arr1);
		System.out.println("result is arr :: "+result);
		
	}
}
