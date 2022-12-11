class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] f = new int[n+1];
        for(int c : citations){
            f[Math.min(c, n)]++;
        }

        int[] s = new int[n+1];
        s[n] = f[n];
        for(int i =n-1; i>=0; --i){
            s[i] = s[i+1]+ f[i];
        }

        int h =n;

        while(h>0){
            if(s[h]>=h){
                return h;
            }

            --h;
        }
        return 0;



    }
}
//tc=O(n)
//sc=O(n)
