// Time complexity: O(n) single traversal
// Space Complexity:  O(1) constant space 
public class TrappingRainWater {
    public int trapWater(int [] height){

        // base case

        if(height == null || height.length == 0) return 0;

        int left = 0, right = height.length -1;
        int leftWall =0, rightWall = 0;

        int water = 0;
        while( left <= right ){
            if(height[left] < height[right]){
                if(height[left] >= leftWall){
                    leftWall = height[left]; // update the leftwall
                } else{
                    water += leftWall - height[left];
                }
                left++;
            } else{
                if(height[right] >= rightWall){
                    rightWall = height[right]; // update the rightWall
                } else{
                    water+= rightWall - height[right];
                }
                right--;
            }
        }
        return water;
    }

    public static void main( String [] args){
        TrappingRainWater solution = new TrappingRainWater();
        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trapWater(height));

    }

}
