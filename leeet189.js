TC - o(n)
SC - o(n)

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
   if(nums == null || nums.length < 2){
        return;
    }
    
    k = k % nums.length;
    reverse(nums, 0, nums.length - k - 1);
    reverse(nums, nums.length - k, nums.length - 1);
    reverse(nums, 0, nums.length - 1);
};
function reverse(nums, i,  j){
    var tmp = 0;       
    while(i < j){
        tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        i++;
        j--;
    }
}