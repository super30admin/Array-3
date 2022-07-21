//time complexity : O(n) n is length of input array
//space complexity : O(n)

class Solution {

    //code 2 - counting sort

    public int hIndex(int[] citations) {

        if(citations == null || citations.length == 0)
            return 0;

        int n = citations.length;
        int[] buckets = new int[n+1];

        for(int i=0; i<n; i++) {
            if(citations[i] < n)
                buckets[citations[i]]++;
            else
                buckets[n]++;
        }

        int sum = 0;

        for(int i=n; i>=0; i--) {
            sum+=buckets[i];
            if(sum >= i)
                return i;
        }
        return 0;
    }
}
