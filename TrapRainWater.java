// Time Complexity : O(2n)=O(n) forward pass and backward pass
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class TrapRainWater {
    public int trap(int[] height) {
        int result = 0;
        int slow = 0;
        int fast = 1;
        int currTrap = 0;
        //forward pass
        while(fast<height.length){
            if(height[fast]<height[slow]){
                currTrap+=height[slow]-height[fast];
            }
            else{
                result += currTrap;
                currTrap = 0;
                slow = fast;
            }
            fast++;
        }

        int peak = slow;
        //backward pass
        currTrap = 0;
        slow = height.length-1;
        fast = slow-1;
        while(fast>=peak){
            if(height[fast]<height[slow]){
                currTrap+=height[slow]-height[fast];
            }
            else{
                result += currTrap;
                currTrap = 0;
                slow = fast;
            }
            fast--;
        }

        return result;
    }

    public static void main(String[] args){
        TrapRainWater trp = new TrapRainWater();
        System.out.println(trp.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}