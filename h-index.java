// TC : O(n)
// SC : O(n)

class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] h = new int[len + 1];
        for(int cite : citations ) if(cite>len) h[len]++; else h[cite]++;
        for(int i =len-1 ; i>=0 ; i--) h[i]+=h[i+1];
        for(int i =1 ; i<=len ; i++) if(h[i]<i) return i-1;
        return len;
    }
}
