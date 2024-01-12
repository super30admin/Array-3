//TC O(n)
//SC O(n)

//Use bucket sort to place citations in buckets and check from last, which citation count and position match
class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] bucket = new int[n+1];
        for(int c : citations){
            if(c>n)
                bucket[n]++;
            else
                bucket[c]++;
        }
        int max = 0;
        for(int i=n;i>=0;i--){
            max += bucket[i];
            if(max>=i) return i;
        }
        return 0;
    }
}