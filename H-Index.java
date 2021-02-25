//Problem 117 : H-Index
//TC: O(N)
//SC: O(N)

/*Steps
  //Brurtefoce: TC: O(nlogn) | SC:O(): First sort the array and then similar to H-IndexII

  //Optimized: TC:O(N) | SC:O(N): Use Bucket sort
    Using Bucket sort because here number greater than the length of array, doesn't matter
    Iterate over the citations and if elemnet is greater than citations length, then just increment counter of bucket last index otherwise keep incrementing the counter for citation element bucket index
    
    //Sort first
   index      0 1 2 3 4 
             [0 1 3 5 6] n =5;
 citations:   5 4 3 2 1


    //Using Bucket Sort
   without sort  [3,0,6,1,5]
     counters     1 1 0 1 0 2
   bucket index   0 1 2 3 4 5  

*/


class Solution {
    
    public int hIndex(int[] citations) {
        if(citations==null) return 0;
        //TC:O(n) | SC:O(n)
        //Using Bucket sort because here number greater than the length of array, doesn't matter
        int[] bucket = new int[citations.length+1];
        int n = citations.length;
        for(int i=0;i<n;i++){
            
            if(citations[i]>n){
                bucket[n]++;
            }else{
                bucket[citations[i]]++;
            }
        }
        
        int sum=0;
        for(int i=n;i>=0;i--){
            sum += bucket[i];
            
            if(sum>=i){
                return i;
            }
        }
        
        return 0;
    }
    
    
    
    /*public int hIndex(int[] citations) {
        if(citations==null) return 0;
        
        //TC:O(nLogn)
        Arrays.sort(citations);
        
        int n = citations.length;
        
        for(int i=0;i<n;i++){
           int diff = n-i;
           
            if(diff<=citations[i]){
             return diff;   
           } 
        }
        
        return 0;
    }*/
}

  