package Array3;

/**
 * We initially find the maximum element in the arr. Now we can traverse from
 * both left and right towards that max element as we are sure that we can trap
 * rain water in between if possible. While traversing from left we will move as
 * long as the height of the next left is smaller (to trap rain water) and if
 * not we shift our left pointer to that spot and continue. Similarly we do this
 * on the right.
 * 
 * Time Complexity : O(n)- where n is the length of the arr
 * 
 * Space Complexity : O(1)
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
public class Problem1 {
    public int trap(int[] height) {
        int start = 0;
        int l=1;
        int end = height.length-1;
        int r=end-1;
        int count=0;
        int maxHeight=0;
        int maxIndex=0;
        for(int i=0;i<height.length;i++){
            if(height[i]>maxHeight)
                {
                    maxHeight=height[i];
                    maxIndex=i;
                }
        }
        while(l<=maxIndex){
            if(height[start]>0){
            if(height[l]<height[start]){
                while(l<=maxIndex && height[l]<height[start]){
                    if(height[l]==0)
                         count+=height[start];
                    else
                        count+=height[start]-height[l];
                    l++;
                }
            }
            else{
                start=l;
                l++;
            }
            } 
            else{
                start++;
                l=start;
            }
                
            }

             while(r>=maxIndex){
                if(height[end]>0){
                if(height[end]>height[r]){
                    while(r>=maxIndex && height[end]>height[r]){
                        if(height[r]==0)
                             count+=height[end];
                        else
                            count+=height[end]-height[r];
                        r--;
                     }
                    }
                else{
                    end=r;
                    r--;
                }
             }
            else{
                end--;
                r=end;
            }

             }

        return count;
    }

}
