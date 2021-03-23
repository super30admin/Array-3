//Time complexity-O(n)
//Space complexity-O(n)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public int hIndex(int[] citations) {
        int[] count = new int[citations.length+1];
        for(int i=0;i<citations.length;i++){
            if(citations[i]>citations.length)
                count[citations.length]++;//Count sort
            else
                count[citations[i]]++;
        }
        int max=0;
        for(int i=count.length-1;i>=0;i--){//Adding all the max hindex possible
            max+=count[i];
            if(max>=i)
                return i;
        }
        return -1;
        
    }
}