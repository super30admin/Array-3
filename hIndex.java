//time O(n)
//space O(n)

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < citations.length; i++) {
            if(citations[i]-1 <= i) {
                max = citations[i];
            }
        }
        return max;
    }
}
