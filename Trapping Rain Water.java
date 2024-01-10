//  Time Complexity: O(2n)
//  Space Complexity: O(1)
class Solution {
    public int trap(int[] height) {
        int maxWall = 0;
        int n = height.length;
        for(int i=0; i<n; i++){
            if(height[i] > height[maxWall]) maxWall = i;
        }

        int l = 0, lw = height[0];
        int r = n-1, rw = height[n-1];
        int result = 0;

        while(l< maxWall){

            if(lw > height[l]){
                result += lw - height[l];
            }else{
                lw = height[l];
            }
            l++;
        }

        while(r> maxWall){
            if(rw > height[r]){
                result += rw - height[r];
            }else{
                rw = height[r];
            }
            r--;
        }
        return result;
    }
}



//  Time Complexity: O(n)
//  Space Complexity: O(1)
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lw = height[0], l = 0;
        int rw = height[n-1], r=n-1;
        int result = 0;

        while(l<=r){
            if(lw <= rw){
                if(lw > height[l]){
                    result += lw - height[l];
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
}


//  Time Complexity: O(n)
//  Space Complexity: O(n)
class Solution {
    public int trap(int[] height) {
        Stack<Integer> stk = new Stack<>();
        int result = 0;

        for(int i=0; i<height.length; i++){
            while(!stk.isEmpty() && height[i] > height[stk.peek()]){
                int popped = stk.pop();
                if(!stk.isEmpty()){
                    int minHeight = Math.min(height[stk.peek()], height[i]);
                    result += (minHeight - height[popped]) * (i - stk.peek() - 1);

                }
            }
            stk.push(i);
        }
        return result;
    }
}