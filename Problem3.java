package Array-3;
// TC: O(logN)
// SC: O(1)
public class Problem3 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0, high = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int diff = n-mid;
            if(citations[mid]==diff) return diff;
            else if(citations[mid]>diff) high=mid-1;
            else low=mid+1;
        }

        return n-low;
    }
}
