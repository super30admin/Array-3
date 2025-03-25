// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    // Approach 1
    public int trap(int[] height){
        int  n = height.length;
        int maxIdx = -1;
        int max = 0;
        for(int i = 0; i < n; i++){
            if(height[i] > max){
                max = height[i];
                maxIdx = i;
            }
        }
        // run from left to right upto maxIdx
        int result = 0;
        int lw = 0; //idx
        int l = 0; //height
        while(l < maxIdx){
            if(lw > height[l]){
                result += lw - height[l];

            } else{
                lw = height[l];
            }
            l++;
        }

        int r = n - 1;
        int rw = 0;
        while(r > maxIdx){
            if(rw > height[r]){
                result += rw - height[r];

            } else{
                rw = height[r];
            }
            r--;
        }
        return result;
    }

    // Approach 2: monotonic decreasing stack solution
    // algorithm that linearizes nested iteration
    // Time Complexity O(2n)
    public int trap(int[] height){
        int n = height.length;
        int result = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i = 0; i < n; i++){
            //if we encounter a bigger ht than one at top of stack
            while(st.peek() != -1 && height[i] > height[st.peek()]){
                //process the smaller ones
                int poppedIdx = st.pop();
                if(st.peek() == -1) break;
                int rw = height[i];
                int lw = height[st.peek()];
                int w = i - st.peek() - 1;
                result += (Math.min(lw, rw) - height[poppedIdx]) * w;
            }
            st.push(i);
        }
        return result;
    }

    // Approach 3
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int lmax = 0, rmax = 0, result = 0;

        while(l<r){
            lmax = Math.max(lmax, height[l]);
            rmax= Math.max(rmax, height[r]);

            if(lmax < rmax){
                result += lmax - height[l];
                l++;
            }
            else{
                result += rmax - height[r];
                r--;
            }
        }
        return result;
    }
}