// Time Complexity : The time complexity is O(n) where n is the length of array
// Space Complexity : The space complexity if O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k%n;

        int count = 0;
        int next = 0;

        for(int i=0;count < n;i++){

            int cur = i;
            int temp1 = nums[i];
            int temp2 = nums[i];
            boolean cycle = false;

            while(cur != i || !cycle){

                // Ishift each number by k position
                if(cur == i){
                    cycle = true;
                }

                // The next number to be shifted is the position where the previous number was shifted
                next = (cur+k)%n;

                temp2 = nums[next];
                nums[next] = temp1;
                temp1 = temp2;
                cur = next;
                count++;
            }
        }
    }
}