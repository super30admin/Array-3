// LC#274 #S30 117 - H-Index

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) {
            return 0;
        }
        
        Arrays.sort(citations);
        int n = citations.length;
        
        for( int i = 0; i < n; i++) {
            int diff = n - i;
            if(citations[i] >= diff) {
                return diff;
            }
        }
        return 0;
    }
}


/*
Complexity Analysis

Time complexity : O(n)
Space Complexity : O(n)
*/