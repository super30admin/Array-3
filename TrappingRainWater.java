//Approach 1: Using left and right pointers
//Time: O(n)
//Space: O(1)
// Did this code successfully run on Leetcode : yes

class Solution {
    public int trap(int[] height) {

        int n= height.length;

        int l=0, lw=0, r=n-1, rw=n-1, res=0;

        while(l<=r){

            if(height[lw]<height[rw]){ //there is a bigger right wall

                if(height[l]>height[lw]){
                    lw=l;
                }

                else{
                    res=res+height[lw]-height[l];
                }
                l++;
            }
            else{
                if(height[rw]<height[r]){ //there is a bigger left wall present

                    rw=r;
                }
                else{
                    res=res+height[rw]-height[r];
                }
                r--;
            }
        }
        return res;
    }
}

// Approach 2: Using Monotonic stack

//Time: O(2n) - add elements to stack and for every bigger height process the elements in stack
//Space: O(n)
// Did this code successfully run on Leetcode : yes

class Solution {
    Stack<Integer> st;
    int res;
    public int trap(int[] height) {

        this.st=new Stack<>();
        this.res=0;

        for(int i=0;i<height.length;i++){

            while(!st.isEmpty() && height[i] > height[st.peek()]){  //check if the stack is not empty and the current height is greater than stack top

                int popped= st.pop();

                if(!st.isEmpty()){
                    int effectiveHeight= Math.min(height[st.peek()], height[i]); //minimum of left and right wall for the popped element

                    int width= i-st.peek()-1;

                    res+=(effectiveHeight-height[popped])*width;
                }
            }
            st.push(i); //if the stack is empty or the incoming height is smaller just push to the stack
        }
        return res;
    }
}