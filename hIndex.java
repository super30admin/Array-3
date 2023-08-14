//Time Complexity (TC): O(n)
//Space Complexity (SC): O(n)

class Solution {
    public int hIndex(int[] citations) {
        int bucket[]=new int[citations.length+1];
        for(int x:citations)
            if(x<citations.length+1)
            bucket[x]++;
            else
            bucket[citations.length]++;    
        int cnt=0;
        for(int i=bucket.length-1;i>=0;i--)
        {
            cnt+=bucket[i];
            if(i<=cnt)
                return i;
        }
        return 0;
    }
}

