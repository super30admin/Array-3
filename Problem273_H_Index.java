/**
 * Time Complexity - O(n)
 * Space Comlexity - O(n)
 */
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] docs = new int[n+1];

        for(int citation : citations){
            docs[Math.min(citation,n)]++;
        }

        int result =0;

        for(int i=n; i>=0; i--){
            result+=docs[i];
            if(i <= result){
                return i;
            }
        }
        return 0;
    }
}