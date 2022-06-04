//Approach 1
class Solution {

    //Time Complexity: 0(nk) where n is the numbers in nums array and k is the rotation value
    //Space Complexity: 0(1)
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding: No

    //In brief, explain your approach

    public void rotate(int[] nums, int k) {
        int n = nums.length;    //finding the length of nums array
        if(k > n){  //if k is greater then doing a modulo division to make it in the range of k
            k = k % n;
        }
        reverse(nums, n - k, n - 1);    //first we are reversing the 2nd part of the array from kth index onward
        reverse(nums, 0, n -k - 1); //then we are reversing the 1st part of the array till kth index
        reverse(nums, 0, n-1);  //then we are reversing the entire array to gove the final output
    }
    public void reverse(int [] nums, int start, int end){   //function which reverses the array in place
        while(start <= end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    public void swap(int [] nums, int start, int end){  //a function to swap values in place
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
//Approach 2

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k > n){
            k = k % n;
        }
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n-1);
    }
    public void reverse(int [] nums, int start, int end){
        while(start <= end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    public void swap(int [] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}