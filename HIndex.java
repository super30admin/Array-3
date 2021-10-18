class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int low = 0; int high = n-1;
        while(low<=high) {
            int mid = low+(high-low)/2;
            if(citations[mid]==n-mid) return n-mid;
            else if(n-mid>citations[mid]) low = mid+1;
            else high=mid-1;
        }
        return n-low;
    }
}