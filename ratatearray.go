// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
reverse all
reverse 0 to k-1
reverse k to n-1
*/
package main

import "fmt"

//O(n), O(1)
func rotate(nums []int, k int)  {
	n := len(nums)
	if k >= n {
		k = k%n
	}

	//for right rotation
	reverse(&nums, 0, n-1)
	reverse(&nums, 0, k-1)
	reverse(&nums, k, n-1)

	fmt.Println(nums)
	//for left rotation
	//reverse(&nums, 0, n-1)
	//reverse(&nums, 0, n-k-1)
	//reverse(&nums, n-k, n-1)
}

func reverse(nums *[]int, l, r int) {
	for l<r {
		swap(nums, l, r)
		l++
		r--
	}
}

func swap(nums *[]int, l, r int) {
	(*nums)[l], (*nums)[r] = (*nums)[r], (*nums)[l]
}

func MainRotate() {
	rotate([]int{1,2,3,4,5,6,7}, 3)
}
