// TIme Complexity: O(N)
// Space Complexity: O(1)
public class TrappingRainWater {
    public int trap(int[] nums) {
        int result = 0;
        int slow = 0;
        int fast = 1;
        int n = nums.length;
        int currTrap = 0;
        while(fast < n){
            if(nums[slow] > nums[fast]){
                currTrap += nums[slow] - nums[fast];
            }
            else{
                result += currTrap;
                currTrap = 0;
                slow = fast;
            }
            fast++;
        }
        int peak = slow;
        fast = n-2;
        slow = n-1;
        currTrap = 0;
        while(fast >= peak){
            if(nums[slow] > nums[fast]){
                currTrap += nums[slow] - nums[fast];
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
}
