// TC - O(n), SC - O(n)

// LC - 274

class Solution {
    public int hIndex(int[] citations) {
		// sanity check
        if(citations == null || citations.length == 0){
            return 0;
        }
        int n = citations.length;
		// We are using sort[] to calculate number of papers with that many citations
        int[] sort = new int[n+1];
		//populating sort array
        for(int ele : citations){
            if(ele >= n){
                sort[n]++;
            }else{
                sort[ele]++;
            }
        }
        int papers = 0;
		// Traverse from back of sort array and if papers >= citations, return x which is H-index
        for(int x=n; x>=0; x--){
            papers += sort[x];
            
            if(papers >= x){
                return x;
            }
        }
        return 0;
    }
}