// O(N), O(N)
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        
        int[] counts = new int[n+1];
        
        for(int i=0;i<n;i++) {
            if(citations[i]>=n) {
                counts[n]++;
            }
            else {
                counts[citations[i]]++;
            }
        }
        int sum = 0;
        for(int i=n;i>=0;i--) {
            sum += counts[i];
            
            if(sum>=i) {
                return i;
            }
        }
        
        return 0;
    }
}
// O(NlgN)
// O(1)
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        for(int i=0;i<n;i++) {
            int diff = n - i;
            if(citations[i] >= diff) {
                return diff;
            }
        }
        
        return 0;
    }
}
