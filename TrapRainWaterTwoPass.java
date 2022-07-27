//Time Complexity=O(n)
//Space Complexity=O(1)
public class TrapRainWaterTwoPass {

    public int trap(int[] height) {
        int slow=0;int fast=1;
        int currTrap=0;
        int result=0;
        while(fast<height.length){
            if(height[fast]<height[slow]){
                currTrap+=height[slow]-height[fast];
            }else{
                result+=currTrap;
                currTrap=0;
                slow=fast;
            }
            fast++;
        }
        int peak=slow;
        currTrap=0;

        slow=height.length-1;
        fast=slow-1;
        while(fast>=peak){
            if(height[fast]<height[slow]){
                currTrap+=height[slow]-height[fast];
            }else{
                result+=currTrap;
                currTrap=0;
                slow=fast;
            }
            fast--;
        }

        return result;
    }
}
