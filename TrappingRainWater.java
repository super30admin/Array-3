//time - O(n), Space - O(1)
class TrappingRainWater {
    public int trap(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int Lw = 0, Rw = 0, L = 0, R = nums.length-1;
        int water = 0;

        while(L <= R) {
            if(Lw <= Rw) {
                if(Lw <= nums[L]) {
                    Lw = nums[L];
                } else {
                    water = water + Lw - nums[L];
                }
                L++;
            } else {
                if(Rw <= nums[R]) {
                    Rw = nums[R];
                } else {
                    water = water + Rw - nums[R];
                }
                R--;
            }
        }

        return water;
    }
}
