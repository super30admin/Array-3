/*
  Two pass approach using slow and fast pointers
  time: o(n)
  space: o(1)
*/

func trap(height []int) int {
    
    slow := 0
    fast := 1
    n := len(height)
    trap := 0
    result := 0
    
    for fast < n {
        if height[fast] < height[slow] {
            trap += height[slow]-height[fast]
        } else {
            result += trap
            trap = 0
            slow = fast
        }
        fast++
    }
    peak := slow
    slow = n-1
    fast = slow-1
    trap = 0
    for fast >= peak {
        if height[fast] < height[slow] {
            trap += height[slow]-height[fast]
        } else {
            result += trap
            trap = 0
            slow = fast
        }
        fast--
    }
    return result
    
}
