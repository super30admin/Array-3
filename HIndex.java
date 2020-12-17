package Dec16;

class HIndex {
    public int hIndex(int[] citations) {
        /* optimized approach:
        Iterate through given array to populate buckets array. O(n)
        Start from back of buckets array and check wherever the sum exceeds no.of citations => h index found.  Worst case, time complexity = O(n)
        
       O(n) + O(n) ~= O(n)
       
       We need not do O(n log n) sorting on given array because we are using bucket sort.
        
        Approach:
        Buckets array created with size = given array size + 1
        
        Use bucket sort so that array elements which are greater than total size of the array are placed in one common bucket.
        
        Example:
        Given array: {0,0,0,0,0,8}
        Initial Buckets array: 
                               {0,0,0,0,0,0,0}
indexes(citations count)        0 1 2 3 4 5 6 
        Buckets array after iterating through given array: 
                               {5,0,0,0,0,0,1}
                                0 1 2 3 4 5 6
        because no.of papers with 0 citations in given array = 5
                no.of papers with 1 citations in given array = 0
                no.of papers with 2 citations in given array = 0
                no.of papers with 3 citations in given array = 0
                no.of papers with 4 citations in given array = 0
                no.of papers with 5 citations in given array = 0
                no.of papers with 6 citations in given array = 1
        
        Start taking sum in buckets array
        sum at each index starting from the last element
                                        6,1,1,1,1,1,1
                                       {5,0,0,0,0,0,1}
        indexes(citations count)        0 1 2 3 4 5 6
        
                                        
        */
      int n = citations.length;
        // bucket sort
       int[] buckets = new int[n+1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                buckets[n]++;
            } else {
                buckets[citations[i]]++;
            }
        }
        
        // check on bucket sorted array. 
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += buckets[i];
            if (sum >= i) {
                return i;
            }
        }
        
        return 0;
    }
}