/*
The time complexity is O(N) and the space complexity is O(N) where N is the length of height array.

Here the intuition is to calculate the left max and right max of each position and take the min of it. Since only the water we can store
is till height min(leftmax,rightmax). We need to remove our height from the calculated height to see the amount of water we can store.

Yes, the solution passed all the test cases in leetcode.
 */
class Solution {
    public int trap(int[] height) {
        int heightlength = height.length;

        //Creating two arrays for calculating the max left and max right of each position.
        int[] maxleft = new int[heightlength];
        int[] maxright = new int[heightlength];

        int maxleftnumber = 0;
        for(int i=0;i<heightlength;i++){
            if(height[i]>maxleftnumber){
                maxleftnumber = height[i];
            }
            maxleft[i] = maxleftnumber;
        }

        int maxrightnumber = 0;
        for(int i=heightlength-1;i>=0;i--){
            if(height[i]>maxrightnumber){
                maxrightnumber = height[i];
            }
            maxright[i] = maxrightnumber;
        }

        //For every position we calculate the min of max left and max right. Then remove our present height. If the obtained value
        //is greater than 0, add this to our result variable.
        int storage = 0;
        for(int i=0;i<heightlength;i++){
            int temp = Math.min(maxleft[i],maxright[i])-height[i];
            if(temp>0){
                storage+=temp;
            }
        }

        return storage;
    }
}