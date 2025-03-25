public class TrappingRainWater {

public int trap(int[] height) {
    int i=0;
    int j=height.length-1;
    if(height.length==0){
        return 0;
    }
    int leftmax=0;
    int rightmax=0;
    int count=0;
    while(i<j){
        leftmax=Math.max(leftmax,height[i]);
        rightmax=Math.max(rightmax,height[j]);
        if(leftmax<rightmax){
            count+=(leftmax-height[i]);
            i++;
        } else{
            count+=(rightmax-height[j]);
            j--;
        }
    }
    return count;
}
}

/* //TC-O(N) SC-O(N)
  // Case of empty height array
        if (height.length == 0) return 0;
        int ans = 0;
        int size = height.length;
        // Create left and right max arrays
        int[] left_max = new int[size];
        int[] right_max = new int[size];
        // Initialize first height into left max
        left_max[0] = height[0];
        for (int i = 1; i < size; i++) {
            // update left max with current max
            left_max[i] = Math.max(height[i], left_max[i - 1]);

        }
        // Initialize last height into right max
        right_max[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            // update right max with current max
            right_max[i] = Math.max(height[i], right_max[i + 1]);

        }
        // Calculate the trapped water
        for (int i = 1; i < size - 1; i++) {
            ans += Math.min(left_max[i], right_max[i]) - height[i];

        }
        // Return amount of trapped water
        return ans;
* */