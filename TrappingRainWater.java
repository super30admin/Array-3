package s30.arrays.array3;


//Algo-> calculate individual bar stored water(IMP).
// We need the boundaries for trapping water for area like left max bar and tight max bar
public class TrappingRainWater {


    // TC; O(n)
    // Sc : O(n)
    //using rMax array and calculating leftMax on the go
    public int trap(int[] height) {

        int n = height.length;
        int leftMax =0;
        int res =0;

        int rMax[] = new int[n];

        rMax[n-1] = height[n-1];

        for(int i= n-2; i>=0; i--){
            rMax[i] = Math.max(rMax[i+1], height[i]);
        }


        for(int i=0; i < n; i++){
            leftMax  = Math.max(leftMax, height[i]);
            res += Math.min(leftMax, rMax[i]) - height[i];
        }


        return res;

    }


    //TC: O(n)
    //SC: O(1)
    // using two pointers
    public int trapTwoPointers(int[] height) {

        int n = height.length;
        int leftMax =0;
        int rightMax =0;

        int res =0;

        int start =0, end = n-1;

        while(start < end){
            leftMax = Math.max(leftMax, height[start]);
            rightMax = Math.max(rightMax, height[end]);

            if(leftMax < rightMax){
                res +=  leftMax - height[start];
                start++;
            }else {

                res+= rightMax - height[end];
                end--;
            }

        }

        return res;

    }
    public static void main(String[] args) {

    }
}
