//
//  RotateAnArrayByKPlaces.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 2/27/26.
//

class RotateAnArrayByKPlaces {
    
    
    init() {
        
    }
    
    /*
     Approach 1 -
     First reverse the whole array
     then reverse the first k elements
     then reverse the remaining elements
     O(n) - time compelxity, no extra space
     */
    func rotate(_ nums: inout [Int], _ k: Int) {
        var k = (nums.count < k) ? k % nums.count : k
        reverse(&nums, start: 0, end: nums.count - 1)
        reverse(&nums, start: 0, end: k - 1)
        reverse(&nums, start: k, end: nums.count - 1)
    }
    
    private func reverse(_ nums: inout [Int], start: Int, end: Int) {
        var i = start
        var j = end
        while (i < j) {
            let temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
            i += 1
            j -= 1
        }
    }
    
    /*
     Approach 2 -
     first reverse the first n - k elements
     then reverse the remaining k elements
     then reverse the whole array
    */
    func rotateByReverseApproach2(_ nums: inout [Int], _ k: Int) {
        var k = (nums.count < k) ? k % nums.count : k
        reverse(&nums, start: 0, end: nums.count - 1 - k)
        reverse(&nums, start: nums.count - k, end: nums.count - 1)
        reverse(&nums, start: 0, end: nums.count - 1)
    }

    
    /*
     for left rotation -
     first reverse the whoel array.
     reverse the first n-k elements
     reverse the remaining k elements
     no extra space needed O(n) time complexity
     */
}
