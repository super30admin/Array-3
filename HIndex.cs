
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
	// 1) Bucket sort
	// 2) We will create new array with value of all 0 of length input
	// 3) Then iterate over input and increment value in new array ay index[value of input]
	// 	a. If value in input array is greater than length, increment last index value in new array
	// 	b. Because out hindex cannot be greater than last value.
	// 4) Then iterate from end in new array
	// 	a. Values is number of papers and index in number of citations
	// 	b. Keep adding like running sum of paper and check 
	// 	c. If nmber of papers >= number of citations, that is answer


public int HIndex(int[] citations) {
    if(citations == null || citations.Length == 0)
        return 0;
    
    int n = citations.Length;
    int[] bucketSortArr = new int[n+1];        
    
    for(int i = 0; i < n; i++)
    {
        if(citations[i] > n)
            bucketSortArr[n]++;
        else
            bucketSortArr[citations[i]]++;
    }
    
    int sum = 0;
    for(int i = n; i >= 0; i--)
    {
        sum = sum + bucketSortArr[i];
        if(sum >= i)
            return i;
    }
    
    return 0;
}