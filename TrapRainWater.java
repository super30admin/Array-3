//TC will be O(n)
//SC will be O(1)
class TrapRainWater {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }

        int lw = 0;
        int rw = 0;
        int l = 0;
        int r = height.length - 1;
        int total = 0;

        while(l <= r){
            if(lw <= rw){
                if(lw >= height[l]){
                    total = total + (lw - height[l]);
                }
                else{
                    lw = height[l];
                }
                l++;
            }
            else {
                if(rw >= height[r]){
                    total = total + (rw - height[r]);
                }
                else{
                    rw = height[r];
                }
                r--;
            }
        }

        return total;
    }

    public static void main(String[] args){
        TrapRainWater obj = new TrapRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(obj.trap(height));

    }
}
