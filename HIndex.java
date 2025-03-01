class Solution {
    //Time Complexity:O(n)
    // Space Complexity:O(h)
    public int hIndex(int[] citations) {
        
        int[] freq = new int [citations.length+1];

        for (int c : citations){
            if (c >= freq.length)
            freq[freq.length-1]++;
            else
            freq[c]++;
        }

        int sum =0;
        for (int f = freq.length-1;f >=0 ;f--){
            sum = sum +freq[f];
            if (sum >= f)
            return f;
        }
        return 0;
    }
}
