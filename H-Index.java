// Approach 1 : Brute force Arrays.sort
//TC: O(nlogn)
//SC: O(1)

// Sort the array
// Traverse the array and find the difference of each citation i.e. n - i
// if diff<= citation[i] that is our h-index

class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        Arrays.sort(citations);
        for(int i=0;i<n;i++){
            int diff=n-i;
            if(diff<=citations[i]){
                return diff;
            }
        }
        return 0;
    }
}

// Approach 2: Optimized, bucket sort, extra space
// TC: O(n)
// SC: O(n)


// Create a bucket of size n+1 i.e. for the range 0 to n
// Traverse through the citation and for every citation, increment the corresponding bucket value by 1.
// If a citation is >= n, add its count to bucket[n] itself, so for n=8, and citations 8,9,10,11, bucket[8] would be these 4
// Traverse the bucket array in reverse order and add the bucket value to a running sum
// When runningSum >= bucketValue, that is our h-index


class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int[] buckets=new int[n+1];
        for(int i=0;i<n;i++){
            if(citations[i]>=n){
                buckets[n]++;
            } else {
                int val=citations[i];
                buckets[val]++;
            }
        }
        int rSum=0;
        for(int i=n;i>=0;i--){
            rSum+=buckets[i];
            if(rSum>=i){
                return i;
            }
            
        }
        return 1234; // return anything because you will anyways find h index above
    }
}