/*
Approach - Sorting
1) we sort the array and search linearly
2) if citations.length - 1 -i > i then increment i
3) at the end return i
Time Complexity - O(N logN)
Space Complexity - O(1)

Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/
import java.util.Arrays;
public class HIndex_LC_274 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations); //0 1 3 5 6
        int i = 0;
        while(i < citations.length && citations[citations.length - 1 -i] > i){
            i++;
        }
        return i;

    }
}

