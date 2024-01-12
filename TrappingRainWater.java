import java.util.Stack;

public class TrappingRainWater {
//    TC:O(n)
//    SC:O(1)
    //two pass
    public int trap(int[] height) {
        int n = height.length;
        int result = 0;
        int maxId = -1; int max = 0;
        for(int i = 0; i < n; i++){
            if(height[i] > max){
                max = height[i];
                maxId = i;
            }
        }
        int l = 0; int lw = 0;
        while(l < maxId){
            if(lw > height[l]){
                result+= lw - height[l];
            }else{
                lw = height[l];
            }
            l++;
        }
        int r = n - 1;
        int rw = 0;
        while(r > maxId){
            if(rw > height[r]){
                result += rw - height[r];
            }else{
                rw = height[r];
            }
            r--;
        }
        return result;
    }
    //One pass
    public int trap2(int[] height) {
        int n = height.length;
        int result = 0;

        int l = 0; int lw = height[0];
        int r = n - 1;
        int rw = height[n-1];
        while(l <= r){
            if(lw <= rw){
                if(lw > height[l]){
                    result+= lw - height[l];
                }else{
                    lw = height[l];
                }
                l++;
            }else{
                if(rw > height[r]){
                    result += rw - height[r];
                }else{
                    rw = height[r];
                }
                r--;
            }
        }
        return result;
    }

    //using stack histogram SC:O(n)
    public int trap3(int[] height) {
        Stack<Integer> st = new Stack<>();
        int n = height.length;
        int result = 0;
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && height[i] > height[st.peek()]){
                int popped = st.pop();
                if(!st.isEmpty()){
                    int minHeight = Math.min(height[i], height[st.peek()]);
                    result += (minHeight - height[popped]) * (i - st.peek() - 1);
                }
            }
            st.push(i);
        }
        return result;
    }
}
