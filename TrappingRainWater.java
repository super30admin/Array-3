//T.C O(n) + O(n)
//S.C O(1)

//Get max building, all buildings left to max can trap water max up to left window height, similarly right buildings can
// trap max to right window height
class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int maxId = -1; int max = 0;
        int result = 0;

        //Get max building and its index
        for(int i=0; i<n; i++){
            if(height[i]>max){
                max = height[i];
                maxId = i;
            }
        }
        //l= curr left pointer index, lw = left window
        int l = 0; int lw = 0;
        while(l<maxId){
            if(lw > height[l]){
                result  += lw - height[l];
            }else {
                lw = height[l];
            }
            l++;
        }
        //r - right pointer, rw = right window
        int r = n-1; int rw = 0;
        while(r>maxId){
            if(rw> height[r]){
                result += rw - height[r];
            } else{
                rw = height[r];
            }
            r--;
        }
        return result;
    }
}