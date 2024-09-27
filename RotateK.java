/*
The time complexity is O(N) and the space complexity is O(1).

Here the intuition is to start from 0 index and move that element to 0+k position. Move the pointer to k position.
Move the present element to k position from the present position and so on. This way we can go into loop. So, we check if our present
position is our start position. If yes, do the same procedure from its next position.

Yes, the solution passed all the test cases in leet code.
 */
class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k%n;
        int count = 0;

        //Start from index 0 and keep a count of no of positions moved. If we reach count to number of elements in nums array then stop.
        for(int start = 0;count<n;start++){

            int tempIndex = start; int temp = nums[tempIndex];

            //Since at the start we have tempIndex as our start index we use do-while loop and after the first step if we again reach
            // tempIndex==start we break the loop and go to start++;
            do{
                int moveIndex = (tempIndex+k)%n;
                int temp1 = nums[moveIndex];
                nums[moveIndex] = temp;
                tempIndex = moveIndex;
                temp = temp1;
                count++;

            }while(tempIndex!=start);
        }
    }
}