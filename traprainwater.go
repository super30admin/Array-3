// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
set res = 0
set lw, rw to height of first, last tower
set l,r as first, last index
while l <= r
if lw<=rw if height of l <lw then water can trap add to result else set lw to height[l] increment l
else if height of r <rw then water can trap add to result else set rw to height[r] decrement r
return res
*/
package main

import "fmt"

func trap(height []int) int {
	/*l := len(height)
	  if l < 3 {
	      return 0
	  }
	  leftmax := make([]int, l)
	  rightmax := make([]int, l)
	  leftmax[0] = height[0]
	  for i:= 1;i<l;i++ {
	      leftmax[i] = max(height[i], leftmax[i-1])
	  }
	  rightmax[l-1] = height[l-1]
	  for i := l - 2;i>=0;i-- {
	      rightmax[i] = max(height[i], rightmax[i+1])
	  }
	  sum :=0
	  for i:=0;i<l;i++{
	      sum+=min(leftmax[i], rightmax[i]) - height[i]
	  }
	  return sum*/

	//2ptr sol O(n)
	n := len(height)
	if n < 3 {
		return 0
	}
	res := 0
	lw := height[0] //actual height not index
	rw := height[n-1] //actual height not index
	l := 0
	r := n-1
	for l<=r {
		//which wall is smaller
		if lw <= rw { //process left side
			if height[l] < lw { //water trapped here only
				res += lw - height[l]
			} else {
				lw = height[l]
			}
			l++
		} else {
			if height[r] < rw { //water trapped here only
				res += rw - height[r]
			} else {
				rw = height[r]
			}
			r--
		}
	}
	return res
}

func max(a, b int) int {
	if a >b {
		return a
	}
	return b
}

func min(a, b int) int {
	if a <b {
		return a
	}
	return b
}

func MainTrap() {
	fmt.Println(trap([]int{0,1,0,2,1,0,1,3,2,1,2,1})) //expected 6
}
