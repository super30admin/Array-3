//OPTIMIZED USING COUNTING - T.C- O(N); 
//S.C- O(N)
class Solution {
    public int hIndex(int[] citations) {
      if(citations==null || citations.length==0) return 0;
      int n= citations.length;
      int [] papers= new int[n+1];

      for(int i=0; i<n;i++){
        if(citations[i]>n){ //create a new array that will count the papers
          papers[n]++; //increment the last index if the citations is greater than length
        }else{
          papers[citations[i]]++; //increment the index of counting array as per the citations
        }
      }

      int rsum=0;
      for(int i= n; i>=0;i--){ //maintain a running suma and start iterating from last pos.
        rsum= rsum+ papers[i];
        if(rsum>=i){ //if the rsum crosses over the citations then return that index- h-index
          return i;
        }
      }
      return 0;
    }
}