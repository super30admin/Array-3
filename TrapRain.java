import java.util.Stack;

public class TrapRain{
    //stack solution - monotonic increasing stack o(n) and o(n)
    public int trap(int[] height) {
        int n = height.length;
        int result = 0;
        Stack<Integer> st = new Stack<>();
        for(int i =0; i < n; i++){
            while(!st.isEmpty() && height[st.peek()] < height[i]){
                int popped = st.pop();
                if(!st.isEmpty()){
                    int width =(i - st.peek() - 1);
                    int minHeight = (Math.min(height[i],height[st.peek()]));
                    result += width * (minHeight - height[popped]);
                }
            }

            st.push(i);
        }

        return result;
    }

    //o(n) - 2 pointers 
    // public int trap(int[] height) {
    //     int n = height.length;
    //     int result = 0;
    //     int l = 0, lw = 0;
    //     int r = n-1, rw = 0;
    //     while( l <= r){
    //         if(lw <= rw){
    //             //we have a bigger left wall so we need to only worry about right wall
    //             if(lw > height[l]){
    //                 result += lw - height[l];
    //             }else{
    //                     lw = height[l];
    //                 }
    //             l++;
    //         }else{
    //             if(rw > height[r]){
    //                 result += rw - height[r];
    //             }else{
    //                 rw = height[r];
    //             }
    //             r--;
    //         }
    //     }
    //     return result;
    // }


    //o(n) 
    // public int trap(int[] height) {
    //     int n = height.length;
    //     int maxHeight = 0, idx = -1;
    //     for(int i = 0; i < n; i++){
    //         if(maxHeight < height[i]){
    //             maxHeight = height[i];
    //             idx = i;
    //         }
    //     }
    //     int result = 0;
    //     int l = 0, lw = 0;
    //     while(l < idx){
    //         if(lw > height[l]){
    //             result += lw - height[l];
    //         }else{
    //             lw = height[l];
    //         }
    //         l++;
    //     }
    //     int r = n-1, rw = 0;
    //     while(r > idx){
    //         if(rw > height[r]){
    //             result += rw - height[r];
    //         }else{
    //             rw = height[r];
    //         }
    //         r--;
    //     }

    //     return result; 
    // }


}