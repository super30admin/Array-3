//Time complexity : O(n)
//Space Complexity :   O(1)
//Did it run on leetcode : yes

public class TrapRainWater {

        public int trap(int[] height) {
            if(height == null || height.length == 0) return 0;
            int result = 0;
            int l = 0, r = height.length -1;
            int lw=0, rw=0;

            while(l <= r){
                //which side to process
                if(lw <= rw){
                    //left side
                    //can we trap water
                    if(height[l] < lw){
                        result += lw -height[l];
                    }else{
                        lw = height[l];
                    }
                    l++;
                }else{
                    //right side
                    if(height[r] < rw){
                        result += rw -height[r];
                    }else{
                        rw = height[r];
                    }
                    r--;
                }
            }
            return result;
        }

}
