// https://leetcode.com/problems/rotate-array/
// runtime: O(n)
// memory: O(1)
// passes leetcode? yes
// obstacles?
//
// edge cases like k > length
// knowing to not do anything if k = 0
//
// explanation:
//   reverse the entire array (that puts k elements at the beginning of the array but in reverse order)
//   reverse elements 0...k-1
//   reverse elements k...end

var rotate = (nums, k) => {
  if (nums.length < 2) return nums
  k = k % nums.length

  if (k === 0) return

  rotate_SE = (s, e) => {
    let S = s
    let E = e

    while(S < E) {
      let temp = nums[S]
      nums[S] = nums[E]
      nums[E] = temp
      S++
      E--
    }
  }

  rotate_SE(0, nums.length - 1)
  rotate_SE(0, k - 1)
  rotate_SE(k, nums.length - 1)
}

/*Input:*/ const nums = [1,2,3,4,5,6,7]
const k = 3

rotate(nums, k)
console.log(nums)
// Output: [5,6,7,1,2,3,4]
