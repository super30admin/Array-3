
// brute force
public class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if(citations==null || n<0) return 0;
        Arrays.sort(citations);
        for(int i=0;i<n;i++){
            int diff = n-i;
            if(diff<=citations[i]){
                return diff;
            }
        }
        return 0;
    }
}

// Time Complexity - O(nlogn)
// Space Complexity - O(1)


// binary search
public class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if(citations==null || n<0) return 0;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int diff = n-mid;
            if(citations[mid]==diff){
                return diff;
            }else if(citations[mid]<diff){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return n-low;
    }
}

// Time Complexity - O(n)
// Space Complexity - O(1)
