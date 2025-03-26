class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int res =0;
        for(int i=0;i<n;i++)
        {
            //if we encouner a bigger ht than top of st
            while(st.peek()!=-1 && height[i] > height[st.peek()])
            {
                //process the smaller heights
                int popIdx = st.pop();
                if(st.peek()!=-1){
                int rightwall = height[i];
                int leftwall = height[st.peek()];
                int width = i-st.peek()-1;
                res+=(Math.min(leftwall,rightwall) - height[popIdx]) *width;
                }
            }

           
                st.push(i);
          

        }
        return res;
    }
}

//tc: O(2n) monotonic stack solution
//sc: O(n)