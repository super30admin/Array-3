class H-Index {
    public int hIndex(int[] citations) {
        // Sort the array and then binary search (same as H-Index II - once the array is sorted)
//         Arrays.sort(citations);
        
//         int n = citations.length;
//         int low = 0;
//         int high = n - 1;
        
//         while(low <= high){
//             int mid = low + (high - low)/2;
//             if(citations[mid] == (n-mid))
//                 return citations[mid];
//             else if(citations[mid] > (n-mid))
//                 high = mid - 1;
//             else
//                 low = mid + 1;
//         }
//         return n - low;
        
        // Count Sort Idea
        
        // Time Complexity: O(n)    (where n -> length of citations array)
        // Space Complexity: O(n)
        
        if(citations == null || citations.length == 0)
            return 0;
        
        int n = citations.length;
        int[] arr = new int[n+1];
        
        for(int i : citations){
            if(i >= n)
                arr[n]++;
            else
                arr[i]++;
        }
        
        int papers = 0;
        for(int i = n; i >= 0; i--){
            papers += arr[i];
            if(papers >= i)
                return i;
        }
        return 0;
    }
}