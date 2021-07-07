/*
Time: O(N log N)
Space: O(1)

Approach:
1. Sort array
2. Now, binary search for citation count where value is equal to h
*/
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        int low = 0, high = citations.length-1, n = citations.length;
        while(low <= high) {
            int mid = low +(high - low)/2;
            if(citations[mid] == n - mid) 
                return n - mid;
            else if(citations[mid] > n - mid) {
                high = mid - 1;
            }
            else 
                low = mid + 1;
        }
        return n - low;
    }
}

/*
 ============================ Counting sort ===========================
 Time: O(N) space: O(N)
 Approach:
 ========
 1. Calculate citations count and store in array
 2. Store running sum as we move from right to left and update it
 3. Stop whenever index is less than or equal to runningsum
*/

class Solution {
    public int hIndex(int[] citations) {
       if(citations == null || citations.length == 0) return 0; 
        int n = citations.length;
        int[] buckets = new int[n+1];
        
        //calculate counts of citations and store in buckets array
        for(int c: citations) {
            if(c > n) 
                buckets[n]++;
            else
                buckets[c]++;
        }
        
        int runningSum = 0, index = n; 
        // calculate running sum and check if index less than or equal to running sum at every index
        while(index >= 0) {
            runningSum += buckets[index];
            if(index <= runningSum)
                return index;
            index--;
        }
        return -1;
    }
}