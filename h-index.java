// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :N/A
// Any problem you faced while coding this :Test cases


// Your code here along with comments explaining your approach

class Solution {
    public int hIndex(int[] citations) {
      
      int n = citations.length;
      //array to store numbers of papers for each number of citations
      int[] papers = new int[n+1];
      
      //populate the papers array with numbers of papers for each number of citations
      for(int i=0;i<citations.length;i++)
      {
        if(citations[i]>n)
        {
          papers[n]+=1;
        }
        else
        {
          papers[citations[i]]+=1;
        }
      }
      
      //variable to calculated h index
      int hIdx = 0;
      for(int j=n;j>=0;j--)
      {
        hIdx += papers[j];
        //when h number of papers have citations more than or equal to h
        if(hIdx >= j)
        {
          return j;
        }
      }
        return 0;
    }
}