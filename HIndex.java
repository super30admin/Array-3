package Array3;
// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

public class HIndex {
    public int hIndex(int[] citations) {
        int buckets[] = new int[citations.length+1];
        for(int citation: citations){
            if(citation > citations.length )
                buckets[citations.length]++;
            else
                buckets[citation]++;
        }
        int total_papers = 0;
        for(int i=buckets.length-1; i>=0;i-- ){
            total_papers += buckets[i];
            if(total_papers >= i){
                return i;
            }
        }
        return -1;
    }
}
