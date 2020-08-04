// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    func rotate(_ nums: inout [Int], _ k: Int) {
        let length = nums.count
        if length == 0 || k == 0 {
            return 
        }
        var steps = k%length
        reverse(&nums,0,length-1)
        reverse(&nums,0,steps-1)
        reverse(&nums,steps,length-1)
    }
    
    func reverse(_ nums: inout [Int], _ left: Int, _ right: Int) {
        var l = left
        var r = right
        while l<r {
            let temp = nums[r]
            nums[r] = nums[l]
            nums[l] = temp
            l += 1
            r -= 1
        }
    }
    
}