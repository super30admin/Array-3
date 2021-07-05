//Sorting+binary search( similar to h-index 2 solution)
//Time Complexity:O(nlogn)
//Space Complexity:O(1)
//Approach- Same as h-index 2, the input array is sorted and then the h index is found using binary search.
//This code was executed successfully and got accepted in leetcode. 
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
//counting sort
//Time Complexity:O(n)
//SPace Complexity:O(1)
//Approach- Counting sort is used to store the count of occurrance of each index in the citations array(as a hashmap). All those indices whose values are greater than or equal to the value of the citations array length are added to the last index of the count array. Then this temp array is iterated from behind and if I find any index whose count value is equal to or greater than the current index value, then that index would become the h index.
 //This code was executed successfully and got accepted in leetcode. 
class Solution {
    public int hIndex(int[] citations) {
        int total=0;
        int n=citations.length;
        int[] temp=new int[n+1];
        for(int c:citations){
            if(c>=n){
                temp[n]++;
            }
            else{
                temp[c]++;
            }
        }
        for(int i=n;i>=0;i--){
            total+=temp[i];
            if(total>=i){
                return i;
            }
        }
        return 0;
    }
}