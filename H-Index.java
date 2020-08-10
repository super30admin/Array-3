/*
Bruteforce sort the array then see where the h index crosses 
for example after sorting we get  [0,1,3,5,6]
                                   [5,4,3,2,1] no of papers against each citation ir 5 papers with no citation
h-index = h papers with atleast h citations and 
          N- h papers with no more than h citations
          
Therefore 3 papers have 3 and more citations  ie 3,5,6
And 5-3 ie 2 papers have less than 3 citations ie 0,1
Henceforth h-index = 3

Executed on leetcode H-Index
*/
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for(int i = 0; i <n ; i++){
           int diff = n-i;
            if(citations[i] >= diff){
                return diff; //it will only hit 3 once with 3 citation value and exits
				//diff only gives the h-index value  for exampe for input [100]  h-index is 1
            }
        }
        return 0;
    }
}

/*
Time complexity:O(nlogn) for sorting and O(n) for traversing . therefore asymtotically O(nlogn)
Space complexity:O(1)
*/


//Using bucket sort
//Used when each value in the array is not significant
//[2,0,1,5,8,9,3] array
//Here all elements greater than certain value are added into one bucket ie 
//for bucket
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0 ) return 0;
        int n = citations.length ;
        int[] buckets = new int[n+1];
        
        //allocated the citations in buckets ranging from 0 to n+1
        for(int i = 0 ; i <n ;i++){ 
	// for citations greater than length of bucket place in the last index of the bucket	
            buckets[Math.min(citations[i],n)]++; //place in bucket
        }
        
        int sum = 0;
        for(int i = buckets.length-1;i>=0;i--){  //calculating from backwards till total no of papers ie sum is greater than the citation value ie there are 4 papers at bucket[3]
		//bucket index i is citation value and sum is total no of papers
        sum+= buckets[i];
        if(sum >=i) return i;  // for input[100]  h-index is 1
        }
        return 1234;
    }
}

/*
Time complexity :O(n)
Space complexity: O(n)
*/