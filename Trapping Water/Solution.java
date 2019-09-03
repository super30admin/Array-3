/**
 * Time complexity: O(n)
 * Space Complexity: O(1)
 */

class TrapWater {
    public int trap(int[] height) {
        int water = 0;
        int l=0;
        int r=height.length-1;

        while(l<r && height[l] < height[l+1]) l++;
        while(l<r && height[r] < height[r-1]) r--;

        int ptr1 = l;
        int ptr2 = r;
        System.out.println(l + " " + r);
        while(l<r){
            if(height[ptr1] < height[ptr2]) {
                while(height[ptr1] > height[++l]) {
                    int vol = height[ptr1] - height[l];
                    water += vol;
                }
            }
            else {
                while(height[ptr2] > height[--r]){
                    int vol = height[ptr2] - height[r];
                    water += vol;
                }
            }

            ptr1 = l;
            ptr2 = r;            
        }
        //
        
        return water;
    }
}

class Solution {
    public static void main(String[] args) {
        System.out.println("Trap Water");
        TrapWater obj = new TrapWater();
        
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
       System.out.println(obj.trap(height));
    }
}