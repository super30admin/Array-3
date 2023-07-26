import java.util.Arrays;

public class HIndex {
    // Time Complexity :O(n*logn) where n is the number of elements in the citations array
    // Space Complexity :O(1) as no auxiliary space is used
    // Did this code successfully run on Leetcode :yes
    public int hIndexBruteForce(int[] citations) {
        if(citations == null || citations.length <1){
            return 0;
        }

        Arrays.sort(citations);
        int n = citations.length;
        for(int i =0; i<n; i++){
            int diff = n-i;
            if(citations[i] >= diff){
                return diff;
            }
        }
        return 0;
    }

    // Time Complexity :O(n) where n is the number of elements in the citations array
    // Space Complexity :O(1) as no auxiliary space is used
    // Did this code successfully run on Leetcode :yes
    public int hIndex(int[] citations) {
        if(citations == null || citations.length <1){
            return 0;
        }

        int n = citations.length;
        int[] buckets = new int[n+1];
        for(int i =0; i<n; i++){
            if(citations[i] >= n){
                buckets[n]++;
            }else{
                buckets[citations[i]]++;
            }
        }
        int sum = 0;
        for(int i =n; i>=0; i--){
            sum = sum + buckets[i];
            if(sum >= i){
                return i;
            }
        }
        return 0;
    }

}
