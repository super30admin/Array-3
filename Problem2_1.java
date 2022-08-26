//Time Complexity: O(n*log(n)); where n is the length of citations array.
//Space Complexity: O(1)
//Code run successfully on LeetCode.

public class Problem2_1 {

    public int hIndex(int[] citations) {
        
        if(citations == null|| citations.length == 0)
            return -1;
        
        int n = citations.length;
        Arrays.sort(citations);
        
        for(int i =0; i < n; i++)
        {
            int diff = n - i;
            
            if(citations[i] >= diff)
                return diff;
        }
        
        return 0;
    }
}
