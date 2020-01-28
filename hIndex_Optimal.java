/**

LeetCode Submitted : YES
Space Complexity : O(N)
Time Complexity : O(N)

The idea is not to sort the citations but have some kind of array to maintain memoization. So, we will be using topological sorting. This algorithm is not intuitive for me and require practice to remember the algorithm.


**/
class Solution {
    public int hIndex(int[] citations) {
        
        if(citations == null || citations.length < 1)
            return 0; 
        
        int n = citations.length;  
        
        int[] order = new int[n+1];
        int num_citations = 0;
        
        //Create topological Sort
        for(int i =0;i<n;i++){
            //if number of citations more than number of papers
            if(citations[i] >= n){
                order[n] += 1;
            }else{
                order[citations[i]] += 1;
            }
        }
        
        //Iterate num_citations from end of topological sort
        for(int i = n;i >=0;i--){
            num_citations += order[i];
            if(num_citations >= i){
                return i;
            }
        }
        
        return -1;
    }
    
}
