// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class HIndex_Array {
    public static void main(String[] args) {
        int[] citations = {0,1,3,5,6};
        hIndex(citations);
    }

    public static int hIndex(int[] citations) {  // T.C - O(n) ; S.C - O(n)
        if(citations == null || citations.length == 0)
            return 0;

        int n = citations.length;

        int[] bucket = new int[n+1];

        for(int i=0; i<n; i++){
            if(citations[i]<n)
                bucket[citations[i]]++;
            else
                bucket[n]++;
        }

        int sum = 0;

        for(int i=n; i>=0; i--){
            sum += bucket[i];
            if(sum >= i)
                return i;
        }

        return 0;
    }
}

