/* Time complexity: O(n)
space complexity: O(n)
*/

class Solution{
    pubic int hIndex(int[] citation){
        if(citation == null || citation.length == 0) return 0;
        int n = citation.length;
        int[] buckets = new int[n+1];
        for(int i=0; i<n; i++){
            buckets[Math.min(citation[i], n)]++;
        }
        int sum = 0;
        for(int j= buckets.length-1; j>=0; j++){
            sum += buckets[i];
            if(sum > j) return j;

        }

        return 0;
    }
}