// Time Complexity:  O(n)
// Space Complexity: O(n)

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] hArr = new int[n+1];
        for(int c : citations) {
            hArr[Math.min(c, n)]++;
        }
        int sum=0;
        for(int i=n; i>=0; i--) {
            sum += hArr[i];
            if(sum >= i)
                return i;
        }
        return 0;
    }
}



// // Time Complexity:  O(nlogn)
// // Space Complexity: O(1)

// class Solution {
//     public int hIndex(int[] citations) {
//         int n = citations.length;
//         Arrays.sort(citations);
//         for(int i=0; i<n; i++) {
//             int diff = n-i;
//             if(citations[i]>=diff)
//                 return diff;
//         }
//         return 0;
//     }
// }



// // ******************** Using Binary Search ********************

// // Time Complexity:  O(nlogn)
// // Space Complexity: O(1)

// class Solution {
//     public int hIndex(int[] citations) {

//         Arrays.sort(citations);
        
//         int n = citations.length;
//         int ans = 0;
//         int l = 1;
//         int r = n;
        
//         while(l <= r) {
            
//             int mid = l + (r-l)/2;
//             int p2 = n-mid;
//             int p1 = p2-1;
            
//             if(citations[p2] >= mid && (p1 == -1 || citations[p1]<=mid)) {
//                 ans = mid;
//                 l = mid+1;
//             }
//             else if(citations[p2] < mid)
//                 r = mid-1;
//             else
//                 l = mid+1;
//         }
//         return ans;
//     }
// }
