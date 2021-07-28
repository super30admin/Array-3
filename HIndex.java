// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * 1. create a bucket array of n+1 length.
 * 2. for each citation maintain a count of citations
 * 3. form end of the citation array count sum and when it is equal or greater than index return i.
 */

public class HIndex {
	public int hIndex(int[] citations) {
        if(citations==null) return 0;
        int n=citations.length;
        int[] buckets=new int[n+1];
        
        for(int i=0;i<n;i++){
            if(citations[i]>=n){
                buckets[n]+=1;
            }else{
                buckets[citations[i]]+=1;
            }
        }
        int sum=0;
        for(int i=n;i>=0;i--){
            sum+=buckets[i];
            if(sum>=i){
              return i;  
            } 
        }
        return 0;
    }
}
