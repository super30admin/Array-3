class Solution {
    public int hIndex(int[] citations) {
        int []bucket = new int[citations.length+1];
        for(int i =0; i< citations.length;i++) {
            if(citations[i] >= citations.length) {
                bucket[citations.length]++;
            } else {
                bucket[citations[i]]++;
            }
        }
        int sum =0;
        for(int i =citations.length; i>=0;i--) {
            sum += bucket[i];
            if(sum>= i) {
                return i;
            }

        }
        return 0;
        
        
    }
}