// Time Complexity : O(n);
// Space Complexity : O(n);

class Solution {
    public int trap(int[] height) {
        int n =  height.length;
        if(height == null || n == 0)
            return 0;
        
        int[] l = new int[n];
        int[] r = new int[n];
        
        l[0] = height[0];
        
        for(int i=1; i<n; i++){
            l[i] = Math.max(l[i-1], height[i]);
        }
        
        r[n-1] = height[n-1];
        
        for(int i=n-2; i>=0; i--){
            r[i] = Math.max(r[i+1], height[i]);
        }
        
        int water = 0;
        
        for(int i=0; i<n; i++){
            water += Math.min(l[i], r[i]) - height[i];
        }
        
        return water;
    }
}


// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int n = height.length;
        int lw = 0, rw = 0;
        int l = 0, r = n-1;
        int water = 0;
        
        while(l<=r){
            if(lw<=rw){ // process left side
                if(lw<=height[l]){
                    lw = height[l];
                    l++;
                }else{
                    while(lw>height[l]){
                        water += lw-height[l];
                        l++;
                    }
                }
            }
            else{ // process right side
                if(rw<=height[r]){
                    rw = height[r];
                    r--;
                }else{
                    while(rw>height[r]){
                        water += rw-height[r];
                        r--;
                    }
                }
            }
        }
        
        return water;
    }
}