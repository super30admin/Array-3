//Time complexity: O(N), where N is the length of the citations array.
//Space complexity: O(N)

class Solution2 {
    public int hIndex(int[] citations) {
//         Arrays.sort(citations);
//         int n = citations.length;
//         int hindex = 0; 
//         int low = 0, high = citations.length - 1;
//         while(low <= high) {
//             int mid = low + (high-low)/2;
//             if(citations[mid] == n-mid) {
//                 return citations[mid]; 
//             }
//             else if(citations[mid] < n - mid) {
//                 low = mid+1;
//             } else if(citations[mid] > n - mid) {
//                 high = mid-1;
//             }
//         }
        
//         return n-low; 
        
        int n = citations.length;
        int[] buckets = new int[n+1]; 
        
        for(int citation: citations) {
            if(citation >= n) {
                buckets[n]++;
            } else {
                buckets[citation]++;
            }
        }
        
        int papers = 0;
        for(int i=n; i>=0; i--) {
            papers += buckets[i];
            if(papers >= i) return i;
        }
        return 0;
    }
}