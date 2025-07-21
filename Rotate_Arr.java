/*
 * TC: O(n) n: length of nums
 * SC: O(1)
 * 
 * Approach: in my approach, i will keep track of my prev number, curr number and next number. At each iteration, i will calculate the position
 * of my current element and swap it with the elment at the next index , update my curr to next and keep doing this until all
 * the numbers are at their position. 
 */

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int count =0;
        k = k%n;
        if(k == 0) return;

        for(int start = 0; count < n; start++){
            int prev = nums[start];
            int curr = start;

            do{
                int next = (curr+k)%n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;

                curr = next;
                count++;
            }while(curr != start);
            
        }
    }
}