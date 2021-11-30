//Timecomplexity:- 0(nlogn);
//spacecomplexity:- O(1);
//Did it run on leetcode:- YES.
//Your code with approach:- this is basically h-index2 problem but here we have unsorted array so first sorting it 
// and applying binary search on the condition citations[middle] will be equal to citations.length-middle.

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int low=0;
        int high= citations.length-1;
        while(low<=high){
            int middle=low+(high-low)/2;
            if(citations[middle]==citations.length-middle){
                return citations[middle];
            }
            else if(citations[middle]<citations.length-middle){
                low=middle+1;
                
            }
            else{
                high=middle-1;
            }
        }
        return citations.length-low;
    }
}