// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
using bucket sort with n+1 buckets
any element greater than length of array dont matter and can be put in same bucket (last extra bucket)
increment bucket with citation[i]
loop in reverse order and add to sum the bucket values
if sum >= i return i
*/
package main

import "fmt"

func hIndex(citations []int) int {
	n := len(citations)

	/*sort(citations)

	  // normal h index 2 we solved earlier
	  for i:=0;i<n;i++ {
	      diff := n-i
	      if diff <= citations[i] {
	          return diff
	      }
	  }
	  return 0*/

	// using bucket sort here to avoid nlogn and get O(n)
	// its used when sorting only some of the elements matter
	// take n+1 buckets

	//in our case any element greater than length of array dont matter and can be put in same bucket (last extra bucket)
	//O(2n)
	buckets := make([]int, n+1)
	for i:=0;i<n;i++ {
		if citations[i] >= n {
			buckets[n]++
		} else {
			buckets[citations[i]]++
		}
	}
	sum := 0
	for i:=n;i>=0;i--{
		sum  += buckets[i]
		if sum >= i {
			return i
		}
	}
	return 64
}

func MainHIndex() {
	fmt.Println(hIndex([]int{3,0,6,1,5})) //expected 3
}
