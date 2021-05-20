//Approach - Reverse the entire array, then reverse the array (0 to k-1)
//finally reverese the array(k, length)

//Time Complexity - O(N) -> O(N) - N is the nums length
//Space Complexity - O(1) -
class Solution {
  public void rotate(int[] nums, int k) {
    int len = nums.length;

    k = k%len;

    reverse(nums, 0, len-1);
    reverse(nums, 0, k-1);
    reverse(nums, k, len-1);

  }

  private void reverse(int[] nums, int start, int end){
    while(start < end){
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;

      start++;
      end--;
    }
  }
}




//Approach - Brute force while copying the array into another array
//and use this copyArr to put elements in their places

//Time Complexity - O(2N) -> O(N) - N is the nums length
//Space Complexity - O(N) - extra arrCopy
class Solution {
  public void rotate(int[] nums, int k) {
    int len = nums.length;
    int[] arrCopy = new int[len];

    k = k%len;

    for(int i=0; i<len; i++){
      arrCopy[i] = nums[i];
    }

    for(int i=0; i<(len-k); i++){
      nums[i+k] = arrCopy[i];
    }
    for(int i=0; i<k; i++){
      nums[i] = arrCopy[len-k+i];
    }
  }
}
