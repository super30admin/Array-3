package Array3;

/**
 * Here we are using the concept used in bucket sort, where we maintain
 * frequency(no of citations above the corresponding H-index) for each possible
 * H-index. Then we pick the min H-index such that frequency>=H-index
 * 
 * Time Complexity : O(n)- where n is the length of given array Space Complexity
 * : O(n)
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
public class Problem2 {
    public int hIndex(int[] citations) {
        int arr[]= new int[citations.length+1];
        for(int i=0;i<citations.length;i++){
            if(citations[i]>arr.length-1)
                arr[arr.length-1]++;
            else
                arr[citations[i]]++;
        }

        for(int i=arr.length-1;i>=0;i--){
            if(i!=arr.length-1){
                arr[i]=arr[i]+arr[i+1];
            }
            if(arr[i]>=i){
                return i;
            }
        }
        return 0;
    }
}
