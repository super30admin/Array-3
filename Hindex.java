// Time Complexity :O(N) 
// Space Complexity :O(N) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach: Maintain the count of number of papers with each citation. if the citation
// exceeds the total number of papers, add its count to the total number of papers. Then traverse the array from the end to find the max h index;

class Solution {
    public int hIndex(int[] citations) {
        int a[] = new int[citations.length+1];
        for(int i=0;i<citations.length;i++){
            if(citations[i]>citations.length)
                a[citations.length]++;
            else
                a[citations[i]]++;
        }
        int max=0;
        int result=0;
        for(int j=a.length-1;j>0;j--){
            max+=a[j];
            if(max>=j)
               return j;
        }
        return 0;
    }
}