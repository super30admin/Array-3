//Sorting+binary search( similar to h-index 2 solution)
//Time Complexity:O(nlogn)
//Space Complexity:O(1)
//Approach- Same as h-index 2, the input array is sorted and then the h index is found using binary search.
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int left=0;
        int right=citations.length-1;
        int n=citations.length;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(citations[mid]==n-mid){
                return n-mid;
            }
            else if(citations[mid]<n-mid){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return n-left;
    }
}
