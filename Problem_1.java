// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
class Solution {
    public int trap(int[] height) {
        int totalAmount=0;
        if(height==null || height.length==0){
            return totalAmount;
        }
        int[] leftHeight=new int[height.length+1];
        leftHeight[0]=height[0];
        for(int i=1;i<height.length;i++){
            leftHeight[i]=Math.max(leftHeight[i-1],height[i]);
        }
        int[] rightHeight=new int[leftHeight.length];
        rightHeight[rightHeight.length-1]=height[height.length-1];
        for(int i=rightHeight.length-2;i>=0;i--){
            rightHeight[i]=Math.max(rightHeight[i+1],height[i]);
        }
        //System.out.println(Arrays.toString(leftHeight));
        //System.out.println(Arrays.toString(rightHeight));
        for(int i=1;i<height.length-1;i++){
            totalAmount=totalAmount+Math.min(leftHeight[i],rightHeight[i])-height[i];
        }
        return totalAmount;
    }
}
//
class Solution {
    public int trap(int[] height) {
        int totalAmount=0;
        if(height==null || height.length<2){
            return totalAmount;
        }
        int n=height.length;
        int lWall=0;
        int rWall=0;
        int l=0;
        int r=n-1;
        while(l<=r){
            if(lWall<rWall){
                if(height[l]<lWall){
                    totalAmount=totalAmount+lWall-height[l];
                }else{
                    lWall=height[l];
                }
                l++;
            }else{
                if(height[r]<rWall){
                    totalAmount=totalAmount+rWall-height[r];
                }else{
                    rWall=height[r];
                }
                r--;
            }
        }

        return totalAmount;
    }
}